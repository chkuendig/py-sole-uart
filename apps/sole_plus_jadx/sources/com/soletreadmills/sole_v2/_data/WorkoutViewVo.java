package com.soletreadmills.sole_v2._data;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._type.CategoryType;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import com.soletreadmills.sole_v2._type.WorkoutDataSourceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutViewVo.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\bU\b\u0087\b\u0018\u0000 ´\u00012\u00020\u0001:\u0002´\u0001B½\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010(\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010$\u0012\b\u00105\u001a\u0004\u0018\u000106\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u000108¢\u0006\u0002\u00109J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010jJ\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010jJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010jJ\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010jJ\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010jJ\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010jJ\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010<J\u0012\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$HÆ\u0003J\u0012\u0010\u0099\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$HÆ\u0003J\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010jJ\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010(HÆ\u0003J\u0012\u0010\u009f\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$HÂ\u0003J\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010jJ\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010$HÆ\u0003J\u0011\u0010¦\u0001\u001a\u0004\u0018\u000106HÆ\u0003¢\u0006\u0002\u0010ZJ\u0012\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u000108HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010jJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010jJÊ\u0004\u0010\u00ad\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010(2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010$2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u000108HÆ\u0001¢\u0006\u0003\u0010®\u0001J\u0015\u0010¯\u0001\u001a\u0002062\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\r\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000$J\n\u0010²\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010³\u0001\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010:R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010:R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010:R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\b>\u0010<R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\b?\u0010<R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\b@\u0010<R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bA\u0010<R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bB\u0010<R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bC\u0010<R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bD\u0010<R\u0019\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:R\u0011\u0010I\u001a\u00020J8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\"\u00107\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010H\"\u0004\bN\u0010OR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u00102\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010QR\u0011\u0010S\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010)\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u001e\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\b5\u0010Z\"\u0004\b[\u0010\\R\u0013\u0010*\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b^\u0010XR\u0011\u0010_\u001a\u00020`8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bc\u0010QR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bd\u0010QR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\be\u0010QR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bf\u0010QR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u0010QR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bh\u0010<R\u0015\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010:\u001a\u0004\bi\u0010jR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bk\u0010QR\u0019\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bl\u0010HR\u0011\u0010m\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\bn\u0010VR\u0013\u0010+\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bo\u0010XR\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bp\u0010HR\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bq\u0010HR\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bt\u0010QR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bu\u0010QR\u0015\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010:\u001a\u0004\bv\u0010jR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bw\u0010<R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\bx\u0010<R\u0015\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010:\u001a\u0004\by\u0010jR\u0015\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010:\u001a\u0004\bz\u0010jR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010:\u001a\u0004\b{\u0010jR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b|\u0010QR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010=\u001a\u0004\b}\u0010<R\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007f¨\u0006µ\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "", "brandId", "", "userWorkoutUuid", "", "machineName", "machineUuid", "machineMac", "machineModelName", "modelNameFromMachine", "_dataSource", "_machineCategoryType", "timeZone", "_activityType", "_rootActivityType", "startTime", SDKConstants.PARAM_END_TIME, "programName", "avgIncline", "", "avgLevel", "avgHeartRate", "avgMet", "avgPace", "avgSpeed", "avgWatt", "avgCadence", "peakHeartRate", "vertical", "totalTime", "totalDistance", "totalCalories", "totalSteps", "totalElevation", "splits", "", "splitsImperial", "profileInterval", "hrProfile", "Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;", "inclineProfile", "levelProfile", "speedProfile", "_bestList", "totalStrokes", "videoRefData", "Lcom/soletreadmills/sole_v2/_data/VideoRefDataVo;", "srvoRefData", "Lcom/soletreadmills/sole_v2/_data/SrvoRefDataVo;", "externalWorkoutUuid", "rawDataList", "Lcom/soletreadmills/sole_v2/_data/WorkoutRawData4WorkoutDetailDisplay;", "isPrimaryInDuplicateGroup", "", "duplicateList", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Ljava/util/List;Ljava/lang/Integer;Lcom/soletreadmills/sole_v2/_data/VideoRefDataVo;Lcom/soletreadmills/sole_v2/_data/SrvoRefDataVo;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)V", "Ljava/lang/Integer;", "getAvgCadence", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAvgHeartRate", "getAvgIncline", "getAvgLevel", "getAvgMet", "getAvgPace", "getAvgSpeed", "getAvgWatt", "bestList", "Lcom/soletreadmills/sole_v2/_type/PersonalBestType;", "getBestList", "()Ljava/util/List;", "dataSource", "Lcom/soletreadmills/sole_v2/_type/WorkoutDataSourceType;", "getDataSource", "()Lcom/soletreadmills/sole_v2/_type/WorkoutDataSourceType;", "getDuplicateList", "setDuplicateList", "(Ljava/util/List;)V", "getEndTime", "()Ljava/lang/String;", "getExternalWorkoutUuid", "historyActivityType", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "getHistoryActivityType", "()Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "getHrProfile", "()Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;", "getInclineProfile", "()Ljava/lang/Boolean;", "setPrimaryInDuplicateGroup", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLevelProfile", "machineCategoryType", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getMachineCategoryType", "()Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getMachineMac", "getMachineModelName", "getMachineName", "getMachineUuid", "getModelNameFromMachine", "getPeakHeartRate", "getProfileInterval", "()Ljava/lang/Integer;", "getProgramName", "getRawDataList", "rootHistoryActivityType", "getRootHistoryActivityType", "getSpeedProfile", "getSplits", "getSplitsImperial", "getSrvoRefData", "()Lcom/soletreadmills/sole_v2/_data/SrvoRefDataVo;", "getStartTime", "getTimeZone", "getTotalCalories", "getTotalDistance", "getTotalElevation", "getTotalSteps", "getTotalStrokes", "getTotalTime", "getUserWorkoutUuid", "getVertical", "getVideoRefData", "()Lcom/soletreadmills/sole_v2/_data/VideoRefDataVo;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Lcom/soletreadmills/sole_v2/_data/WorkoutProfile;Ljava/util/List;Ljava/lang/Integer;Lcom/soletreadmills/sole_v2/_data/VideoRefDataVo;Lcom/soletreadmills/sole_v2/_data/SrvoRefDataVo;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "equals", "other", "expand", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class WorkoutViewVo {

    @SerializedName("activityType")
    private final Integer _activityType;
    private final List<String> _bestList;

    @SerializedName("dataSource")
    private final Integer _dataSource;

    @SerializedName("machineCategoryType")
    private final Integer _machineCategoryType;

    @SerializedName("rootActivityType")
    private final Integer _rootActivityType;
    private final Double avgCadence;
    private final Double avgHeartRate;
    private final Double avgIncline;
    private final Double avgLevel;
    private final Double avgMet;
    private final Double avgPace;
    private final Double avgSpeed;
    private final Double avgWatt;
    private final Integer brandId;
    private List<WorkoutViewVo> duplicateList;
    private final String endTime;
    private final String externalWorkoutUuid;
    private final WorkoutProfile hrProfile;
    private final WorkoutProfile inclineProfile;
    private Boolean isPrimaryInDuplicateGroup;
    private final WorkoutProfile levelProfile;
    private final String machineMac;
    private final String machineModelName;
    private final String machineName;
    private final String machineUuid;
    private final String modelNameFromMachine;
    private final Double peakHeartRate;
    private final Integer profileInterval;
    private final String programName;
    private final List<WorkoutRawData4WorkoutDetailDisplay> rawDataList;
    private final WorkoutProfile speedProfile;
    private final List<Integer> splits;
    private final List<Integer> splitsImperial;
    private final SrvoRefDataVo srvoRefData;
    private final String startTime;
    private final String timeZone;
    private final Integer totalCalories;
    private final Double totalDistance;
    private final Double totalElevation;
    private final Integer totalSteps;
    private final Integer totalStrokes;
    private final Integer totalTime;
    private final String userWorkoutUuid;
    private final Double vertical;
    private final VideoRefDataVo videoRefData;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: component1, reason: from getter */
    private final Integer getBrandId() {
        return this.brandId;
    }

    /* renamed from: component11, reason: from getter */
    private final Integer get_activityType() {
        return this._activityType;
    }

    /* renamed from: component12, reason: from getter */
    private final Integer get_rootActivityType() {
        return this._rootActivityType;
    }

    private final List<String> component38() {
        return this._bestList;
    }

    /* renamed from: component8, reason: from getter */
    private final Integer get_dataSource() {
        return this._dataSource;
    }

    /* renamed from: component9, reason: from getter */
    private final Integer get_machineCategoryType() {
        return this._machineCategoryType;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* renamed from: component13, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component14, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: component15, reason: from getter */
    public final String getProgramName() {
        return this.programName;
    }

    /* renamed from: component16, reason: from getter */
    public final Double getAvgIncline() {
        return this.avgIncline;
    }

    /* renamed from: component17, reason: from getter */
    public final Double getAvgLevel() {
        return this.avgLevel;
    }

    /* renamed from: component18, reason: from getter */
    public final Double getAvgHeartRate() {
        return this.avgHeartRate;
    }

    /* renamed from: component19, reason: from getter */
    public final Double getAvgMet() {
        return this.avgMet;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserWorkoutUuid() {
        return this.userWorkoutUuid;
    }

    /* renamed from: component20, reason: from getter */
    public final Double getAvgPace() {
        return this.avgPace;
    }

    /* renamed from: component21, reason: from getter */
    public final Double getAvgSpeed() {
        return this.avgSpeed;
    }

    /* renamed from: component22, reason: from getter */
    public final Double getAvgWatt() {
        return this.avgWatt;
    }

    /* renamed from: component23, reason: from getter */
    public final Double getAvgCadence() {
        return this.avgCadence;
    }

    /* renamed from: component24, reason: from getter */
    public final Double getPeakHeartRate() {
        return this.peakHeartRate;
    }

    /* renamed from: component25, reason: from getter */
    public final Double getVertical() {
        return this.vertical;
    }

    /* renamed from: component26, reason: from getter */
    public final Integer getTotalTime() {
        return this.totalTime;
    }

    /* renamed from: component27, reason: from getter */
    public final Double getTotalDistance() {
        return this.totalDistance;
    }

    /* renamed from: component28, reason: from getter */
    public final Integer getTotalCalories() {
        return this.totalCalories;
    }

    /* renamed from: component29, reason: from getter */
    public final Integer getTotalSteps() {
        return this.totalSteps;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMachineName() {
        return this.machineName;
    }

    /* renamed from: component30, reason: from getter */
    public final Double getTotalElevation() {
        return this.totalElevation;
    }

    public final List<Integer> component31() {
        return this.splits;
    }

    public final List<Integer> component32() {
        return this.splitsImperial;
    }

    /* renamed from: component33, reason: from getter */
    public final Integer getProfileInterval() {
        return this.profileInterval;
    }

    /* renamed from: component34, reason: from getter */
    public final WorkoutProfile getHrProfile() {
        return this.hrProfile;
    }

    /* renamed from: component35, reason: from getter */
    public final WorkoutProfile getInclineProfile() {
        return this.inclineProfile;
    }

    /* renamed from: component36, reason: from getter */
    public final WorkoutProfile getLevelProfile() {
        return this.levelProfile;
    }

    /* renamed from: component37, reason: from getter */
    public final WorkoutProfile getSpeedProfile() {
        return this.speedProfile;
    }

    /* renamed from: component39, reason: from getter */
    public final Integer getTotalStrokes() {
        return this.totalStrokes;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMachineUuid() {
        return this.machineUuid;
    }

    /* renamed from: component40, reason: from getter */
    public final VideoRefDataVo getVideoRefData() {
        return this.videoRefData;
    }

    /* renamed from: component41, reason: from getter */
    public final SrvoRefDataVo getSrvoRefData() {
        return this.srvoRefData;
    }

    /* renamed from: component42, reason: from getter */
    public final String getExternalWorkoutUuid() {
        return this.externalWorkoutUuid;
    }

    public final List<WorkoutRawData4WorkoutDetailDisplay> component43() {
        return this.rawDataList;
    }

    /* renamed from: component44, reason: from getter */
    public final Boolean getIsPrimaryInDuplicateGroup() {
        return this.isPrimaryInDuplicateGroup;
    }

    public final List<WorkoutViewVo> component45() {
        return this.duplicateList;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMachineMac() {
        return this.machineMac;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMachineModelName() {
        return this.machineModelName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getModelNameFromMachine() {
        return this.modelNameFromMachine;
    }

    public final WorkoutViewVo copy(Integer brandId, String userWorkoutUuid, String machineName, String machineUuid, String machineMac, String machineModelName, String modelNameFromMachine, Integer _dataSource, Integer _machineCategoryType, String timeZone, Integer _activityType, Integer _rootActivityType, String startTime, String endTime, String programName, Double avgIncline, Double avgLevel, Double avgHeartRate, Double avgMet, Double avgPace, Double avgSpeed, Double avgWatt, Double avgCadence, Double peakHeartRate, Double vertical, Integer totalTime, Double totalDistance, Integer totalCalories, Integer totalSteps, Double totalElevation, List<Integer> splits, List<Integer> splitsImperial, Integer profileInterval, WorkoutProfile hrProfile, WorkoutProfile inclineProfile, WorkoutProfile levelProfile, WorkoutProfile speedProfile, List<String> _bestList, Integer totalStrokes, VideoRefDataVo videoRefData, SrvoRefDataVo srvoRefData, String externalWorkoutUuid, List<WorkoutRawData4WorkoutDetailDisplay> rawDataList, Boolean isPrimaryInDuplicateGroup, List<WorkoutViewVo> duplicateList) {
        return new WorkoutViewVo(brandId, userWorkoutUuid, machineName, machineUuid, machineMac, machineModelName, modelNameFromMachine, _dataSource, _machineCategoryType, timeZone, _activityType, _rootActivityType, startTime, endTime, programName, avgIncline, avgLevel, avgHeartRate, avgMet, avgPace, avgSpeed, avgWatt, avgCadence, peakHeartRate, vertical, totalTime, totalDistance, totalCalories, totalSteps, totalElevation, splits, splitsImperial, profileInterval, hrProfile, inclineProfile, levelProfile, speedProfile, _bestList, totalStrokes, videoRefData, srvoRefData, externalWorkoutUuid, rawDataList, isPrimaryInDuplicateGroup, duplicateList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkoutViewVo)) {
            return false;
        }
        WorkoutViewVo workoutViewVo = (WorkoutViewVo) other;
        return Intrinsics.areEqual(this.brandId, workoutViewVo.brandId) && Intrinsics.areEqual(this.userWorkoutUuid, workoutViewVo.userWorkoutUuid) && Intrinsics.areEqual(this.machineName, workoutViewVo.machineName) && Intrinsics.areEqual(this.machineUuid, workoutViewVo.machineUuid) && Intrinsics.areEqual(this.machineMac, workoutViewVo.machineMac) && Intrinsics.areEqual(this.machineModelName, workoutViewVo.machineModelName) && Intrinsics.areEqual(this.modelNameFromMachine, workoutViewVo.modelNameFromMachine) && Intrinsics.areEqual(this._dataSource, workoutViewVo._dataSource) && Intrinsics.areEqual(this._machineCategoryType, workoutViewVo._machineCategoryType) && Intrinsics.areEqual(this.timeZone, workoutViewVo.timeZone) && Intrinsics.areEqual(this._activityType, workoutViewVo._activityType) && Intrinsics.areEqual(this._rootActivityType, workoutViewVo._rootActivityType) && Intrinsics.areEqual(this.startTime, workoutViewVo.startTime) && Intrinsics.areEqual(this.endTime, workoutViewVo.endTime) && Intrinsics.areEqual(this.programName, workoutViewVo.programName) && Intrinsics.areEqual((Object) this.avgIncline, (Object) workoutViewVo.avgIncline) && Intrinsics.areEqual((Object) this.avgLevel, (Object) workoutViewVo.avgLevel) && Intrinsics.areEqual((Object) this.avgHeartRate, (Object) workoutViewVo.avgHeartRate) && Intrinsics.areEqual((Object) this.avgMet, (Object) workoutViewVo.avgMet) && Intrinsics.areEqual((Object) this.avgPace, (Object) workoutViewVo.avgPace) && Intrinsics.areEqual((Object) this.avgSpeed, (Object) workoutViewVo.avgSpeed) && Intrinsics.areEqual((Object) this.avgWatt, (Object) workoutViewVo.avgWatt) && Intrinsics.areEqual((Object) this.avgCadence, (Object) workoutViewVo.avgCadence) && Intrinsics.areEqual((Object) this.peakHeartRate, (Object) workoutViewVo.peakHeartRate) && Intrinsics.areEqual((Object) this.vertical, (Object) workoutViewVo.vertical) && Intrinsics.areEqual(this.totalTime, workoutViewVo.totalTime) && Intrinsics.areEqual((Object) this.totalDistance, (Object) workoutViewVo.totalDistance) && Intrinsics.areEqual(this.totalCalories, workoutViewVo.totalCalories) && Intrinsics.areEqual(this.totalSteps, workoutViewVo.totalSteps) && Intrinsics.areEqual((Object) this.totalElevation, (Object) workoutViewVo.totalElevation) && Intrinsics.areEqual(this.splits, workoutViewVo.splits) && Intrinsics.areEqual(this.splitsImperial, workoutViewVo.splitsImperial) && Intrinsics.areEqual(this.profileInterval, workoutViewVo.profileInterval) && Intrinsics.areEqual(this.hrProfile, workoutViewVo.hrProfile) && Intrinsics.areEqual(this.inclineProfile, workoutViewVo.inclineProfile) && Intrinsics.areEqual(this.levelProfile, workoutViewVo.levelProfile) && Intrinsics.areEqual(this.speedProfile, workoutViewVo.speedProfile) && Intrinsics.areEqual(this._bestList, workoutViewVo._bestList) && Intrinsics.areEqual(this.totalStrokes, workoutViewVo.totalStrokes) && Intrinsics.areEqual(this.videoRefData, workoutViewVo.videoRefData) && Intrinsics.areEqual(this.srvoRefData, workoutViewVo.srvoRefData) && Intrinsics.areEqual(this.externalWorkoutUuid, workoutViewVo.externalWorkoutUuid) && Intrinsics.areEqual(this.rawDataList, workoutViewVo.rawDataList) && Intrinsics.areEqual(this.isPrimaryInDuplicateGroup, workoutViewVo.isPrimaryInDuplicateGroup) && Intrinsics.areEqual(this.duplicateList, workoutViewVo.duplicateList);
    }

    public int hashCode() {
        Integer num = this.brandId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.userWorkoutUuid;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.machineName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.machineUuid;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.machineMac;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.machineModelName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.modelNameFromMachine;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num2 = this._dataSource;
        int iHashCode8 = (iHashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this._machineCategoryType;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str7 = this.timeZone;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num4 = this._activityType;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this._rootActivityType;
        int iHashCode12 = (iHashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str8 = this.startTime;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.endTime;
        int iHashCode14 = (iHashCode13 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.programName;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Double d = this.avgIncline;
        int iHashCode16 = (iHashCode15 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.avgLevel;
        int iHashCode17 = (iHashCode16 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.avgHeartRate;
        int iHashCode18 = (iHashCode17 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Double d4 = this.avgMet;
        int iHashCode19 = (iHashCode18 + (d4 == null ? 0 : d4.hashCode())) * 31;
        Double d5 = this.avgPace;
        int iHashCode20 = (iHashCode19 + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.avgSpeed;
        int iHashCode21 = (iHashCode20 + (d6 == null ? 0 : d6.hashCode())) * 31;
        Double d7 = this.avgWatt;
        int iHashCode22 = (iHashCode21 + (d7 == null ? 0 : d7.hashCode())) * 31;
        Double d8 = this.avgCadence;
        int iHashCode23 = (iHashCode22 + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.peakHeartRate;
        int iHashCode24 = (iHashCode23 + (d9 == null ? 0 : d9.hashCode())) * 31;
        Double d10 = this.vertical;
        int iHashCode25 = (iHashCode24 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num6 = this.totalTime;
        int iHashCode26 = (iHashCode25 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Double d11 = this.totalDistance;
        int iHashCode27 = (iHashCode26 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num7 = this.totalCalories;
        int iHashCode28 = (iHashCode27 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.totalSteps;
        int iHashCode29 = (iHashCode28 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Double d12 = this.totalElevation;
        int iHashCode30 = (iHashCode29 + (d12 == null ? 0 : d12.hashCode())) * 31;
        List<Integer> list = this.splits;
        int iHashCode31 = (iHashCode30 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.splitsImperial;
        int iHashCode32 = (iHashCode31 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num9 = this.profileInterval;
        int iHashCode33 = (iHashCode32 + (num9 == null ? 0 : num9.hashCode())) * 31;
        WorkoutProfile workoutProfile = this.hrProfile;
        int iHashCode34 = (iHashCode33 + (workoutProfile == null ? 0 : workoutProfile.hashCode())) * 31;
        WorkoutProfile workoutProfile2 = this.inclineProfile;
        int iHashCode35 = (iHashCode34 + (workoutProfile2 == null ? 0 : workoutProfile2.hashCode())) * 31;
        WorkoutProfile workoutProfile3 = this.levelProfile;
        int iHashCode36 = (iHashCode35 + (workoutProfile3 == null ? 0 : workoutProfile3.hashCode())) * 31;
        WorkoutProfile workoutProfile4 = this.speedProfile;
        int iHashCode37 = (iHashCode36 + (workoutProfile4 == null ? 0 : workoutProfile4.hashCode())) * 31;
        List<String> list3 = this._bestList;
        int iHashCode38 = (iHashCode37 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Integer num10 = this.totalStrokes;
        int iHashCode39 = (iHashCode38 + (num10 == null ? 0 : num10.hashCode())) * 31;
        VideoRefDataVo videoRefDataVo = this.videoRefData;
        int iHashCode40 = (iHashCode39 + (videoRefDataVo == null ? 0 : videoRefDataVo.hashCode())) * 31;
        SrvoRefDataVo srvoRefDataVo = this.srvoRefData;
        int iHashCode41 = (iHashCode40 + (srvoRefDataVo == null ? 0 : srvoRefDataVo.hashCode())) * 31;
        String str11 = this.externalWorkoutUuid;
        int iHashCode42 = (iHashCode41 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<WorkoutRawData4WorkoutDetailDisplay> list4 = this.rawDataList;
        int iHashCode43 = (iHashCode42 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Boolean bool = this.isPrimaryInDuplicateGroup;
        int iHashCode44 = (iHashCode43 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<WorkoutViewVo> list5 = this.duplicateList;
        return iHashCode44 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WorkoutViewVo(brandId=");
        sb.append(this.brandId).append(", userWorkoutUuid=").append(this.userWorkoutUuid).append(", machineName=").append(this.machineName).append(", machineUuid=").append(this.machineUuid).append(", machineMac=").append(this.machineMac).append(", machineModelName=").append(this.machineModelName).append(", modelNameFromMachine=").append(this.modelNameFromMachine).append(", _dataSource=").append(this._dataSource).append(", _machineCategoryType=").append(this._machineCategoryType).append(", timeZone=").append(this.timeZone).append(", _activityType=").append(this._activityType).append(", _rootActivityType=");
        sb.append(this._rootActivityType).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(", programName=").append(this.programName).append(", avgIncline=").append(this.avgIncline).append(", avgLevel=").append(this.avgLevel).append(", avgHeartRate=").append(this.avgHeartRate).append(", avgMet=").append(this.avgMet).append(", avgPace=").append(this.avgPace).append(", avgSpeed=").append(this.avgSpeed).append(", avgWatt=").append(this.avgWatt).append(", avgCadence=").append(this.avgCadence);
        sb.append(", peakHeartRate=").append(this.peakHeartRate).append(", vertical=").append(this.vertical).append(", totalTime=").append(this.totalTime).append(", totalDistance=").append(this.totalDistance).append(", totalCalories=").append(this.totalCalories).append(", totalSteps=").append(this.totalSteps).append(", totalElevation=").append(this.totalElevation).append(", splits=").append(this.splits).append(", splitsImperial=").append(this.splitsImperial).append(", profileInterval=").append(this.profileInterval).append(", hrProfile=").append(this.hrProfile).append(", inclineProfile=");
        sb.append(this.inclineProfile).append(", levelProfile=").append(this.levelProfile).append(", speedProfile=").append(this.speedProfile).append(", _bestList=").append(this._bestList).append(", totalStrokes=").append(this.totalStrokes).append(", videoRefData=").append(this.videoRefData).append(", srvoRefData=").append(this.srvoRefData).append(", externalWorkoutUuid=").append(this.externalWorkoutUuid).append(", rawDataList=").append(this.rawDataList).append(", isPrimaryInDuplicateGroup=").append(this.isPrimaryInDuplicateGroup).append(", duplicateList=").append(this.duplicateList).append(')');
        return sb.toString();
    }

    public WorkoutViewVo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, String str7, Integer num4, Integer num5, String str8, String str9, String str10, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Integer num6, Double d11, Integer num7, Integer num8, Double d12, List<Integer> list, List<Integer> list2, Integer num9, WorkoutProfile workoutProfile, WorkoutProfile workoutProfile2, WorkoutProfile workoutProfile3, WorkoutProfile workoutProfile4, List<String> list3, Integer num10, VideoRefDataVo videoRefDataVo, SrvoRefDataVo srvoRefDataVo, String str11, List<WorkoutRawData4WorkoutDetailDisplay> list4, Boolean bool, List<WorkoutViewVo> list5) {
        this.brandId = num;
        this.userWorkoutUuid = str;
        this.machineName = str2;
        this.machineUuid = str3;
        this.machineMac = str4;
        this.machineModelName = str5;
        this.modelNameFromMachine = str6;
        this._dataSource = num2;
        this._machineCategoryType = num3;
        this.timeZone = str7;
        this._activityType = num4;
        this._rootActivityType = num5;
        this.startTime = str8;
        this.endTime = str9;
        this.programName = str10;
        this.avgIncline = d;
        this.avgLevel = d2;
        this.avgHeartRate = d3;
        this.avgMet = d4;
        this.avgPace = d5;
        this.avgSpeed = d6;
        this.avgWatt = d7;
        this.avgCadence = d8;
        this.peakHeartRate = d9;
        this.vertical = d10;
        this.totalTime = num6;
        this.totalDistance = d11;
        this.totalCalories = num7;
        this.totalSteps = num8;
        this.totalElevation = d12;
        this.splits = list;
        this.splitsImperial = list2;
        this.profileInterval = num9;
        this.hrProfile = workoutProfile;
        this.inclineProfile = workoutProfile2;
        this.levelProfile = workoutProfile3;
        this.speedProfile = workoutProfile4;
        this._bestList = list3;
        this.totalStrokes = num10;
        this.videoRefData = videoRefDataVo;
        this.srvoRefData = srvoRefDataVo;
        this.externalWorkoutUuid = str11;
        this.rawDataList = list4;
        this.isPrimaryInDuplicateGroup = bool;
        this.duplicateList = list5;
    }

    public /* synthetic */ WorkoutViewVo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, Integer num2, Integer num3, String str7, Integer num4, Integer num5, String str8, String str9, String str10, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, Double d8, Double d9, Double d10, Integer num6, Double d11, Integer num7, Integer num8, Double d12, List list, List list2, Integer num9, WorkoutProfile workoutProfile, WorkoutProfile workoutProfile2, WorkoutProfile workoutProfile3, WorkoutProfile workoutProfile4, List list3, Integer num10, VideoRefDataVo videoRefDataVo, SrvoRefDataVo srvoRefDataVo, String str11, List list4, Boolean bool, List list5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : num4, (i & 2048) != 0 ? null : num5, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (32768 & i) != 0 ? null : d, (65536 & i) != 0 ? null : d2, (131072 & i) != 0 ? null : d3, (262144 & i) != 0 ? null : d4, (524288 & i) != 0 ? null : d5, (1048576 & i) != 0 ? null : d6, (2097152 & i) != 0 ? null : d7, (4194304 & i) != 0 ? null : d8, (8388608 & i) != 0 ? null : d9, (16777216 & i) != 0 ? null : d10, (33554432 & i) != 0 ? null : num6, (67108864 & i) != 0 ? null : d11, (134217728 & i) != 0 ? null : num7, (268435456 & i) != 0 ? null : num8, (536870912 & i) != 0 ? null : d12, (1073741824 & i) != 0 ? null : list, (i & Integer.MIN_VALUE) != 0 ? null : list2, (i2 & 1) != 0 ? null : num9, (i2 & 2) != 0 ? null : workoutProfile, (i2 & 4) != 0 ? null : workoutProfile2, (i2 & 8) != 0 ? null : workoutProfile3, (i2 & 16) != 0 ? null : workoutProfile4, (i2 & 32) != 0 ? null : list3, (i2 & 64) != 0 ? null : num10, (i2 & 128) != 0 ? null : videoRefDataVo, (i2 & 256) != 0 ? null : srvoRefDataVo, (i2 & 512) != 0 ? null : str11, (i2 & 1024) != 0 ? null : list4, bool, (i2 & 4096) != 0 ? null : list5);
    }

    public final String getUserWorkoutUuid() {
        return this.userWorkoutUuid;
    }

    public final String getMachineName() {
        return this.machineName;
    }

    public final String getMachineUuid() {
        return this.machineUuid;
    }

    public final String getMachineMac() {
        return this.machineMac;
    }

    public final String getMachineModelName() {
        return this.machineModelName;
    }

    public final String getModelNameFromMachine() {
        return this.modelNameFromMachine;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final Double getAvgIncline() {
        return this.avgIncline;
    }

    public final Double getAvgLevel() {
        return this.avgLevel;
    }

    public final Double getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public final Double getAvgMet() {
        return this.avgMet;
    }

    public final Double getAvgPace() {
        return this.avgPace;
    }

    public final Double getAvgSpeed() {
        return this.avgSpeed;
    }

    public final Double getAvgWatt() {
        return this.avgWatt;
    }

    public final Double getAvgCadence() {
        return this.avgCadence;
    }

    public final Double getPeakHeartRate() {
        return this.peakHeartRate;
    }

    public final Double getVertical() {
        return this.vertical;
    }

    public final Integer getTotalTime() {
        return this.totalTime;
    }

    public final Double getTotalDistance() {
        return this.totalDistance;
    }

    public final Integer getTotalCalories() {
        return this.totalCalories;
    }

    public final Integer getTotalSteps() {
        return this.totalSteps;
    }

    public final Double getTotalElevation() {
        return this.totalElevation;
    }

    public final List<Integer> getSplits() {
        return this.splits;
    }

    public final List<Integer> getSplitsImperial() {
        return this.splitsImperial;
    }

    public final Integer getProfileInterval() {
        return this.profileInterval;
    }

    public final WorkoutProfile getHrProfile() {
        return this.hrProfile;
    }

    public final WorkoutProfile getInclineProfile() {
        return this.inclineProfile;
    }

    public final WorkoutProfile getLevelProfile() {
        return this.levelProfile;
    }

    public final WorkoutProfile getSpeedProfile() {
        return this.speedProfile;
    }

    public final Integer getTotalStrokes() {
        return this.totalStrokes;
    }

    public final VideoRefDataVo getVideoRefData() {
        return this.videoRefData;
    }

    public final SrvoRefDataVo getSrvoRefData() {
        return this.srvoRefData;
    }

    public final String getExternalWorkoutUuid() {
        return this.externalWorkoutUuid;
    }

    public final List<WorkoutRawData4WorkoutDetailDisplay> getRawDataList() {
        return this.rawDataList;
    }

    public final Boolean isPrimaryInDuplicateGroup() {
        return this.isPrimaryInDuplicateGroup;
    }

    public final void setPrimaryInDuplicateGroup(Boolean bool) {
        this.isPrimaryInDuplicateGroup = bool;
    }

    public final List<WorkoutViewVo> getDuplicateList() {
        return this.duplicateList;
    }

    public final void setDuplicateList(List<WorkoutViewVo> list) {
        this.duplicateList = list;
    }

    public final CategoryType getMachineCategoryType() {
        Integer num = this._machineCategoryType;
        if (num != null) {
            CategoryType categoryTypeFromCode = CategoryType.INSTANCE.fromCode(num.intValue());
            if (categoryTypeFromCode != null) {
                return categoryTypeFromCode;
            }
        }
        return CategoryType.UNDEFINED;
    }

    public final HistoryActivityType getRootHistoryActivityType() {
        Integer num = this._rootActivityType;
        if (num != null) {
            HistoryActivityType historyActivityTypeFromCode = HistoryActivityType.INSTANCE.fromCode(num.intValue());
            if (historyActivityTypeFromCode != null) {
                return historyActivityTypeFromCode;
            }
        }
        return HistoryActivityType.UNDEFINED;
    }

    public final HistoryActivityType getHistoryActivityType() {
        Integer num = this._activityType;
        if (num != null) {
            HistoryActivityType historyActivityTypeFromCode = HistoryActivityType.INSTANCE.fromCode(num.intValue());
            if (historyActivityTypeFromCode != null) {
                return historyActivityTypeFromCode;
            }
        }
        return HistoryActivityType.UNDEFINED;
    }

    public final WorkoutDataSourceType getDataSource() {
        Integer num = this._dataSource;
        if (num != null) {
            WorkoutDataSourceType workoutDataSourceTypeFromCode = WorkoutDataSourceType.INSTANCE.fromCode(num.intValue());
            if (workoutDataSourceTypeFromCode != null) {
                return workoutDataSourceTypeFromCode;
            }
        }
        return WorkoutDataSourceType.UNDEFINED;
    }

    public final List<PersonalBestType> getBestList() {
        List<String> list = this._bestList;
        if (list == null) {
            return null;
        }
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            PersonalBestType personalBestTypeFromRawValue = PersonalBestType.INSTANCE.fromRawValue((String) it.next());
            if (personalBestTypeFromRawValue == null) {
                personalBestTypeFromRawValue = PersonalBestType.UNDEFINED;
            }
            arrayList.add(personalBestTypeFromRawValue);
        }
        return arrayList;
    }

    public final List<WorkoutViewVo> expand() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        List<WorkoutViewVo> list = this.duplicateList;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    /* compiled from: WorkoutViewVo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo$Companion;", "", "()V", "convertedPace", "", "unitType", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final double convertedPace(double d, boolean z) {
            return z ? d * 1.609344d : d;
        }

        private Companion() {
        }
    }
}
