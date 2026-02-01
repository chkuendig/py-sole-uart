package com.dyaco.sole.custom_view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.adapter.ConnectionListAdapter;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class SelectChartDialog extends Dialog implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int BMI = 2;
    private static final int body_fat = 1;
    private static final int diastolic = 4;
    private static final int systolic = 3;
    private static final int weight = 0;

    /* renamed from: 血糖, reason: contains not printable characters */
    private static final int f7 = 5;
    private ConnectionListAdapter adapter;
    private TextView connection_cancel_textview;
    private TextView connection_connect_textview;
    private ListView connection_listView;
    private TextView connection_title_textview;

    public SelectChartDialog(Context context) {
        super(context, R.style.full_screen_dialog);
        setContentView(R.layout.dialog_connection);
        findViews();
        initParams();
        setListeners();
    }

    protected void findViews() {
        this.connection_title_textview = (TextView) findViewById(R.id.connection_title_textview);
        this.connection_listView = (ListView) findViewById(R.id.connection_listView);
        this.connection_cancel_textview = (TextView) findViewById(R.id.connection_cancel_textview);
        this.connection_connect_textview = (TextView) findViewById(R.id.connection_connect_textview);
    }

    protected void initParams() {
        this.connection_title_textview.setText(R.string.select_omron_data);
        ConnectionListAdapter connectionListAdapter = new ConnectionListAdapter(getContext());
        this.adapter = connectionListAdapter;
        this.connection_listView.setAdapter((ListAdapter) connectionListAdapter);
        this.adapter.addConnectionData("mac0", getContext().getResources().getString(R.string.omron_weight), 0);
        this.adapter.addConnectionData("mac1", getContext().getResources().getString(R.string.omron_body_fat), 1);
        this.adapter.addConnectionData("mac2", getContext().getResources().getString(R.string.omron_BMI), 2);
        this.adapter.addConnectionData("mac3", getContext().getResources().getString(R.string.omron_systolic_pressure), 3);
        this.adapter.addConnectionData("mac4", getContext().getResources().getString(R.string.omron_diastolic_pressure), 4);
        this.connection_connect_textview.setText(R.string.confirm);
        this.connection_connect_textview.setEnabled(true);
        this.adapter.setSelectedLanguage(String.format("mac%d", Integer.valueOf(MyApp.omron_data_select_index)));
        findViewById(R.id.connection_refresh_imageview).setVisibility(8);
    }

    protected void setListeners() {
        this.connection_cancel_textview.setOnClickListener(this);
        this.connection_connect_textview.setOnClickListener(this);
        this.connection_listView.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.connection_cancel_textview /* 2131231027 */:
                dismiss();
                break;
            case R.id.connection_connect_textview /* 2131231028 */:
                MyApp.omron_data_select_index = this.adapter.getRssi(this.adapter.getSelected());
                dismiss();
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.connection_connect_textview.setEnabled(true);
        this.adapter.setSelected(i);
    }
}
