package com.classy.settingspagelibrary.Image;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.classy.settingspagelibrary.Basic.BasicSettings;
import com.classy.settingspagelibrary.Enum.Type;
import com.classy.settingspagelibrary.R;

import java.io.Serializable;

public class ImageSettings extends BasicSettings implements Serializable {
    private String content;
    private boolean useContent;
    @Nullable @IdRes
    private Integer imageSettings_LBL_contentId;   // TextView Content ID (R.id)

    @Nullable @IdRes
    private Integer imageSettings_IMG_IconId; // id of the ImageView icon
    @Nullable @DrawableRes
    private Integer iconDrawableId;	// id of the Drawable icon
    @Nullable
    private Drawable iconDrawable; // the Drawable that is being used as the icon

    public ImageSettings(String title) {
        super(title,
                R.id.imageSettings_LBL_header,
                false,
                Type.IMAGE);
        setContent("");
        setUseContent(false);
        setTextViewContentId(R.id.imageSettings_LBL_content);
        setImageViewIconId(R.id.imageSettings_IMG_image);
        setIconDrawableId(-1);
        setIconDrawable(null);
    }

    @Nullable @IdRes
    public Integer getImageViewIconId() {
        return imageSettings_IMG_IconId;
    }

    public void setImageViewIconId(@Nullable @IdRes Integer imageSettings_IMG_IconId) {
        this.imageSettings_IMG_IconId = imageSettings_IMG_IconId;
    }

    @Nullable @DrawableRes
    public Integer getIconDrawableId() {
        return iconDrawableId;
    }

    public void setIconDrawableId(@Nullable @DrawableRes Integer iconDrawableId) {
        this.iconDrawableId = iconDrawableId;
    }

    @Nullable
    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(@Nullable Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    @Nullable
    public Integer getTextViewContentId() {
        return imageSettings_LBL_contentId;
    }

    public void setTextViewContentId(@Nullable Integer imageSettings_LBL_contentId) {
        this.imageSettings_LBL_contentId = imageSettings_LBL_contentId;
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
        return R.layout.image_settings;
    }

    @Override
    public void initializeViews(View root)
    {
        int rootId = View.generateViewId();
        root.setId(rootId);

        TextView imageSetting_LBL_header = root.findViewById(this.getTextViewTitleId());
        imageSetting_LBL_header.setText(getTitle());

        // Content
        if (this.imageSettings_LBL_contentId != null) {
            TextView contentId = root.findViewById(imageSettings_LBL_contentId);
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

        // Image
        if(imageSettings_IMG_IconId != null)
        {
            ImageView ivIcon = root.findViewById(imageSettings_IMG_IconId);
            if(iconDrawable != null)
                ivIcon.setImageDrawable(iconDrawable);
            else if(iconDrawableId == null)
                ivIcon.setImageDrawable(null);
            else
                ivIcon.setImageResource(iconDrawableId);
        }
    }
}
