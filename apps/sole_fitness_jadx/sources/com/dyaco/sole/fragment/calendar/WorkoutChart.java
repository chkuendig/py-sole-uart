package com.dyaco.sole.fragment.calendar;

import android.content.Context;
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
import androidx.exifinterface.media.ExifInterface;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.dyaco.sole.custom.Global;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public class WorkoutChart extends RelativeLayout implements View.OnClickListener {
    private static final int CHART_COUNT = 3;
    private String[] UnitLabels;
    private String[] UnitLabels2;
    private Button btnNext;
    private Button btnPre;
    private List<Entry> caloriesEntries;
    private LinearLayout centerLayout;
    private View chartView;
    private final Context context;
    private int curPos;
    private List<DCTrainingDetailData> detailData;
    private List<List<Entry>> entriesList;
    private IAxisValueFormatter iAxisValueFormatter;
    private String in_out;
    private TextView infoLeft1;
    private TextView infoLeft2;
    private TextView infoRight1;
    private TextView infoRight2;
    private String[] labels;
    private LinearLayout leftLayout1;
    private LinearLayout leftLayout2;
    private YAxis leftYAxis;
    private TextView nextTitle;
    private List<Entry> paceEntries;
    private TextView preTitle;
    private YAxis rightYAxis;
    private List<Entry> speedEntries;
    private DCTrainingData trainData;
    private float[] values;
    private LineChart workoutChart;
    private XAxis xAxis;

    public WorkoutChart(Context context) {
        super(context);
        this.entriesList = new ArrayList();
        this.curPos = 1;
        this.labels = new String[]{getResources().getString(R.string.display_pace), getResources().getString(R.string.speed).toUpperCase(), getResources().getString(R.string.calories)};
        this.UnitLabels2 = new String[]{getResources().getString(R.string.avg_pace_chart2), getResources().getString(R.string.avg_speed_chart2), getResources().getString(R.string.avg_calorie_chart2)};
        this.UnitLabels = new String[]{getResources().getString(R.string.avg_pace_chart), getResources().getString(R.string.avg_speed_chart), getResources().getString(R.string.avg_calorie_chart)};
        this.context = context;
        init();
    }

    public WorkoutChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.entriesList = new ArrayList();
        this.curPos = 1;
        this.labels = new String[]{getResources().getString(R.string.display_pace), getResources().getString(R.string.speed).toUpperCase(), getResources().getString(R.string.calories)};
        this.UnitLabels2 = new String[]{getResources().getString(R.string.avg_pace_chart2), getResources().getString(R.string.avg_speed_chart2), getResources().getString(R.string.avg_calorie_chart2)};
        this.UnitLabels = new String[]{getResources().getString(R.string.avg_pace_chart), getResources().getString(R.string.avg_speed_chart), getResources().getString(R.string.avg_calorie_chart)};
        this.context = context;
        init();
    }

    public WorkoutChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.entriesList = new ArrayList();
        this.curPos = 1;
        this.labels = new String[]{getResources().getString(R.string.display_pace), getResources().getString(R.string.speed).toUpperCase(), getResources().getString(R.string.calories)};
        this.UnitLabels2 = new String[]{getResources().getString(R.string.avg_pace_chart2), getResources().getString(R.string.avg_speed_chart2), getResources().getString(R.string.avg_calorie_chart2)};
        this.UnitLabels = new String[]{getResources().getString(R.string.avg_pace_chart), getResources().getString(R.string.avg_speed_chart), getResources().getString(R.string.avg_calorie_chart)};
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

    public void updateView(DCTrainingData dCTrainingData, List<DCTrainingDetailData> list) {
        this.trainData = dCTrainingData;
        this.detailData = list;
        this.workoutChart.clear();
        this.in_out = dCTrainingData.getIn_out();
        String category_code = dCTrainingData.getCategory_code();
        int i = getContext().getSharedPreferences("UnitWay", 0).getInt("unit", -1);
        if (i != -1) {
            if (i == 0 && !this.trainData.getUnit().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.trainData.setUnit(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                dCTrainingData.setTotal_distance((float) (dCTrainingData.getTotal_distance() * 0.6d));
                dCTrainingData.setAvg_speed((float) (dCTrainingData.getAvg_speed() * 0.6d));
            } else if (i == 1 && this.trainData.getUnit().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                this.trainData.setUnit(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                dCTrainingData.setTotal_distance((float) (dCTrainingData.getTotal_distance() * 1.6d));
                dCTrainingData.setAvg_speed((float) (dCTrainingData.getAvg_speed() * 1.6d));
            }
        }
        int i2 = R.string.avg_speed_chart2_km;
        if (!this.trainData.getUnit().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            i2 = R.string.avg_speed_chart2;
        }
        if (category_code.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            i2 = R.string.avg_rpm_chart2;
        }
        int i3 = R.string.avg_pace_chart2_km;
        if (!this.trainData.getUnit().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            i3 = R.string.avg_pace_chart2;
        }
        this.UnitLabels2 = new String[]{getResources().getString(i3), getResources().getString(i2), getResources().getString(R.string.avg_calorie_chart2)};
        String upperCase = getResources().getString(R.string.speed).toUpperCase();
        if (category_code.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            upperCase = getResources().getString(R.string.display_rpm).toUpperCase();
        }
        this.labels = new String[]{getResources().getString(R.string.display_pace), upperCase, getResources().getString(R.string.calories)};
        turnEntryData();
        updateChart();
        Logger.d("333");
        this.centerLayout.setVisibility(8);
        this.leftLayout2.setVisibility(8);
        this.leftLayout1.setVisibility(0);
    }

    private void setDataSetUI(int i, LineDataSet lineDataSet) {
        int[] iArr = {-16776961, SupportMenu.CATEGORY_MASK, Color.rgb(255, 102, 0)};
        lineDataSet.setColor(iArr[i]);
        lineDataSet.setCircleColor(iArr[i]);
        lineDataSet.setLineWidth(1.0f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setCircleRadius(2.0f);
        lineDataSet.setCircleHoleRadius(0.5f);
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
        this.speedEntries = new ArrayList();
        this.caloriesEntries = new ArrayList();
        this.paceEntries = new ArrayList();
        this.entriesList.clear();
        int i = 0;
        if (this.trainData.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D) || (this.trainData.getBrand_code() != null && this.trainData.getBrand_code().contains("garmin"))) {
            this.values = new float[]{this.trainData.getTotal_distance() != 0.0f ? (this.trainData.getTotal_time() / this.trainData.getTotal_distance()) / 60.0f : 0.0f, this.trainData.getAvg_speed(), this.trainData.getTotal_calories()};
        } else {
            float total_time = this.trainData.getTotal_distance() != 0.0f ? (this.trainData.getTotal_time() / this.trainData.getTotal_distance()) / 60.0f : 0.0f;
            float avg_speed = this.trainData.getAvg_speed();
            if (!this.in_out.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) ? !this.trainData.getUnit().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) : !Global.memberData.getUnit_type().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                avg_speed /= 1.6f;
            }
            if (this.trainData.getCategory_code().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                avg_speed = this.trainData.getAvg_rpm();
            }
            this.values = new float[]{total_time, avg_speed, this.trainData.getTotal_calories()};
        }
        while (i < this.detailData.size()) {
            DCTrainingDetailData dCTrainingDetailData = this.detailData.get(i);
            new DateTime(dCTrainingDetailData.getTraning_datetime()).plusSeconds((int) dCTrainingDetailData.getD_time());
            float f = i;
            this.paceEntries.add(new Entry(f, new BigDecimal(dCTrainingDetailData.getD_distance() != 0.0f ? (dCTrainingDetailData.getD_time() / dCTrainingDetailData.getD_distance()) / 60.0f : 0.0f).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
            this.speedEntries.add(new Entry(f, new BigDecimal(dCTrainingDetailData.getD_speed()).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
            if (this.trainData.getIn_out().equals(ExifInterface.GPS_MEASUREMENT_2D) || (this.trainData.getBrand_code() != null && this.trainData.getBrand_code().contains("garmin"))) {
                this.caloriesEntries.add(new Entry(f, new BigDecimal(dCTrainingDetailData.getD_calories()).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
            } else {
                this.caloriesEntries.add(new Entry(f, new BigDecimal(i > 0 ? dCTrainingDetailData.getD_calories() - this.detailData.get(i - 1).getD_calories() : 0.0f).setScale(2, RoundingMode.HALF_DOWN).floatValue()));
            }
            i++;
        }
        this.entriesList.add(this.paceEntries);
        this.entriesList.add(this.speedEntries);
        this.entriesList.add(this.caloriesEntries);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnNext) {
            goNextChart();
            updateChart();
        } else {
            if (id != R.id.btnPre) {
                return;
            }
            goPreChart();
            updateChart();
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
        Date training_datetime = this.trainData.getTraining_datetime();
        String string = new DateTime(training_datetime).toString("MM-dd HH:mm");
        String str4 = this.UnitLabels[this.curPos];
        this.infoRight1.setText(str);
        this.infoRight2.setText(string);
        this.nextTitle.setText(str2);
        this.preTitle.setText(str3);
        String str5 = String.format("%4.2f", Float.valueOf(this.values[this.curPos]));
        String str6 = this.UnitLabels2[this.curPos];
        this.infoLeft1.setText(String.valueOf(str5 + "  " + str6));
        this.infoLeft2.setText(String.valueOf(str4));
        setData();
        MyIAxisValueFormatter myIAxisValueFormatter = new MyIAxisValueFormatter(training_datetime);
        this.iAxisValueFormatter = myIAxisValueFormatter;
        this.xAxis.setValueFormatter(myIAxisValueFormatter);
        Logger.d("222");
        this.workoutChart.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setData() {
        if (this.workoutChart.getData() != null && ((LineData) this.workoutChart.getData()).getDataSetCount() > 0) {
            LineDataSet lineDataSet = (LineDataSet) ((LineData) this.workoutChart.getData()).getDataSetByIndex(0);
            lineDataSet.setValues(this.entriesList.get(this.curPos));
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
        private final Date training_datetime;

        public MyIAxisValueFormatter(Date date) {
            this.training_datetime = date;
        }

        @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
        public String getFormattedValue(float f, AxisBase axisBase) {
            return String.valueOf(new DateTime(this.training_datetime).plusSeconds((int) f).toString("HH:mm:ss"));
        }
    }

    public class MyValueFormatter implements IValueFormatter {
        private DecimalFormat mFormat = new DecimalFormat("##0.00");

        public MyValueFormatter() {
        }

        @Override // com.github.mikephil.charting.formatter.IValueFormatter
        public String getFormattedValue(float f, Entry entry, int i, ViewPortHandler viewPortHandler) {
            Logger.d("getFormattedValue  value = " + f);
            return this.mFormat.format(f);
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
}
