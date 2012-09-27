package com.kair.cinema.vo;


public class MovieGridItem {

    private String name;
    private int imageResource;

    public MovieGridItem(final String name, final int imageResource) {
        super();
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(final int imageResource) {
        this.imageResource = imageResource;
    }

}
