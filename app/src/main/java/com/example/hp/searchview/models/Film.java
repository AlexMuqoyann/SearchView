package com.example.hp.searchview.models;

/**
 * Created by HP on 19.01.2018.
 */

public class Film {
    private String name;
    private String foto;
    private String info;
    private String stars;
    private String creators;

    public Film() {
    }
    public Film(String name, String foto, String info, String stars, String creators){
        this.name = name;
        this.foto = foto;
        this.info = info;
        this.stars = stars;
        this.creators = creators;

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }



    public Film(String name, String foto) {

        this.name = name;
        this.foto = foto;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
