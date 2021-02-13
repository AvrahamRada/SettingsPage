package com.classy.settingspagelibrary.CheckBox;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class CheckboxSettings extends BasicSettings implements Serializable {
    private String content;
    private boolean useContent;
    @Nullable @IdRes
    private Integer textViewContentId;     // TextView Content ID (R.id)

    private boolean isChecked;
    @Nullable @IdRes
    private Integer checkboxId;            // CheckBox ID (R.id)

    public CheckboxSettings(String title) {
        super(title,
                R.id.checkboxSettings_LBL_header,
                true,
                Type.CHECKBOX);
        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.checkboxSettings_LBL_content);
        setCheckboxSettings_LBL_isChecked(false);
        setCheckboxId(R.id.checkboxSettings_CBX_checkbox);
    }

    public boolean isCheckboxSettings_LBL_isChecked() {
        return isChecked;
    }

    public void setCheckboxSettings_LBL_isChecked(boolean checkboxSettings_LBL_isChecked) {
        this.isChecked = checkboxSettings_LBL_isChecked;
    }

    @Nullable
    public Integer getCheckboxId() {
        return checkboxId;
    }

    public void setCheckboxId(@Nullable Integer checkboxId) {
        this.checkboxId = checkboxId;
    }

    @Nullable
    public Integer getTextViewContentId() {
        return textViewContentId;
    }

    public void setTextViewContentId(@Nullable Integer textViewContentId) {
        this.textViewContentId = textViewContentId;
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
        this.useContent = true;
    }

    @Override
    public int getLayout() {
        return R.layout.checkbox_settings;
    }

    @Override
    public void initializeViews(View root)
    {
        int rootId = View.generateViewId();
        root.setId(rootId);
        //individualSettingsRootId = rootId;

        TextView tvTitle = root.findViewById(this.getTextViewTitleId());
        tvTitle.setText(getTitle());

        // Content TextBox
        if (this.textViewContentId != null) {
            TextView tvSummary = root.findViewById(textViewContentId);
            String summary;

            if (this.useContent) {
                summary = this.content;
            } else {
                summary = "Default Value";
            }

            if (summary != null &&
                    summary.isEmpty() == false) {
                tvSummary.setText(summary);
            } else {
                tvSummary.setVisibility(View.GONE);
            }
        }

        // CheckBox
        if (this.checkboxId != null) {
            CheckBox tvSummary = root.findViewById(this.checkboxId);
            String summary;

//            if (this.) {
//                summary = this.content;
//            } else {
//                summary = "Default Value";
//            }
//
//            if (summary != null &&
//                    summary.isEmpty() == false) {
//                tvSummary.setText(summary);
//            } else {
//                tvSummary.setVisibility(View.GONE);
//            }
        }
    }
}
