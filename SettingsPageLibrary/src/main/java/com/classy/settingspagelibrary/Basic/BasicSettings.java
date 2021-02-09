package com.classy.settingspagelibrary.Basic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

import com.classy.settingspagelibrary.Enum.Type;

import java.io.Serializable;

public abstract class BasicSettings implements Serializable {
    private String title;                   // Header
    @IdRes
    private int textViewTitleId;            // TextView Header ID (R.id)
    private boolean separator;              // Underline separator
    @IdRes
    private int individualSettingsRootId;   // rootId
    private Type type;                      // Type of settings

    public BasicSettings(String title, int textViewTitleId, boolean separator, Type type) {
        this.title = title;
        this.textViewTitleId = textViewTitleId;
        this.separator = separator;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @IdRes
    public int getTextViewTitleId() {
        return textViewTitleId;
    }

    public void setTextViewTitleId(int textViewTitleId) {
        this.textViewTitleId = textViewTitleId;
    }

    public boolean isSeparator() {
        return separator;
    }

    public void setSeparator(boolean separator) {
        this.separator = separator;
    }

    @IdRes
    public int getIndividualSettingsRootId() {
        return individualSettingsRootId;
    }

    public void setIndividualSettingsRootId(int individualSettingsRootId) {
        this.individualSettingsRootId = individualSettingsRootId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // --------------------------------

    public void initializeViews(View root)
    {
        int rootId = View.generateViewId();
        root.setId(rootId);
        individualSettingsRootId = rootId;

        // Set the title
        TextView tvTitle = root.findViewById(textViewTitleId);
        tvTitle.setText(getTitle());
    }

    @LayoutRes
    public abstract int getLayout();
}
