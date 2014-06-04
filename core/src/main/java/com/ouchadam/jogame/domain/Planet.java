package com.ouchadam.jogame.domain;

public class Planet {

    public final int id;
    public final String name;
    public final String planetImage;
    public final String coord;
    public final String size;
    public final String temp;

    public Planet(int id, String name, String planetImage, String coord, String size, String temp) {
        this.id = id;
        this.name = name;
        this.planetImage = planetImage;
        this.coord = coord;
        this.size = size;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planetImage='" + planetImage + '\'' +
                ", coord='" + coord + '\'' +
                ", size='" + size + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
