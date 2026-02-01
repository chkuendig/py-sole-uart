package com.google.gms.googleservices;

import com.android.SdkConstants;
import com.google.gms.googleservices.GoogleServicesPlugin;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.file.Directory;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.logging.Logger;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;

/* compiled from: GoogleServicesTask.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J&\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 H\u0002J&\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001b2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0005*\u00060\u001bj\u0002`#H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u001b*\u00060\u001bj\u0002`#2\u0006\u0010%\u001a\u00020\u0005H\u0002J&\u0010&\u001a\u00020\u0019*\u00060\u001bj\u0002`#2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 H\u0002J&\u0010'\u001a\u00020\u0019*\u00060\u001bj\u0002`#2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 H\u0002J$\u0010(\u001a\u00020\u0019*\u00060\u001bj\u0002`#2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 J&\u0010)\u001a\u00020\u0019*\u00060\u001bj\u0002`#2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 H\u0002J$\u0010*\u001a\u00020\u0019*\u00060\u001bj\u0002`#2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u00158gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/google/gms/googleservices/GoogleServicesTask;", "Lorg/gradle/api/DefaultTask;", "()V", "applicationId", "Lorg/gradle/api/provider/Property;", "", "getApplicationId", "()Lorg/gradle/api/provider/Property;", "gmpAppId", "Ljava/io/File;", "getGmpAppId", "googleServicesJsonFiles", "", "getGoogleServicesJsonFiles", "intermediateDir", "getIntermediateDir", "()Ljava/io/File;", "missingGoogleServicesStrategy", "Lcom/google/gms/googleservices/GoogleServicesPlugin$MissingGoogleServicesStrategy;", "getMissingGoogleServicesStrategy", "outputDirectory", "Lorg/gradle/api/file/DirectoryProperty;", "getOutputDirectory", "()Lorg/gradle/api/file/DirectoryProperty;", "action", "", "getClientForPackageName", "Lcom/google/gson/JsonObject;", "jsonObject", "handleFirebaseUrl", "rootObject", "resValues", "", "handleProjectNumberAndProjectId", "getAndroidApiKey", "Lcom/google/gms/googleservices/FirebaseClientData;", "getServiceByName", "serviceName", "handleAnalytics", "handleGoogleApiKey", "handleGoogleAppId", "handleMapsService", "handleWebClientId", "Companion", "google-services-plugin"}, k = 1, mv = {1, 7, 1}, xi = 48)
@CacheableTask
/* loaded from: classes5.dex */
public abstract class GoogleServicesTask extends DefaultTask {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String JSON_FILE_NAME = "google-services.json";
    private static final String OAUTH_CLIENT_TYPE_WEB = "3";
    private static final String STATUS_DISABLED = "1";
    private static final String STATUS_ENABLED = "2";

