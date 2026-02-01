package com.dyaco.sole.fragment.calendar;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.dbapi.DbManager;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.R2;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.QuestMainView;
import com.dyaco.sole.custom_view.SelectChartDialog;
import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.orhanobut.logger.Logger;
import com.soletreadmills.sole.R;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.database.Database;
import org.joda.time.Interval;

/* loaded from: classes.dex */
public class WorkoutTotalChart extends RelativeLayout implements View.OnClickListener {
    private static final int CHART_COUNT = 3;
    private String[] UnitLabels;
    private String[] UnitLabels2;
    private Button btnNext;
    private Button btnPre;
    private int calendar_type;
    private List<Entry> caloriesEntries;
    private LinearLayout centerLayout;
    private View chartView;
    private final Context context;
    private int curPos;
    private List<DCTrainingDetailData> detailData;
    private List<Entry> distanceEntries;
    private String endTime;
    private List<List<Entry>> entriesList;
    private IAxisValueFormatter iAxisValueFormatter;
    private String in_out;
    private TextView infoCenter1;
    private TextView infoCenter2;
    private TextView infoLeft1;
    private TextView infoLeft2;
    private Button infoLeft3;
    private TextView infoLeft4;
    private TextView infoRight1;
    private TextView infoRight2;
    private String[] labels;
    private LinearLayout leftLayout1;
    private LinearLayout leftLayout2;
    private YAxis leftYAxis;
    private TextView nextTitle;
    private int omronDataIndex;
    private String[] omronDataLabels;
    private String[] omronDataUnitLabels;
    private TextView preTitle;
    private YAxis rightYAxis;
    private String startTime;
    private List<Entry> timeEntries;
    private List<DCTrainingData> trainData;
    private float[] values;
    private LineChart workoutChart;
    private XAxis xAxis;

    public WorkoutTotalChart(Context context) {
        super(context);
        this.entriesList = new ArrayList();
        this.curPos = 1;
        this.labels = new String[]{getResources().getString(R.string.goal_field_time), getResources().getString(R.string.distance).toUpperCase(), getResources().getString(R.string.calories)};
        this.UnitLabels2 = new String[]{getResources().getString(R.string.minutes), getResources().getString(R.string.unit_km_upper), getResources().getString(R.string.calories)};
        this.UnitLabels = new String[]{"", "", ""};
        this.omronDataIndex = 0;
        this.omronDataLabels = new String[]{getResources().getString(R.string.omron_weight), getResources().getString(R.string.omron_body_fat), getResources().getString(R.string.omron_BMI), getResources().getString(R.string.omron_systolic), getResources().getString(R.string.omron_diastolic)};
        this.omronDataUnitLabels = new String[]{getResources().getString(R.string.omron_weight_unit), getResources().getString(R.string.omron_body_fat_unit), getResources().getString(R.string.omron_BMI_unit), getResources().getString(R.string.omron_systolic_unit), getResources().getString(R.string.omron_diastolic_unit)};
        this.context = context;
        init();
    }

