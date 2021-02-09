package com.classy.settingspagelibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Header.HeaderSettings;

import java.util.ArrayList;
import java.util.Collections;

public class MainSettings {

    public static ArrayList<BasicSettings> createSettingsArray(BasicSettings... settingsArr)
    {
        ArrayList<BasicSettings> array = new ArrayList<>(settingsArr.length);
        Collections.addAll(array, settingsArr);
        return array;
    }

    public static void initializeSettings(Context context,
                                          ArrayList<BasicSettings> settingsList)
    {

    }

//    @Nullable
//    public static BasicSettings findSettingsObject(String key, ArrayList<BasicSettings> settingsList)
//    {
//        for(BasicSettings obj : settingsList)
//        {
//            if(key.equals(obj.getKey()))
//            {
//                return obj;
//            }
//        }
//        return null;
//    }

    public static void inflateSettingsLayout(Context context,
                                             ViewGroup settingsActivityContainer,
                                             ArrayList<BasicSettings> mySettings)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(inflater == null)
            throw new InflateException("inflateSettingsLayout: cannot retrieve LAYOUT_INFLATER_SERVICE");

        Resources resources = context.getResources();
        BasicSettings settObj;
        for (int i = 0; i < mySettings.size(); i++)
        {
            settObj = mySettings.get(i);

            // Getting R.layout of the specific settings
            View individualSettingsContainer = inflater.inflate(settObj.getLayout(), settingsActivityContainer, false);
            // Sending R.layout to initializeView(View root) method in BasicSettings
            settObj.initializeViews(individualSettingsContainer);
            settingsActivityContainer.addView(individualSettingsContainer);

            // Add underline below R.layout
            if(settObj.isSeparator())
            {
                int dividerHeight = (int) resources.getDimension(R.dimen.settings_divider_height);

                View divider = new View(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        dividerHeight);
//                divider.setBackgroundColor(Color.LTGRAY);
                divider.setBackgroundColor(Color.BLACK);
                divider.setLayoutParams(params);
                settingsActivityContainer.addView(divider);
            }

            if(settObj instanceof HeaderSettings)
            {
                int settingsPadding = (int) resources.getDimension(R.dimen.settings_container_padding);
                int bottomPadding = individualSettingsContainer.getPaddingBottom();
                int topPadding = individualSettingsContainer.getPaddingTop();

                // If i am the first or the last layout
                if(i == 0 || mySettings.get(i-1).isSeparator())
                    topPadding = settingsPadding;
                if(settObj.isSeparator())
                    bottomPadding = settingsPadding;

                individualSettingsContainer.setPadding(individualSettingsContainer.getPaddingLeft(),
                        topPadding,
                        individualSettingsContainer.getPaddingRight(),
                        bottomPadding);
            }
        }
    }
}
