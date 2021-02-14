package com.classy.settingspagelibrary.Image;

import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.CheckBox.CheckboxSettings;
import com.classy.settingspagelibrary.Enum.Type;

public class Image {

    private ImageSettings imageSettings;

    public Image(String title){
        imageSettings = new ImageSettings(title);
    }

    public Image setTitle(String title) {
        this.imageSettings.setTitle(title);
        return this;
    }

    public Image setContent(String content) {
        this.imageSettings.setContent(content);
        return this;
    }

    public Image setTextViewTitleId(int textViewTitleId) {
        this.imageSettings.setTextViewTitleId(textViewTitleId);
        return this;
    }

    public Image setTextViewContentId(int textViewContentId) {
        this.imageSettings.setTextViewContentId(textViewContentId);
        return this;
    }

    public Image setSeparator(boolean separator) {
        this.imageSettings.setSeparator(separator);
        return this;
    }

    public Image setIndividualSettingsRootId(int individualSettingsRootId) {
        this.imageSettings.setIndividualSettingsRootId(individualSettingsRootId);
        return this;
    }

    public Image setType(Type type) {
        this.imageSettings.setType(type);
        return this;
    }

    public Image setImageViewIconId(@Nullable @IdRes Integer imageViewIconId) {
        this.imageSettings.setImageViewIconId(imageViewIconId);
        return this;
    }

    public Image setIconDrawableId(@Nullable @DrawableRes Integer iconDrawableId) {
        this.imageSettings.setIconDrawableId(iconDrawableId);
        return this;
    }

    public Image setIconDrawable(@Nullable Drawable iconDrawable) {
        this.setIconDrawable(iconDrawable);
        return this;
    }

    public ImageSettings build(){
        return this.imageSettings;
    }
}
