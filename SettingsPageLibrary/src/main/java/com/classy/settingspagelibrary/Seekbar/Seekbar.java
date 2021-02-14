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

    public Seekbar setTextViewTitleId(int textViewTitleId) {
        this.seekbarSettings.setTextViewTitleId(textViewTitleId);
        return this;
    }

    public Seekbar setTextViewContentId(int textViewContentId) {
        this.seekbarSettings.setTextViewContentId(textViewContentId);
        return this;
    }

    public Seekbar setSeparator(boolean separator) {
        this.seekbarSettings.setSeparator(separator);
        return this;
    }

    public Seekbar setIndividualSettingsRootId(int individualSettingsRootId) {
        this.seekbarSettings.setIndividualSettingsRootId(individualSettingsRootId);
        return this;
    }

    public Seekbar setType(Type type) {
        this.seekbarSettings.setType(type);
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
