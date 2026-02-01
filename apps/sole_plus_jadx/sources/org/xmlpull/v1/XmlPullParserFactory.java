package org.xmlpull.v1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes6.dex */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    static final Class referenceContextClass = new XmlPullParserFactory().getClass();
    protected String classNamesLocation;
    protected Hashtable features = new Hashtable();
    protected Vector parserClasses;
    protected Vector serializerClasses;

    protected XmlPullParserFactory() {
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        this.features.put(str, new Boolean(z));
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void setNamespaceAware(boolean z) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(z));
    }

    public boolean isNamespaceAware() {
        return getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    public void setValidating(boolean z) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z));
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() throws XmlPullParserException {
        Vector vector = this.parserClasses;
        if (vector == null) {
            throw new XmlPullParserException(new StringBuffer("Factory initialization was incomplete - has not tried ").append(this.classNamesLocation).toString());
        }
        if (vector.size() == 0) {
            throw new XmlPullParserException(new StringBuffer("No valid parser classes found in ").append(this.classNamesLocation).toString());
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.parserClasses.size(); i++) {
            Class cls = (Class) this.parserClasses.elementAt(i);
            try {
                XmlPullParser xmlPullParser = (XmlPullParser) cls.newInstance();
                Enumeration enumerationKeys = this.features.keys();
                while (enumerationKeys.hasMoreElements()) {
                    String str = (String) enumerationKeys.nextElement();
                    Boolean bool = (Boolean) this.features.get(str);
                    if (bool != null && bool.booleanValue()) {
                        xmlPullParser.setFeature(str, true);
                    }
                }
                return xmlPullParser;
            } catch (Exception e) {
                stringBuffer.append(new StringBuffer().append(cls.getName()).append(": ").append(e.toString()).append("; ").toString());
            }
        }
        throw new XmlPullParserException(new StringBuffer("could not create parser: ").append((Object) stringBuffer).toString());
    }

    public XmlSerializer newSerializer() throws XmlPullParserException {
        Vector vector = this.serializerClasses;
        if (vector == null) {
            throw new XmlPullParserException(new StringBuffer("Factory initialization incomplete - has not tried ").append(this.classNamesLocation).toString());
        }
        if (vector.size() == 0) {
            throw new XmlPullParserException(new StringBuffer("No valid serializer classes found in ").append(this.classNamesLocation).toString());
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.serializerClasses.size(); i++) {
            Class cls = (Class) this.serializerClasses.elementAt(i);
            try {
                return (XmlSerializer) cls.newInstance();
            } catch (Exception e) {
                stringBuffer.append(new StringBuffer().append(cls.getName()).append(": ").append(e.toString()).append("; ").toString());
            }
        }
        throw new XmlPullParserException(new StringBuffer("could not create serializer: ").append((Object) stringBuffer).toString());
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ce A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.xmlpull.v1.XmlPullParserFactory newInstance(java.lang.String r12, java.lang.Class r13) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.v1.XmlPullParserFactory.newInstance(java.lang.String, java.lang.Class):org.xmlpull.v1.XmlPullParserFactory");
    }
}
