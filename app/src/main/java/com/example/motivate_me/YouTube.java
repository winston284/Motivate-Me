package com.example.motivate_me;

public class YouTube {
    String videoUrl;

    public YouTube(){

    }

    public YouTube(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() { return videoUrl; }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}

