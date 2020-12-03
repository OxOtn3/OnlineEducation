package com.example.onlineeducation.classification;

public class ClassificationItem {
    private String name;

    private int ImageId;

    public ClassificationItem(String name, int imageId) {
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
