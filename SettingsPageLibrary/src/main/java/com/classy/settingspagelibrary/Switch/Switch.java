package com.classy.settingspagelibrary.Switch;

import com.classy.settingspagelibrary.CheckBox.CheckboxSettings;
import com.classy.settingspagelibrary.Enum.Type;

public class Switch {

    private SwitchSettings switchSettings;

    public Switch(String title){
        switchSettings = new SwitchSettings(title);
    }

    public Switch setTitle(String title) {
        this.switchSettings.setTitle(title);
        return this;
    }

    public Switch setContent(String content) {
        this.switchSettings.setContent(content);
        return this;
    }

    public Switch setTextViewTitleId(int textViewTitleId) {
        this.switchSettings.setTextViewTitleId(textViewTitleId);
        return this;
    }

    public Switch setTextViewContentId(int textViewContentId) {
        this.switchSettings.setTextViewContentId(textViewContentId);
        return this;
    }

    public Switch setSeparator(boolean separator) {
        this.switchSettings.setSeparator(separator);
        return this;
    }

    public Switch setIndividualSettingsRootId(int individualSettingsRootId) {
        this.switchSettings.setIndividualSettingsRootId(individualSettingsRootId);
        return this;
    }

    public Switch setType(Type type) {
        this.switchSettings.setType(type);
        return this;
    }

    public SwitchSettings build(){
        return this.switchSettings;
    }
}
