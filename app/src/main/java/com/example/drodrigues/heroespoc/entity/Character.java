package com.example.drodrigues.heroespoc.entity;

import java.io.Serializable;

public class Character implements Serializable {

    private String name;
    private String secretName;
    private String description;
    private String picture;
    private CharacterType type;

    public Character() {
    }

    public Character(final String name,
                     final String secretName,
                     final String description,
                     final String picture,
                     final CharacterType type) {
        this.name = name;
        this.secretName = secretName;
        this.description = description;
        this.picture = picture;
        this.type = type;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

}
