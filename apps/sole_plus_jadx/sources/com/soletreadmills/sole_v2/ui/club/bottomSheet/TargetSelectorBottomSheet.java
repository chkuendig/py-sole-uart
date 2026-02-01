package com.soletreadmills.sole_v2.ui.club.bottomSheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.DialogClubFilterTargetBottomSheetBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TargetSelectorBottomSheet.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/bottomSheet/TargetSelectorBottomSheet;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "previousSelections", "", "", "onTargetsSelected", "Lkotlin/Function1;", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "show", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TargetSelectorBottomSheet {
    public static final int $stable = 8;
    private final Context context;
    private final Function1<List<String>, Unit> onTargetsSelected;
    private final List<String> previousSelections;

    /* JADX WARN: Multi-variable type inference failed */
    public TargetSelectorBottomSheet(Context context, List<String> previousSelections, Function1<? super List<String>, Unit> onTargetsSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(previousSelections, "previousSelections");
        Intrinsics.checkNotNullParameter(onTargetsSelected, "onTargetsSelected");
        this.context = context;
        this.previousSelections = previousSelections;
        this.onTargetsSelected = onTargetsSelected;
    }

    public final void show() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context);
        final DialogClubFilterTargetBottomSheetBinding dialogClubFilterTargetBottomSheetBindingInflate = DialogClubFilterTargetBottomSheetBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(dialogClubFilterTargetBottomSheetBindingInflate, "inflate(...)");
        bottomSheetDialog.setContentView(dialogClubFilterTargetBottomSheetBindingInflate.getRoot());
        final List listListOf = CollectionsKt.listOf((Object[]) new String[]{"distance", "calories", "active_time", "sessions"});
        final List listListOf2 = CollectionsKt.listOf((Object[]) new LinearLayout[]{dialogClubFilterTargetBottomSheetBindingInflate.llDistance, dialogClubFilterTargetBottomSheetBindingInflate.llCalories, dialogClubFilterTargetBottomSheetBindingInflate.llActiveTime, dialogClubFilterTargetBottomSheetBindingInflate.llSessions});
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (this.previousSelections.contains((String) obj)) {
                linkedHashSet.add(Integer.valueOf(i));
            }
            i = i2;
        }
        final int i3 = 0;
        for (Object obj2 : listListOf2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((LinearLayout) obj2).setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.bottomSheet.TargetSelectorBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TargetSelectorBottomSheet.show$lambda$3$lambda$2(linkedHashSet, i3, dialogClubFilterTargetBottomSheetBindingInflate, this, listListOf2, view);
                }
            });
            i3 = i4;
        }
        show$updateUI(linkedHashSet, dialogClubFilterTargetBottomSheetBindingInflate, this, listListOf2);
        dialogClubFilterTargetBottomSheetBindingInflate.btnDone.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.bottomSheet.TargetSelectorBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TargetSelectorBottomSheet.show$lambda$5(linkedHashSet, this, bottomSheetDialog, listListOf, view);
            }
        });
        dialogClubFilterTargetBottomSheetBindingInflate.imgBack.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.bottomSheet.TargetSelectorBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TargetSelectorBottomSheet.show$lambda$6(bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void show$updateUI(Set<Integer> set, DialogClubFilterTargetBottomSheetBinding dialogClubFilterTargetBottomSheetBinding, TargetSelectorBottomSheet targetSelectorBottomSheet, List<? extends LinearLayout> list) {
        int i;
        int size = set.size();
        if (size == 0) {
            dialogClubFilterTargetBottomSheetBinding.btnDone.setText(dialogClubFilterTargetBottomSheetBinding.getRoot().getContext().getString(R.string.done));
        } else if (size == 1) {
            dialogClubFilterTargetBottomSheetBinding.btnDone.setText(targetSelectorBottomSheet.context.getString(R.string.apply_filter_count, Integer.valueOf(size)));
        } else {
            dialogClubFilterTargetBottomSheetBinding.btnDone.setText(targetSelectorBottomSheet.context.getString(R.string.apply_filters_count, Integer.valueOf(size)));
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LinearLayout linearLayout = (LinearLayout) obj;
            boolean zContains = set.contains(Integer.valueOf(i2));
            View childAt = linearLayout.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            View childAt2 = linearLayout.getChildAt(1);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt2;
            if (zContains) {
                i = R.drawable.bg_corner28_red_raised_bg;
            } else {
                i = R.drawable.bg_corner28_line_canvas_gray;
            }
            linearLayout.setBackgroundResource(i);
            textView.setTextColor(ContextCompat.getColor(targetSelectorBottomSheet.context, zContains ? R.color.colorPalette_red : R.color.colorLabel_label3));
            imageView.setImageTintList(ContextCompat.getColorStateList(targetSelectorBottomSheet.context, zContains ? R.color.colorPalette_red : R.color.colorLabel_label2));
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3$lambda$2(Set selectedIndices, int i, DialogClubFilterTargetBottomSheetBinding binding, TargetSelectorBottomSheet this$0, List targetViews, View view) {
        Intrinsics.checkNotNullParameter(selectedIndices, "$selectedIndices");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(targetViews, "$targetViews");
        if (selectedIndices.contains(Integer.valueOf(i))) {
            selectedIndices.remove(Integer.valueOf(i));
        } else {
            selectedIndices.add(Integer.valueOf(i));
        }
        show$updateUI(selectedIndices, binding, this$0, targetViews);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5(Set selectedIndices, TargetSelectorBottomSheet this$0, BottomSheetDialog dialog, List targetIds, View view) {
        Intrinsics.checkNotNullParameter(selectedIndices, "$selectedIndices");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(targetIds, "$targetIds");
        Set set = selectedIndices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add((String) targetIds.get(((Number) it.next()).intValue()));
        }
        this$0.onTargetsSelected.invoke(CollectionsKt.toMutableList((Collection) arrayList));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$6(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }
}
