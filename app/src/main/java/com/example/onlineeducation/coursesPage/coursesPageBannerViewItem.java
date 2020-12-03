package com.example.onlineeducation.coursesPage;

public class coursesPageBannerViewItem {

    private int imageId;

    private String name;

    public coursesPageBannerViewItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
