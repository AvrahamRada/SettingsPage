package com.classy.settingspagelibrary.Switch;
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

    public Switch setSeparator(boolean separator) {
        this.switchSettings.setSeparator(separator);
        return this;
    }

    public Switch setType(Type type) {
        this.switchSettings.setType(type);
        return this;
    }

    public Switch setChecked(boolean isChecked) {
        this.switchSettings.setIsChecked(isChecked);
        return this;
    }

    public SwitchSettings build(){
        return this.switchSettings;
    }
}