    /* compiled from: GoogleServicesTask.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GoogleServicesPlugin.MissingGoogleServicesStrategy.values().length];
            try {
                iArr[GoogleServicesPlugin.MissingGoogleServicesStrategy.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GoogleServicesPlugin.MissingGoogleServicesStrategy.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GoogleServicesPlugin.MissingGoogleServicesStrategy.IGNORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Input
    public abstract Property<String> getApplicationId();

    @OutputFile
    public abstract Property<File> getGmpAppId();

    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    public abstract Property<Collection<File>> getGoogleServicesJsonFiles();

    @Input
    public abstract Property<GoogleServicesPlugin.MissingGoogleServicesStrategy> getMissingGoogleServicesStrategy();

    @OutputDirectory
    public abstract DirectoryProperty getOutputDirectory();

    @Internal
    public final File getIntermediateDir() {
        Object obj = getOutputDirectory().getAsFile().get();
        Intrinsics.checkNotNullExpressionValue(obj, "outputDirectory.asFile.get()");
        return (File) obj;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    @TaskAction
    public final void action() throws GradleException, JsonSyntaxException, JsonIOException, IOException {
        Object obj = getGoogleServicesJsonFiles().get();
        Intrinsics.checkNotNullExpressionValue(obj, "googleServicesJsonFiles.get()");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (((File) obj2).isFile()) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Object obj3 = getGoogleServicesJsonFiles().get();
            Intrinsics.checkNotNullExpressionValue(obj3, "googleServicesJsonFiles.get()");
            String strTrimIndent = StringsKt.trimIndent("\n                File google-services.json is missing. \n                The Google Services Plugin cannot function without it. \n                Searched locations: " + CollectionsKt.joinToString$default((Iterable) obj3, null, null, null, 0, null, new Function1<File, CharSequence>() { // from class: com.google.gms.googleservices.GoogleServicesTask$action$message$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(File it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String absolutePath = it.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                    return absolutePath;
                }
            }, 31, null) + "\n                ");
            GoogleServicesPlugin.MissingGoogleServicesStrategy missingGoogleServicesStrategy = (GoogleServicesPlugin.MissingGoogleServicesStrategy) getMissingGoogleServicesStrategy().get();
            int i = missingGoogleServicesStrategy == null ? -1 : WhenMappings.$EnumSwitchMapping$0[missingGoogleServicesStrategy.ordinal()];
            if (i == 1) {
                throw new GradleException(strTrimIndent);
            }
            if (i != 2) {
                return;
            }
            getLogger().warn(strTrimIndent);
            return;
        }
        File file = (File) CollectionsKt.first((List) arrayList2);
        getLogger().info("Parsing json file: " + file.getPath());
        File intermediateDir = ((Directory) getOutputDirectory().get()).getAsFile();
        Intrinsics.checkNotNullExpressionValue(intermediateDir, "intermediateDir");
        FilesKt.deleteRecursively(intermediateDir);
        if (!intermediateDir.mkdirs()) {
            throw new GradleException("Failed to create folder: " + intermediateDir);
        }
        JsonParser jsonParser = new JsonParser();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
        JsonElement jsonElement = jsonParser.parse(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
        if (!jsonElement.isJsonObject()) {
            throw new GradleException("Malformed root json at " + file.getAbsolutePath());
        }
        JsonObject rootObject = jsonElement.getAsJsonObject();
        TreeMap treeMap = new TreeMap();
        Intrinsics.checkNotNullExpressionValue(rootObject, "rootObject");
        handleProjectNumberAndProjectId(rootObject, treeMap);
        handleFirebaseUrl(rootObject, treeMap);
        JsonObject clientForPackageName = getClientForPackageName(rootObject);
        if (clientForPackageName != null) {
            handleAnalytics(clientForPackageName, treeMap);
            handleMapsService(clientForPackageName, treeMap);
            handleGoogleApiKey(clientForPackageName, treeMap);
            handleGoogleAppId(clientForPackageName, treeMap);
            handleWebClientId(clientForPackageName, treeMap);
            File file2 = new File(intermediateDir, SdkConstants.FD_RES_VALUES);
            if (!file2.exists() && !file2.mkdirs()) {
                throw new GradleException("Failed to create folder: " + file2);
            }
            FilesKt.writeText(new File(file2, "values.xml"), INSTANCE.getValuesContent(treeMap), Charsets.UTF_8);
            return;
        }
        throw new GradleException("No matching client found for package name '" + getApplicationId().get() + "' in " + file.getPath());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    private final void handleFirebaseUrl(JsonObject rootObject, Map<String, String> resValues) throws GradleException, IOException {
        JsonObject asJsonObject = rootObject.getAsJsonObject("project_info");
        if (asJsonObject == null) {
            throw new GradleException("Missing project_info object");
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("firebase_url");
        if (asJsonPrimitive != null) {
            resValues.put("firebase_database_url", asJsonPrimitive.getAsString());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    private final void handleProjectNumberAndProjectId(JsonObject rootObject, Map<String, String> resValues) throws GradleException, IOException {
        JsonObject asJsonObject = rootObject.getAsJsonObject("project_info");
        if (asJsonObject == null) {
            throw new GradleException("Missing project_info object");
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("project_number");
        if (asJsonPrimitive == null) {
            throw new GradleException("Missing project_info/project_number object");
        }
        resValues.put("gcm_defaultSenderId", asJsonPrimitive.getAsString());
        JsonPrimitive asJsonPrimitive2 = asJsonObject.getAsJsonPrimitive("project_id");
        if (asJsonPrimitive2 != null) {
            resValues.put("project_id", asJsonPrimitive2.getAsString());
            JsonPrimitive asJsonPrimitive3 = asJsonObject.getAsJsonPrimitive("storage_bucket");
            if (asJsonPrimitive3 != null) {
                resValues.put("google_storage_bucket", asJsonPrimitive3.getAsString());
                return;
            }
            return;
        }
        throw new GradleException("Missing project_info/project_id object");
    }

    private final JsonObject getClientForPackageName(JsonObject jsonObject) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        JsonObject asJsonObject3;
        JsonPrimitive asJsonPrimitive;
        JsonArray asJsonArray = jsonObject.getAsJsonArray("client");
        if (asJsonArray == null) {
            return null;
        }
        int size = asJsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonElement jsonElement = asJsonArray.get(i);
            if (jsonElement != null && jsonElement.isJsonObject() && (asJsonObject2 = (asJsonObject = jsonElement.getAsJsonObject()).getAsJsonObject("client_info")) != null && (asJsonObject3 = asJsonObject2.getAsJsonObject("android_client_info")) != null && (asJsonPrimitive = asJsonObject3.getAsJsonPrimitive("package_name")) != null && Intrinsics.areEqual(getApplicationId().get(), asJsonPrimitive.getAsString())) {
                return asJsonObject;
            }
        }
        return null;
    }

    /* compiled from: GoogleServicesTask.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/google/gms/googleservices/GoogleServicesTask$Companion;", "", "()V", "JSON_FILE_NAME", "", "OAUTH_CLIENT_TYPE_WEB", "STATUS_DISABLED", "STATUS_ENABLED", "getGlobalTrackerContent", "ga_trackingId", "getValuesContent", SdkConstants.FD_RES_VALUES, "", "google-services-plugin"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getGlobalTrackerContent(String ga_trackingId) {
            return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n    <string name=\"ga_trackingId\" translatable=\"false\">" + ga_trackingId + "</string>\n</resources>\n";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getValuesContent(Map<String, String> values) {
            StringBuilder sb = new StringBuilder(256);
            sb.append(StringsKt.trimIndent("\n                    <?xml version=\"1.0\" encoding=\"utf-8\"?>\n                    <resources>\n                    \n                "));
            for (Map.Entry<String, String> entry : values.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                sb.append("    <string name=\"").append(key).append("\" translatable=\"false\">");
                sb.append(value).append("</string>\n");
            }
            sb.append("</resources>\n");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
            return string;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    public final void handleGoogleAppId(JsonObject jsonObject, Map<String, String> resValues) throws GradleException, IOException {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(resValues, "resValues");
        JsonObject asJsonObject = jsonObject.getAsJsonObject("client_info");
        if (asJsonObject == null) {
            throw new GradleException("Client does not have client info");
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("mobilesdk_app_id");
        String asString = asJsonPrimitive != null ? asJsonPrimitive.getAsString() : null;
        String str = asString;
        if (str == null || str.length() == 0) {
            throw new GradleException("Missing Google App Id. Please follow instructions on https://firebase.google.com/ to get a valid config file that contains a Google App Id");
        }
        resValues.put("google_app_id", asString);
        Object obj = getGmpAppId().get();
        Intrinsics.checkNotNullExpressionValue(obj, "gmpAppId.get()");
        FilesKt.writeText((File) obj, asString, Charsets.UTF_8);
    }

    public final void handleWebClientId(JsonObject jsonObject, Map<String, String> resValues) {
        JsonObject asJsonObject;
        JsonPrimitive asJsonPrimitive;
        JsonPrimitive asJsonPrimitive2;
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Intrinsics.checkNotNullParameter(resValues, "resValues");
        JsonArray asJsonArray = jsonObject.getAsJsonArray("oauth_client");
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement = asJsonArray.get(i);
                if (jsonElement != null && jsonElement.isJsonObject() && (asJsonPrimitive = (asJsonObject = jsonElement.getAsJsonObject()).getAsJsonPrimitive("client_type")) != null && Intrinsics.areEqual("3", asJsonPrimitive.getAsString()) && (asJsonPrimitive2 = asJsonObject.getAsJsonPrimitive("client_id")) != null) {
                    resValues.put("default_web_client_id", asJsonPrimitive2.getAsString());
                    return;
                }
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    private final void handleAnalytics(JsonObject jsonObject, Map<String, String> map) throws GradleException, IOException {
        JsonObject asJsonObject;
        JsonPrimitive asJsonPrimitive;
        JsonObject serviceByName = getServiceByName(jsonObject, "analytics_service");
        if (serviceByName == null || (asJsonObject = serviceByName.getAsJsonObject("analytics_property")) == null || (asJsonPrimitive = asJsonObject.getAsJsonPrimitive("tracking_id")) == null) {
            return;
        }
        map.put("ga_trackingId", asJsonPrimitive.getAsString());
        File file = new File(((Directory) getOutputDirectory().get()).getAsFile(), "xml");
        if (!file.exists() && !file.mkdirs()) {
            throw new GradleException("Failed to create folder: " + file);
        }
        File file2 = new File(file, "global_tracker.xml");
        Companion companion = INSTANCE;
        String asString = asJsonPrimitive.getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "trackingId.asString");
        FilesKt.writeText(file2, companion.getGlobalTrackerContent(asString), Charsets.UTF_8);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    private final void handleMapsService(JsonObject jsonObject, Map<String, String> map) throws GradleException, IOException {
        if (getServiceByName(jsonObject, "maps_service") == null) {
            return;
        }
        String androidApiKey = getAndroidApiKey(jsonObject);
        if (androidApiKey != null) {
            map.put("google_maps_key", androidApiKey);
            return;
        }
        throw new GradleException("Missing api_key/current_key object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.gradle.api.GradleException */
    private final void handleGoogleApiKey(JsonObject jsonObject, Map<String, String> map) throws GradleException {
        String androidApiKey = getAndroidApiKey(jsonObject);
        if (androidApiKey != null) {
            map.put("google_api_key", androidApiKey);
            map.put("google_crash_reporting_api_key", androidApiKey);
            return;
        }
        throw new GradleException("Missing api_key/current_key object");
    }

