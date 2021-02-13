package com.classy.settingspagelibrary.Header;

import com.classy.settingspagelibrary.Enum.Type;

public class Header {

    private HeaderSettings headerSettings;

    public Header(String title){
        headerSettings = new HeaderSettings(title);
    }

    public Header setTitle(String title) {
        this.headerSettings.setTitle(title);
        return this;
    }

    public Header setTextViewTitleId(int textViewTitleId) {
        this.headerSettings.setTextViewTitleId(textViewTitleId);
        return this;
    }

    private Header setSeparator(boolean separator) {
        this.headerSettings.setSeparator(separator);
        return this;
    }

    public Header setIndividualSettingsRootId(int individualSettingsRootId) {
        this.headerSettings.setIndividualSettingsRootId(individualSettingsRootId);
        return this;
    }

    public Header setType(Type type) {
        this.headerSettings.setType(type);
        return this;
    }

    public HeaderSettings build(){
        return this.headerSettings;
    }
}
