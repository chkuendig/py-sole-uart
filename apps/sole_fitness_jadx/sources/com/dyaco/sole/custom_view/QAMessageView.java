package com.dyaco.sole.custom_view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dyaco.sole.Bean.MessageBean;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import com.soletreadmills.sole.R;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class QAMessageView extends LinearLayout {
    private TextView qa_date;
    private ImageView qa_img;
    private TextView qa_text;

    public QAMessageView(Context context) {
        super(context);
        initView(context);
    }

    public QAMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.qa_message_view, this);
        this.qa_img = (ImageView) findViewById(R.id.qa_img);
        this.qa_text = (TextView) findViewById(R.id.qa_text);
        this.qa_date = (TextView) findViewById(R.id.qa_date);
    }

    public void setView(MessageBean messageBean) {
        if (messageBean == null) {
            return;
        }
        if (messageBean.getType().equals("TEXT")) {
            this.qa_img.setImageResource(R.drawable.qa_icon_message_user);
            this.qa_text.setText(messageBean.getMsg_content());
            this.qa_text.setTextColor(Color.parseColor("#000000"));
        } else if (messageBean.getType().equals("RETEXT")) {
            this.qa_img.setImageResource(R.drawable.qa_icon_message_csr);
            this.qa_text.setText(messageBean.getMsg_content());
            this.qa_text.setTextColor(Color.parseColor("#000000"));
        } else if (messageBean.getType().equals(ShareConstants.IMAGE_URL)) {
            this.qa_img.setImageResource(R.drawable.qa_icon_message_user);
            this.qa_text.setText("Uploaded photo");
            this.qa_text.setTextColor(Color.parseColor("#0000CC"));
            this.qa_text.getPaint().setFlags(8);
            this.qa_text.getPaint().setAntiAlias(true);
        } else if (messageBean.getType().equals("REIMAGE")) {
            this.qa_img.setImageResource(R.drawable.qa_icon_message_csr);
            this.qa_text.setText("Uploaded photo");
            this.qa_text.setTextColor(Color.parseColor("#0000CC"));
            this.qa_text.getPaint().setFlags(8);
            this.qa_text.getPaint().setAntiAlias(true);
        }
        this.qa_date.setText(getDate(messageBean.getMsg_datetime()));
    }

    public void setTextOnClickListener(View.OnClickListener onClickListener) {
        this.qa_text.setOnClickListener(onClickListener);
    }

    private String getDate(String str) throws NumberFormatException {
        String str2;
        String[] strArrSplit = str.split(StringUtils.SPACE);
        String[] strArrSplit2 = strArrSplit[1].split(CertificateUtil.DELIMITER);
        Log.e("checkTime", strArrSplit2[0] + " | " + strArrSplit2[1] + " | " + strArrSplit2[2]);
        int i = Integer.parseInt(strArrSplit2[0]);
        if (i > 12) {
            i -= 12;
            str2 = "PM";
        } else {
            str2 = "AM";
        }
        String strValueOf = String.valueOf(i);
        if (i < 10) {
            strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + String.valueOf(i);
        }
        return strArrSplit[0] + StringUtils.LF + strValueOf + CertificateUtil.DELIMITER + strArrSplit2[1] + str2;
    }
}
