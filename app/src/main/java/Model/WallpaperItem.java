package Model;

import android.widget.ImageView;

public class WallpaperItem {
    public String categoryId,imageLink;

    public WallpaperItem()
    {}

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public WallpaperItem(String categoryId, String imageLink) {
        this.categoryId = categoryId;
        this.imageLink = imageLink;

    }
}
