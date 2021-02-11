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
    private String content;
    private boolean useContent;
    @Nullable @IdRes
    private Integer textViewContentId;            // TextView Content ID (R.id)

    public HeaderAndContentSettings(String title) {
        super(title,
                R.id.content_LBL_header,
                true,
                Type.CONTENT);
        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.content_LBL_content);
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
        return R.layout.header_and_content_settings;
    }

    @Override
    public void initializeViews(View root)
    {
        int rootId = View.generateViewId();
        root.setId(rootId);
        //individualSettingsRootId = rootId;

        TextView tvTitle = root.findViewById(this.getTextViewTitleId());
        tvTitle.setText(getTitle());

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
    }
}
