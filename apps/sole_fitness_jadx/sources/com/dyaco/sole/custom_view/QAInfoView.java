package com.dyaco.sole.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class QAInfoView extends LinearLayout {
    private TextView answer_text;
    private TextView qa_text;

    public QAInfoView(Context context) {
        super(context);
        initView(context);
    }

    public QAInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.qa_info_view, this);
        this.qa_text = (TextView) findViewById(R.id.qa_text);
        this.answer_text = (TextView) findViewById(R.id.answer_text);
    }

    public void setView(String str, String str2) {
        this.qa_text.setText(str);
        this.answer_text.setText(str2);
    }
}
