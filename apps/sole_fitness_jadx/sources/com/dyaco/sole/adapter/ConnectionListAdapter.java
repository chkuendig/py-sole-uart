package com.dyaco.sole.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConnectionListAdapter extends BaseAdapter {
    public ArrayList<HashMap<String, String>> mConnectionData = new ArrayList<>();
    public ArrayList<BluetoothDevice> mConnectionDevice = new ArrayList<>();
    private Context mContext;
    private int selectedColor;
    private int unselectedColor;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public ConnectionListAdapter(Context context) {
        this.mContext = context;
        this.unselectedColor = context.getResources().getColor(R.color.light_gray);
        this.selectedColor = context.getResources().getColor(R.color.display_number_blue);
    }

    public void addConnectionDevice(BluetoothDevice bluetoothDevice, int i) {
        addConnectionData(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bluetoothDevice);
    }

    public void addConnectionData(String str, String str2, int i) {
        addConnectionData(str, str2, i, null);
    }

    public void addConnectionData(String str, String str2, int i, BluetoothDevice bluetoothDevice) {
        Iterator<HashMap<String, String>> it = this.mConnectionData.iterator();
        while (it.hasNext()) {
            if (it.next().get("mac").equals(str)) {
                return;
            }
        }
        HashMap<String, String> map = new HashMap<>(4);
        map.put("mac", str);
        map.put("name", str2);
        map.put("rssi", String.valueOf(i));
        map.put("selected", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.mConnectionDevice.add(bluetoothDevice);
        this.mConnectionData.add(map);
        notifyDataSetChanged();
    }

    public ArrayList<HashMap<String, String>> getmConnectionData() {
        return this.mConnectionData;
    }

    public int getSelectedType() {
        Iterator<HashMap<String, String>> it = this.mConnectionData.iterator();
        while (it.hasNext()) {
            HashMap<String, String> next = it.next();
            if (next.get("selected").equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                String str = next.get("name");
                return (str == null || !str.contains("BM62")) ? 1 : 0;
            }
        }
        return 0;
    }

    public BluetoothDevice getSelectedDevice() {
        for (int i = 0; i < this.mConnectionData.size(); i++) {
            if (this.mConnectionData.get(i).get("selected").equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                return this.mConnectionDevice.get(i);
            }
        }
        return null;
    }

    public String getSelectedMac() {
        Iterator<HashMap<String, String>> it = this.mConnectionData.iterator();
        while (it.hasNext()) {
            HashMap<String, String> next = it.next();
            if (next.get("selected").equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                return next.get("mac");
            }
        }
        return null;
    }

    public String getItemMac(int i) {
        ArrayList<HashMap<String, String>> arrayList = this.mConnectionData;
        HashMap<String, String> map = null;
        if (arrayList == null || arrayList.isEmpty() || i >= this.mConnectionData.size()) {
            return null;
        }
        try {
            map = this.mConnectionData.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map.get("mac");
    }

    public int getRssi(int i) {
        return Integer.parseInt(this.mConnectionData.get(i).get("rssi"));
    }

    public void clearAllData() {
        this.mConnectionData.clear();
        this.mConnectionDevice.clear();
        notifyDataSetChanged();
    }

    public String getSelectedLanguage() {
        for (int i = 0; i < this.mConnectionData.size(); i++) {
            if (this.mConnectionData.get(i).get("selected").equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                return this.mConnectionData.get(i).get("mac");
            }
        }
        return "";
    }

    public void setSelectedLanguage(String str) {
        for (int i = 0; i < this.mConnectionData.size(); i++) {
            if (this.mConnectionData.get(i).get("mac").equals(str)) {
                setSelected(i);
                return;
            }
        }
    }

    public int getSelected() {
        for (int i = 0; i < this.mConnectionData.size(); i++) {
            if (this.mConnectionData.get(i).get("selected").equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                return i;
            }
        }
        return 0;
    }

    public void setSelected(int i) {
        Iterator<HashMap<String, String>> it = this.mConnectionData.iterator();
        while (it.hasNext()) {
            it.next().put("selected", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (i < this.mConnectionData.size()) {
            this.mConnectionData.get(i).put("selected", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<HashMap<String, String>> arrayList = this.mConnectionData;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mConnectionData.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.item_connection, null);
            viewHolder = new ViewHolder();
            viewHolder.item_name_textview = (TextView) view.findViewById(R.id.item_name_textview);
            viewHolder.item_selected_imageview = (ImageView) view.findViewById(R.id.item_selected_imageview);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        HashMap<String, String> map = this.mConnectionData.get(i);
        boolean zEquals = map.get("selected").equals(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        viewHolder.item_selected_imageview.setVisibility(zEquals ? 0 : 8);
        viewHolder.item_name_textview.setTextColor(zEquals ? this.selectedColor : this.unselectedColor);
        viewHolder.item_name_textview.setText(map.get("name"));
        return view;
    }

    class ViewHolder {
        TextView item_name_textview;
        ImageView item_selected_imageview;

        ViewHolder() {
        }
    }
}