    private final String getAndroidApiKey(JsonObject jsonObject) {
        JsonPrimitive asJsonPrimitive;
        JsonArray asJsonArray = jsonObject.getAsJsonArray("api_key");
        if (asJsonArray == null) {
            return null;
        }
        int size = asJsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonElement jsonElement = asJsonArray.get(i);
            if (jsonElement != null && jsonElement.isJsonObject() && (asJsonPrimitive = jsonElement.getAsJsonObject().getAsJsonPrimitive("current_key")) != null) {
                return asJsonPrimitive.getAsString();
            }
        }
        return null;
    }

    private final JsonObject getServiceByName(JsonObject jsonObject, String str) {
        JsonObject asJsonObject;
        JsonPrimitive asJsonPrimitive;
        JsonObject asJsonObject2 = jsonObject.getAsJsonObject("services");
        if (asJsonObject2 == null || (asJsonObject = asJsonObject2.getAsJsonObject(str)) == null || (asJsonPrimitive = asJsonObject.getAsJsonPrimitive("status")) == null) {
            return null;
        }
        String asString = asJsonPrimitive.getAsString();
        if (Intrinsics.areEqual("1", asString)) {
            return null;
        }
        if (Intrinsics.areEqual("2", asString)) {
            return asJsonObject;
        }
        Logger logger = getLogger();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("Status with value '%1$s' for service '%2$s' is unknown", Arrays.copyOf(new Object[]{asString, str}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        logger.warn(str2);
        return null;
    }
}
