package com.android.prefs;

import com.android.io.CancellableFileIo;
import com.android.utils.EnvironmentProvider;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: AbstractAndroidLocations.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0014J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J!\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u001b*\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/android/prefs/PathLocator;", "", "environmentProvider", "Lcom/android/utils/EnvironmentProvider;", "(Lcom/android/utils/EnvironmentProvider;)V", "visitedVariables", "", "Lcom/android/prefs/QueryResult;", "getVisitedVariables", "()Ljava/util/List;", "firstPathOf", "Ljava/nio/file/Path;", "globalVars", "", "Lcom/android/prefs/Global;", "([Lcom/android/prefs/Global;)Ljava/nio/file/Path;", "handlePath", "globalVar", "path", "queryPath", "Lcom/android/prefs/VariableValue;", "queryType", "Lcom/android/prefs/VariableType;", "reset", "", "singlePathOf", "gatherPaths", "", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
class PathLocator {
    private final EnvironmentProvider environmentProvider;
    private final List<QueryResult> visitedVariables;

    /* compiled from: AbstractAndroidLocations.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VariableType.values().length];
            iArr[VariableType.SYS_PROP.ordinal()] = 1;
            iArr[VariableType.ENV_VAR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PathLocator(EnvironmentProvider environmentProvider) {
        Intrinsics.checkNotNullParameter(environmentProvider, "environmentProvider");
        this.environmentProvider = environmentProvider;
        this.visitedVariables = new ArrayList();
    }

    public final List<QueryResult> getVisitedVariables() {
        return this.visitedVariables;
    }

    public final void reset() {
        this.visitedVariables.clear();
    }

    public final Path firstPathOf(Global... globalVars) {
        Intrinsics.checkNotNullParameter(globalVars, "globalVars");
        int length = globalVars.length;
        int i = 0;
        while (i < length) {
            Global global = globalVars[i];
            i++;
            Path pathSinglePathOf = singlePathOf(global);
            if (pathSinglePathOf != null) {
                return pathSinglePathOf;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Path singlePathOf(Global... globalVars) {
        Intrinsics.checkNotNullParameter(globalVars, "globalVars");
        List list = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.map(ArraysKt.asSequence(globalVars), new Function1<Global, List<? extends VariableValue>>() { // from class: com.android.prefs.PathLocator$singlePathOf$values$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<VariableValue> invoke(Global it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return this.this$0.gatherPaths(it);
            }
        }), new Function1<List<? extends VariableValue>, Sequence<? extends VariableValue>>() { // from class: com.android.prefs.PathLocator$singlePathOf$values$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Sequence<? extends VariableValue> invoke(List<? extends VariableValue> list2) {
                return invoke2((List<VariableValue>) list2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Sequence<VariableValue> invoke2(List<VariableValue> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return CollectionsKt.asSequence(it);
            }
        }));
        Throwable th = null;
        Object[] objArr = 0;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return ((VariableValue) CollectionsKt.single(list)).getCorrectPath();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Path correctPath = ((VariableValue) obj).getCorrectPath();
            Object obj2 = linkedHashMap.get(correctPath);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(correctPath, obj2);
            }
            ((List) obj2).add(obj);
        }
        if (linkedHashMap.size() == 1) {
            return (Path) CollectionsKt.single(linkedHashMap.keySet());
        }
        throw new AndroidLocationsException(AbstractAndroidLocationsKt.combineLocationValuesIntoMessage$default(list, "Several environment variables and/or system properties contain different paths to the Android Preferences folder.\nPlease correct and use only one way to inject the preference location.", "It is recommended to use ANDROID_USER_HOME as other methods are deprecated", null, 8, null), th, 2, objArr == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<VariableValue> gatherPaths(Global global) {
        return CollectionsKt.listOfNotNull((Object[]) new VariableValue[]{global.getIsSysProp() ? queryPath(global, VariableType.SYS_PROP) : null, global.getIsEnvVar() ? queryPath(global, VariableType.ENV_VAR) : null});
    }

    protected Path handlePath(Global globalVar, Path path) {
        Intrinsics.checkNotNullParameter(globalVar, "globalVar");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!globalVar.getMustExist() || CancellableFileIo.isDirectory(path, new LinkOption[0])) {
            return path;
        }
        return null;
    }

    private final VariableValue queryPath(Global globalVar, VariableType queryType) {
        String systemProperty;
        int i = WhenMappings.$EnumSwitchMapping$0[queryType.ordinal()];
        if (i == 1) {
            systemProperty = this.environmentProvider.getSystemProperty(globalVar.getPropName());
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            systemProperty = this.environmentProvider.getEnvVariable(globalVar.getPropName());
        }
        if (systemProperty == null) {
            return null;
        }
        Path path = this.environmentProvider.getFileSystem().getPath(systemProperty, new String[0]);
        List<QueryResult> list = this.visitedVariables;
        Intrinsics.checkNotNullExpressionValue(path, "path");
        list.add(new QueryResult(globalVar, queryType, path));
        Path pathHandlePath = handlePath(globalVar, path);
        if (pathHandlePath == null) {
            return null;
        }
        return new VariableValue(globalVar.getPropName(), queryType, path, pathHandlePath);
    }
}
