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
import com.soletreadmills.sole_v2.databinding.DialogClubFilterFormatBottomSheetBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FormatSelectorBottomSheet.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/bottomSheet/FormatSelectorBottomSheet;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "previousSelections", "", "", "onFormatsSelected", "Lkotlin/Function1;", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "show", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FormatSelectorBottomSheet {
    public static final int $stable = 8;
    private final Context context;
    private final Function1<List<String>, Unit> onFormatsSelected;
    private final List<String> previousSelections;

    /* JADX WARN: Multi-variable type inference failed */
    public FormatSelectorBottomSheet(Context context, List<String> previousSelections, Function1<? super List<String>, Unit> onFormatsSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(previousSelections, "previousSelections");
        Intrinsics.checkNotNullParameter(onFormatsSelected, "onFormatsSelected");
        this.context = context;
        this.previousSelections = previousSelections;
        this.onFormatsSelected = onFormatsSelected;
    }

    public final void show() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context);
        final DialogClubFilterFormatBottomSheetBinding dialogClubFilterFormatBottomSheetBindingInflate = DialogClubFilterFormatBottomSheetBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(dialogClubFilterFormatBottomSheetBindingInflate, "inflate(...)");
        bottomSheetDialog.setContentView(dialogClubFilterFormatBottomSheetBindingInflate.getRoot());
        final List listListOf = CollectionsKt.listOf((Object[]) new Triple[]{new Triple(dialogClubFilterFormatBottomSheetBindingInflate.llFormatSharedGoal, dialogClubFilterFormatBottomSheetBindingInflate.imgFormatSharedGoalCheck, dialogClubFilterFormatBottomSheetBindingInflate.tvFormatSharedGoalTitle), new Triple(dialogClubFilterFormatBottomSheetBindingInflate.llFormatRanking, dialogClubFilterFormatBottomSheetBindingInflate.imgFormatRankingCheck, dialogClubFilterFormatBottomSheetBindingInflate.tvFormatRankingTitle), new Triple(dialogClubFilterFormatBottomSheetBindingInflate.llFormatVirtualRace, dialogClubFilterFormatBottomSheetBindingInflate.imgFormatVirtualRaceCheck, dialogClubFilterFormatBottomSheetBindingInflate.tvFormatVirtualRaceTitle)});
        final List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"sharedGoal", "ranking", "virtualRace"});
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        for (Object obj : listListOf2) {
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
        for (Object obj2 : listListOf) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((LinearLayout) ((Triple) obj2).component1()).setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.bottomSheet.FormatSelectorBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FormatSelectorBottomSheet.show$lambda$3$lambda$2(linkedHashSet, i3, dialogClubFilterFormatBottomSheetBindingInflate, this, listListOf, view);
                }
            });
            i3 = i4;
        }
        show$updateUI(linkedHashSet, dialogClubFilterFormatBottomSheetBindingInflate, this, listListOf);
        dialogClubFilterFormatBottomSheetBindingInflate.btnDone.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.bottomSheet.FormatSelectorBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormatSelectorBottomSheet.show$lambda$5(linkedHashSet, this, bottomSheetDialog, listListOf2, view);
            }
        });
        dialogClubFilterFormatBottomSheetBindingInflate.imgBack.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.bottomSheet.FormatSelectorBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormatSelectorBottomSheet.show$lambda$6(bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void show$updateUI(Set<Integer> set, DialogClubFilterFormatBottomSheetBinding dialogClubFilterFormatBottomSheetBinding, FormatSelectorBottomSheet formatSelectorBottomSheet, List<? extends Triple<? extends LinearLayout, ? extends ImageView, ? extends TextView>> list) {
        int i;
        int i2;
        int size = set.size();
        if (size == 0) {
            dialogClubFilterFormatBottomSheetBinding.btnDone.setText(dialogClubFilterFormatBottomSheetBinding.getRoot().getContext().getString(R.string.done));
        } else if (size == 1) {
            dialogClubFilterFormatBottomSheetBinding.btnDone.setText(formatSelectorBottomSheet.context.getString(R.string.apply_filter_count, Integer.valueOf(size)));
        } else {
            dialogClubFilterFormatBottomSheetBinding.btnDone.setText(formatSelectorBottomSheet.context.getString(R.string.apply_filters_count, Integer.valueOf(size)));
        }
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Triple triple = (Triple) obj;
            LinearLayout linearLayout = (LinearLayout) triple.component1();
            ImageView imageView = (ImageView) triple.component2();
            TextView textView = (TextView) triple.component3();
            boolean zContains = set.contains(Integer.valueOf(i3));
            if (zContains) {
                i = R.drawable.bg_corner28_red_raised_bg;
            } else {
                i = R.drawable.bg_corner28_line_canvas_gray;
            }
            linearLayout.setBackgroundResource(i);
            if (zContains) {
                i2 = R.drawable.ic_checkbox_active;
            } else {
                i2 = R.drawable.ic_checkbox_empty;
            }
            imageView.setImageResource(i2);
            textView.setTextColor(ContextCompat.getColor(formatSelectorBottomSheet.context, zContains ? R.color.colorPalette_red : R.color.colorLabel_label3));
            i3 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3$lambda$2(Set selectedIndices, int i, DialogClubFilterFormatBottomSheetBinding formatBinding, FormatSelectorBottomSheet this$0, List optionViews, View view) {
        Intrinsics.checkNotNullParameter(selectedIndices, "$selectedIndices");
        Intrinsics.checkNotNullParameter(formatBinding, "$formatBinding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(optionViews, "$optionViews");
        if (selectedIndices.contains(Integer.valueOf(i))) {
            selectedIndices.remove(Integer.valueOf(i));
        } else {
            selectedIndices.add(Integer.valueOf(i));
        }
        show$updateUI(selectedIndices, formatBinding, this$0, optionViews);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5(Set selectedIndices, FormatSelectorBottomSheet this$0, BottomSheetDialog dialog, List formatIds, View view) {
        Intrinsics.checkNotNullParameter(selectedIndices, "$selectedIndices");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(formatIds, "$formatIds");
        Set set = selectedIndices;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add((String) formatIds.get(((Number) it.next()).intValue()));
        }
        this$0.onFormatsSelected.invoke(CollectionsKt.toMutableList((Collection) arrayList));
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$6(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }
}
