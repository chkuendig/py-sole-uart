package com.dyaco.sole.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.database.UserData;
import com.soletreadmills.sole.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UserListAdapter extends BaseAdapter {
    private int blackColor;
    private Context context;
    public OnClickListener mOnClickListener;
    private ArrayList<UserData> mUserData;
    private Resources res;
    private int whiteColor;

    public interface OnClickListener {
        void onDelete(String str);

        void onGuestIn();

        void onSignIn(String str);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public UserListAdapter(Context context) {
        this.context = context;
        Resources resources = context.getResources();
        this.res = resources;
        this.whiteColor = resources.getColor(R.color.white);
        this.blackColor = this.res.getColor(R.color.black);
    }

    public void setUserData(ArrayList<UserData> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.mUserData = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<UserData> arrayList = this.mUserData;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mUserData.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(this.context, R.layout.item_user_profiles, null);
            viewHolder = new ViewHolder();
            viewHolder.item_number_textview = (TypefaceTextView) view.findViewById(R.id.item_number_textview);
            viewHolder.item_name_textview = (TypefaceTextView) view.findViewById(R.id.item_name_textview);
            viewHolder.item_delete_imageview = (ImageView) view.findViewById(R.id.item_delete_imageview);
            viewHolder.item_user_layout = (LinearLayout) view.findViewById(R.id.item_user_layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.item_user_layout.getLayoutParams();
            layoutParams.height = Global.getLongScreenHeight(layoutParams.height, 0.9f);
            viewHolder.item_user_layout.setLayoutParams(layoutParams);
            viewHolder.item_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.sign_item_text_size), 0.9f));
            viewHolder.item_name_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.sign_item_text_size), 0.9f));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewHolder.item_delete_imageview.getLayoutParams();
            layoutParams2.height = Global.getLongScreenHeight(layoutParams2.height, 0.9f);
            viewHolder.item_delete_imageview.setLayoutParams(layoutParams2);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int i2 = Global.BRAND;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            viewHolder.item_user_layout.setBackgroundColor(this.whiteColor);
            viewHolder.item_number_textview.setTextColor(this.blackColor);
            viewHolder.item_name_textview.setTextColor(this.blackColor);
        }
        if (i == 0) {
            viewHolder.item_number_textview.setVisibility(8);
            viewHolder.item_delete_imageview.setVisibility(8);
            viewHolder.item_name_textview.setText(R.string.guest);
        } else {
            final String name = this.mUserData.get(i).getName();
            viewHolder.item_number_textview.setVisibility(0);
            viewHolder.item_delete_imageview.setVisibility(0);
            viewHolder.item_number_textview.setText(String.valueOf(i));
            viewHolder.item_name_textview.setText(name);
            viewHolder.item_delete_imageview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.adapter.UserListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    UserListAdapter.this.mOnClickListener.onDelete(name);
                }
            });
        }
        viewHolder.item_name_textview.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.adapter.UserListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i != 0) {
                    UserListAdapter.this.mOnClickListener.onSignIn(((UserData) UserListAdapter.this.mUserData.get(i)).getName());
                } else {
                    UserListAdapter.this.mOnClickListener.onGuestIn();
                }
            }
        });
        return view;
    }

    class ViewHolder {
        ImageView item_delete_imageview;
        TypefaceTextView item_name_textview;
        TypefaceTextView item_number_textview;
        LinearLayout item_user_layout;

        ViewHolder() {
        }
    }
}
