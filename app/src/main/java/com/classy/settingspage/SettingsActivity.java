package com.classy.settingspage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.CheckBox.CheckboxSettings;
import com.classy.settingspagelibrary.HeaderAndContent.HeaderAndContentSettings;
import com.classy.settingspagelibrary.Image.ImageSettings;
import com.classy.settingspagelibrary.MainSettings;
import com.classy.settingspagelibrary.Seekbar.Seekbar;
import com.classy.settingspagelibrary.Seekbar.SeekbarSettings;
import com.classy.settingspagelibrary.Switch.SwitchSettings;
import com.classy.settingspagelibrary.Title.TitleSettings;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    public static final String INTENT_EXTRA_RESULT = "INTENT_EXTRA_RESULT";
    private ArrayList<BasicSettings> mySettings;


    TextView tempTitle;
    TextView tempContent;
    CheckBox tempCheckbox;
    Switch tempSwitch;
    Seekbar tempSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        LinearLayout container = findViewById(R.id.settings);
        mySettings = (ArrayList<BasicSettings>) getIntent().getSerializableExtra(MainActivity.MY_SETTINGS);
        MainSettings.inflateSettingsLayout(this, container, mySettings);


        for (int i = 0; i < mySettings.size(); i++) {
//            switch (mySettings.get(i).getType()) {
                if(mySettings.get(i) instanceof TitleSettings) {
//                    Log.d("PTTT", ((TitleSettings) mySettings.get(i)).getTitle() + "");
                }

            if(mySettings.get(i) instanceof HeaderAndContentSettings) {
//                    Log.d("PTTT", ((HeaderAndContentSettings) mySettings.get(i)).getTitle() + "");
            }

            if(mySettings.get(i) instanceof CheckboxSettings) {
//                    Log.d("PTTT", ((CheckboxSettings) mySettings.get(i)).getTitle() + "");
                tempCheckbox = findViewById(((CheckboxSettings) mySettings.get(i)).getCheckboxId());
                tempContent = findViewById(((CheckboxSettings) mySettings.get(i)).getTextViewContentId());

                tempCheckbox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = tempContent.getText().toString();
                        if (tempCheckbox.isChecked() == true) {
                            tempContent.setText(tempContent.getText() + " - On");
                        } else {
                            tempContent.setText(tempContent.getText() + " - Off");
                        }
                    }
                });
            }

            if(mySettings.get(i) instanceof SwitchSettings) {
            }

            else if(mySettings.get(i) instanceof ImageSettings) {
            }
            else if(mySettings.get(i) instanceof SeekbarSettings) {
            }

            else{

            }

        }

        for (BasicSettings obj : mySettings) {
            int i = 0;
            switch (obj.getType()) {
                case TITLE:

                    break;
                case CONTENT:

                    break;
                case CHECKBOX:
//                    test = findViewById(((CheckboxSettings) mySettings.get(i)).getCheckboxId());
//                    TextView test1 = findViewById(((CheckboxSettings) mySettings.get(i)).getTextViewContentId());
//                    test.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            if(test.isChecked() == true){
//                                test1.setText("On");
//                            }
//                            else{
//                                test1.setText("Off");
//                            }
//                        }
//                    });

                    break;
                case SWITCH:

                    break;
                case IMAGE:

                    break;
                case SEEKBAR:

                    break;

                default:
                    break;
            }
            i++;
        }

//        if (mySettings.get(7) instanceof CheckboxSettings){
//            test = findViewById(((CheckboxSettings) mySettings.get(7)).getCheckboxId());
//            test.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    TextView test1 = findViewById(((CheckboxSettings) mySettings.get(7)).getTextViewContentId());
//                    if(test.isChecked() == true){
//                        test1.setText("On");
//                    }
//                    else{
//                        test1.setText("Off");
//                    }
//                }
//            });
//        }
    }

    @Override
    public void onBackPressed() {
        Intent results = new Intent();
        results.putExtra(INTENT_EXTRA_RESULT, mySettings);
        setResult(RESULT_OK, results);
        super.onBackPressed();
    }
}