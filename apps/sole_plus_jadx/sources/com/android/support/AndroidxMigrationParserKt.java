package com.android.support;

import com.android.utils.XmlUtils;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: AndroidxMigrationParser.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"ATTR_ARTIFACT_NAME", "", "ATTR_GROUP_NAME", "ATTR_NEW_ARTIFACT_NAME", "ATTR_NEW_BASE_VERSION_NAME", "ATTR_NEW_GROUP_NAME", "ATTR_NEW_NAME", "ATTR_OLD_ARTIFACT_NAME", "ATTR_OLD_GROUP_NAME", "ATTR_OLD_NAME", "ATTR_TYPE", "MIGRATE_DEPENDENCY_NAME", "MIGRATE_ENTRY_NAME", "ROOT_ELEMENT", "TYPE_CLASS", "TYPE_PACKAGE", "UPGRADE_DEPENDENCY_NAME", "parseMigrationFile", "", "visitor", "Lcom/android/support/MigrationParserVisitor;", "common"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidxMigrationParserKt {
    private static final String ATTR_ARTIFACT_NAME = "artifact-name";
    private static final String ATTR_GROUP_NAME = "group-name";
    private static final String ATTR_NEW_ARTIFACT_NAME = "new-artifact-name";
    private static final String ATTR_NEW_BASE_VERSION_NAME = "base-version";
    private static final String ATTR_NEW_GROUP_NAME = "new-group-name";
    private static final String ATTR_NEW_NAME = "new-name";
    private static final String ATTR_OLD_ARTIFACT_NAME = "old-artifact-name";
    private static final String ATTR_OLD_GROUP_NAME = "old-group-name";
    private static final String ATTR_OLD_NAME = "old-name";
    private static final String ATTR_TYPE = "type";
    private static final String MIGRATE_DEPENDENCY_NAME = "migrate-dependency";
    private static final String MIGRATE_ENTRY_NAME = "migrate";
    private static final String ROOT_ELEMENT = "migration-map";
    private static final String TYPE_CLASS = "CLASS";
    private static final String TYPE_PACKAGE = "PACKAGE";
    private static final String UPGRADE_DEPENDENCY_NAME = "upgrade-dependency";

    public static final void parseMigrationFile(MigrationParserVisitor visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        InputStream resourceAsStream = MigrationParserVisitor.class.getResourceAsStream("migrateToAndroidx/migration.xml");
        Intrinsics.checkNotNull(resourceAsStream);
        InputStream inputStream = resourceAsStream;
        try {
            Document document = XmlUtils.parseDocument((Reader) new InputStreamReader(resourceAsStream), false);
            Intrinsics.checkNotNullExpressionValue(document, "parseDocument(InputStreamReader(stream), false)");
            Element documentElement = document.getDocumentElement();
            if (!Intrinsics.areEqual(ROOT_ELEMENT, documentElement.getNodeName())) {
                throw new InvalidDataException("Migration file does not start with <migration-map>");
            }
            Iterable<Element> subTags = XmlUtils.getSubTags(documentElement);
            Intrinsics.checkNotNullExpressionValue(subTags, "getSubTags(root)");
            for (Element element : subTags) {
                if (Intrinsics.areEqual(element.getNodeName(), MIGRATE_ENTRY_NAME)) {
                    String oldName = element.getAttribute(ATTR_OLD_NAME);
                    String newName = element.getAttribute(ATTR_NEW_NAME);
                    String attribute = element.getAttribute("type");
                    if (Intrinsics.areEqual(attribute, TYPE_PACKAGE)) {
                        Intrinsics.checkNotNullExpressionValue(oldName, "oldName");
                        Intrinsics.checkNotNullExpressionValue(newName, "newName");
                        visitor.visitPackage(oldName, newName);
                    } else {
                        if (!Intrinsics.areEqual(attribute, TYPE_CLASS)) {
                            throw new InvalidDataException(Intrinsics.stringPlus("Invalid type ", attribute));
                        }
                        Intrinsics.checkNotNullExpressionValue(oldName, "oldName");
                        Intrinsics.checkNotNullExpressionValue(newName, "newName");
                        visitor.visitClass(oldName, newName);
                    }
                } else if (Intrinsics.areEqual(element.getNodeName(), MIGRATE_DEPENDENCY_NAME)) {
                    String oldGroupName = element.getAttribute(ATTR_OLD_GROUP_NAME);
                    String oldArtifactName = element.getAttribute(ATTR_OLD_ARTIFACT_NAME);
                    String newGroupName = element.getAttribute(ATTR_NEW_GROUP_NAME);
                    String newArtifactName = element.getAttribute(ATTR_NEW_ARTIFACT_NAME);
                    String newBaseVersion = element.getAttribute(ATTR_NEW_BASE_VERSION_NAME);
                    Intrinsics.checkNotNullExpressionValue(oldGroupName, "oldGroupName");
                    Intrinsics.checkNotNullExpressionValue(oldArtifactName, "oldArtifactName");
                    Intrinsics.checkNotNullExpressionValue(newGroupName, "newGroupName");
                    Intrinsics.checkNotNullExpressionValue(newArtifactName, "newArtifactName");
                    Intrinsics.checkNotNullExpressionValue(newBaseVersion, "newBaseVersion");
                    visitor.visitGradleCoordinate(oldGroupName, oldArtifactName, newGroupName, newArtifactName, newBaseVersion);
                } else if (Intrinsics.areEqual(element.getNodeName(), UPGRADE_DEPENDENCY_NAME)) {
                    String groupName = element.getAttribute(ATTR_GROUP_NAME);
                    String artifactName = element.getAttribute(ATTR_ARTIFACT_NAME);
                    String baseVersion = element.getAttribute(ATTR_NEW_BASE_VERSION_NAME);
                    Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
                    Intrinsics.checkNotNullExpressionValue(artifactName, "artifactName");
                    Intrinsics.checkNotNullExpressionValue(baseVersion, "baseVersion");
                    visitor.visitGradleCoordinateUpgrade(groupName, artifactName, baseVersion);
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(inputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }
}
