package com.android.utils;

/* loaded from: classes3.dex */
public final class Pair<S, T> {
    private final S mFirst;
    private final T mSecond;

    private Pair(S first, T second) {
        this.mFirst = first;
        this.mSecond = second;
    }

    public S getFirst() {
        return this.mFirst;
    }

    public T getSecond() {
        return this.mSecond;
    }

    public static <S, T> Pair<S, T> of(S first, T second) {
        return new Pair<>(first, second);
    }

    public String toString() {
        return "Pair [first=" + this.mFirst + ", second=" + this.mSecond + "]";
    }

    public int hashCode() {
        S s = this.mFirst;
        int iHashCode = ((s == null ? 0 : s.hashCode()) + 31) * 31;
        T t = this.mSecond;
        return iHashCode + (t != null ? t.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        S s = this.mFirst;
        if (s == null) {
            if (pair.mFirst != null) {
                return false;
            }
        } else if (!s.equals(pair.mFirst)) {
            return false;
        }
        T t = this.mSecond;
        if (t == null) {
            if (pair.mSecond != null) {
                return false;
            }
        } else if (!t.equals(pair.mSecond)) {
            return false;
        }
        return true;
    }
}
