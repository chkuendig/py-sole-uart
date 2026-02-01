package com.android.support;

import kotlin.Metadata;

/* compiled from: AndroidxMigrationParser.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J0\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/android/support/MigrationParserVisitor;", "", "visitClass", "", "old", "", "new", "visitGradleCoordinate", "oldGroupName", "oldArtifactName", "newGroupName", "newArtifactName", "newBaseVersion", "visitGradleCoordinateUpgrade", "groupName", "artifactName", "visitPackage", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface MigrationParserVisitor {
    void visitClass(String old, String str);

    void visitGradleCoordinate(String oldGroupName, String oldArtifactName, String newGroupName, String newArtifactName, String newBaseVersion);

    void visitGradleCoordinateUpgrade(String groupName, String artifactName, String newBaseVersion);

    void visitPackage(String old, String str);
}
