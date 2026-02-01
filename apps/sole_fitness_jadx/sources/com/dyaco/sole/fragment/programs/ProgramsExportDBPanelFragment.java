package com.dyaco.sole.fragment.programs;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.dyaco.sole.activity.ConnectionDialog;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.fragment.BaseFragment;
import com.soletreadmills.sole.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public class ProgramsExportDBPanelFragment extends BaseFragment {
    private static final String SAMPLE_DB_NAME = "digifly.db";
    private static final String SAMPLE_TABLE_NAME = "TRAINING_DATA";
    private MainActivity activity;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private FrameLayout content_layout;
    private View exportDb;
    private View include_calendar_goal;
    private View outdoor;
    private View rootView;
    private TextView txtAdbCmd;
    private TextView txtDstDBPath;
    private TextView txtSrcDBPath;
    private String dbPath = "";
    private View.OnClickListener onClick = new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProgramsExportDBPanelFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IOException, SQLException {
            switch (view.getId()) {
                case R.id.btnCheck /* 2131230847 */:
                    ProgramsExportDBPanelFragment.this.checkDBExist();
                    break;
                case R.id.btnExportDB /* 2131230849 */:
                    Toast.makeText(ProgramsExportDBPanelFragment.this.getActivity(), "Export DB", 1).show();
                    break;
                case R.id.btnOutdoor /* 2131230856 */:
                    ProgramsExportDBPanelFragment.this.activity.switchFragment(8);
                    break;
                case R.id.button1 /* 2131230870 */:
                    ProgramsExportDBPanelFragment.this.deleteDB();
                    break;
                case R.id.button2 /* 2131230871 */:
                    ProgramsExportDBPanelFragment.this.exportDB();
                    break;
                case R.id.button3 /* 2131230872 */:
                    ProgramsExportDBPanelFragment.this.createDB();
                    break;
            }
        }
    };

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initGoalView();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_programs_export_db_panel, viewGroup, false);
        } else if (i == 1 || i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_export_db_panel, viewGroup, false);
        }
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.outdoor = this.rootView.findViewById(R.id.btnOutdoor);
        this.exportDb = this.rootView.findViewById(R.id.btnExportDB);
        this.btn1 = (Button) this.rootView.findViewById(R.id.button1);
        this.btn2 = (Button) this.rootView.findViewById(R.id.button2);
        this.btn3 = (Button) this.rootView.findViewById(R.id.button3);
        this.btn4 = (Button) this.rootView.findViewById(R.id.btnCheck);
        this.txtSrcDBPath = (TextView) this.rootView.findViewById(R.id.txt_src_db_path);
        this.txtDstDBPath = (TextView) this.rootView.findViewById(R.id.txt_dst_db_path);
        this.txtAdbCmd = (TextView) this.rootView.findViewById(R.id.txt_adb_cmd);
    }

    private void initGoalView() {
        int i = Global.BRAND;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        int i = Global.BRAND;
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        this.outdoor.setOnClickListener(this.onClick);
        this.exportDb.setOnClickListener(this.onClick);
        this.btn1.setOnClickListener(this.onClick);
        this.btn2.setOnClickListener(this.onClick);
        this.btn3.setOnClickListener(this.onClick);
        this.btn4.setOnClickListener(this.onClick);
        this.txtSrcDBPath.setOnClickListener(this.onClick);
        this.txtDstDBPath.setOnClickListener(this.onClick);
        this.txtAdbCmd.setOnClickListener(this.onClick);
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws IOException {
        super.onActivityResult(i, i2, intent);
        if (i == 99 && i2 == -1) {
            int i3 = Global.BRAND;
            if (i3 == 0) {
                this.activity.switchFragment(3);
                return;
            }
            if (i3 == 1) {
                this.activity.switchFragment(3);
                return;
            }
            if (i3 == 2 || i3 == 3) {
                if (ProtocolHandler.protocol.salesVersion == 1) {
                    this.activity.startWorkout();
                    this.activity.switchFragment(5);
                } else {
                    this.activity.switchFragment(3);
                }
            }
        }
    }

    private void goPage(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this.activity, cls);
        startActivity(intent);
    }

    private void goConnection() {
        startActivityForResult(new Intent(getActivity(), (Class<?>) ConnectionDialog.class), 99);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteDB() {
        if (getActivity().deleteDatabase(SAMPLE_DB_NAME)) {
            Toast.makeText(getActivity(), "DB Deleted!", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDB() throws SQLException {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = getActivity().openOrCreateDatabase(SAMPLE_DB_NAME, 0, null);
        sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRAINING_DATA (LastName VARCHAR, FirstName VARCHAR, Rank VARCHAR);");
        sQLiteDatabaseOpenOrCreateDatabase.execSQL("INSERT INTO TRAINING_DATA Values ('Kirk','James, T','Captain');");
        sQLiteDatabaseOpenOrCreateDatabase.close();
        String path = sQLiteDatabaseOpenOrCreateDatabase.getPath();
        this.dbPath = path;
        this.txtSrcDBPath.setText(path);
        Toast.makeText(getActivity(), "DB Created @ " + sQLiteDatabaseOpenOrCreateDatabase.getPath(), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkDBExist() {
        this.dbPath = getActivity().openOrCreateDatabase(SAMPLE_DB_NAME, 0, null).getPath();
        File file = new File(this.dbPath);
        try {
            if (file.exists()) {
                Toast.makeText(getActivity(), "dbPath " + this.dbPath + " dbFile.exists() " + file.exists(), 1).show();
            } else {
                Toast.makeText(getActivity(), "dbPath " + this.dbPath + " dbFile dose not exist ! ", 1).show();
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "dbFile dose not exist ! " + e.toString(), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exportDB() throws IOException {
        this.dbPath = getActivity().openOrCreateDatabase(SAMPLE_DB_NAME, 0, null).getPath();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        Environment.getDataDirectory();
        String str = this.dbPath;
        File file = new File(str);
        File file2 = new File(externalStorageDirectory, "digifly.db.db");
        if (file.exists()) {
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                channel2.transferFrom(channel, 0L, channel.size());
                channel.close();
                channel2.close();
                if (file2.exists()) {
                    this.txtDstDBPath.setText(file2.getPath());
                    this.txtAdbCmd.setText("adb pull " + file2.getPath());
                    Toast.makeText(getActivity(), file2.getPath() + " DB Exported!", 1).show();
                } else {
                    Toast.makeText(getActivity(), file2.getPath() + " DB Export failed !", 1).show();
                }
                return;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), str + " DB Export failed ! " + e.toString(), 1).show();
                return;
            }
        }
        Toast.makeText(getActivity(), "dbPath " + this.dbPath + " currentDB dose not exist ! ", 1).show();
    }
}
