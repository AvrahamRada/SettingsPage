package com.classy.settingspagelibrary.CheckBox;

import com.classy.settingspagelibrary.Enum.Type;

public class Checkbox {

    private CheckboxSettings checkboxSettings;

    public Checkbox(String title){
        checkboxSettings = new CheckboxSettings(title);
    }

    public Checkbox setTitle(String title) {
        this.checkboxSettings.setTitle(title);
        return this;
    }

    public Checkbox setContent(String content) {
        this.checkboxSettings.setContent(content);
        return this;
    }

    public Checkbox setSeparator(boolean separator) {
        this.checkboxSettings.setSeparator(separator);
        return this;
    }

    public Checkbox setChecked(boolean isChecked) {
        this.checkboxSettings.setIsChecked(isChecked);
        return this;
    }

    public CheckboxSettings build(){
        return this.checkboxSettings;
    }
}
