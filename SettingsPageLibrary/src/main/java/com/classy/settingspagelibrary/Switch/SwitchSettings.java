package com.classy.settingspagelibrary.Switch;

import android.view.View;
import android.widget.Switch;
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
    private Integer switchSettings_LBL_contentId;   // TextView Content ID (R.id)

    private boolean isChecked;
    @Nullable @IdRes
    private Integer switchSettings_SW_switchId;     // Switch ID (R.id)

    public SwitchSettings(String title) {
        super(title,
                R.id.switchSettings_LBL_header,
                true,
                Type.SWITCH);
        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.switchSettings_LBL_content);
        setIsChecked(false);
        setSwitchId(R.id.switchSettings_SW_switch);
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Nullable
    public Integer getSwitchId() {
        return switchSettings_SW_switchId;
    }

    public void setSwitchId(@Nullable Integer switchSettings_SW_switchId) {
        this.switchSettings_SW_switchId = switchSettings_SW_switchId;
    }

    @Nullable
    public Integer getTextViewContentId() {
        return switchSettings_LBL_contentId;
    }

    public void setTextViewContentId(@Nullable Integer switchSettings_LBL_contentId) {
        this.switchSettings_LBL_contentId = switchSettings_LBL_contentId;
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

        // Header
        TextView titleId = root.findViewById(this.getTextViewTitleId());
        titleId.setText(getTitle());

        // Content
        if (this.switchSettings_LBL_contentId != null) {
            TextView contentId = root.findViewById(switchSettings_LBL_contentId);
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

        // Switch
        if (this.switchSettings_SW_switchId != null) {
            Switch switchId = root.findViewById(this.switchSettings_SW_switchId);
            if (getIsChecked()) {
                switchId.setChecked(true);
            }
            else {
                switchId.setChecked(false);
            }
        }
    }
}
