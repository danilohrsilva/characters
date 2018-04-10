package com.example.drodrigues.heroespoc.entity;

import java.io.Serializable;

public class Character implements Serializable {

    private String name;
    private String secretName;
    private String description;
    private String pictureUrl;
    private byte[] picture;
    private CharacterType type;

    public Character() {
    }

    public Character(final String name,
                     final String secretName,
                     final String description,
                     final String pictureUrl,
                     final byte[] picture,
                     final CharacterType type) {
        this.name = name;
        this.secretName = secretName;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.picture = picture;
        this.type = type;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(final String secretName) {
        this.secretName = secretName;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(final String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(final byte[] picture) {
        this.picture = picture;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(final CharacterType type) {
        this.type = type;
    }

}
