package com.sun.jna.platform;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.platform.RasterRangesUtils;
import com.sun.jna.platform.unix.X11;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Psapi;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinGDI;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.awt.AWTEvent;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

/* loaded from: classes4.dex */
public class WindowUtils {
    private static final Logger LOG = Logger.getLogger(WindowUtils.class.getName());
    public static final Shape MASK_NONE = null;
    private static final String TRANSPARENT_ALPHA = "transparent-alpha";
    private static final String TRANSPARENT_OLD_BG = "transparent-old-bg";
    private static final String TRANSPARENT_OLD_OPAQUE = "transparent-old-opaque";

    private static class HeavyweightForcer extends Window {
        private static final long serialVersionUID = 1;
        private final boolean packed;

        public HeavyweightForcer(Window window) {
            super(window);
            pack();
            this.packed = true;
        }

        public boolean isVisible() {
            return this.packed;
        }

        public Rectangle getBounds() {
            return getOwner().getBounds();
        }
    }

    protected static class RepaintTrigger extends JComponent {
        private static final long serialVersionUID = 1;
        private final JComponent content;
        private Rectangle dirty;
        private final Listener listener = createListener();

        protected class Listener extends WindowAdapter implements ComponentListener, HierarchyListener, AWTEventListener {
            public void componentHidden(ComponentEvent componentEvent) {
            }

            public void componentMoved(ComponentEvent componentEvent) {
            }

            protected Listener() {
            }

            public void windowOpened(WindowEvent windowEvent) {
                RepaintTrigger.this.repaint();
            }

            public void componentResized(ComponentEvent componentEvent) {
                RepaintTrigger repaintTrigger = RepaintTrigger.this;
                repaintTrigger.setSize(repaintTrigger.getParent().getSize());
                RepaintTrigger.this.repaint();
            }

            public void componentShown(ComponentEvent componentEvent) {
                RepaintTrigger.this.repaint();
            }

            public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
                RepaintTrigger.this.repaint();
            }

            public void eventDispatched(AWTEvent aWTEvent) {
                MouseEvent mouseEvent;
                Component component;
                if ((aWTEvent instanceof MouseEvent) && (component = (mouseEvent = (MouseEvent) aWTEvent).getComponent()) != null && SwingUtilities.isDescendingFrom(component, RepaintTrigger.this.content)) {
                    MouseEvent mouseEventConvertMouseEvent = SwingUtilities.convertMouseEvent(component, mouseEvent, RepaintTrigger.this.content);
                    Component deepestComponentAt = SwingUtilities.getDeepestComponentAt(RepaintTrigger.this.content, mouseEventConvertMouseEvent.getX(), mouseEventConvertMouseEvent.getY());
                    if (deepestComponentAt != null) {
                        RepaintTrigger.this.setCursor(deepestComponentAt.getCursor());
                    }
                }
            }
        }

        public RepaintTrigger(JComponent jComponent) {
            this.content = jComponent;
        }

        public void addNotify() {
            super.addNotify();
            Window windowAncestor = SwingUtilities.getWindowAncestor(this);
            setSize(getParent().getSize());
            windowAncestor.addComponentListener(this.listener);
            windowAncestor.addWindowListener(this.listener);
            Toolkit.getDefaultToolkit().addAWTEventListener(this.listener, 48L);
        }

        public void removeNotify() {
            Toolkit.getDefaultToolkit().removeAWTEventListener(this.listener);
            Window windowAncestor = SwingUtilities.getWindowAncestor(this);
            windowAncestor.removeComponentListener(this.listener);
            windowAncestor.removeWindowListener(this.listener);
            super.removeNotify();
        }

        protected void paintComponent(Graphics graphics) {
            Rectangle clipBounds = graphics.getClipBounds();
            Rectangle rectangle = this.dirty;
            if (rectangle == null || !rectangle.contains(clipBounds)) {
                Rectangle rectangle2 = this.dirty;
                if (rectangle2 == null) {
                    this.dirty = clipBounds;
                } else {
                    this.dirty = rectangle2.union(clipBounds);
                }
                this.content.repaint(this.dirty);
                return;
            }
            this.dirty = null;
        }

