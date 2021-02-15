package com.classy.settingspagelibrary.HeaderAndContent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class HeaderAndContentSettings extends BasicSettings implements Serializable {
    private String content;                                     // Actual content
    @Nullable
    @IdRes
    private Integer headerAndContentSettings_LBL_contentId;     // TextView content ID (R.id)
    private boolean useContent;                                 // should we use the content ?

    public HeaderAndContentSettings(String title) {
        super(title,
                R.id.headerAndContent_LBL_header,
                true,
                Type.CONTENT);
        setContent(""); // Empty
        setUseContent(false);
        setTextViewContentId(R.id.headerAndContent_LBL_content);
    }

    // Content ID
    @Nullable
    public Integer getTextViewContentId() {
        return headerAndContentSettings_LBL_contentId;
    }

    private void setTextViewContentId(@Nullable Integer headerAndContentSettings_LBL_contentId) {
        this.headerAndContentSettings_LBL_contentId = headerAndContentSettings_LBL_contentId;
    }

    // Use Content
    public boolean isUseContent() {
        return useContent;
    }

    private void setUseContent(boolean useContent) {
        this.useContent = useContent;
    }

    // Text Content
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
        return R.layout.header_and_content_settings;
    }

    @Override
    public void initializeViews(View root) {
        int rootId = View.generateViewId();
        root.setId(rootId);

        // Header
        TextView titleId = root.findViewById(this.getTextViewTitleId());
        titleId.setText(getTitle());

        // Content
        if (this.headerAndContentSettings_LBL_contentId != null) {
            TextView contentId = root.findViewById(headerAndContentSettings_LBL_contentId);
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
    }
}