    public WorkoutTotalChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.entriesList = new ArrayList();
        this.curPos = 1;
        this.labels = new String[]{getResources().getString(R.string.goal_field_time), getResources().getString(R.string.distance).toUpperCase(), getResources().getString(R.string.calories)};
        this.UnitLabels2 = new String[]{getResources().getString(R.string.minutes), getResources().getString(R.string.unit_km_upper), getResources().getString(R.string.calories)};
        this.UnitLabels = new String[]{"", "", ""};
        this.omronDataIndex = 0;
        this.omronDataLabels = new String[]{getResources().getString(R.string.omron_weight), getResources().getString(R.string.omron_body_fat), getResources().getString(R.string.omron_BMI), getResources().getString(R.string.omron_systolic), getResources().getString(R.string.omron_diastolic)};
        this.omronDataUnitLabels = new String[]{getResources().getString(R.string.omron_weight_unit), getResources().getString(R.string.omron_body_fat_unit), getResources().getString(R.string.omron_BMI_unit), getResources().getString(R.string.omron_systolic_unit), getResources().getString(R.string.omron_diastolic_unit)};
        this.context = context;
        init();
    }

    public WorkoutTotalChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.entriesList = new ArrayList();
        this.curPos = 1;
        this.labels = new String[]{getResources().getString(R.string.goal_field_time), getResources().getString(R.string.distance).toUpperCase(), getResources().getString(R.string.calories)};
        this.UnitLabels2 = new String[]{getResources().getString(R.string.minutes), getResources().getString(R.string.unit_km_upper), getResources().getString(R.string.calories)};
        this.UnitLabels = new String[]{"", "", ""};
        this.omronDataIndex = 0;
        this.omronDataLabels = new String[]{getResources().getString(R.string.omron_weight), getResources().getString(R.string.omron_body_fat), getResources().getString(R.string.omron_BMI), getResources().getString(R.string.omron_systolic), getResources().getString(R.string.omron_diastolic)};
        this.omronDataUnitLabels = new String[]{getResources().getString(R.string.omron_weight_unit), getResources().getString(R.string.omron_body_fat_unit), getResources().getString(R.string.omron_BMI_unit), getResources().getString(R.string.omron_systolic_unit), getResources().getString(R.string.omron_diastolic_unit)};
        this.context = context;
        init();
    }

    private void init() {
        int i = Global.BRAND;
        if (i == 0) {
            this.chartView = View.inflate(this.context, R.layout.include_calendar_workout_chart, null);
        } else if (i == 1 || i == 2 || i == 3) {
            this.chartView = View.inflate(this.context, R.layout.s_include_calendar_workout_chart, null);
        }
        addView(this.chartView, new LinearLayout.LayoutParams(-1, -1));
        initView();
        initListener();
        initChart();
    }

    private void initView() {
        this.btnPre = (Button) findViewById(R.id.btnPre);
        this.btnNext = (Button) findViewById(R.id.btnNext);
        this.preTitle = (TextView) findViewById(R.id.preTitle);
        this.nextTitle = (TextView) findViewById(R.id.nextTitle);
        this.infoLeft1 = (TextView) findViewById(R.id.infoLeft1);
        this.infoLeft2 = (TextView) findViewById(R.id.infoLeft2);
        this.infoRight1 = (TextView) findViewById(R.id.infoRight1);
        this.infoRight2 = (TextView) findViewById(R.id.infoRight2);
        this.centerLayout = (LinearLayout) findViewById(R.id.infoCenterWrapper);
        this.leftLayout1 = (LinearLayout) findViewById(R.id.infoLeftWrapper);
        this.leftLayout2 = (LinearLayout) findViewById(R.id.infoLeftWrapper2);
        this.infoLeft3 = (Button) findViewById(R.id.infoLeft3);
        this.infoLeft4 = (TextView) findViewById(R.id.infoLeft4);
        this.infoCenter1 = (TextView) findViewById(R.id.infoCenter1);
        this.infoCenter2 = (TextView) findViewById(R.id.infoCenter2);
        this.infoLeft3.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.calendar.WorkoutTotalChart.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectChartDialog selectChartDialog = new SelectChartDialog(WorkoutTotalChart.this.getContext());
                selectChartDialog.show();
                selectChartDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.dyaco.sole.fragment.calendar.WorkoutTotalChart.1.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        WorkoutTotalChart.this.updateView(MyApp.calendar_type, MyApp.trainData, MyApp.interval);
                    }
                });
            }
        });
    }

    private void initListener() {
        this.btnPre.setOnClickListener(this);
        this.btnNext.setOnClickListener(this);
    }

    private void initChart() {
        LineChart lineChart = (LineChart) findViewById(R.id.workoutChart);
        this.workoutChart = lineChart;
        int[] iArr = {ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK};
        lineChart.setDescription(null);
        XAxis xAxis = this.workoutChart.getXAxis();
        this.xAxis = xAxis;
        xAxis.setDrawGridLines(false);
        this.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        this.xAxis.setGranularity(1.0f);
        this.xAxis.setLabelCount(4, false);
        this.xAxis.setAxisLineWidth(1.0f);
        this.xAxis.setAxisLineColor(Color.rgb(0, 85, 255));
        this.xAxis.setAvoidFirstLastClipping(true);
        this.xAxis.setTextColor(iArr[Global.BRAND]);
        YAxis axisLeft = this.workoutChart.getAxisLeft();
        this.leftYAxis = axisLeft;
        axisLeft.setEnabled(false);
        YAxis axisRight = this.workoutChart.getAxisRight();
        this.rightYAxis = axisRight;
        axisRight.setDrawGridLines(false);
        this.rightYAxis.setEnabled(true);
        this.rightYAxis.setLabelCount(5, false);
        this.rightYAxis.setDrawAxisLine(false);
        this.rightYAxis.setTextColor(iArr[Global.BRAND]);
        this.workoutChart.setScaleYEnabled(false);
        this.workoutChart.getLegend().setEnabled(false);
        XYMarkerView xYMarkerView = new XYMarkerView(this.context, this.iAxisValueFormatter);
        xYMarkerView.setChartView(this.workoutChart);
        this.workoutChart.setMarker(xYMarkerView);
    }

    public void updateView(int i, List<DCTrainingData> list, Interval interval) {
        this.calendar_type = i;
        this.trainData = list;
        if (i == 0) {
            this.startTime = interval.getStart().toString("yyyy-MM-dd HH:mm");
            this.endTime = interval.getEnd().toString("yyyy-MM-dd HH:mm");
        } else {
            this.startTime = interval.getStart().toString(CalendarUtils.SQL_DATE_FORMAT);
            this.endTime = interval.getEnd().toString(CalendarUtils.SQL_DATE_FORMAT);
        }
        this.workoutChart.clear();
        MyApp.calendar_type = i;
        MyApp.trainData = list;
        MyApp.interval = interval;
        showOmronDataOnChart(i, interval);
    }

    private void setDataSetUI(int i, LineDataSet lineDataSet) {
        int[] iArr = {-16776961, SupportMenu.CATEGORY_MASK, Color.rgb(255, 102, 0)};
        lineDataSet.setColor(iArr[i]);
        lineDataSet.setCircleColor(iArr[i]);
        lineDataSet.setLineWidth(1.0f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setCircleHoleRadius(1.0f);
        lineDataSet.setValueTextSize(9.0f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setHighLightColor(-7829368);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(true);
        lineDataSet.setFillDrawable(ContextCompat.getDrawable(this.context, new int[]{R.drawable.fade_blue, R.drawable.fade_red, R.drawable.fade_orange}[i]));
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineDataSet.setCubicIntensity(0.1f);
        lineDataSet.setDrawValues(false);
        if (lineDataSet.getEntryCount() > 10) {
            lineDataSet.getEntryCount();
        }
    }

    private void turnEntryData() {
        this.timeEntries = new ArrayList();
        this.distanceEntries = new ArrayList();
        this.caloriesEntries = new ArrayList();
        this.entriesList.clear();
        for (int i = 0; i < this.trainData.size(); i++) {
            DCTrainingData dCTrainingData = this.trainData.get(i);
            float total_time = dCTrainingData.getTotal_time();
            float total_distance = dCTrainingData.getTotal_distance();
            float total_calories = dCTrainingData.getTotal_calories();
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(dCTrainingData.getUnit())) {
                this.UnitLabels2 = new String[]{getResources().getString(R.string.minutes), getResources().getString(R.string.unit_km_upper), getResources().getString(R.string.calories)};
                float f = i;
                this.timeEntries.add(new Entry(f, new BigDecimal(total_time).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
                this.distanceEntries.add(new Entry(f, new BigDecimal(total_distance).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
                this.caloriesEntries.add(new Entry(f, new BigDecimal(total_calories).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
            } else {
                this.UnitLabels2 = new String[]{getResources().getString(R.string.minutes), getResources().getString(R.string.unit_mi_upper), getResources().getString(R.string.calories)};
                float f2 = i;
                this.timeEntries.add(new Entry(f2, new BigDecimal(total_time).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
                this.distanceEntries.add(new Entry(f2, new BigDecimal(total_distance / 1.6093f).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
                this.caloriesEntries.add(new Entry(f2, new BigDecimal(total_calories).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
            }
        }
        this.entriesList.add(this.timeEntries);
        this.entriesList.add(this.distanceEntries);
        this.entriesList.add(this.caloriesEntries);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnNext) {
            goNextChart();
            updateView(MyApp.calendar_type, MyApp.trainData, MyApp.interval);
        } else {
            if (id != R.id.btnPre) {
                return;
            }
            goPreChart();
            updateView(MyApp.calendar_type, MyApp.trainData, MyApp.interval);
        }
    }

    private void goPreChart() {
        this.curPos = countNextChartNo(-1);
    }

    private void goNextChart() {
        this.curPos = countNextChartNo(1);
    }

    private int countNextChartNo(int i) {
        return ((this.curPos + i) + 3) % 3;
    }

    private void updateChart() {
        String[] strArr = this.labels;
        String str = strArr[this.curPos];
        String str2 = strArr[countNextChartNo(1)];
        String str3 = this.labels[countNextChartNo(-1)];
        String str4 = this.UnitLabels2[this.curPos];
        this.infoRight1.setText(str);
        this.infoRight2.setText(str4);
        this.nextTitle.setText(str2);
        this.preTitle.setText(str3);
        this.infoLeft1.setText("From:" + this.startTime);
        this.infoLeft2.setText("To:" + this.endTime);
        this.infoCenter1.setText("From:" + this.startTime);
        this.infoCenter2.setText("To:" + this.endTime);
        this.infoLeft3.setText(this.omronDataLabels[MyApp.omron_data_select_index]);
        this.infoLeft4.setText(this.omronDataUnitLabels[MyApp.omron_data_select_index]);
        setData();
        MyIAxisValueFormatter myIAxisValueFormatter = new MyIAxisValueFormatter(this.trainData);
        this.iAxisValueFormatter = myIAxisValueFormatter;
        this.xAxis.setValueFormatter(myIAxisValueFormatter);
        this.workoutChart.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setData() {
        if (this.workoutChart.getData() != null && ((LineData) this.workoutChart.getData()).getDataSetCount() > 0) {
            LineDataSet lineDataSet = (LineDataSet) ((LineData) this.workoutChart.getData()).getDataSetByIndex(0);
            lineDataSet.setValues(this.entriesList.get(this.curPos));
            lineDataSet.setValueFormatter(new MyValueFormatter());
            lineDataSet.setLabel(this.labels[this.curPos]);
            setDataSetUI(this.curPos, lineDataSet);
            Logger.d("dataset = " + lineDataSet);
            ((LineData) this.workoutChart.getData()).notifyDataChanged();
            this.workoutChart.notifyDataSetChanged();
            return;
        }
        Logger.d("entriesList = " + this.entriesList);
        if (this.entriesList.get(this.curPos).size() > 0) {
            LineDataSet lineDataSet2 = new LineDataSet(this.entriesList.get(this.curPos), this.labels[this.curPos]);
            lineDataSet2.setValueFormatter(new MyValueFormatter());
            setDataSetUI(this.curPos, lineDataSet2);
            Logger.d("dataset 2= " + lineDataSet2);
            this.workoutChart.setData(new LineData(lineDataSet2));
            Logger.d("111");
        }
    }

    private LineDataSet turnLineDataSet(int i) {
        Logger.d("entriesList = " + this.entriesList);
        LineDataSet lineDataSet = new LineDataSet(this.entriesList.get(i), this.labels[i]);
        setDataSetUI(i, lineDataSet);
        return lineDataSet;
    }

    private static class MyIAxisValueFormatter implements IAxisValueFormatter {
        private List<DCTrainingData> trainData;

        public MyIAxisValueFormatter(List<DCTrainingData> list) {
            this.trainData = list;
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float f, AxisBase axisBase) {
            int i = (int) f;
            return (i < 0 || i >= this.trainData.size()) ? "" : this.trainData.get(i).getCategory_code();
        }
    }

    public class MyValueFormatter implements IValueFormatter {
        private DecimalFormat mFormat = new DecimalFormat("##0.000");

        public MyValueFormatter() {
        }

        @Override // com.github.mikephil.charting.formatter.IValueFormatter
        public String getFormattedValue(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
            Logger.d("getFormattedValue  value = " + f);
            return "" + ((int) f);
        }
    }

    public class XYMarkerView extends MarkerView {
        private TextView tvContent;
        private IAxisValueFormatter xAxisValueFormatter;

        public XYMarkerView(Context context, IAxisValueFormatter iAxisValueFormatter) {
            super(context, R.layout.custom_marker_view);
            this.xAxisValueFormatter = iAxisValueFormatter;
            this.tvContent = (TextView) findViewById(R.id.tvContent);
        }

        @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
        public void refreshContent(Entry entry, Highlight highlight) {
            this.tvContent.setText(entry.getY() + "");
            super.refreshContent(entry, highlight);
        }

        @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
        public MPPointF getOffset() {
            return new MPPointF(-getWidth(), -getHeight());
        }
    }

    private void showOmronDataOnChart(int i, Interval interval) {
        if (i == 0 || "".equals(MyApp.omron_access_token)) {
            this.centerLayout.setVisibility(8);
            this.leftLayout2.setVisibility(8);
            this.leftLayout1.setVisibility(0);
            setInitChartView();
            turnEntryData();
            updateChart();
            return;
        }
        this.centerLayout.setVisibility(0);
        this.leftLayout2.setVisibility(0);
        this.leftLayout1.setVisibility(4);
        turnEntryData();
        updateOmronChartTitle();
        setOmronChartView();
        getAndSetOmronChartData(i, interval);
    }

    private void updateOmronChartTitle() {
        String[] strArr = this.labels;
        String str = strArr[this.curPos];
        String str2 = strArr[countNextChartNo(1)];
        String str3 = this.labels[countNextChartNo(-1)];
        String str4 = this.UnitLabels2[this.curPos];
        this.infoRight1.setText(str);
        this.infoRight2.setText(str4);
        this.nextTitle.setText(str2);
        this.preTitle.setText(str3);
        this.infoLeft1.setText("From:" + this.startTime);
        this.infoLeft2.setText("To:" + this.endTime);
        this.infoCenter1.setText("From:" + this.startTime);
        this.infoCenter2.setText("To:" + this.endTime);
        this.infoLeft3.setText(this.omronDataLabels[MyApp.omron_data_select_index]);
        this.infoLeft4.setText(this.omronDataUnitLabels[MyApp.omron_data_select_index]);
    }

    private void setInitChartView() {
        int[] iArr = {ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK};
        this.workoutChart.setDescription(null);
        XAxis xAxis = this.workoutChart.getXAxis();
        this.xAxis = xAxis;
        xAxis.setDrawGridLines(false);
        this.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        this.xAxis.setGranularity(1.0f);
        this.xAxis.setLabelCount(4, false);
        this.xAxis.setAxisLineWidth(1.0f);
        this.xAxis.setAxisLineColor(Color.rgb(0, 85, 255));
        this.xAxis.setAvoidFirstLastClipping(true);
        this.xAxis.setTextColor(iArr[Global.BRAND]);
        YAxis axisLeft = this.workoutChart.getAxisLeft();
        this.leftYAxis = axisLeft;
        axisLeft.setEnabled(false);
        YAxis axisRight = this.workoutChart.getAxisRight();
        this.rightYAxis = axisRight;
        axisRight.setDrawGridLines(false);
        this.rightYAxis.setEnabled(true);
        this.rightYAxis.setLabelCount(5, false);
        this.rightYAxis.setDrawAxisLine(false);
        this.rightYAxis.setTextColor(iArr[Global.BRAND]);
        this.workoutChart.setScaleYEnabled(false);
        this.workoutChart.getLegend().setEnabled(false);
    }

    private void setOmronChartView() {
        this.workoutChart.setDescription(null);
        this.workoutChart.setScaleYEnabled(false);
        this.workoutChart.getLegend().setEnabled(true);
        XAxis xAxis = this.workoutChart.getXAxis();
        this.xAxis = xAxis;
        xAxis.setDrawGridLines(false);
        this.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        this.xAxis.setGranularity(1.0f);
        this.xAxis.setLabelCount(4, false);
        this.xAxis.setAxisLineWidth(1.0f);
        this.xAxis.setAxisLineColor(Color.rgb(0, 85, 255));
        this.xAxis.setAvoidFirstLastClipping(true);
        this.xAxis.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        YAxis axisLeft = this.workoutChart.getAxisLeft();
        this.leftYAxis = axisLeft;
        axisLeft.setDrawGridLines(false);
        this.leftYAxis.setEnabled(true);
        this.leftYAxis.setLabelCount(5, false);
        this.leftYAxis.setDrawAxisLine(false);
        this.leftYAxis.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        YAxis axisRight = this.workoutChart.getAxisRight();
        this.rightYAxis = axisRight;
        axisRight.setDrawGridLines(false);
        this.rightYAxis.setEnabled(true);
        this.rightYAxis.setLabelCount(5, false);
        this.rightYAxis.setDrawAxisLine(false);
        this.rightYAxis.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    private void getAndSetOmronChartData(int i, Interval interval) {
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;
        int i2;
        String str;
        ArrayList arrayList;
        double d;
        int i3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        double d2;
        double d3;
        double d4;
        String account;
        SimpleDateFormat simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3;
        double d5;
        ArrayList arrayList4;
        String account2;
        WorkoutTotalChart workoutTotalChart = this;
        int i4 = i;
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(interval.getStart().toDate());
        Date date = interval.getStart().toDate();
        Date date2 = new Date();
        int actualMaximum = 7;
        int i5 = 3;
        int i6 = 2;
        int i7 = 1;
        if (i4 == 1) {
            calendar2.add(5, 7);
        } else if (i4 == 2) {
            actualMaximum = calendar2.getActualMaximum(5);
            calendar2.add(2, 1);
        } else if (i4 != 3) {
            actualMaximum = 0;
        } else {
            actualMaximum = 12;
            calendar2.add(1, 1);
        }
        calendar2.getTime();
        Database database = DbManager.getDCTrainingDataDao().getDatabase();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        double d6 = 9999.0d;
        Date time = date2;
        double d7 = 9999.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        Date date3 = date;
        SimpleDateFormat simpleDateFormat5 = simpleDateFormat4;
        int i8 = 0;
        while (i8 < actualMaximum) {
            calendar2.setTime(date3);
            if (i4 == i7 || i4 == i6) {
                calendar2.add(5, i7);
                time = calendar2.getTime();
            } else if (i4 == i5) {
                calendar2.add(i6, i7);
                time = calendar2.getTime();
            }
            int i9 = workoutTotalChart.curPos;
            String account3 = "";
            if (i9 == 0) {
                long time2 = date3.getTime();
                calendar = calendar2;
                simpleDateFormat = simpleDateFormat5;
                long time3 = time.getTime();
                if (Global.memberData == null || Global.memberData.getAccount() == null) {
                    i2 = actualMaximum;
                    account2 = "";
                } else {
                    account2 = Global.memberData.getAccount();
                    i2 = actualMaximum;
                }
                StringBuilder sb = new StringBuilder();
                arrayList = arrayList7;
                sb.append("select sum(total_time) from TRAINING_DATA where (account = '%s') and (brand_code = '%s' or brand_code = '%s') and (training_datetime between ");
                sb.append(time2);
                sb.append(" and ");
                sb.append(time3);
                str = ")";
                sb.append(str);
                Cursor cursorRawQuery = database.rawQuery(String.format(sb.toString(), account2, BuildConfig.FLAVOR, "garmin"), null);
                d3 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getDouble(0) / 60.0d : 0.0d;
                cursorRawQuery.close();
                ArrayList arrayList9 = arrayList6;
                double d13 = d8;
                double d14 = d3 > d13 ? d3 : d13;
                double d15 = d7;
                d2 = (d15 != 0.0d && d3 < d15) ? d3 : d15;
                d = d14;
                i3 = i8;
                arrayList3 = arrayList9;
                arrayList2 = arrayList8;
            } else {
                calendar = calendar2;
                simpleDateFormat = simpleDateFormat5;
                i2 = actualMaximum;
                str = ")";
                ArrayList arrayList10 = arrayList6;
                arrayList = arrayList7;
                double d16 = d7;
                d = d8;
                if (i9 == 1) {
                    long time4 = date3.getTime();
                    long time5 = time.getTime();
                    if (Global.memberData == null || Global.memberData.getAccount() == null) {
                        i3 = i8;
                        account = "";
                    } else {
                        account = Global.memberData.getAccount();
                        i3 = i8;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    arrayList2 = arrayList8;
                    sb2.append("select sum(total_distance) from TRAINING_DATA where (account = '%s') and (brand_code = '%s' or brand_code = '%s') and (training_datetime between ");
                    sb2.append(time4);
                    sb2.append(" and ");
                    sb2.append(time5);
                    sb2.append(str);
                    Cursor cursorRawQuery2 = database.rawQuery(String.format(sb2.toString(), account, BuildConfig.FLAVOR, "garmin"), null);
                    d4 = cursorRawQuery2.moveToFirst() ? cursorRawQuery2.getDouble(0) : 0.0d;
                    cursorRawQuery2.close();
                    if (d4 > d) {
                        d = d4;
                    }
                    if (d16 != 0.0d && d4 < d16) {
                        d16 = d4;
                    }
                    arrayList3 = arrayList10;
                } else {
                    i3 = i8;
                    arrayList2 = arrayList8;
                    if (i9 == 2) {
                        long time6 = date3.getTime();
                        long time7 = time.getTime();
                        String account4 = (Global.memberData == null || Global.memberData.getAccount() == null) ? "" : Global.memberData.getAccount();
                        StringBuilder sb3 = new StringBuilder();
                        arrayList3 = arrayList10;
                        sb3.append("select sum(total_calories) from TRAINING_DATA where (account = '%s') and (brand_code = '%s' or brand_code = '%s') and (training_datetime between ");
                        sb3.append(time6);
                        sb3.append(" and ");
                        sb3.append(time7);
                        sb3.append(str);
                        Cursor cursorRawQuery3 = database.rawQuery(String.format(sb3.toString(), account4, BuildConfig.FLAVOR, "garmin"), null);
                        d4 = cursorRawQuery3.moveToFirst() ? cursorRawQuery3.getDouble(0) : 0.0d;
                        cursorRawQuery3.close();
                        if (d4 > d) {
                            d = d4;
                        }
                        if (d16 != 0.0d && d4 < d16) {
                            d2 = d4;
                            d3 = d2;
                        }
                    } else {
                        arrayList3 = arrayList10;
                        d2 = d16;
                        d3 = 0.0d;
                    }
                }
                d2 = d16;
                d3 = d4;
            }
            double d17 = d2;
            double d18 = d10;
            arrayList5.add(new Entry((float) d18, (float) d3));
            if (i == 1 || i == 2) {
                simpleDateFormat2 = new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT);
            } else {
                simpleDateFormat2 = i != 3 ? simpleDateFormat : new SimpleDateFormat("yyyy-MM");
            }
            ArrayList arrayList11 = arrayList3;
            arrayList11.add(simpleDateFormat2.format(date3));
            int i10 = MyApp.omron_data_select_index;
            if (i10 == 0) {
                simpleDateFormat3 = simpleDateFormat2;
                d5 = d;
                arrayList4 = arrayList2;
                long time8 = date3.getTime();
                long time9 = time.getTime();
                if (Global.memberData != null && Global.memberData.getAccount() != null) {
                    account3 = Global.memberData.getAccount();
                }
                Cursor cursorRawQuery4 = database.rawQuery(String.format("select avg(avg_speed) from TRAINING_DATA where (account = '%s') and (brand_code = '%s') and (avg_speed > 0) and(training_datetime between " + time8 + " and " + time9 + str, account3, QuestMainView.OMRON), null);
                if (cursorRawQuery4.moveToFirst()) {
                    d11 = cursorRawQuery4.getDouble(0);
                }
                cursorRawQuery4.close();
                if (d11 > 0.0d) {
                    if (d9 == 0.0d) {
                        d9 = d11;
                    }
                    d12 = d11;
                }
                arrayList4.add(Double.valueOf(d12));
            } else if (i10 == 1) {
                simpleDateFormat3 = simpleDateFormat2;
                d5 = d;
                arrayList4 = arrayList2;
                long time10 = date3.getTime();
                long time11 = time.getTime();
                if (Global.memberData != null && Global.memberData.getAccount() != null) {
                    account3 = Global.memberData.getAccount();
                }
                Cursor cursorRawQuery5 = database.rawQuery(String.format("select avg(total_distance) from TRAINING_DATA where (account = '%s') and (brand_code = '%s') and (total_distance > 0) and (training_datetime between " + time10 + " and " + time11 + str, account3, QuestMainView.OMRON), null);
                if (cursorRawQuery5.moveToFirst()) {
                    d11 = cursorRawQuery5.getDouble(0);
                }
                cursorRawQuery5.close();
                if (d11 > 0.0d) {
                    if (d9 == 0.0d) {
                        d9 = d11;
                    }
                    d12 = d11;
                }
                arrayList4.add(Double.valueOf(d12));
            } else if (i10 == 2) {
                simpleDateFormat3 = simpleDateFormat2;
                d5 = d;
                arrayList4 = arrayList2;
                long time12 = date3.getTime();
                long time13 = time.getTime();
                if (Global.memberData != null && Global.memberData.getAccount() != null) {
                    account3 = Global.memberData.getAccount();
                }
                Cursor cursorRawQuery6 = database.rawQuery(String.format("select avg(total_calories) from TRAINING_DATA where (account = '%s') and (brand_code = '%s') and (total_calories > 0) and (training_datetime between " + time12 + " and " + time13 + str, account3, QuestMainView.OMRON), null);
                if (cursorRawQuery6.moveToFirst()) {
                    d11 = cursorRawQuery6.getDouble(0);
                }
                cursorRawQuery6.close();
                if (d11 > 0.0d) {
                    if (d9 == 0.0d) {
                        d9 = d11;
                    }
                    d12 = d11;
                }
                arrayList4.add(Double.valueOf(d12));
            } else if (i10 == 3) {
                d5 = d;
                arrayList4 = arrayList2;
                long time14 = date3.getTime();
                simpleDateFormat3 = simpleDateFormat2;
                long time15 = time.getTime();
                if (Global.memberData != null && Global.memberData.getAccount() != null) {
                    account3 = Global.memberData.getAccount();
                }
                Cursor cursorRawQuery7 = database.rawQuery(String.format("select avg(avg_rpm) from TRAINING_DATA where (account = '%s') and (brand_code = '%s') and (avg_rpm > 0) and (training_datetime between " + time14 + " and " + time15 + str, account3, QuestMainView.OMRON), null);
                if (cursorRawQuery7.moveToFirst()) {
                    d11 = cursorRawQuery7.getDouble(0);
                }
                cursorRawQuery7.close();
                if (d11 > 0.0d) {
                    if (d9 == 0.0d) {
                        d9 = d11;
                    }
                    d12 = d11;
                }
                arrayList4.add(Double.valueOf(d12));
            } else if (i10 != 4) {
                simpleDateFormat3 = simpleDateFormat2;
                d5 = d;
                arrayList4 = arrayList2;
            } else {
                long time16 = date3.getTime();
                d5 = d;
                long time17 = time.getTime();
                if (Global.memberData != null && Global.memberData.getAccount() != null) {
                    account3 = Global.memberData.getAccount();
                }
                Cursor cursorRawQuery8 = database.rawQuery(String.format("select avg(avg_hr) from TRAINING_DATA where (account = '%s') and (brand_code = '%s') and (avg_hr > 0) and (training_datetime between " + time16 + " and " + time17 + str, account3, QuestMainView.OMRON), null);
                if (cursorRawQuery8.moveToFirst()) {
                    d11 = cursorRawQuery8.getDouble(0);
                }
                cursorRawQuery8.close();
                if (d11 > 0.0d) {
                    if (d9 == 0.0d) {
                        d9 = d11;
                    }
                    d12 = d11;
                }
                arrayList4 = arrayList2;
                arrayList4.add(Double.valueOf(d12));
                simpleDateFormat3 = simpleDateFormat2;
            }
            i8 = i3 + 1;
            i5 = 3;
            i7 = 1;
            arrayList8 = arrayList4;
            arrayList6 = arrayList11;
            simpleDateFormat5 = simpleDateFormat3;
            date3 = time;
            d8 = d5;
            d7 = d17;
            calendar2 = calendar;
            actualMaximum = i2;
            arrayList7 = arrayList;
            i6 = 2;
            d10 = d18 + 1.0d;
            workoutTotalChart = this;
            i4 = i;
        }
        ArrayList arrayList12 = arrayList8;
        final ArrayList arrayList13 = arrayList6;
        ArrayList arrayList14 = arrayList7;
        double d19 = d7;
        double d20 = d8;
        int i11 = workoutTotalChart.curPos;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            workoutTotalChart.workoutChart.getAxisRight().setAxisMinimum(((float) d19) - 10.0f);
            workoutTotalChart.workoutChart.getAxisRight().setAxisMaximum(((float) d20) + 10.0f);
        }
        if (d9 > 0.0d) {
            double d21 = 0.0d;
            int i12 = 0;
            while (i12 < arrayList12.size()) {
                double dDoubleValue = ((Double) arrayList12.get(i12)).doubleValue();
                if (dDoubleValue == 0.0d) {
                    dDoubleValue = d9;
                }
                ArrayList arrayList15 = arrayList14;
                arrayList15.add(new Entry(i12, (float) dDoubleValue));
                if (dDoubleValue > d21) {
                    d21 = dDoubleValue;
                }
                if (dDoubleValue < d6) {
                    d6 = dDoubleValue;
                }
                i12++;
                arrayList14 = arrayList15;
            }
        }
        ArrayList arrayList16 = arrayList14;
        double d22 = d6;
        if (arrayList16.size() > 0) {
            int i13 = MyApp.omron_data_select_index;
            if (i13 == 0) {
                float f = (float) d22;
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMinimum(f - 25.0f);
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMaximum(f + 15.0f);
            } else if (i13 == 1) {
                float f2 = (float) d22;
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMinimum(f2 - 15.0f);
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMaximum(f2 + 5.0f);
            } else if (i13 == 2) {
                float f3 = (float) d22;
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMinimum(f3 - 15.0f);
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMaximum(f3 + 5.0f);
            } else if (i13 == 3) {
                float f4 = (float) d22;
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMinimum(f4 - 25.0f);
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMaximum(f4 + 15.0f);
            } else if (i13 == 4) {
                float f5 = (float) d22;
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMinimum(f5 - 25.0f);
                workoutTotalChart.workoutChart.getAxisLeft().setAxisMaximum(f5 + 15.0f);
            }
        }
        workoutTotalChart.workoutChart.getXAxis().setValueFormatter(new IAxisValueFormatter() { // from class: com.dyaco.sole.fragment.calendar.WorkoutTotalChart.2
            @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
            public String getFormattedValue(float f6, AxisBase axisBase) {
                int i14 = (int) f6;
                return (i14 < 0 || i14 >= arrayList13.size()) ? "" : (String) arrayList13.get(i14);
            }
        });
        ArrayList arrayList17 = new ArrayList();
        int[] iArr = {-16776961, SupportMenu.CATEGORY_MASK, Color.rgb(255, 102, 0)};
        LineDataSet lineDataSet = new LineDataSet(arrayList5, workoutTotalChart.labels[workoutTotalChart.curPos]);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
        lineDataSet.setValueTextColor(iArr[workoutTotalChart.curPos]);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setColor(iArr[workoutTotalChart.curPos]);
        lineDataSet.setLineWidth(1.0f);
        lineDataSet.setHighLightColor(iArr[workoutTotalChart.curPos]);
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        arrayList17.add(lineDataSet);
        if (arrayList16.size() > 0) {
            int[] iArr2 = {-7829368, -16711936, Color.rgb(128, 0, 128), Color.rgb(0, R2.attr.constraintRotate, 255), Color.rgb(0, R2.attr.constraintRotate, 255)};
            LineDataSet lineDataSet2 = new LineDataSet(arrayList16, workoutTotalChart.omronDataLabels[MyApp.omron_data_select_index]);
            lineDataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet2.setValueTextColor(iArr2[MyApp.omron_data_select_index]);
            lineDataSet2.setDrawCircles(false);
            lineDataSet2.setDrawValues(false);
            lineDataSet2.setColor(iArr2[MyApp.omron_data_select_index]);
            lineDataSet2.setLineWidth(1.0f);
            lineDataSet2.setHighLightColor(iArr2[MyApp.omron_data_select_index]);
            lineDataSet2.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
            arrayList17.add(lineDataSet2);
        } else {
            workoutTotalChart.workoutChart.getAxisLeft().setEnabled(false);
        }
        new LineData();
        workoutTotalChart.workoutChart.setData(new LineData(arrayList17));
        workoutTotalChart.workoutChart.invalidate();
    }
}
