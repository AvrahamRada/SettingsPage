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
    private Integer textViewContentId;     // TextView Content ID (R.id)

    @Nullable @IdRes
    private Integer imageViewIconId; // id of the ImageView icon
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
        return imageViewIconId;
    }

    public void setImageViewIconId(@Nullable @IdRes Integer imageViewIconId) {
        this.imageViewIconId = imageViewIconId;
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
        return R.layout.image_settings;
    }

    @Override
    public void initializeViews(View root)
    {
        int rootId = View.generateViewId();
        root.setId(rootId);

        TextView imageSetting_LBL_header = root.findViewById(this.getTextViewTitleId());
        imageSetting_LBL_header.setText(getTitle());

        // Content TextBox
        if (this.textViewContentId != null) {
            TextView imageSetting_LBL_content = root.findViewById(textViewContentId);
            String content;

            if (this.useContent) {
                content = this.content;
            } else {
                content = null;
            }

            if (content != null &&
                    content.isEmpty() == false) {
                imageSetting_LBL_content.setText(content);
            } else {
                imageSetting_LBL_content.setVisibility(View.GONE);
            }

        }
        // Image
        if(imageViewIconId != null)
        {
            ImageView ivIcon = root.findViewById(imageViewIconId);

            if(iconDrawable != null)
                ivIcon.setImageDrawable(iconDrawable);
            else if(iconDrawableId == null)
                ivIcon.setImageDrawable(null);
            else
                ivIcon.setImageResource(iconDrawableId);
        }
    }
}
