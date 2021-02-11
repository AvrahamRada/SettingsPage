package com.classy.settingspagelibrary.HeaderAndContent;

import com.classy.settingspagelibrary.Enum.Type;

public class HeaderAndContent {

    private HeaderAndContentSettings headerAndSubHeaderSettings;

    public HeaderAndContent(String title){
        headerAndSubHeaderSettings = new HeaderAndContentSettings(title);
    }

    public HeaderAndContent setTitle(String title) {
        this.headerAndSubHeaderSettings.setTitle(title);
        return this;
    }

    public HeaderAndContent setContent(String content) {
        this.headerAndSubHeaderSettings.setContent(content);
        return this;
    }

    public HeaderAndContent setTextViewTitleId(int textViewTitleId) {
        this.headerAndSubHeaderSettings.setTextViewTitleId(textViewTitleId);
        return this;
    }

    public HeaderAndContent setTextViewContentId(int textViewContentId) {
        this.headerAndSubHeaderSettings.setTextViewContentId(textViewContentId);
        return this;
    }

    public HeaderAndContent setSeparator(boolean separator) {
        this.headerAndSubHeaderSettings.setSeparator(separator);
        return this;
    }

    public HeaderAndContent setIndividualSettingsRootId(int individualSettingsRootId) {
        this.headerAndSubHeaderSettings.setIndividualSettingsRootId(individualSettingsRootId);
        return this;
    }

    public HeaderAndContent setType(Type type) {
        this.headerAndSubHeaderSettings.setType(type);
        return this;
    }

    public HeaderAndContentSettings build(){
        return this.headerAndSubHeaderSettings;
    }
}
