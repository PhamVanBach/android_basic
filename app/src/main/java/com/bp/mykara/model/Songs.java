package com.bp.mykara.model;

import java.io.Serializable;

public class Songs  implements Serializable {
    private int ID_img;
    private String song_id;
    private String song_name;
    private String singer;
    private boolean isClicked;
    public Songs() {

    }

    public Songs(int ID_img, String song_id, String song_name, String singer, boolean isClicked) {
        this.ID_img = ID_img;
        this.song_id = song_id;
        this.song_name = song_name;
        this.singer = singer;
        this.isClicked = isClicked;
    }

    public int getID_img() {
        return ID_img;
    }

    public void setID_img(int ID_img) {
        this.ID_img = ID_img;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean getIsClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}


