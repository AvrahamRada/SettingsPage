package com.classy.settingspagelibrary.Basic;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.classy.settingspagelibrary.Enum.Type;
import java.io.Serializable;

public abstract class BasicSettings implements Serializable {
    private String title;                           // Title
    @IdRes
    private int basicSettings_LBL_titleId;             // TextView Title ID (R.id)
    private boolean separator;                      // Underline separator
    @IdRes
    private int individualSettingsRootId;    // rootId
    private Type type;                              // Type of setting

    public BasicSettings(String title, int basicSettings_LBL_titleId, boolean separator, Type type) {
        this.title = title;
        this.basicSettings_LBL_titleId = basicSettings_LBL_titleId;
        this.separator = separator;
        this.type = type;
    }

    // title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // basicSettings_LBL_titleId
    @IdRes
    public int getTextViewTitleId() {
        return basicSettings_LBL_titleId;
    }

    public void setTextViewTitleId(int basicSettings_LBL_titleId) {
        this.basicSettings_LBL_titleId = basicSettings_LBL_titleId;
    }

    // separator
    public boolean getSeparator() {
        return separator;
    }

    public void setSeparator(boolean separator) {
        this.separator = separator;
    }

    // rootId
    @IdRes
    public int getIndividualSettingsRootId() {
        return individualSettingsRootId;
    }

    public void setIndividualSettingsRootId(int individualSettingsRootId) {
        this.individualSettingsRootId = individualSettingsRootId;
    }

    // type
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void initializeViews(View root) {
        int rootId = View.generateViewId();
        root.setId(rootId);
        individualSettingsRootId = rootId;

        // Title
        TextView titleId = root.findViewById(basicSettings_LBL_titleId);
        titleId.setText(getTitle());
    }

    @LayoutRes
    public abstract int getLayout();
}
