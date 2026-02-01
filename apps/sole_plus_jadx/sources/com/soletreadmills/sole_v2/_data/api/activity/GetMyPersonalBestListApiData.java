package com.soletreadmills.sole_v2._data.api.activity;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMyPersonalBestListApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData;", "", "()V", com.google.android.gms.wearable.DataMap.TAG, "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyPersonalBestListApiData {
    public static final int $stable = 0;

    /* compiled from: GetMyPersonalBestListApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$RequestBodyData;", "", "categoryType", "", "(Ljava/lang/String;)V", "getCategoryType", "()Ljava/lang/String;", "setCategoryType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("categoryType")
        private String categoryType;

        /* JADX WARN: Multi-variable type inference failed */
        public RequestBodyData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public RequestBodyData(String str) {
            this.categoryType = str;
        }

        public /* synthetic */ RequestBodyData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getCategoryType() {
            return this.categoryType;
        }

        public final void setCategoryType(String str) {
            this.categoryType = str;
        }
    }

    /* compiled from: GetMyPersonalBestListApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: GetMyPersonalBestListApiData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {

        @SerializedName("data")
        private final List<UserPersonalBestVoData> data;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataMap.data;
            }
            return dataMap.copy(list);
        }

        public final List<UserPersonalBestVoData> component1() {
            return this.data;
        }

        public final DataMap copy(List<UserPersonalBestVoData> data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            List<UserPersonalBestVoData> list = this.data;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(List<UserPersonalBestVoData> list) {
            this.data = list;
        }

        public /* synthetic */ DataMap(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<UserPersonalBestVoData> getData() {
            return this.data;
        }

        /* compiled from: GetMyPersonalBestListApiData.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n*\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n*\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyPersonalBestListApiData$DataMap$Companion;", "", "()V", "filterBestRecords", "", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "filterByYear", "year", "", "getAvailableYears", "", "getMissingPersonalBestItems", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final List<UserPersonalBestVoData> filterBestRecords(List<UserPersonalBestVoData> list) {
                Object obj;
                Intrinsics.checkNotNullParameter(list, "<this>");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (((UserPersonalBestVoData) obj2).getPersonalBestItem() != PersonalBestType.UNDEFINED) {
                        arrayList.add(obj2);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj3 : arrayList) {
                    PersonalBestType personalBestItem = ((UserPersonalBestVoData) obj3).getPersonalBestItem();
                    Object obj4 = linkedHashMap.get(personalBestItem);
                    if (obj4 == null) {
                        obj4 = (List) new ArrayList();
                        linkedHashMap.put(personalBestItem, obj4);
                    }
                    ((List) obj4).add(obj3);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    Object key = entry.getKey();
                    Iterator it = ((List) entry.getValue()).iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (it.hasNext()) {
                            Double currentBestValue = ((UserPersonalBestVoData) next).getCurrentBestValue();
                            double dDoubleValue = currentBestValue != null ? currentBestValue.doubleValue() : 0.0d;
                            do {
                                Object next2 = it.next();
                                Double currentBestValue2 = ((UserPersonalBestVoData) next2).getCurrentBestValue();
                                double dDoubleValue2 = currentBestValue2 != null ? currentBestValue2.doubleValue() : 0.0d;
                                if (Double.compare(dDoubleValue, dDoubleValue2) < 0) {
                                    next = next2;
                                    dDoubleValue = dDoubleValue2;
                                }
                            } while (it.hasNext());
                        }
                        obj = next;
                    } else {
                        obj = null;
                    }
                    linkedHashMap2.put(key, (UserPersonalBestVoData) obj);
                }
                return CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(CollectionsKt.filterNotNull(linkedHashMap2.values()), new Comparator() { // from class: com.soletreadmills.sole_v2._data.api.activity.GetMyPersonalBestListApiData$DataMap$Companion$filterBestRecords$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((UserPersonalBestVoData) t).getPersonalBestItem().ordinal()), Integer.valueOf(((UserPersonalBestVoData) t2).getPersonalBestItem().ordinal()));
                    }
                }));
            }

            public final List<UserPersonalBestVoData> filterByYear(List<UserPersonalBestVoData> list, int i) {
                Intrinsics.checkNotNullParameter(list, "<this>");
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    String eventTime = ((UserPersonalBestVoData) obj).getEventTime();
                    if (eventTime != null) {
                        try {
                            Date date = new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.getDefault()).parse(eventTime);
                            Calendar calendar = Calendar.getInstance();
                            if (date != null) {
                                calendar.setTime(date);
                                if (calendar.get(1) == i) {
                                    arrayList.add(obj);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                return CollectionsKt.toMutableList((Collection) arrayList);
            }

            public final List<Integer> getAvailableYears(List<UserPersonalBestVoData> list) {
                Intrinsics.checkNotNullParameter(list, "<this>");
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String eventTime = ((UserPersonalBestVoData) it.next()).getEventTime();
                    Integer numValueOf = null;
                    if (eventTime != null) {
                        try {
                            Date date = new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.getDefault()).parse(eventTime);
                            Calendar calendar = Calendar.getInstance();
                            if (date != null) {
                                calendar.setTime(date);
                                numValueOf = Integer.valueOf(calendar.get(1));
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (numValueOf != null) {
                        arrayList.add(numValueOf);
                    }
                }
                return CollectionsKt.sortedDescending(CollectionsKt.distinct(arrayList));
            }

            public final List<PersonalBestType> getMissingPersonalBestItems(List<UserPersonalBestVoData> list) {
                Intrinsics.checkNotNullParameter(list, "<this>");
                List<UserPersonalBestVoData> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((UserPersonalBestVoData) it.next()).getPersonalBestItem());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (((PersonalBestType) obj) != PersonalBestType.UNDEFINED) {
                        arrayList2.add(obj);
                    }
                }
                Set set = CollectionsKt.toSet(arrayList2);
                PersonalBestType[] allCases = PersonalBestType.INSTANCE.getAllCases();
                ArrayList arrayList3 = new ArrayList();
                for (PersonalBestType personalBestType : allCases) {
                    if (personalBestType != PersonalBestType.UNDEFINED) {
                        arrayList3.add(personalBestType);
                    }
                }
                return CollectionsKt.toList(SetsKt.minus(CollectionsKt.toSet(arrayList3), (Iterable) set));
            }
        }
    }
}
