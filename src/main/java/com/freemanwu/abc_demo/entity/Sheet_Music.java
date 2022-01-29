package com.freemanwu.abc_demo.entity;

public class Sheet_Music {
    private String music_name;
    private String beat;
    private String tone;
    private String username;
    private String location;

    @Override
    public String toString() {
        return "Sheet_Music{" +
                "music_name='" + music_name + '\'' +
                ", beat='" + beat + '\'' +
                ", tone='" + tone + '\'' +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Sheet_Music(String music_name, String beat, String tone, String username, String location) {
        this.music_name = music_name;
        this.beat = beat;
        this.tone = tone;
        this.username = username;
        this.location = location;
    }

    public Sheet_Music() {
    }
}
