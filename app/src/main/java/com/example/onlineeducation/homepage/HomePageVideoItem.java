package com.example.onlineeducation.homepage;

public class HomePageVideoItem {

    private String name;

    private int ImageId;

    public HomePageVideoItem(String name, int imageId) {
        this.name = name;
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
