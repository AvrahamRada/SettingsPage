package com.classy.settingspagelibrary.Header;

import android.view.View;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class HeaderSettings extends BasicSettings implements Serializable {

    public HeaderSettings(String title) {
        super(title,
                R.id.textView_headerSettingsObject_title,
                false,
                Type.HEADER);
    }

    @Override
    public int getLayout() {
        return R.layout.header_settings;
    }

    @Override
    public void initializeViews(View root)
    {
        //just a header - nothing else to do other than initialize the text
        super.initializeViews(root);
    }
}
