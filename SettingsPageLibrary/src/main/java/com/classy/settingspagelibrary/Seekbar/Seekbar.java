package com.classy.settingspagelibrary.Seekbar;

import com.classy.settingspagelibrary.CheckBox.CheckboxSettings;
import com.classy.settingspagelibrary.Enum.Type;

public class Seekbar {

    private SeekbarSettings seekbarSettings;

    public Seekbar(String title){
        seekbarSettings = new SeekbarSettings(title);
    }

    public Seekbar setTitle(String title) {
        this.seekbarSettings.setTitle(title);
        return this;
    }

    public Seekbar setContent(String content) {
        this.seekbarSettings.setContent(content);
        return this;
    }

    public Seekbar setSeparator(boolean separator) {
        this.seekbarSettings.setSeparator(separator);
        return this;
    }

    public Seekbar setMin(int min) {
        this.seekbarSettings.setMin(min);
        return this;
    }

    public Seekbar setMax(int max) {
        this.seekbarSettings.setMax(max);
        return this;
    }

    public SeekbarSettings build(){
        return this.seekbarSettings;
    }
}
