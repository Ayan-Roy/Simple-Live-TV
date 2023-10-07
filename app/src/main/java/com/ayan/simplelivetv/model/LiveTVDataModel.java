package com.ayan.simplelivetv.model;

public class LiveTVDataModel {
    int chanelImage;
    String chanelName;
    String chanelLink;

    public LiveTVDataModel(int chanelImage, String chanelName, String chanelLink) {
        this.chanelImage = chanelImage;
        this.chanelName = chanelName;
        this.chanelLink = chanelLink;
    }

    public int getChanelImage() {
        return chanelImage;
    }

    public void setChanelImage(int chanelImage) {
        this.chanelImage = chanelImage;
    }

    public String getChanelName() {
        return chanelName;
    }

    public void setChanelName(String chanelName) {
        this.chanelName = chanelName;
    }

    public String getChanelLink() {
        return chanelLink;
    }

    public void setChanelLink(String chanelLink) {
        this.chanelLink = chanelLink;
    }
}
