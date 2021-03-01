package com.classy.settingspage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.CheckBox.Checkbox;
import com.classy.settingspagelibrary.Title.Title;
import com.classy.settingspagelibrary.HeaderAndContent.HeaderAndContent;
import com.classy.settingspagelibrary.Image.Image;
import com.classy.settingspagelibrary.MainSettings;
import com.classy.settingspagelibrary.Seekbar.Seekbar;
import com.classy.settingspagelibrary.Switch.Switch;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MaterialButton main_BTN_click;
    public static final String MY_SETTINGS = "MY_SETTINGS";
    private ArrayList<BasicSettings> mySettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        main_BTN_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra(MY_SETTINGS, mySettings);
                startActivityForResult(intent, SETTINGS);
            }
        });

        mySettings = MainSettings.createSettingsArray(
                new Title("General")                // TITLE
                        .build(),
                new HeaderAndContent("Title")
                        .setSeparator(false)
                        .build(),
                new HeaderAndContent("Title")
                        .setContent("content")
                        .build(),
                new Title("Screen Display")
                        .build(),
                new Seekbar("Brightness")
                        .setContent("content")
                        .build(),
                new Title("Checkbox")
                        .build(),
                new Checkbox("Title")
                        .setContent("content")
                        .setChecked(true)
                        .setSeparator(false)
                        .build(),
                new Checkbox("Title")
                        .setContent("content")
                        .setChecked(true)
                        .build(),
                new Title("Configurations")
                        .build(),
                new Switch("Sound")
                        .setContent("Off")
                        .setChecked(true)
                        .setSeparator(true)
                        .build(),
                new Title("Network")
                        .build(),
                new Switch("Wi-Fi")
                        .setContent("Off")
                        .setChecked(true)
                        .build(),
                new Switch("Bluetooth")
                        .setContent("On")
                        .setChecked(true)
                        .build(),
                new Switch("NFC")
                        .setContent("Off")
                        .setSeparator(true)
                        .build(),
                new Title("Social Media")
                        .build(),
                new Image("Facebook")
                        .setContent("Click to visit")
                        .setIconDrawableId(R.drawable.facebook)
                        .build(),
                new Image("Instagram")
                        .setIconDrawableId(R.drawable.instagram)
                        .setContent("Click to visit")
                        .build(),
                new Image("Tik-Tok")
                        .setIconDrawableId(R.drawable.tik_tok)
                        .setContent("Not available yet")
                        .build());
    }

    private void init() {
        main_BTN_click = findViewById(R.id.main_BTN_click);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == SETTINGS &&
                resultCode == RESULT_OK) {
            mySettings = (ArrayList<BasicSettings>) data.getSerializableExtra(SettingsActivity.INTENT_EXTRA_RESULT);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private static final int SETTINGS = 1001;

}