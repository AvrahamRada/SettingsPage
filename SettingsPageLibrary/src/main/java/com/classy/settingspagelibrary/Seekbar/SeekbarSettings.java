package com.classy.settingspagelibrary.Seekbar;

import android.view.View;
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
    @Nullable
    @IdRes
    private Integer seekbarSettings_LBL_contentId;     // TextView content ID (R.id)
    @Nullable
    @IdRes
    private Integer seekbarSettings_SKB_seekbarId;      // SeekBar ID (R.id)
    private int min;
    private int max;

    public SeekbarSettings(String title) {
        super(title,
                R.id.seekbarSettings_LBL_header,
                true,
                Type.SEEKBAR);
        setContent(""); // Empty
        setUseContent(false);
        setTextViewContentId(R.id.seekbarSettings_LBL_content);
        setSeekbarId(R.id.seekbarSettings_SBR_seekbar);
        setMax(10);
        setMin(-10);
    }

    @Nullable
    public Integer getSeekbarId() {
        return seekbarSettings_SKB_seekbarId;
    }

    public void setSeekbarId(@Nullable Integer seekbarSettings_SKB_seekbarId) {
        this.seekbarSettings_SKB_seekbarId = seekbarSettings_SKB_seekbarId;
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
    public Integer getTextViewContentId() {
        return seekbarSettings_LBL_contentId;
    }

    private void setTextViewContentId(@Nullable Integer seekbarSettings_LBL_contentId) {
        this.seekbarSettings_LBL_contentId = seekbarSettings_LBL_contentId;
    }

    public boolean isUseContent() {
        return useContent;
    }

    private void setUseContent(boolean useContent) {
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
        return R.layout.seekbar_settings;
    }

    @Override
    public void initializeViews(View root) {
        int rootId = View.generateViewId();
        root.setId(rootId);

        // Title
        TextView titleId = root.findViewById(this.getTextViewTitleId());
        titleId.setText(getTitle());

        // Content
        if (this.seekbarSettings_LBL_contentId != null) {
            TextView contentId = root.findViewById(seekbarSettings_LBL_contentId);
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

        // SeekBar
        if (this.seekbarSettings_SKB_seekbarId != null) {
            View seekbarId = root.findViewById(this.seekbarSettings_SKB_seekbarId);
        }
    }
}
