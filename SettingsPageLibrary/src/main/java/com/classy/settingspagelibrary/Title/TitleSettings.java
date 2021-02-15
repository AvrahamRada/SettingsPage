package com.classy.settingspagelibrary.Title;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class TitleSettings extends BasicSettings implements Serializable {

    public TitleSettings(String title) {
        super(title,
                R.id.headerSettings_LBL_title,
                false,
                Type.TITLE);
    }

    @Override
    public int getLayout() {
        return R.layout.title_settings;
    }
}
