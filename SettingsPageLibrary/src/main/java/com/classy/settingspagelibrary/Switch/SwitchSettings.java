package com.classy.settingspagelibrary.Switch;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class SwitchSettings extends BasicSettings implements Serializable {
    private String content;
    private boolean useContent;
    @Nullable @IdRes
    private Integer textViewContentId;     // TextView Content ID (R.id)

    private boolean isChecked;
    @Nullable @IdRes
    private Integer switchId;            // Switch ID (R.id)

    public SwitchSettings(String title) {
        super(title,
                R.id.switchSettings_LBL_header,
                true,
                Type.SWITCH);
        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.switchSettings_LBL_content);
        setCheckboxSettings_LBL_isChecked(false);
        setSwitchId(R.id.switchSettings_SW_switch);
    }

    public boolean isCheckboxSettings_LBL_isChecked() {
        return isChecked;
    }

    public void setCheckboxSettings_LBL_isChecked(boolean checkboxSettings_LBL_isChecked) {
        this.isChecked = checkboxSettings_LBL_isChecked;
    }

    @Nullable
    public Integer getSwitchId() {
        return switchId;
    }

    public void setSwitchId(@Nullable Integer switchId) {
        this.switchId = switchId;
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
        return R.layout.switch_settings;
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
        if (this.switchId != null) {
            View tvSummary = root.findViewById(this.switchId);
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
