package com.sun.jna.platform.dnd;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.share.internal.ShareConstants;
import com.sun.jna.Platform;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.InvalidDnDOperationException;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.text.JTextComponent;

/* loaded from: classes4.dex */
public abstract class DragHandler implements DragSourceListener, DragSourceMotionListener, DragGestureListener {
    protected static final int COPY = 1;
    static final int COPY_MASK;
    public static final float DEFAULT_GHOST_ALPHA = 0.5f;
    static final int KEY_MASK = 9152;
    protected static final int LINK = 1073741824;
    static final int LINK_MASK;
    protected static final int MOVE = 2;
    static final int MOVE_MASK = 64;
    protected static final int NONE = 0;
    static final boolean OSX;
    public static final int UNKNOWN_MODIFIERS = -1;
    private static int modifiers;
    private static Transferable transferable;
    private Component dragSource;
    private boolean fixCursor = true;
    private GhostedDragImage ghost;
    private float ghostAlpha;
    private Point imageOffset;
    private String lastAction;
    private Dimension maxGhostSize;
    private boolean moved;
    private int supportedActions;
    private static final Logger LOG = Logger.getLogger(DragHandler.class.getName());
    public static final Dimension MAX_GHOST_SIZE = new Dimension(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    public static final Transferable UNKNOWN_TRANSFERABLE = null;

    private int reduce(int i) {
        if ((i & 2) != 0 && i != 2) {
            return 2;
        }
        if ((i & 1) == 0 || i == 1) {
            return i;
        }
        return 1;
    }

    protected void dragStarted(DragGestureEvent dragGestureEvent) {
    }

    protected Icon getDragIcon(DragGestureEvent dragGestureEvent, Point point) {
        return null;
    }

    protected abstract Transferable getTransferable(DragGestureEvent dragGestureEvent);

    protected Icon scaleDragIcon(Icon icon, Point point) {
        return icon;
    }

    static {
        boolean zIsMac = Platform.isMac();
        OSX = zIsMac;
        COPY_MASK = zIsMac ? 512 : 128;
        LINK_MASK = zIsMac ? 768 : 192;
        modifiers = -1;
        transferable = null;
    }

    static int getModifiers() {
        return modifiers;
    }

    public static Transferable getTransferable(DropTargetEvent dropTargetEvent) {
        if (dropTargetEvent instanceof DropTargetDragEvent) {
            try {
                return ((DropTargetDragEvent) dropTargetEvent).getTransferable();
            } catch (Exception unused) {
            }
        } else if (dropTargetEvent instanceof DropTargetDropEvent) {
            return ((DropTargetDropEvent) dropTargetEvent).getTransferable();
        }
        return transferable;
    }

    protected DragHandler(Component component, int i) {
        this.maxGhostSize = MAX_GHOST_SIZE;
        this.ghostAlpha = 0.5f;
        this.dragSource = component;
        this.supportedActions = i;
        try {
            String property = System.getProperty("DragHandler.alpha");
            if (property != null) {
                try {
                    this.ghostAlpha = Float.parseFloat(property);
                } catch (NumberFormatException unused) {
                }
            }
            String property2 = System.getProperty("DragHandler.maxDragImageSize");
            if (property2 != null) {
                String[] strArrSplit = property2.split("x");
                if (strArrSplit.length == 2) {
                    this.maxGhostSize = new Dimension(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
                }
            }
        } catch (NumberFormatException | SecurityException unused2) {
        }
        disableSwingDragSupport(component);
        DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(component, this.supportedActions, this);
    }

    private void disableSwingDragSupport(Component component) {
        if (component instanceof JTree) {
            ((JTree) component).setDragEnabled(false);
            return;
        }
        if (component instanceof JList) {
            ((JList) component).setDragEnabled(false);
            return;
        }
        if (component instanceof JTable) {
            ((JTable) component).setDragEnabled(false);
            return;
        }
        if (component instanceof JTextComponent) {
            ((JTextComponent) component).setDragEnabled(false);
        } else if (component instanceof JColorChooser) {
            ((JColorChooser) component).setDragEnabled(false);
        } else if (component instanceof JFileChooser) {
            ((JFileChooser) component).setDragEnabled(false);
        }
    }

    protected boolean canDrag(DragGestureEvent dragGestureEvent) {
        int modifiersEx = dragGestureEvent.getTriggerEvent().getModifiersEx() & KEY_MASK;
        return modifiersEx == 64 ? (this.supportedActions & 2) != 0 : modifiersEx == COPY_MASK ? (this.supportedActions & 1) != 0 : (modifiersEx == LINK_MASK && (this.supportedActions & 1073741824) == 0) ? false : true;
    }

    protected void setModifiers(int i) {
        modifiers = i;
    }

    public void dragGestureRecognized(DragGestureEvent dragGestureEvent) {
        if ((dragGestureEvent.getDragAction() & this.supportedActions) == 0 || !canDrag(dragGestureEvent)) {
            return;
        }
        setModifiers(dragGestureEvent.getTriggerEvent().getModifiersEx() & KEY_MASK);
        Transferable transferable2 = getTransferable(dragGestureEvent);
        if (transferable2 == null) {
            return;
        }
        try {
            Point point = new Point(0, 0);
            Icon dragIcon = getDragIcon(dragGestureEvent, point);
            Point dragOrigin = dragGestureEvent.getDragOrigin();
            Point point2 = new Point(point.x - dragOrigin.x, point.y - dragOrigin.y);
            this.imageOffset = point2;
            Icon iconScaleDragIcon = scaleDragIcon(dragIcon, point2);
            if (iconScaleDragIcon != null && DragSource.isDragImageSupported()) {
                dragGestureEvent.startDrag((Cursor) null, createDragImage(dragGestureEvent.getComponent().getGraphicsConfiguration(), iconScaleDragIcon), this.imageOffset, transferable2, this);
            } else {
                if (iconScaleDragIcon != null) {
                    Point locationOnScreen = this.dragSource.getLocationOnScreen();
                    locationOnScreen.translate(dragOrigin.x, dragOrigin.y);
                    GhostedDragImage ghostedDragImage = new GhostedDragImage(this.dragSource, iconScaleDragIcon, getImageLocation(locationOnScreen), new Point(-this.imageOffset.x, -this.imageOffset.y));
                    this.ghost = ghostedDragImage;
                    ghostedDragImage.setAlpha(this.ghostAlpha);
                }
                dragGestureEvent.startDrag((Cursor) null, transferable2, this);
            }
            dragStarted(dragGestureEvent);
            this.moved = false;
            dragGestureEvent.getDragSource().addDragSourceMotionListener(this);
            transferable = transferable2;
        } catch (InvalidDnDOperationException unused) {
            GhostedDragImage ghostedDragImage2 = this.ghost;
            if (ghostedDragImage2 != null) {
                ghostedDragImage2.dispose();
                this.ghost = null;
            }
        }
    }

    protected Image createDragImage(GraphicsConfiguration graphicsConfiguration, Icon icon) {
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        BufferedImage bufferedImageCreateCompatibleImage = graphicsConfiguration.createCompatibleImage(iconWidth, iconHeight, 3);
        Graphics2D graphics = bufferedImageCreateCompatibleImage.getGraphics();
        graphics.setComposite(AlphaComposite.Clear);
        graphics.fillRect(0, 0, iconWidth, iconHeight);
        graphics.setComposite(AlphaComposite.getInstance(2, this.ghostAlpha));
        icon.paintIcon(this.dragSource, graphics, 0, 0);
        graphics.dispose();
        return bufferedImageCreateCompatibleImage;
    }

    protected Cursor getCursorForAction(int i) {
        if (i == 1) {
            return DragSource.DefaultCopyDrop;
        }
        if (i == 2) {
            return DragSource.DefaultMoveDrop;
        }
        if (i == 1073741824) {
            return DragSource.DefaultLinkDrop;
        }
        return DragSource.DefaultMoveNoDrop;
    }

    protected int getAcceptableDropAction(int i) {
        return reduce(i & this.supportedActions);
    }

    protected int getDropAction(DragSourceEvent dragSourceEvent) {
        if (dragSourceEvent instanceof DragSourceDragEvent) {
            return ((DragSourceDragEvent) dragSourceEvent).getDropAction();
        }
        if (dragSourceEvent instanceof DragSourceDropEvent) {
            return ((DragSourceDropEvent) dragSourceEvent).getDropAction();
        }
        return 0;
    }

    protected int adjustDropAction(DragSourceEvent dragSourceEvent) {
        int dropAction = getDropAction(dragSourceEvent);
        if (!(dragSourceEvent instanceof DragSourceDragEvent)) {
            return dropAction;
        }
        DragSourceDragEvent dragSourceDragEvent = (DragSourceDragEvent) dragSourceEvent;
        return (dropAction == 0 && (dragSourceDragEvent.getGestureModifiersEx() & KEY_MASK) == 0) ? getAcceptableDropAction(dragSourceDragEvent.getTargetActions()) : dropAction;
    }

    protected void updateCursor(DragSourceEvent dragSourceEvent) {
        if (this.fixCursor) {
            dragSourceEvent.getDragSourceContext().setCursor(getCursorForAction(adjustDropAction(dragSourceEvent)));
        }
    }

    static String actionString(int i) {
        if (i == 1) {
            return "COPY";
        }
        if (i == 2) {
            return "MOVE";
        }
        if (i == 3) {
            return "MOVE|COPY";
        }
        switch (i) {
            case 1073741824:
                return ShareConstants.CONTENT_URL;
            case 1073741825:
                return "COPY|LINK";
            case 1073741826:
                return "MOVE|LINK";
            case 1073741827:
                return "MOVE|COPY|LINK";
            default:
                return "NONE";
        }
    }

    private void describe(String str, DragSourceEvent dragSourceEvent) {
        Logger logger = LOG;
        if (logger.isLoggable(Level.FINE)) {
            StringBuilder sb = new StringBuilder("drag: ");
            sb.append(str);
            DragSourceContext dragSourceContext = dragSourceEvent.getDragSourceContext();
            if (dragSourceEvent instanceof DragSourceDragEvent) {
                DragSourceDragEvent dragSourceDragEvent = (DragSourceDragEvent) dragSourceEvent;
                sb.append(": src=");
                sb.append(actionString(dragSourceContext.getSourceActions()));
                sb.append(" usr=");
                sb.append(actionString(dragSourceDragEvent.getUserAction()));
                sb.append(" tgt=");
                sb.append(actionString(dragSourceDragEvent.getTargetActions()));
                sb.append(" act=");
                sb.append(actionString(dragSourceDragEvent.getDropAction()));
                sb.append(" mods=");
                sb.append(dragSourceDragEvent.getGestureModifiersEx());
            } else {
                sb.append(": e=");
                sb.append(dragSourceEvent);
            }
            String string = sb.toString();
            if (string.equals(this.lastAction)) {
                return;
            }
            logger.log(Level.FINE, string);
            this.lastAction = string;
        }
    }

    public void dragDropEnd(DragSourceDropEvent dragSourceDropEvent) {
        describe("end", dragSourceDropEvent);
        setModifiers(-1);
        transferable = UNKNOWN_TRANSFERABLE;
        if (this.ghost != null) {
            if (dragSourceDropEvent.getDropSuccess()) {
                this.ghost.dispose();
            } else {
                this.ghost.returnToOrigin();
            }
            this.ghost = null;
        }
        dragSourceDropEvent.getDragSourceContext().getDragSource().removeDragSourceMotionListener(this);
        this.moved = false;
    }

    private Point getImageLocation(Point point) {
        point.translate(this.imageOffset.x, this.imageOffset.y);
        return point;
    }

    public void dragEnter(DragSourceDragEvent dragSourceDragEvent) {
        describe("enter", dragSourceDragEvent);
        GhostedDragImage ghostedDragImage = this.ghost;
        if (ghostedDragImage != null) {
            ghostedDragImage.move(getImageLocation(dragSourceDragEvent.getLocation()));
        }
        updateCursor(dragSourceDragEvent);
    }

    public void dragMouseMoved(DragSourceDragEvent dragSourceDragEvent) {
        describe("move", dragSourceDragEvent);
        GhostedDragImage ghostedDragImage = this.ghost;
        if (ghostedDragImage != null) {
            ghostedDragImage.move(getImageLocation(dragSourceDragEvent.getLocation()));
        }
        if (this.moved) {
            updateCursor(dragSourceDragEvent);
        }
        this.moved = true;
    }

    public void dragOver(DragSourceDragEvent dragSourceDragEvent) {
        describe("over", dragSourceDragEvent);
        GhostedDragImage ghostedDragImage = this.ghost;
        if (ghostedDragImage != null) {
            ghostedDragImage.move(getImageLocation(dragSourceDragEvent.getLocation()));
        }
        updateCursor(dragSourceDragEvent);
    }

    public void dragExit(DragSourceEvent dragSourceEvent) {
        describe("exit", dragSourceEvent);
    }

    public void dropActionChanged(DragSourceDragEvent dragSourceDragEvent) {
        describe("change", dragSourceDragEvent);
        setModifiers(dragSourceDragEvent.getGestureModifiersEx() & KEY_MASK);
        GhostedDragImage ghostedDragImage = this.ghost;
        if (ghostedDragImage != null) {
            ghostedDragImage.move(getImageLocation(dragSourceDragEvent.getLocation()));
        }
        updateCursor(dragSourceDragEvent);
    }
}
