package pl.akademiakodu.model;

import java.time.LocalDate;

public class Gif {
    private String name;
    private LocalDate dateUpload;
    private String username;
    private boolean favourite;

    public Gif(String name, LocalDate dateUpload, String username, boolean favourite) {
        this.name = name;
        this.dateUpload = dateUpload;
        this.username = username;
        this.favourite = favourite;
    }

    public Gif() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(LocalDate dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
