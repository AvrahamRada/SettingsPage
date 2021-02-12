package com.classy.settingspage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.CheckBox.Checkbox;
import com.classy.settingspagelibrary.Header.Header;
import com.classy.settingspagelibrary.HeaderAndContent.HeaderAndContent;
import com.classy.settingspagelibrary.MainSettings;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ACTIVITY_SETTINGS = 1001;

    public static final String MY_LIST = "MY_LIST";
    public static final String DEFAULT_VALUE_EDIT_TEXT = "default value";

    private static final String LIST_DIALOG_ONE = "one";
    private static final String LIST_DIALOG_TWO = "two";
    private static final String LIST_DIALOG_THREE = "three";
    private static final String LIST_DIALOG_FOUR = "four";
    private static final String LIST_DIALOG_FIVE = "five";

    public static final String SETTINGS_KEY_BASIC = "SETTINGS_KEY_BASIC";
    public static final String SETTINGS_KEY_RINGTONE = "SETTINGS_KEY_RINGTONE";
    public static final String SETTINGS_KEY_CHECKBOX = "SETTINGS_KEY_CHECKBOX";
    public static final String SETTINGS_KEY_SWITCH = "SETTINGS_KEY_SWITCH";
    public static final String SETTINGS_KEY_SEEKBAR = "SETTINGS_KEY_SEEKBAR";
    public static final String SETTINGS_KEY_EDIT_TEXT = "SETTINGS_KEY_EDIT_TEXT";
    public static final String SETTINGS_KEY_LIST_SINGLE_CHOICE = "SETTINGS_KEY_LIST_SINGLE_CHOICE";
    public static final String SETTINGS_KEY_CUSTOM_DIALOG = "SETTINGS_KEY_CUSTOM_DIALOG";
    public static final String SETTINGS_KEY_CUSTOM_LIST_DIALOG = "SETTINGS_KEY_CUSTOM_LIST_DIALOG";
    public static final String SETTINGS_KEY_LIST_MULTI_CHOICE = "SETTINGS_KEY_LIST_MULTI_CHOICE";
    public static final String SETTINGS_KEY_CUSTOM = "SETTINGS_KEY_CUSTOM";

    private ArrayList<BasicSettings> mySettingsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySettingsList = MainSettings.createSettingsArray(
                new Header("HEADER")
                        .build(),
                new HeaderAndContent("HEADER 2")
                        .setContent("Header 2 content")
                        .setSeparator(false)
                        .build(),
                new Header("CHECKBOX")
                        .build(),
                new Checkbox("HEADER 3")
                        .setContent("Header 3 content")
                        .setSeparator(false)
                        .build(),
                new Header("HEADER 4")
                        .build(),
                new Header("HEADER 5")
                        .build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.settings:

                Intent intent = new Intent(this, SettingsActivity.class);
                intent.putExtra(MY_LIST, mySettingsList);
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY_SETTINGS);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}