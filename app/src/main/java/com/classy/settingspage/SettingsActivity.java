package com.classy.settingspage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.CheckBox.CheckboxSettings;
import com.classy.settingspagelibrary.MainSettings;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_NOTIFICATION_PICKER = 1000;
    public static final String INTENT_EXTRA_RESULT = "INTENT_EXTRA_RESULT";
    public static final String DEFAULT_NOTIFICATION_SUMMARY = "Silent";
    public static final String SETTINGS_RINGTONE_SILENT_VALUE = "";
    private Toast mToast;
    private ArrayList<BasicSettings> mySettings;

    CheckBox test;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        LinearLayout container = findViewById(R.id.settings);
        mySettings = (ArrayList<BasicSettings>) getIntent().getSerializableExtra(MainActivity.MY_SETTINGS);
        MainSettings.inflateSettingsLayout(this, container, mySettings);

        if (mySettings.get(7) instanceof CheckboxSettings){
            test = findViewById(((CheckboxSettings) mySettings.get(7)).getCheckboxId());
            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView test1 = findViewById(((CheckboxSettings) mySettings.get(7)).getTextViewContentId());
                    if(test.isChecked() == true){
                        test1.setText("On");
                    }
                    else{
                        test1.setText("Off");
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent results = new Intent();
        results.putExtra(INTENT_EXTRA_RESULT, mySettings);
        setResult(RESULT_OK, results);
        super.onBackPressed();
    }
}