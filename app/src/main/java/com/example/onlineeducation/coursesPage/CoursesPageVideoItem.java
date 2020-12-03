package com.example.onlineeducation.coursesPage;

public class CoursesPageVideoItem {


        private String name;

        private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int ImageId;

        public CoursesPageVideoItem(String name, int imageId, String description) {
            this.name = name;
            ImageId = imageId;
            this.description = description;
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
