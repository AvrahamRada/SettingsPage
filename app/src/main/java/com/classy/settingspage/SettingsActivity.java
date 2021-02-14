package com.classy.settingspage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.MainSettings;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_NOTIFICATION_PICKER = 1000;
    public static final String INTENT_EXTRA_RESULT = "INTENT_EXTRA_RESULT";
    public static final String DEFAULT_NOTIFICATION_SUMMARY = "Silent";
    public static final String SETTINGS_RINGTONE_SILENT_VALUE = "";
    private Toast mToast;
    private ArrayList<BasicSettings> mySettings;

    @Nullable
    private TextView tvNotificationToneSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        LinearLayout container = findViewById(R.id.settingsContainer);
        mySettings = (ArrayList<BasicSettings>) getIntent().getSerializableExtra(MainActivity.MY_LIST);
        MainSettings.inflateSettingsLayout(this, container, mySettings);

    }
}