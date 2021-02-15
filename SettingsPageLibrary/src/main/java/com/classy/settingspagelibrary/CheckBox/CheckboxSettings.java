package com.classy.settingspagelibrary.CheckBox;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class CheckboxSettings extends BasicSettings implements Serializable {
    private String content;
    private boolean useContent;
    @Nullable
    @IdRes
    private Integer checkboxSettings_LBL_contentId;     // TextView Content ID (R.id)

    private boolean isChecked;
    @Nullable
    @IdRes
    private Integer checkboxSettings_CBX_checkboxId;            // CheckBox ID (R.id)

    public CheckboxSettings(String title) {
        super(title,
                R.id.checkboxSettings_LBL_header,
                true,
                Type.CHECKBOX);

        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.checkboxSettings_LBL_content);
        setIsChecked(false);
        setCheckboxId(R.id.checkboxSettings_CBX_checkbox);
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Nullable
    public Integer getCheckboxId() {
        return checkboxSettings_CBX_checkboxId;
    }

    public void setCheckboxId(@Nullable Integer checkboxSettings_CBX_checkboxId) {
        this.checkboxSettings_CBX_checkboxId = checkboxSettings_CBX_checkboxId;
    }

    @Nullable
    public Integer getTextViewContentId() {
        return checkboxSettings_LBL_contentId;
    }

    public void setTextViewContentId(@Nullable Integer checkboxSettings_LBL_contentId) {
        this.checkboxSettings_LBL_contentId = checkboxSettings_LBL_contentId;
    }

    public boolean isUseContent() {
        return useContent;
    }

    public void setUseContent(boolean useContent) {
        this.useContent = useContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        if (!(content.isEmpty() || content == "" || content == null))
            this.useContent = true;
        else
            this.useContent = false;
    }

    @Override
    public int getLayout() {
        return R.layout.checkbox_settings;
    }

    @Override
    public void initializeViews(View root) {
        int rootId = View.generateViewId();
        root.setId(rootId);

        // Header
        TextView titleId = root.findViewById(this.getTextViewTitleId());
        titleId.setText(getTitle());

        // Content
        if (this.checkboxSettings_LBL_contentId != null) {
            TextView contentId = root.findViewById(checkboxSettings_LBL_contentId);
            String content;

            if (this.useContent)
                content = this.content;
            else
                content = "";

            if (content != null && content.isEmpty() == false)
                contentId.setText(content);
            else
                contentId.setVisibility(View.GONE);
        }

        // CheckBox
        if (this.checkboxSettings_CBX_checkboxId != null) {
            CheckBox checkboxId = root.findViewById(this.checkboxSettings_CBX_checkboxId);

            if (getIsChecked())
                checkboxId.setChecked(true);
            else
                checkboxId.setChecked(false);
        }
    }
}
