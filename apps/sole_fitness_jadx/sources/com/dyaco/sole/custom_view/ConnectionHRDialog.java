package com.dyaco.sole.custom_view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.adapter.ConnectionListAdapter;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class ConnectionHRDialog extends LinearLayout implements AdapterView.OnItemClickListener {
    final String TAG;
    public ConnectionListAdapter adapter;
    private ProgressWheel circle_progress;
    private View connectHRDialog;
    private TextView connection_cancel_textview;
    private TextView connection_connect_textview;
    private ListView connection_listView;
    private ImageView connection_refresh_imageview;
    private TextView connection_title_textview;

    public ConnectionHRDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ConnectionHRDialog";
        this.connectHRDialog = LayoutInflater.from(context).inflate(R.layout.dialog_connection, this);
        findViews();
        initViews();
        initListener();
    }

    private void findViews() {
        this.connection_title_textview = (TextView) this.connectHRDialog.findViewById(R.id.connection_title_textview);
        this.connection_cancel_textview = (TextView) this.connectHRDialog.findViewById(R.id.connection_cancel_textview);
        this.connection_connect_textview = (TextView) this.connectHRDialog.findViewById(R.id.connection_connect_textview);
        this.connection_refresh_imageview = (ImageView) this.connectHRDialog.findViewById(R.id.connection_refresh_imageview);
        this.connection_listView = (ListView) this.connectHRDialog.findViewById(R.id.connection_listView);
        this.circle_progress = (ProgressWheel) this.connectHRDialog.findViewById(R.id.circle_progress);
    }

    private void initViews() {
        this.connectHRDialog.setVisibility(8);
        this.connection_title_textview.setText(getContext().getString(R.string.connect_hr_title));
        ConnectionListAdapter connectionListAdapter = new ConnectionListAdapter(getContext());
        this.adapter = connectionListAdapter;
        this.connection_listView.setAdapter((ListAdapter) connectionListAdapter);
    }

    private void initListener() {
        this.connection_listView.setOnItemClickListener(this);
        this.connection_connect_textview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.ConnectionHRDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(ConnectionHRDialog.this.getContext(), ErrorLogSave.CLICK, "ConnectionHRDialog_connect", ErrorLogSave.CLICK);
                ConnectionHRDialog.this.circle_progress.setVisibility(0);
                ((MainActivity) ConnectionHRDialog.this.getContext()).stopHRScan();
                ((MainActivity) ConnectionHRDialog.this.getContext()).connectHRDevice(ConnectionHRDialog.this.adapter.getSelectedDevice().getAddress());
            }
        });
        this.connection_cancel_textview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.ConnectionHRDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(ConnectionHRDialog.this.getContext(), ErrorLogSave.CLICK, "ConnectionHRDialog_cancel", ErrorLogSave.CLICK);
                ((MainActivity) ConnectionHRDialog.this.getContext()).startHRScan();
                ConnectionHRDialog.this.connectHRDialog.setVisibility(8);
            }
        });
        this.connection_refresh_imageview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.ConnectionHRDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorLogSave.addErrorString(ConnectionHRDialog.this.getContext(), ErrorLogSave.CLICK, "ConnectionHRDialog_refresh", ErrorLogSave.CLICK);
                ConnectionHRDialog.this.scan();
            }
        });
        this.connectHRDialog.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.ConnectionHRDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    public void scan() {
        Log.d(this.TAG, "circle_progress getVisibility=" + this.circle_progress.getVisibility());
        this.adapter.clearAllData();
        this.connection_connect_textview.setEnabled(false);
        this.connectHRDialog.setVisibility(0);
        ((MainActivity) getContext()).startHRScan();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(10);
        this.connection_refresh_imageview.startAnimation(rotateAnimation);
        new Handler().postDelayed(new Runnable() { // from class: com.dyaco.sole.custom_view.ConnectionHRDialog.5
            @Override // java.lang.Runnable
            public void run() {
                ((MainActivity) ConnectionHRDialog.this.getContext()).stopHRScan();
            }
        }, 10000L);
    }

    public void close() {
        closeProgress();
        this.connectHRDialog.setVisibility(8);
    }

    public void closeProgress() {
        this.circle_progress.setVisibility(8);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.connection_connect_textview.setEnabled(true);
        this.adapter.setSelected(i);
    }
}
