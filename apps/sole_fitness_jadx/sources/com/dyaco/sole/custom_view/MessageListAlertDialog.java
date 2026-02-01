package com.dyaco.sole.custom_view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.MessagePullData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.data.ResponseMessagePush;
import com.digifly.cloudapi.listener.GetPushMessageListener;
import com.digifly.cloudapi.listener.ReadPushMessageListener;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/* loaded from: classes.dex */
public class MessageListAlertDialog {
    private final String TAG = "MessageListAlertDialog";
    private final MyActivity activity;
    private AlertDialog alertDialog;
    private Button btnOk;
    private DialogListener dialogListener;
    private MyAdapter mAdapter;
    private LinearLayout messageListTile;
    private RecyclerView messagePullListView2;
    private TextView txtMessageTitle;
    private Window window;

    public interface DialogListener {
        void OnDismiss();
    }

    public void setDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    public MessageListAlertDialog(MyActivity myActivity) {
        this.activity = myActivity;
    }

    public static MessageListAlertDialog createMessageDialog(MyActivity myActivity) {
        return new MessageListAlertDialog(myActivity);
    }

    public void showAlertDialog() {
        dismiss();
        AlertDialog alertDialogCreate = new AlertDialog.Builder(new ContextThemeWrapper(this.activity, R.style.myDialog)).create();
        this.alertDialog = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.dyaco.sole.custom_view.MessageListAlertDialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (MessageListAlertDialog.this.dialogListener != null) {
                    MessageListAlertDialog.this.dialogListener.OnDismiss();
                }
            }
        });
        this.alertDialog.show();
        TypedValue.applyDimension(1, this.activity.getResources().getDimension(R.dimen.mess_dialog_width), this.activity.getResources().getDisplayMetrics());
        TypedValue.applyDimension(1, this.activity.getResources().getDimension(R.dimen.mess_dialog_height), this.activity.getResources().getDisplayMetrics());
        this.activity.getWindowManager().getDefaultDisplay().getSize(new Point());
        Window window = this.alertDialog.getWindow();
        this.window = window;
        window.setContentView(R.layout.fragment_programs_message);
        this.alertDialog.getWindow().setLayout((int) (this.activity.getResources().getDisplayMetrics().widthPixels * 0.9d), (int) (this.activity.getResources().getDisplayMetrics().heightPixels * 0.9d));
        initView();
        updateMessages();
    }

    public boolean isShowing() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog == null) {
            return false;
        }
        return alertDialog.isShowing();
    }

    public void dismiss() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.alertDialog.dismiss();
        this.alertDialog = null;
    }

    private void initView() {
        Log.d(this.TAG, "initView");
        this.txtMessageTitle = (TextView) this.window.findViewById(R.id.txtMessageTitle);
        Button button = (Button) this.window.findViewById(R.id.btnOk);
        this.btnOk = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.MessageListAlertDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageListAlertDialog.this.alertDialog.dismiss();
            }
        });
        this.messagePullListView2 = (RecyclerView) this.window.findViewById(R.id.messagePullListView);
        this.messagePullListView2.setLayoutManager(new LinearLayoutManager(this.activity));
        MyAdapter myAdapter = new MyAdapter(this.activity);
        this.mAdapter = myAdapter;
        this.messagePullListView2.setAdapter(myAdapter);
        this.mAdapter.setClickListener(new AnonymousClass3());
    }

    /* renamed from: com.dyaco.sole.custom_view.MessageListAlertDialog$3, reason: invalid class name */
    class AnonymousClass3 implements MyAdapter.OnItemClickListener {
        AnonymousClass3() {
        }

        @Override // com.dyaco.sole.custom_view.MessageListAlertDialog.MyAdapter.OnItemClickListener
        public void onClick(View view, int i) {
            final MessagePullData mess = MessageListAlertDialog.this.mAdapter.getMess(i);
            mess.setUmsg_isread(1);
            MessageListAlertDialog.this.mAdapter.notifyItemChanged(i);
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(new ContextThemeWrapper(MessageListAlertDialog.this.activity, R.style.myDialog)).create();
            alertDialogCreate.show();
            TypedValue.applyDimension(1, MessageListAlertDialog.this.activity.getResources().getDimension(R.dimen.mess_dialog_width), MessageListAlertDialog.this.activity.getResources().getDisplayMetrics());
            TypedValue.applyDimension(1, MessageListAlertDialog.this.activity.getResources().getDimension(R.dimen.mess_dialog_height), MessageListAlertDialog.this.activity.getResources().getDisplayMetrics());
            Window window = alertDialogCreate.getWindow();
            window.setContentView(R.layout.dialog_mess_content);
            alertDialogCreate.getWindow().setLayout((int) (MessageListAlertDialog.this.activity.getResources().getDisplayMetrics().widthPixels * 0.9d), (int) (MessageListAlertDialog.this.activity.getResources().getDisplayMetrics().heightPixels * 0.9d));
            TextView textView = (TextView) window.findViewById(R.id.message_date);
            TextView textView2 = (TextView) window.findViewById(R.id.message_title);
            TextView textView3 = (TextView) window.findViewById(R.id.message_content);
            Button button = (Button) window.findViewById(R.id.btnOk);
            textView.setText(mess.getC_date());
            textView2.setText(mess.getUmsg_subject());
            textView3.setText(mess.getUmsg_content());
            button.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.custom_view.MessageListAlertDialog.3.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    alertDialogCreate.dismiss();
                    CloudApi.getInstance(MessageListAlertDialog.this.activity).callReadPushMessage(Global.memberData.getAccount(), Global.memberData.getPassword(), mess.getMessage_no(), new ReadPushMessageListener() { // from class: com.dyaco.sole.custom_view.MessageListAlertDialog.3.1.1
                        @Override // com.digifly.cloudapi.listener.ReadPushMessageListener
                        public void onSuccess(ResponseDataCollection responseDataCollection) {
                            Log.d(MessageListAlertDialog.this.TAG, "initView -> onSuccess -> responseMessage=" + responseDataCollection);
                        }

                        @Override // com.digifly.cloudapi.listener.ReadPushMessageListener
                        public void onFail(ResponseDataCollection responseDataCollection) {
                            Log.d(MessageListAlertDialog.this.TAG, "initView -> onFail -> responseMessage=" + responseDataCollection);
                        }

                        @Override // com.digifly.cloudapi.listener.ReadPushMessageListener
                        public void onError(String str) {
                            Log.d(MessageListAlertDialog.this.TAG, "initView -> onFail -> err=" + str);
                        }
                    });
                }
            });
        }
    }

    public void updateMessages() {
        Log.d(this.TAG, "updateMessages");
        CloudApi cloudApi = CloudApi.getInstance(this.activity);
        cloudApi.setGetPushMessageListener(new GetPushMessageListener() { // from class: com.dyaco.sole.custom_view.MessageListAlertDialog.4
            @Override // com.digifly.cloudapi.listener.GetPushMessageListener
            public void onSuccess(final ResponseMessagePush responseMessagePush) {
                Log.d(MessageListAlertDialog.this.TAG, "updateMessages -> onSuccess");
                MessageListAlertDialog.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.custom_view.MessageListAlertDialog.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageListAlertDialog.this.mAdapter.clearAllData();
                        List<MessagePullData> sys_response_data = responseMessagePush.getSys_response_data();
                        Log.d(MessageListAlertDialog.this.TAG, "updateMessages -> onSuccess -> sys_response_data=" + sys_response_data);
                        Iterator<MessagePullData> it = sys_response_data.iterator();
                        while (it.hasNext()) {
                            MessageListAlertDialog.this.mAdapter.addMess(it.next());
                        }
                    }
                });
            }

            @Override // com.digifly.cloudapi.listener.GetPushMessageListener
            public void onFail(ResponseMessagePush responseMessagePush) {
                Log.d(MessageListAlertDialog.this.TAG, "updateMessages -> onFail");
            }

            @Override // com.digifly.cloudapi.listener.GetPushMessageListener
            public void onError(String str) {
                Log.d(MessageListAlertDialog.this.TAG, "updateMessages -> onError");
            }
        });
        cloudApi.callMessagePull(Global.memberData.getAccount(), Global.memberData.getPassword());
    }

    public static class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private OnItemClickListener clickListener;
        private List<MessagePullData> datas = new ArrayList();
        private Context mContext;

        public interface OnItemClickListener {
            void onClick(View view, int i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        public MyAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message_pull, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            DateTime dateTime = DateTime.parse(this.datas.get(i).getC_date(), DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_TIME_FORMAT));
            viewHolder.date.setText(dateTime.toString(CalendarUtils.SQL_DATE_FORMAT));
            viewHolder.time.setText(dateTime.toString("HH:mm"));
            viewHolder.subject.setText(this.datas.get(i).getUmsg_subject());
            if (this.datas.get(i).getUmsg_isread() == 1) {
                viewHolder.iconIsRead.setVisibility(8);
            } else {
                viewHolder.iconIsRead.setVisibility(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MessagePullData> list = this.datas;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void addMess(MessagePullData messagePullData) {
            this.datas.add(messagePullData);
            notifyDataSetChanged();
        }

        public MessagePullData getMess(int i) {
            return this.datas.get(i);
        }

        public void setClickListener(OnItemClickListener onItemClickListener) {
            this.clickListener = onItemClickListener;
        }

        public void clearAllData() {
            this.datas.clear();
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public final TextView date;
            private final ImageView iconIsRead;
            public final TextView subject;
            public final TextView time;

            public ViewHolder(View view) {
                super(view);
                this.date = (TextView) view.findViewById(R.id.dateMess);
                this.time = (TextView) view.findViewById(R.id.timeMess);
                this.subject = (TextView) view.findViewById(R.id.subjectMess);
                this.iconIsRead = (ImageView) view.findViewById(R.id.iconIsRead);
                view.setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MyAdapter.this.clickListener != null) {
                    MyAdapter.this.clickListener.onClick(view, getAdapterPosition());
                }
            }
        }
    }
}
