package com.classy.settingspagelibrary.Title;

public class Title {

    private TitleSettings titleSettings;

    public Title(String title){
        titleSettings = new TitleSettings(title);
    }

    public Title setTitle(String title) {
        this.titleSettings.setTitle(title);
        return this;
    }

//    private Title setSeparator(boolean separator) {
//        this.titleSettings.setSeparator(separator);
//        return this;
//    }
//
//    public Title setTextViewTitleId(int textViewTitleId) {
//        this.titleSettings.setTextViewTitleId(textViewTitleId);
//        return this;
//    }
//
//    public Title setIndividualSettingsRootId(int individualSettingsRootId) {
//        this.titleSettings.setIndividualSettingsRootId(individualSettingsRootId);
//        return this;
//    }
//
//    public Title setType(Type type) {
//        this.titleSettings.setType(type);
//        return this;
//    }

    public TitleSettings build(){
        return this.titleSettings;
    }
}