        protected Listener createListener() {
            return new Listener();
        }
    }

    public static abstract class NativeWindowUtils {
        public boolean isWindowAlphaSupported() {
            return false;
        }

        public void setWindowAlpha(Window window, float f) {
        }

        public void setWindowTransparent(Window window, boolean z) {
        }

        protected abstract class TransparentContentPane extends JPanel implements AWTEventListener {
            private static final long serialVersionUID = 1;
            private boolean transparent;

            protected abstract void paintDirect(BufferedImage bufferedImage, Rectangle rectangle);

            public TransparentContentPane(Container container) {
                super(new BorderLayout());
                add(container, "Center");
                setTransparent(true);
                if (container instanceof JPanel) {
                    ((JComponent) container).setOpaque(false);
                }
            }

            public void addNotify() {
                super.addNotify();
                Toolkit.getDefaultToolkit().addAWTEventListener(this, 2L);
            }

            public void removeNotify() {
                Toolkit.getDefaultToolkit().removeAWTEventListener(this);
                super.removeNotify();
            }

            public void setTransparent(boolean z) {
                this.transparent = z;
                setOpaque(!z);
                setDoubleBuffered(!z);
                repaint();
            }

            public void eventDispatched(AWTEvent aWTEvent) {
                if (aWTEvent.getID() == 300) {
                    ContainerEvent containerEvent = (ContainerEvent) aWTEvent;
                    if (SwingUtilities.isDescendingFrom(containerEvent.getChild(), this)) {
                        NativeWindowUtils.this.setDoubleBuffered(containerEvent.getChild(), false);
                    }
                }
            }

            public void paint(Graphics graphics) {
                if (this.transparent) {
                    Rectangle clipBounds = graphics.getClipBounds();
                    int i = clipBounds.width;
                    int i2 = clipBounds.height;
                    if (getWidth() <= 0 || getHeight() <= 0) {
                        return;
                    }
                    BufferedImage bufferedImage = new BufferedImage(i, i2, 3);
                    Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
                    graphics2DCreateGraphics.setComposite(AlphaComposite.Clear);
                    graphics2DCreateGraphics.fillRect(0, 0, i, i2);
                    graphics2DCreateGraphics.dispose();
                    Graphics2D graphics2DCreateGraphics2 = bufferedImage.createGraphics();
                    graphics2DCreateGraphics2.translate(-clipBounds.x, -clipBounds.y);
                    super.paint(graphics2DCreateGraphics2);
                    graphics2DCreateGraphics2.dispose();
                    paintDirect(bufferedImage, clipBounds);
                    return;
                }
                super.paint(graphics);
            }
        }

        protected Window getWindow(Component component) {
            return component instanceof Window ? (Window) component : SwingUtilities.getWindowAncestor(component);
        }

        protected void whenDisplayable(Component component, final Runnable runnable) {
            if (component.isDisplayable() && (!Holder.requiresVisible || component.isVisible())) {
                runnable.run();
            } else if (Holder.requiresVisible) {
                getWindow(component).addWindowListener(new WindowAdapter() { // from class: com.sun.jna.platform.WindowUtils.NativeWindowUtils.1
                    public void windowOpened(WindowEvent windowEvent) {
                        windowEvent.getWindow().removeWindowListener(this);
                        runnable.run();
                    }

                    public void windowClosed(WindowEvent windowEvent) {
                        windowEvent.getWindow().removeWindowListener(this);
                    }
                });
            } else {
                component.addHierarchyListener(new HierarchyListener() { // from class: com.sun.jna.platform.WindowUtils.NativeWindowUtils.2
                    public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
                        if ((hierarchyEvent.getChangeFlags() & 2) == 0 || !hierarchyEvent.getComponent().isDisplayable()) {
                            return;
                        }
                        hierarchyEvent.getComponent().removeHierarchyListener(this);
                        runnable.run();
                    }
                });
            }
        }

        protected Raster toRaster(Shape shape) {
            if (shape != WindowUtils.MASK_NONE) {
                Rectangle bounds = shape.getBounds();
                if (bounds.width > 0 && bounds.height > 0) {
                    BufferedImage bufferedImage = new BufferedImage(bounds.x + bounds.width, bounds.y + bounds.height, 12);
                    Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
                    graphics2DCreateGraphics.setColor(Color.black);
                    graphics2DCreateGraphics.fillRect(0, 0, bounds.x + bounds.width, bounds.y + bounds.height);
                    graphics2DCreateGraphics.setColor(Color.white);
                    graphics2DCreateGraphics.fill(shape);
                    return bufferedImage.getRaster();
                }
            }
            return null;
        }

        protected Raster toRaster(Component component, Icon icon) {
            if (icon == null) {
                return null;
            }
            Rectangle rectangle = new Rectangle(0, 0, icon.getIconWidth(), icon.getIconHeight());
            BufferedImage bufferedImage = new BufferedImage(rectangle.width, rectangle.height, 2);
            Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
            graphics2DCreateGraphics.setComposite(AlphaComposite.Clear);
            graphics2DCreateGraphics.fillRect(0, 0, rectangle.width, rectangle.height);
            graphics2DCreateGraphics.setComposite(AlphaComposite.SrcOver);
            icon.paintIcon(component, graphics2DCreateGraphics, 0, 0);
            return bufferedImage.getAlphaRaster();
        }

        protected Shape toShape(Raster raster) {
            final Area area = new Area(new Rectangle(0, 0, 0, 0));
            RasterRangesUtils.outputOccupiedRanges(raster, new RasterRangesUtils.RangesOutput() { // from class: com.sun.jna.platform.WindowUtils.NativeWindowUtils.3
                @Override // com.sun.jna.platform.RasterRangesUtils.RangesOutput
                public boolean outputRange(int i, int i2, int i3, int i4) {
                    area.add(new Area(new Rectangle(i, i2, i3, i4)));
                    return true;
                }
            });
            return area;
        }

        public GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
            return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        }

        protected void setDoubleBuffered(Component component, boolean z) {
            if (component instanceof JComponent) {
                ((JComponent) component).setDoubleBuffered(z);
            }
            if ((component instanceof JRootPane) && z) {
                ((JRootPane) component).setDoubleBuffered(true);
                return;
            }
            if (component instanceof Container) {
                for (Component component2 : ((Container) component).getComponents()) {
                    setDoubleBuffered(component2, z);
                }
            }
        }

        protected void setLayersTransparent(Window window, boolean z) {
            Color color = z ? new Color(0, 0, 0, 0) : null;
            if (window instanceof RootPaneContainer) {
                JRootPane rootPane = ((RootPaneContainer) window).getRootPane();
                JLayeredPane layeredPane = rootPane.getLayeredPane();
                JComponent contentPane = rootPane.getContentPane();
                JComponent jComponent = contentPane instanceof JComponent ? contentPane : null;
                if (z) {
                    layeredPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, Boolean.valueOf(layeredPane.isOpaque()));
                    layeredPane.setOpaque(false);
                    rootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, Boolean.valueOf(rootPane.isOpaque()));
                    rootPane.setOpaque(false);
                    if (jComponent != null) {
                        jComponent.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, Boolean.valueOf(jComponent.isOpaque()));
                        jComponent.setOpaque(false);
                    }
                    rootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, rootPane.getParent().getBackground());
                } else {
                    layeredPane.setOpaque(Boolean.TRUE.equals(layeredPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE)));
                    layeredPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, (Object) null);
                    rootPane.setOpaque(Boolean.TRUE.equals(rootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE)));
                    rootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, (Object) null);
                    if (jComponent != null) {
                        jComponent.setOpaque(Boolean.TRUE.equals(jComponent.getClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE)));
                        jComponent.putClientProperty(WindowUtils.TRANSPARENT_OLD_OPAQUE, (Object) null);
                    }
                    color = (Color) rootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_BG);
                    rootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, (Object) null);
                }
            }
            window.setBackground(color);
        }

        protected void setMask(Component component, Raster raster) {
            throw new UnsupportedOperationException("Window masking is not available");
        }

        protected void setWindowMask(Component component, Raster raster) {
            if (component.isLightweight()) {
                throw new IllegalArgumentException("Component must be heavyweight: " + component);
            }
            setMask(component, raster);
        }

        public void setWindowMask(Component component, Shape shape) {
            setWindowMask(component, toRaster(shape));
        }

        public void setWindowMask(Component component, Icon icon) {
            setWindowMask(component, toRaster(component, icon));
        }

        protected void setForceHeavyweightPopups(Window window, boolean z) {
            if (window instanceof HeavyweightForcer) {
                return;
            }
            for (Window window2 : window.getOwnedWindows()) {
                if (window2 instanceof HeavyweightForcer) {
                    if (z) {
                        return;
                    } else {
                        window2.dispose();
                    }
                }
            }
            Boolean boolValueOf = Boolean.valueOf(System.getProperty("jna.force_hw_popups", "true"));
            if (z && boolValueOf.booleanValue()) {
                new HeavyweightForcer(window);
            }
        }

        protected BufferedImage getWindowIcon(WinDef.HWND hwnd) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected Dimension getIconSize(WinDef.HICON hicon) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected List<DesktopWindow> getAllWindows(boolean z) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected String getWindowTitle(WinDef.HWND hwnd) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected String getProcessFilePath(WinDef.HWND hwnd) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }

        protected Rectangle getWindowLocationAndSize(WinDef.HWND hwnd) {
            throw new UnsupportedOperationException("This platform is not supported, yet.");
        }
    }

    private static class Holder {
        public static final NativeWindowUtils INSTANCE;
        public static boolean requiresVisible;

        private Holder() {
        }

        static {
            if (Platform.isWindows()) {
                INSTANCE = new W32WindowUtils();
                return;
            }
            if (Platform.isMac()) {
                INSTANCE = new MacWindowUtils();
            } else if (Platform.isX11()) {
                INSTANCE = new X11WindowUtils();
                requiresVisible = System.getProperty("java.version").matches("^1\\.4\\..*");
            } else {
                throw new UnsupportedOperationException("No support for " + System.getProperty("os.name"));
            }
        }
    }

    private static NativeWindowUtils getInstance() {
        return Holder.INSTANCE;
    }

    private static class W32WindowUtils extends NativeWindowUtils {
        private W32WindowUtils() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public WinDef.HWND getHWnd(Component component) {
            WinDef.HWND hwnd = new WinDef.HWND();
            hwnd.setPointer(Native.getComponentPointer(component));
            return hwnd;
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public boolean isWindowAlphaSupported() {
            return Boolean.getBoolean("sun.java2d.noddraw");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean usingUpdateLayeredWindow(Window window) {
            return (window instanceof RootPaneContainer) && ((RootPaneContainer) window).getRootPane().getClientProperty(WindowUtils.TRANSPARENT_OLD_BG) != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void storeAlpha(Window window, byte b) {
            if (window instanceof RootPaneContainer) {
                ((RootPaneContainer) window).getRootPane().putClientProperty(WindowUtils.TRANSPARENT_ALPHA, b == -1 ? null : Byte.valueOf(b));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte getAlpha(Window window) {
            Byte b;
            if (!(window instanceof RootPaneContainer) || (b = (Byte) ((RootPaneContainer) window).getRootPane().getClientProperty(WindowUtils.TRANSPARENT_ALPHA)) == null) {
                return (byte) -1;
            }
            return b.byteValue();
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowAlpha(final Window window, final float f) {
            if (!isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("Set sun.java2d.noddraw=true to enable transparent windows");
            }
            whenDisplayable(window, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.W32WindowUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    WinDef.HWND hWnd = W32WindowUtils.this.getHWnd(window);
                    User32 user32 = User32.INSTANCE;
                    int iGetWindowLong = user32.GetWindowLong(hWnd, -20);
                    byte b = (byte) (((int) (f * 255.0f)) & 255);
                    if (W32WindowUtils.this.usingUpdateLayeredWindow(window)) {
                        WinUser.BLENDFUNCTION blendfunction = new WinUser.BLENDFUNCTION();
                        blendfunction.SourceConstantAlpha = b;
                        blendfunction.AlphaFormat = (byte) 1;
                        user32.UpdateLayeredWindow(hWnd, null, null, null, null, null, 0, blendfunction, 2);
                    } else if (f == 1.0f) {
                        user32.SetWindowLong(hWnd, -20, iGetWindowLong & (-524289));
                    } else {
                        user32.SetWindowLong(hWnd, -20, iGetWindowLong | 524288);
                        user32.SetLayeredWindowAttributes(hWnd, 0, b, 2);
                    }
                    W32WindowUtils.this.setForceHeavyweightPopups(window, f != 1.0f);
                    W32WindowUtils.this.storeAlpha(window, b);
                }
            });
        }

        private class W32TransparentContentPane extends NativeWindowUtils.TransparentContentPane {
            private static final long serialVersionUID = 1;
            private Dimension bitmapSize;
            private WinDef.HBITMAP hBitmap;
            private WinDef.HDC memDC;
            private Pointer pbits;

            public W32TransparentContentPane(Container container) {
                super(container);
            }

            private void disposeBackingStore() {
                GDI32 gdi32 = GDI32.INSTANCE;
                WinDef.HBITMAP hbitmap = this.hBitmap;
                if (hbitmap != null) {
                    gdi32.DeleteObject(hbitmap);
                    this.hBitmap = null;
                }
                WinDef.HDC hdc = this.memDC;
                if (hdc != null) {
                    gdi32.DeleteDC(hdc);
                    this.memDC = null;
                }
            }

            @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils.TransparentContentPane
            public void removeNotify() {
                super.removeNotify();
                disposeBackingStore();
            }

            @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils.TransparentContentPane
            public void setTransparent(boolean z) {
                super.setTransparent(z);
                if (z) {
                    return;
                }
                disposeBackingStore();
            }

            /* JADX WARN: Removed duplicated region for block: B:62:0x01d6 A[ADDED_TO_REGION] */
            @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils.TransparentContentPane
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void paintDirect(java.awt.image.BufferedImage r24, java.awt.Rectangle r25) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 476
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.platform.WindowUtils.W32WindowUtils.W32TransparentContentPane.paintDirect(java.awt.image.BufferedImage, java.awt.Rectangle):void");
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowTransparent(final Window window, final boolean z) {
            if (!(window instanceof RootPaneContainer)) {
                throw new IllegalArgumentException("Window must be a RootPaneContainer");
            }
            if (!isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("Set sun.java2d.noddraw=true to enable transparent windows");
            }
            if (z == (window.getBackground() != null && window.getBackground().getAlpha() == 0)) {
                return;
            }
            whenDisplayable(window, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.W32WindowUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    User32 user32 = User32.INSTANCE;
                    WinDef.HWND hWnd = W32WindowUtils.this.getHWnd(window);
                    int iGetWindowLong = user32.GetWindowLong(hWnd, -20);
                    JRootPane rootPane = window.getRootPane();
                    JLayeredPane layeredPane = rootPane.getLayeredPane();
                    W32TransparentContentPane contentPane = rootPane.getContentPane();
                    if (contentPane instanceof W32TransparentContentPane) {
                        contentPane.setTransparent(z);
                    } else if (z) {
                        W32TransparentContentPane w32TransparentContentPane = W32WindowUtils.this.new W32TransparentContentPane(contentPane);
                        rootPane.setContentPane(w32TransparentContentPane);
                        layeredPane.add(new RepaintTrigger(w32TransparentContentPane), JLayeredPane.DRAG_LAYER);
                    }
                    if (z && !W32WindowUtils.this.usingUpdateLayeredWindow(window)) {
                        user32.SetWindowLong(hWnd, -20, iGetWindowLong | 524288);
                    } else if (!z && W32WindowUtils.this.usingUpdateLayeredWindow(window)) {
                        user32.SetWindowLong(hWnd, -20, iGetWindowLong & (-524289));
                    }
                    W32WindowUtils.this.setLayersTransparent(window, z);
                    W32WindowUtils.this.setForceHeavyweightPopups(window, z);
                    W32WindowUtils.this.setDoubleBuffered(window, !z);
                }
            });
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowMask(Component component, Shape shape) {
            if (shape instanceof Area) {
                Area area = (Area) shape;
                if (area.isPolygonal()) {
                    setMask(component, area);
                    return;
                }
            }
            super.setWindowMask(component, shape);
        }

        private void setWindowRegion(final Component component, final WinDef.HRGN hrgn) {
            whenDisplayable(component, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.W32WindowUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    GDI32 gdi32 = GDI32.INSTANCE;
                    try {
                        boolean z = true;
                        User32.INSTANCE.SetWindowRgn(W32WindowUtils.this.getHWnd(component), hrgn, true);
                        W32WindowUtils w32WindowUtils = W32WindowUtils.this;
                        Window window = w32WindowUtils.getWindow(component);
                        if (hrgn == null) {
                            z = false;
                        }
                        w32WindowUtils.setForceHeavyweightPopups(window, z);
                    } finally {
                        gdi32.DeleteObject(hrgn);
                    }
                }
            });
        }

        private void setMask(Component component, Area area) {
            GDI32 gdi32 = GDI32.INSTANCE;
            PathIterator pathIterator = area.getPathIterator((AffineTransform) null);
            int i = pathIterator.getWindingRule() == 1 ? 2 : 1;
            float[] fArr = new float[6];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            while (!pathIterator.isDone()) {
                int iCurrentSegment = pathIterator.currentSegment(fArr);
                if (iCurrentSegment == 0) {
                    arrayList.add(new WinDef.POINT((int) fArr[0], (int) fArr[1]));
                    i2 = 1;
                } else if (iCurrentSegment == 1) {
                    i2++;
                    arrayList.add(new WinDef.POINT((int) fArr[0], (int) fArr[1]));
                } else if (iCurrentSegment == 4) {
                    arrayList2.add(Integer.valueOf(i2));
                } else {
                    throw new RuntimeException("Area is not polygonal: " + area);
                }
                pathIterator.next();
            }
            WinDef.POINT[] pointArr = (WinDef.POINT[]) new WinDef.POINT().toArray(arrayList.size());
            WinDef.POINT[] pointArr2 = (WinDef.POINT[]) arrayList.toArray(new WinDef.POINT[arrayList.size()]);
            for (int i3 = 0; i3 < pointArr.length; i3++) {
                pointArr[i3].x = pointArr2[i3].x;
                pointArr[i3].y = pointArr2[i3].y;
            }
            int size = arrayList2.size();
            int[] iArr = new int[size];
            for (int i4 = 0; i4 < size; i4++) {
                iArr[i4] = ((Integer) arrayList2.get(i4)).intValue();
            }
            setWindowRegion(component, gdi32.CreatePolyPolygonRgn(pointArr, iArr, size, i));
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        protected void setMask(Component component, Raster raster) {
            GDI32 gdi32 = GDI32.INSTANCE;
            final WinDef.HRGN hrgnCreateRectRgn = raster != null ? gdi32.CreateRectRgn(0, 0, 0, 0) : null;
            if (hrgnCreateRectRgn != null) {
                final WinDef.HRGN hrgnCreateRectRgn2 = gdi32.CreateRectRgn(0, 0, 0, 0);
                try {
                    RasterRangesUtils.outputOccupiedRanges(raster, new RasterRangesUtils.RangesOutput() { // from class: com.sun.jna.platform.WindowUtils.W32WindowUtils.4
                        @Override // com.sun.jna.platform.RasterRangesUtils.RangesOutput
                        public boolean outputRange(int i, int i2, int i3, int i4) {
                            GDI32 gdi322 = GDI32.INSTANCE;
                            gdi322.SetRectRgn(hrgnCreateRectRgn2, i, i2, i + i3, i2 + i4);
                            WinDef.HRGN hrgn = hrgnCreateRectRgn;
                            return gdi322.CombineRgn(hrgn, hrgn, hrgnCreateRectRgn2, 2) != 0;
                        }
                    });
                } finally {
                    gdi32.DeleteObject(hrgnCreateRectRgn2);
                }
            }
            setWindowRegion(component, hrgnCreateRectRgn);
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public BufferedImage getWindowIcon(WinDef.HWND hwnd) {
            WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
            WinDef.LRESULT lresultSendMessageTimeout = User32.INSTANCE.SendMessageTimeout(hwnd, 127, new WinDef.WPARAM(1L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
            if (lresultSendMessageTimeout.intValue() == 0) {
                lresultSendMessageTimeout = User32.INSTANCE.SendMessageTimeout(hwnd, 127, new WinDef.WPARAM(0L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
            }
            if (lresultSendMessageTimeout.intValue() == 0) {
                lresultSendMessageTimeout = User32.INSTANCE.SendMessageTimeout(hwnd, 127, new WinDef.WPARAM(2L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
            }
            if (lresultSendMessageTimeout.intValue() == 0) {
                lresultSendMessageTimeout = new WinDef.LRESULT(User32.INSTANCE.GetClassLongPtr(hwnd, -14).intValue());
                dWORDByReference.getValue().setValue(lresultSendMessageTimeout.intValue());
            }
            if (lresultSendMessageTimeout.intValue() == 0) {
                lresultSendMessageTimeout = new WinDef.LRESULT(User32.INSTANCE.GetClassLongPtr(hwnd, -34).intValue());
                dWORDByReference.getValue().setValue(lresultSendMessageTimeout.intValue());
            }
            if (lresultSendMessageTimeout.intValue() == 0) {
                return null;
            }
            WinDef.HICON hicon = new WinDef.HICON(new Pointer(dWORDByReference.getValue().longValue()));
            Dimension iconSize = getIconSize(hicon);
            if (iconSize.width == 0 || iconSize.height == 0) {
                return null;
            }
            int i = iconSize.width;
            int i2 = iconSize.height;
            int i3 = ((i * i2) * 24) / 8;
            byte[] bArr = new byte[i3];
            long j = i3;
            Memory memory = new Memory(j);
            byte[] bArr2 = new byte[i3];
            Memory memory2 = new Memory(j);
            WinGDI.BITMAPINFO bitmapinfo = new WinGDI.BITMAPINFO();
            WinGDI.BITMAPINFOHEADER bitmapinfoheader = new WinGDI.BITMAPINFOHEADER();
            bitmapinfo.bmiHeader = bitmapinfoheader;
            bitmapinfoheader.biWidth = i;
            bitmapinfoheader.biHeight = i2;
            bitmapinfoheader.biPlanes = (short) 1;
            bitmapinfoheader.biBitCount = (short) 24;
            bitmapinfoheader.biCompression = 0;
            bitmapinfoheader.write();
            bitmapinfo.write();
            WinDef.HDC hdcGetDC = User32.INSTANCE.GetDC(null);
            WinGDI.ICONINFO iconinfo = new WinGDI.ICONINFO();
            User32.INSTANCE.GetIconInfo(hicon, iconinfo);
            iconinfo.read();
            GDI32.INSTANCE.GetDIBits(hdcGetDC, iconinfo.hbmColor, 0, i2, memory, bitmapinfo, 0);
            memory.read(0L, bArr, 0, i3);
            GDI32.INSTANCE.GetDIBits(hdcGetDC, iconinfo.hbmMask, 0, i2, memory2, bitmapinfo, 0);
            memory2.read(0L, bArr2, 0, i3);
            BufferedImage bufferedImage = new BufferedImage(i, i2, 2);
            int i4 = i2 - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6 += 3) {
                bufferedImage.setRGB(i5, i4, (bArr[i6] & 255) | ((bArr[i6 + 1] & 255) << 8) | ((bArr[i6 + 2] & 255) << 16) | (((255 - bArr2[i6]) & 255) << 24));
                i5 = (i5 + 1) % i;
                if (i5 == 0) {
                    i4--;
                }
            }
            User32.INSTANCE.ReleaseDC(null, hdcGetDC);
            return bufferedImage;
        }

        /* JADX WARN: Finally extract failed */
        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public Dimension getIconSize(WinDef.HICON hicon) {
            WinGDI.ICONINFO iconinfo = new WinGDI.ICONINFO();
            try {
                if (!User32.INSTANCE.GetIconInfo(hicon, iconinfo)) {
                    Dimension dimension = new Dimension();
                    if (iconinfo.hbmColor != null && iconinfo.hbmColor.getPointer() != Pointer.NULL) {
                        GDI32.INSTANCE.DeleteObject(iconinfo.hbmColor);
                    }
                    if (iconinfo.hbmMask != null && iconinfo.hbmMask.getPointer() != Pointer.NULL) {
                        GDI32.INSTANCE.DeleteObject(iconinfo.hbmMask);
                    }
                    return dimension;
                }
                iconinfo.read();
                WinGDI.BITMAP bitmap = new WinGDI.BITMAP();
                if (iconinfo.hbmColor != null && iconinfo.hbmColor.getPointer() != Pointer.NULL) {
                    int iGetObject = GDI32.INSTANCE.GetObject(iconinfo.hbmColor, bitmap.size(), bitmap.getPointer());
                    bitmap.read();
                    if (iGetObject > 0) {
                        Dimension dimension2 = new Dimension(bitmap.bmWidth.intValue(), bitmap.bmHeight.intValue());
                        if (iconinfo.hbmColor != null && iconinfo.hbmColor.getPointer() != Pointer.NULL) {
                            GDI32.INSTANCE.DeleteObject(iconinfo.hbmColor);
                        }
                        if (iconinfo.hbmMask != null && iconinfo.hbmMask.getPointer() != Pointer.NULL) {
                            GDI32.INSTANCE.DeleteObject(iconinfo.hbmMask);
                        }
                        return dimension2;
                    }
                } else if (iconinfo.hbmMask != null && iconinfo.hbmMask.getPointer() != Pointer.NULL) {
                    int iGetObject2 = GDI32.INSTANCE.GetObject(iconinfo.hbmMask, bitmap.size(), bitmap.getPointer());
                    bitmap.read();
                    if (iGetObject2 > 0) {
                        Dimension dimension3 = new Dimension(bitmap.bmWidth.intValue(), bitmap.bmHeight.intValue() / 2);
                        if (iconinfo.hbmColor != null && iconinfo.hbmColor.getPointer() != Pointer.NULL) {
                            GDI32.INSTANCE.DeleteObject(iconinfo.hbmColor);
                        }
                        if (iconinfo.hbmMask != null && iconinfo.hbmMask.getPointer() != Pointer.NULL) {
                            GDI32.INSTANCE.DeleteObject(iconinfo.hbmMask);
                        }
                        return dimension3;
                    }
                }
                if (iconinfo.hbmColor != null && iconinfo.hbmColor.getPointer() != Pointer.NULL) {
                    GDI32.INSTANCE.DeleteObject(iconinfo.hbmColor);
                }
                if (iconinfo.hbmMask != null && iconinfo.hbmMask.getPointer() != Pointer.NULL) {
                    GDI32.INSTANCE.DeleteObject(iconinfo.hbmMask);
                }
                return new Dimension();
            } catch (Throwable th) {
                if (iconinfo.hbmColor != null && iconinfo.hbmColor.getPointer() != Pointer.NULL) {
                    GDI32.INSTANCE.DeleteObject(iconinfo.hbmColor);
                }
                if (iconinfo.hbmMask != null && iconinfo.hbmMask.getPointer() != Pointer.NULL) {
                    GDI32.INSTANCE.DeleteObject(iconinfo.hbmMask);
                }
                throw th;
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public List<DesktopWindow> getAllWindows(final boolean z) {
            final LinkedList linkedList = new LinkedList();
            if (User32.INSTANCE.EnumWindows(new WinUser.WNDENUMPROC() { // from class: com.sun.jna.platform.WindowUtils.W32WindowUtils.5
                @Override // com.sun.jna.platform.win32.WinUser.WNDENUMPROC
                public boolean callback(WinDef.HWND hwnd, Pointer pointer) {
                    try {
                        if (z && !User32.INSTANCE.IsWindowVisible(hwnd)) {
                            return true;
                        }
                        linkedList.add(new DesktopWindow(hwnd, W32WindowUtils.this.getWindowTitle(hwnd), W32WindowUtils.this.getProcessFilePath(hwnd), W32WindowUtils.this.getWindowLocationAndSize(hwnd)));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return true;
                    }
                }
            }, null)) {
                return linkedList;
            }
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public String getWindowTitle(WinDef.HWND hwnd) {
            int iGetWindowTextLength = User32.INSTANCE.GetWindowTextLength(hwnd) + 1;
            char[] cArr = new char[iGetWindowTextLength];
            return Native.toString(Arrays.copyOfRange(cArr, 0, User32.INSTANCE.GetWindowText(hwnd, cArr, iGetWindowTextLength)));
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public String getProcessFilePath(WinDef.HWND hwnd) {
            char[] cArr = new char[2048];
            IntByReference intByReference = new IntByReference();
            User32.INSTANCE.GetWindowThreadProcessId(hwnd, intByReference);
            WinNT.HANDLE handleOpenProcess = Kernel32.INSTANCE.OpenProcess(1040, false, intByReference.getValue());
            if (handleOpenProcess == null) {
                if (Kernel32.INSTANCE.GetLastError() == 5) {
                    return "";
                }
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            try {
                if (Psapi.INSTANCE.GetModuleFileNameExW(handleOpenProcess, null, cArr, 2048) == 0) {
                    if (Kernel32.INSTANCE.GetLastError() == 6) {
                        return "";
                    }
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }
                return Native.toString(cArr).trim();
            } finally {
                Kernel32.INSTANCE.CloseHandle(handleOpenProcess);
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public Rectangle getWindowLocationAndSize(WinDef.HWND hwnd) {
            WinDef.RECT rect = new WinDef.RECT();
            if (!User32.INSTANCE.GetWindowRect(hwnd, rect)) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            return new Rectangle(rect.left, rect.top, Math.abs(rect.right - rect.left), Math.abs(rect.bottom - rect.top));
        }
    }

    private static class MacWindowUtils extends NativeWindowUtils {
        private static final String WDRAG = "apple.awt.draggableWindowBackground";

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public boolean isWindowAlphaSupported() {
            return true;
        }

        private MacWindowUtils() {
        }

        private OSXMaskingContentPane installMaskingPane(Window window) {
            OSXMaskingContentPane oSXMaskingContentPane;
            if (window instanceof RootPaneContainer) {
                RootPaneContainer rootPaneContainer = (RootPaneContainer) window;
                OSXMaskingContentPane contentPane = rootPaneContainer.getContentPane();
                if (contentPane instanceof OSXMaskingContentPane) {
                    return contentPane;
                }
                oSXMaskingContentPane = new OSXMaskingContentPane(contentPane);
                rootPaneContainer.setContentPane(oSXMaskingContentPane);
            } else {
                Component component = window.getComponentCount() > 0 ? window.getComponent(0) : null;
                if (component instanceof OSXMaskingContentPane) {
                    return (OSXMaskingContentPane) component;
                }
                oSXMaskingContentPane = new OSXMaskingContentPane(component);
                window.add(oSXMaskingContentPane);
            }
            return oSXMaskingContentPane;
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowTransparent(Window window, boolean z) {
            if (z != (window.getBackground() != null && window.getBackground().getAlpha() == 0)) {
                setBackgroundTransparent(window, z, "setWindowTransparent");
            }
        }

        private void fixWindowDragging(Window window, String str) {
            if (window instanceof RootPaneContainer) {
                JRootPane rootPane = ((RootPaneContainer) window).getRootPane();
                if (((Boolean) rootPane.getClientProperty(WDRAG)) == null) {
                    rootPane.putClientProperty(WDRAG, Boolean.FALSE);
                    if (window.isDisplayable()) {
                        WindowUtils.LOG.log(Level.WARNING, "{0}(): To avoid content dragging, {1}() must be called before the window is realized, or apple.awt.draggableWindowBackground must be set to Boolean.FALSE before the window is realized.  If you really want content dragging, set apple.awt.draggableWindowBackground on the window''s root pane to Boolean.TRUE before calling {2}() to hide this message.", new Object[]{str, str, str});
                    }
                }
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowAlpha(final Window window, final float f) {
            if (window instanceof RootPaneContainer) {
                ((RootPaneContainer) window).getRootPane().putClientProperty("Window.alpha", Float.valueOf(f));
                fixWindowDragging(window, "setWindowAlpha");
            }
            whenDisplayable(window, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.MacWindowUtils.1
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    try {
                        Object objInvoke = window.getClass().getMethod("getPeer", new Class[0]).invoke(window, new Object[0]);
                        objInvoke.getClass().getMethod("setAlpha", Float.TYPE).invoke(objInvoke, Float.valueOf(f));
                    } catch (Exception unused) {
                    }
                }
            });
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        protected void setWindowMask(Component component, Raster raster) {
            if (raster != null) {
                setWindowMask(component, toShape(raster));
            } else {
                setWindowMask(component, (Shape) new Rectangle(0, 0, component.getWidth(), component.getHeight()));
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowMask(Component component, Shape shape) {
            if (component instanceof Window) {
                Window window = (Window) component;
                installMaskingPane(window).setMask(shape);
                setBackgroundTransparent(window, shape != WindowUtils.MASK_NONE, "setWindowMask");
            }
        }

        private static class OSXMaskingContentPane extends JPanel {
            private static final long serialVersionUID = 1;
            private Shape shape;

            public OSXMaskingContentPane(Component component) {
                super(new BorderLayout());
                if (component != null) {
                    add(component, "Center");
                }
            }

            public void setMask(Shape shape) {
                this.shape = shape;
                repaint();
            }

            public void paint(Graphics graphics) {
                Graphics2D graphics2DCreate = graphics.create();
                graphics2DCreate.setComposite(AlphaComposite.Clear);
                graphics2DCreate.fillRect(0, 0, getWidth(), getHeight());
                graphics2DCreate.dispose();
                if (this.shape != null) {
                    Graphics2D graphics2DCreate2 = graphics.create();
                    graphics2DCreate2.setClip(this.shape);
                    super.paint(graphics2DCreate2);
                    graphics2DCreate2.dispose();
                    return;
                }
                super.paint(graphics);
            }
        }

        private void setBackgroundTransparent(Window window, boolean z, String str) {
            JRootPane rootPane = window instanceof RootPaneContainer ? ((RootPaneContainer) window).getRootPane() : null;
            if (z) {
                if (rootPane != null) {
                    rootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, window.getBackground());
                }
                window.setBackground(new Color(0, 0, 0, 0));
            } else if (rootPane != null) {
                Color color = (Color) rootPane.getClientProperty(WindowUtils.TRANSPARENT_OLD_BG);
                if (color != null) {
                    color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
                }
                window.setBackground(color);
                rootPane.putClientProperty(WindowUtils.TRANSPARENT_OLD_BG, (Object) null);
            } else {
                window.setBackground((Color) null);
            }
            fixWindowDragging(window, str);
        }
    }

    private static class X11WindowUtils extends NativeWindowUtils {
        private static final String OPACITY = "_NET_WM_WINDOW_OPACITY";
        private static final long OPAQUE = 4294967295L;
        private long[] alphaVisualIDs;
        private boolean didCheck;

        private interface PixmapSource {
            X11.Pixmap getPixmap(X11.Display display, X11.Window window);
        }

        private X11WindowUtils() {
            this.alphaVisualIDs = new long[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static X11.Pixmap createBitmap(X11.Display display, X11.Window window, Raster raster) {
            X11 x11 = X11.INSTANCE;
            Rectangle bounds = raster.getBounds();
            int i = bounds.x + bounds.width;
            int i2 = bounds.y + bounds.height;
            X11.Pixmap pixmapXCreatePixmap = x11.XCreatePixmap(display, window, i, i2, 1);
            X11.GC gcXCreateGC = x11.XCreateGC(display, pixmapXCreatePixmap, new NativeLong(0L), null);
            if (gcXCreateGC == null) {
                return null;
            }
            x11.XSetForeground(display, gcXCreateGC, new NativeLong(0L));
            x11.XFillRectangle(display, pixmapXCreatePixmap, gcXCreateGC, 0, 0, i, i2);
            final ArrayList arrayList = new ArrayList();
            try {
                RasterRangesUtils.outputOccupiedRanges(raster, new RasterRangesUtils.RangesOutput() { // from class: com.sun.jna.platform.WindowUtils.X11WindowUtils.1
                    @Override // com.sun.jna.platform.RasterRangesUtils.RangesOutput
                    public boolean outputRange(int i3, int i4, int i5, int i6) {
                        arrayList.add(new Rectangle(i3, i4, i5, i6));
                        return true;
                    }
                });
                X11.XRectangle[] xRectangleArr = (X11.XRectangle[]) new X11.XRectangle().toArray(arrayList.size());
                for (int i3 = 0; i3 < xRectangleArr.length; i3++) {
                    Rectangle rectangle = (Rectangle) arrayList.get(i3);
                    xRectangleArr[i3].x = (short) rectangle.x;
                    xRectangleArr[i3].y = (short) rectangle.y;
                    xRectangleArr[i3].width = (short) rectangle.width;
                    xRectangleArr[i3].height = (short) rectangle.height;
                    Pointer pointer = xRectangleArr[i3].getPointer();
                    pointer.setShort(0L, (short) rectangle.x);
                    pointer.setShort(2L, (short) rectangle.y);
                    pointer.setShort(4L, (short) rectangle.width);
                    pointer.setShort(6L, (short) rectangle.height);
                    xRectangleArr[i3].setAutoSynch(false);
                }
                x11.XSetForeground(display, gcXCreateGC, new NativeLong(1L));
                x11.XFillRectangles(display, pixmapXCreatePixmap, gcXCreateGC, xRectangleArr, xRectangleArr.length);
                return pixmapXCreatePixmap;
            } finally {
                x11.XFreeGC(display, gcXCreateGC);
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public boolean isWindowAlphaSupported() {
            return getAlphaVisualIDs().length > 0;
        }

        private static long getVisualID(GraphicsConfiguration graphicsConfiguration) {
            try {
                return ((Number) graphicsConfiguration.getClass().getMethod("getVisual", null).invoke(graphicsConfiguration, null)).longValue();
            } catch (Exception e) {
                e.printStackTrace();
                return -1L;
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
            if (isWindowAlphaSupported()) {
                for (GraphicsDevice graphicsDevice : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()) {
                    GraphicsConfiguration[] configurations = graphicsDevice.getConfigurations();
                    for (int i = 0; i < configurations.length; i++) {
                        long visualID = getVisualID(configurations[i]);
                        for (long j : getAlphaVisualIDs()) {
                            if (visualID == j) {
                                return configurations[i];
                            }
                        }
                    }
                }
            }
            return super.getAlphaCompatibleGraphicsConfiguration();
        }

        private synchronized long[] getAlphaVisualIDs() {
            long[] jArr;
            if (this.didCheck) {
                return this.alphaVisualIDs;
            }
            this.didCheck = true;
            X11 x11 = X11.INSTANCE;
            X11.XVisualInfo xVisualInfoXGetVisualInfo = null;
            X11.Display displayXOpenDisplay = x11.XOpenDisplay(null);
            if (displayXOpenDisplay == null) {
                return this.alphaVisualIDs;
            }
            try {
                int iXDefaultScreen = x11.XDefaultScreen(displayXOpenDisplay);
                X11.XVisualInfo xVisualInfo = new X11.XVisualInfo();
                xVisualInfo.screen = iXDefaultScreen;
                xVisualInfo.depth = 32;
                xVisualInfo.c_class = 4;
                NativeLong nativeLong = new NativeLong(14L);
                IntByReference intByReference = new IntByReference();
                xVisualInfoXGetVisualInfo = x11.XGetVisualInfo(displayXOpenDisplay, nativeLong, xVisualInfo, intByReference);
                if (xVisualInfoXGetVisualInfo != null) {
                    ArrayList arrayList = new ArrayList();
                    X11.XVisualInfo[] xVisualInfoArr = (X11.XVisualInfo[]) xVisualInfoXGetVisualInfo.toArray(intByReference.getValue());
                    int i = 0;
                    for (int i2 = 0; i2 < xVisualInfoArr.length; i2++) {
                        X11.Xrender.XRenderPictFormat xRenderPictFormatXRenderFindVisualFormat = X11.Xrender.INSTANCE.XRenderFindVisualFormat(displayXOpenDisplay, xVisualInfoArr[i2].visual);
                        if (xRenderPictFormatXRenderFindVisualFormat.type == 1 && xRenderPictFormatXRenderFindVisualFormat.direct.alphaMask != 0) {
                            arrayList.add(xVisualInfoArr[i2].visualid);
                        }
                    }
                    this.alphaVisualIDs = new long[arrayList.size()];
                    while (true) {
                        jArr = this.alphaVisualIDs;
                        if (i >= jArr.length) {
                            break;
                        }
                        jArr[i] = ((Number) arrayList.get(i)).longValue();
                        i++;
                    }
                    return jArr;
                }
                if (xVisualInfoXGetVisualInfo != null) {
                    x11.XFree(xVisualInfoXGetVisualInfo.getPointer());
                }
                x11.XCloseDisplay(displayXOpenDisplay);
                return this.alphaVisualIDs;
            } finally {
                if (xVisualInfoXGetVisualInfo != null) {
                    x11.XFree(xVisualInfoXGetVisualInfo.getPointer());
                }
                x11.XCloseDisplay(displayXOpenDisplay);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static X11.Window getContentWindow(Window window, X11.Display display, X11.Window window2, Point point) {
            if (((window instanceof Frame) && !((Frame) window).isUndecorated()) || ((window instanceof Dialog) && !((Dialog) window).isUndecorated())) {
                X11 x11 = X11.INSTANCE;
                X11.WindowByReference windowByReference = new X11.WindowByReference();
                X11.WindowByReference windowByReference2 = new X11.WindowByReference();
                PointerByReference pointerByReference = new PointerByReference();
                IntByReference intByReference = new IntByReference();
                x11.XQueryTree(display, window2, windowByReference, windowByReference2, pointerByReference, intByReference);
                Pointer value = pointerByReference.getValue();
                if (value.getIntArray(0L, intByReference.getValue()).length > 0) {
                    X11.Window window3 = new X11.Window(r1[0]);
                    X11.XWindowAttributes xWindowAttributes = new X11.XWindowAttributes();
                    x11.XGetWindowAttributes(display, window3, xWindowAttributes);
                    point.x = -xWindowAttributes.x;
                    point.y = -xWindowAttributes.y;
                    window2 = window3;
                }
                if (value != null) {
                    x11.XFree(value);
                }
            }
            return window2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static X11.Window getDrawable(Component component) {
            int componentID = (int) Native.getComponentID(component);
            if (componentID == 0) {
                return null;
            }
            return new X11.Window(componentID);
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowAlpha(final Window window, final float f) {
            if (!isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("This X11 display does not provide a 32-bit visual");
            }
            whenDisplayable(window, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.X11WindowUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    X11 x11 = X11.INSTANCE;
                    X11.Display displayXOpenDisplay = x11.XOpenDisplay(null);
                    if (displayXOpenDisplay == null) {
                        return;
                    }
                    try {
                        X11.Window drawable = X11WindowUtils.getDrawable(window);
                        if (f == 1.0f) {
                            x11.XDeleteProperty(displayXOpenDisplay, drawable, x11.XInternAtom(displayXOpenDisplay, X11WindowUtils.OPACITY, false));
                        } else {
                            x11.XChangeProperty(displayXOpenDisplay, drawable, x11.XInternAtom(displayXOpenDisplay, X11WindowUtils.OPACITY, false), X11.XA_CARDINAL, 32, 0, new IntByReference((int) (r0 * 4.2949673E9f)).getPointer(), 1);
                        }
                    } finally {
                        x11.XCloseDisplay(displayXOpenDisplay);
                    }
                }
            });
        }

        private class X11TransparentContentPane extends NativeWindowUtils.TransparentContentPane {
            private static final long serialVersionUID = 1;
            private Memory buffer;
            private final int[] pixel;
            private int[] pixels;

            public X11TransparentContentPane(Container container) {
                super(container);
                this.pixel = new int[4];
            }

            @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils.TransparentContentPane
            protected void paintDirect(BufferedImage bufferedImage, Rectangle rectangle) {
                Window windowAncestor = SwingUtilities.getWindowAncestor(this);
                X11 x11 = X11.INSTANCE;
                X11.Display displayXOpenDisplay = x11.XOpenDisplay(null);
                X11.Window drawable = X11WindowUtils.getDrawable(windowAncestor);
                Point point = new Point();
                X11.Window contentWindow = X11WindowUtils.getContentWindow(windowAncestor, displayXOpenDisplay, drawable, point);
                X11.GC gcXCreateGC = x11.XCreateGC(displayXOpenDisplay, contentWindow, new NativeLong(0L), null);
                Raster data = bufferedImage.getData();
                int i = rectangle.width;
                int i2 = rectangle.height;
                Memory memory = this.buffer;
                if (memory == null || memory.size() != i * i2 * 4) {
                    this.buffer = new Memory(r5 * 4);
                    this.pixels = new int[i * i2];
                }
                int i3 = 0;
                int i4 = 0;
                while (i4 < i2) {
                    int i5 = i3;
                    while (i5 < i) {
                        data.getPixel(i5, i4, this.pixel);
                        int[] iArr = this.pixel;
                        int i6 = iArr[3] & 255;
                        Raster raster = data;
                        this.pixels[(i4 * i) + i5] = ((iArr[1] & 255) << 8) | ((iArr[i3] & 255) << 16) | (i6 << 24) | (iArr[2] & 255);
                        i5++;
                        data = raster;
                        i3 = 0;
                    }
                    i4++;
                    i3 = 0;
                }
                X11.XWindowAttributes xWindowAttributes = new X11.XWindowAttributes();
                x11.XGetWindowAttributes(displayXOpenDisplay, contentWindow, xWindowAttributes);
                X11.XImage xImageXCreateImage = x11.XCreateImage(displayXOpenDisplay, xWindowAttributes.visual, 32, 2, 0, this.buffer, i, i2, 32, i * 4);
                Memory memory2 = this.buffer;
                int[] iArr2 = this.pixels;
                memory2.write(0L, iArr2, 0, iArr2.length);
                point.x += rectangle.x;
                point.y += rectangle.y;
                x11.XPutImage(displayXOpenDisplay, contentWindow, gcXCreateGC, xImageXCreateImage, 0, 0, point.x, point.y, i, i2);
                x11.XFree(xImageXCreateImage.getPointer());
                x11.XFreeGC(displayXOpenDisplay, gcXCreateGC);
                x11.XCloseDisplay(displayXOpenDisplay);
            }
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        public void setWindowTransparent(final Window window, final boolean z) {
            if (!(window instanceof RootPaneContainer)) {
                throw new IllegalArgumentException("Window must be a RootPaneContainer");
            }
            if (!isWindowAlphaSupported()) {
                throw new UnsupportedOperationException("This X11 display does not provide a 32-bit visual");
            }
            if (!window.getGraphicsConfiguration().equals(getAlphaCompatibleGraphicsConfiguration())) {
                throw new IllegalArgumentException("Window GraphicsConfiguration '" + window.getGraphicsConfiguration() + "' does not support transparency");
            }
            if (z == (window.getBackground() != null && window.getBackground().getAlpha() == 0)) {
                return;
            }
            whenDisplayable(window, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.X11WindowUtils.3
                @Override // java.lang.Runnable
                public void run() {
                    JRootPane rootPane = window.getRootPane();
                    JLayeredPane layeredPane = rootPane.getLayeredPane();
                    X11TransparentContentPane contentPane = rootPane.getContentPane();
                    if (contentPane instanceof X11TransparentContentPane) {
                        contentPane.setTransparent(z);
                    } else if (z) {
                        X11TransparentContentPane x11TransparentContentPane = X11WindowUtils.this.new X11TransparentContentPane(contentPane);
                        rootPane.setContentPane(x11TransparentContentPane);
                        layeredPane.add(new RepaintTrigger(x11TransparentContentPane), JLayeredPane.DRAG_LAYER);
                    }
                    X11WindowUtils.this.setLayersTransparent(window, z);
                    X11WindowUtils.this.setForceHeavyweightPopups(window, z);
                    X11WindowUtils.this.setDoubleBuffered(window, !z);
                }
            });
        }

        private void setWindowShape(final Window window, final PixmapSource pixmapSource) {
            whenDisplayable(window, new Runnable() { // from class: com.sun.jna.platform.WindowUtils.X11WindowUtils.4
                /* JADX WARN: Finally extract failed */
                @Override // java.lang.Runnable
                public void run() {
                    X11 x11 = X11.INSTANCE;
                    X11.Pixmap pixmap = null;
                    X11.Display displayXOpenDisplay = x11.XOpenDisplay(null);
                    if (displayXOpenDisplay == null) {
                        return;
                    }
                    try {
                        X11.Window drawable = X11WindowUtils.getDrawable(window);
                        pixmap = pixmapSource.getPixmap(displayXOpenDisplay, drawable);
                        X11.Xext.INSTANCE.XShapeCombineMask(displayXOpenDisplay, drawable, 0, 0, 0, pixmap == null ? X11.Pixmap.None : pixmap, 0);
                        if (pixmap != null) {
                            x11.XFreePixmap(displayXOpenDisplay, pixmap);
                        }
                        x11.XCloseDisplay(displayXOpenDisplay);
                        X11WindowUtils x11WindowUtils = X11WindowUtils.this;
                        x11WindowUtils.setForceHeavyweightPopups(x11WindowUtils.getWindow(window), pixmap != null);
                    } catch (Throwable th) {
                        if (pixmap != null) {
                            x11.XFreePixmap(displayXOpenDisplay, pixmap);
                        }
                        x11.XCloseDisplay(displayXOpenDisplay);
                        throw th;
                    }
                }
            });
        }

        @Override // com.sun.jna.platform.WindowUtils.NativeWindowUtils
        protected void setMask(Component component, final Raster raster) {
            setWindowShape(getWindow(component), new PixmapSource() { // from class: com.sun.jna.platform.WindowUtils.X11WindowUtils.5
                @Override // com.sun.jna.platform.WindowUtils.X11WindowUtils.PixmapSource
                public X11.Pixmap getPixmap(X11.Display display, X11.Window window) {
                    Raster raster2 = raster;
                    if (raster2 != null) {
                        return X11WindowUtils.createBitmap(display, window, raster2);
                    }
                    return null;
                }
            });
        }
    }

    public static void setWindowMask(Window window, Shape shape) {
        getInstance().setWindowMask((Component) window, shape);
    }

    public static void setComponentMask(Component component, Shape shape) {
        getInstance().setWindowMask(component, shape);
    }

    public static void setWindowMask(Window window, Icon icon) {
        getInstance().setWindowMask((Component) window, icon);
    }

    public static boolean isWindowAlphaSupported() {
        return getInstance().isWindowAlphaSupported();
    }

    public static GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
        return getInstance().getAlphaCompatibleGraphicsConfiguration();
    }

    public static void setWindowAlpha(Window window, float f) {
        getInstance().setWindowAlpha(window, Math.max(0.0f, Math.min(f, 1.0f)));
    }

    public static void setWindowTransparent(Window window, boolean z) {
        getInstance().setWindowTransparent(window, z);
    }

    public static BufferedImage getWindowIcon(WinDef.HWND hwnd) {
        return getInstance().getWindowIcon(hwnd);
    }

    public static Dimension getIconSize(WinDef.HICON hicon) {
        return getInstance().getIconSize(hicon);
    }

    public static List<DesktopWindow> getAllWindows(boolean z) {
        return getInstance().getAllWindows(z);
    }

    public static String getWindowTitle(WinDef.HWND hwnd) {
        return getInstance().getWindowTitle(hwnd);
    }

    public static String getProcessFilePath(WinDef.HWND hwnd) {
        return getInstance().getProcessFilePath(hwnd);
    }

    public static Rectangle getWindowLocationAndSize(WinDef.HWND hwnd) {
        return getInstance().getWindowLocationAndSize(hwnd);
    }
}
