package no.nordicsemi.android.ble.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class JsonMerger implements DataMerger {
    private String buffer = "";

    @Override // no.nordicsemi.android.ble.data.DataMerger
    public boolean merge(DataStream dataStream, byte[] bArr, int i) {
        dataStream.write(bArr);
        this.buffer += new String(bArr);
        try {
            try {
                new JSONObject(this.buffer);
            } catch (JSONException unused) {
                return false;
            }
        } catch (JSONException unused2) {
            new JSONArray(this.buffer);
        }
        reset();
        return true;
    }

    public void reset() {
        this.buffer = "";
    }
}
