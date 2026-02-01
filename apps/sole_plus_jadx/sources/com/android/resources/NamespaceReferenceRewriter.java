package com.android.resources;

import com.android.SdkConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: NamespaceReferenceRewriter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/resources/NamespaceReferenceRewriter;", "", "localPackage", "", "packageProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "type", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "rewriteManifestNode", "", "node", "Lorg/w3c/dom/Node;", "localLib", "", "rewritePossibleReference", "Lcom/android/resources/NamespaceReferenceRewriter$RewrittenReference;", "content", "writeLocalPackage", "RewrittenReference", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NamespaceReferenceRewriter {
    private final String localPackage;
    private final Function2<String, String, String> packageProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public NamespaceReferenceRewriter(String localPackage, Function2<? super String, ? super String, String> packageProvider) {
        Intrinsics.checkNotNullParameter(localPackage, "localPackage");
        Intrinsics.checkNotNullParameter(packageProvider, "packageProvider");
        this.localPackage = localPackage;
        this.packageProvider = packageProvider;
    }

    public final void rewriteManifestNode(Node node, boolean localLib) throws DOMException {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.getNodeType() == 2) {
            String content = node.getNodeValue();
            Intrinsics.checkNotNullExpressionValue(content, "content");
            String content2 = rewritePossibleReference(content, true, localLib).getContent();
            if (!Intrinsics.areEqual(content, content2)) {
                node.setNodeValue(content2);
            }
        }
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            ArrayList arrayList = new ArrayList(attributes.getLength());
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                arrayList.add(attributes.item(i));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                rewriteManifestNode((Node) it.next(), localLib);
            }
        }
        NodeList childNodes = node.getChildNodes();
        if (childNodes == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(childNodes.getLength());
        int length2 = childNodes.getLength();
        for (int i2 = 0; i2 < length2; i2++) {
            arrayList2.add(childNodes.item(i2));
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            rewriteManifestNode((Node) it2.next(), localLib);
        }
    }

    public final void rewriteManifestNode(Node node) throws DOMException {
        Intrinsics.checkNotNullParameter(node, "node");
        rewriteManifestNode(node, false);
    }

    /* compiled from: NamespaceReferenceRewriter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/android/resources/NamespaceReferenceRewriter$RewrittenReference;", "", "content", "", "pckg", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getPckg", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class RewrittenReference {
        private final String content;
        private final String pckg;

        public static /* synthetic */ RewrittenReference copy$default(RewrittenReference rewrittenReference, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rewrittenReference.content;
            }
            if ((i & 2) != 0) {
                str2 = rewrittenReference.pckg;
            }
            return rewrittenReference.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final String getPckg() {
            return this.pckg;
        }

        public final RewrittenReference copy(String content, String pckg) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(pckg, "pckg");
            return new RewrittenReference(content, pckg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RewrittenReference)) {
                return false;
            }
            RewrittenReference rewrittenReference = (RewrittenReference) other;
            return Intrinsics.areEqual(this.content, rewrittenReference.content) && Intrinsics.areEqual(this.pckg, rewrittenReference.pckg);
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + this.pckg.hashCode();
        }

        public String toString() {
            return "RewrittenReference(content=" + this.content + ", pckg=" + this.pckg + ')';
        }

        public RewrittenReference(String content, String pckg) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(pckg, "pckg");
            this.content = content;
            this.pckg = pckg;
        }

        public /* synthetic */ RewrittenReference(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getPckg() {
            return this.pckg;
        }
    }

    public static /* synthetic */ RewrittenReference rewritePossibleReference$default(NamespaceReferenceRewriter namespaceReferenceRewriter, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return namespaceReferenceRewriter.rewritePossibleReference(str, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RewrittenReference rewritePossibleReference(String content, boolean writeLocalPackage, boolean localLib) {
        Intrinsics.checkNotNullParameter(content, "content");
        String str = SdkConstants.PREFIX_RESOURCE_REF;
        int i = 2;
        String str2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        if (!StringsKt.startsWith$default(content, SdkConstants.PREFIX_RESOURCE_REF, false, 2, (Object) null) && !StringsKt.startsWith$default(content, SdkConstants.PREFIX_THEME_REF, false, 2, (Object) null)) {
            return new RewrittenReference(content, str2, i, objArr9 == true ? 1 : 0);
        }
        String str3 = content;
        if (!StringsKt.contains$default((CharSequence) str3, (CharSequence) "/", false, 2, (Object) null)) {
            return new RewrittenReference(content, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (StringsKt.startsWith$default(content, "@+", false, 2, (Object) null)) {
            return new RewrittenReference(content, objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (StringsKt.contains$default((CharSequence) str3, ':', false, 2, (Object) null)) {
            return new RewrittenReference(content, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        String string = StringsKt.trim((CharSequence) str3).toString();
        String strDrop = StringsKt.drop(StringsKt.substringBefore$default(string, '/', (String) null, 2, (Object) null), 1);
        String strSubstringAfter$default = StringsKt.substringAfter$default(string, '/', (String) null, 2, (Object) null);
        String strInvoke = this.packageProvider.invoke(strDrop, strSubstringAfter$default);
        if (!StringsKt.startsWith$default((CharSequence) str3, '@', false, 2, (Object) null)) {
            str = SdkConstants.PREFIX_THEME_REF;
        } else if (!Intrinsics.areEqual(strInvoke, this.localPackage) || !localLib) {
            str = "@*";
        }
        if (!writeLocalPackage && Intrinsics.areEqual(strInvoke, this.localPackage)) {
            return new RewrittenReference(content, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        return new RewrittenReference(str + strInvoke + ':' + strDrop + '/' + strSubstringAfter$default, strInvoke);
    }
}
