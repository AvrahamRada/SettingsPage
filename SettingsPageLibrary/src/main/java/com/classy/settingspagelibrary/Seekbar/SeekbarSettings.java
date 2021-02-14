package com.classy.settingspagelibrary.Seekbar;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class SeekbarSettings extends BasicSettings implements Serializable {
    private String content;
    private boolean useContent;
    @Nullable @IdRes
    private Integer textViewContentId;     // TextView Content ID (R.id)
    @Nullable @IdRes
    private Integer seekbarId;            // SeekBar ID (R.id)
    private int min;
    private int max;

    public SeekbarSettings(String title) {
        super(title,
                R.id.seekbarSettings_LBL_header,
                false,
                Type.SEEKBAR);
        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.seekbarSettings_LBL_content);
        setSeekbarId(R.id.seekbarSettings_SBR_seekbar);
        setMax(10);
        setMin(-10);
    }

    @Nullable
    public Integer getSeekbarId() {
        return seekbarId;
    }

    public void setSeekbarId(@Nullable Integer seekbarId) {
        this.seekbarId = seekbarId;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        if (min <= this.max)
            this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if (max >= this.min)
            this.max = max;
    }

    @Nullable
    public Integer getCheckboxId() {
        return seekbarId;
    }

    public void setCheckboxId(@Nullable Integer checkboxId) {
        this.seekbarId = checkboxId;
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
        return R.layout.seekbar_settings;
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

        // SeekBar
        if (this.seekbarId != null) {
            View tvSummary = root.findViewById(this.seekbarId);
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
