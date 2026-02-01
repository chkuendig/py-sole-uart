package com.android.support;

/* loaded from: classes3.dex */
public class AndroidxName {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final String myNewName;
    private final String myOldName;

    private AndroidxName(String oldName, String newName) {
        this.myOldName = oldName;
        this.myNewName = newName;
    }

    public static AndroidxName of(String oldPackage, String simpleClassName) {
        String str = oldPackage + simpleClassName;
        return new AndroidxName(str, AndroidxNameUtils.getNewName(str));
    }

    public static AndroidxName of(AndroidxName pkg, String simpleClassName) {
        return new AndroidxName(pkg.oldName() + (pkg.oldName().endsWith(".") ? "" : ".") + simpleClassName, pkg.newName() + (pkg.newName().endsWith(".") ? "" : ".") + simpleClassName);
    }

    public static AndroidxName of(String oldPackageName) {
        return new AndroidxName(oldPackageName, AndroidxNameUtils.getPackageMapping(oldPackageName, true));
    }

    public String oldName() {
        return this.myOldName;
    }

    public String newName() {
        return this.myNewName;
    }

    public String defaultName() {
        return this.myOldName;
    }

    public boolean isPrefix(String name) {
        return isPrefix(name, false);
    }

    public boolean isPrefix(String name, boolean strict) {
        if (name == null) {
            return false;
        }
        if (name.startsWith(oldName())) {
            return !strict || oldName().length() < name.length();
        }
        if (name.startsWith(newName())) {
            return !strict || newName().length() < name.length();
        }
        return false;
    }

    public String removeFrom(String qualifiedName) {
        if (qualifiedName.startsWith(oldName())) {
            return qualifiedName.substring(oldName().length());
        }
        return qualifiedName.startsWith(newName()) ? qualifiedName.substring(newName().length()) : qualifiedName;
    }

    public boolean isEquals(String strName) {
        if (strName == null) {
            return false;
        }
        return this.myOldName.equals(strName) || this.myNewName.equals(strName);
    }

    public boolean isEqualsIgnoreCase(String strName) {
        if (strName == null) {
            return false;
        }
        return this.myOldName.equalsIgnoreCase(strName) || this.myNewName.equalsIgnoreCase(strName);
    }

    public boolean equals(Object other) {
        if (other instanceof String) {
            throw new IllegalStateException("You probably meant to call isEquals!");
        }
        return super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }
}
