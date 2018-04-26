package com.example.d.pleh;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashSet;

public class Wish {
    private String title, reward, description, author;
    private WishCategory wishCategory;
    private HashSet<Integer> confirmed, applying;
    private long id, authorId;
    private ImageView wishImage;
    private WishStatus wishStatus;


    public Wish(String title, String reward, String description, String author,
                WishCategory wishCategory, long authorId, long id) {
        this.title = title;
        this.reward = reward;
        this.description = description;
        this.author = author;
        this.wishCategory = wishCategory;
        this.authorId = authorId;
        this.id = id;
        confirmed = new HashSet<Integer>();
        applying = new HashSet<Integer>();

    }

    public WishCategory getWishCategory() {
        return wishCategory;
    }

    public void setWishCategory(WishCategory wishCategory) {
        this.wishCategory = wishCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public WishStatus getWishStatus() {
        return wishStatus;
    }

    public void setWishStatus(WishStatus wishStatus) {
        this.wishStatus = wishStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HashSet<Integer> getConfirmed() {
        return confirmed;
    }

    public void addConfirmed(int IdConfirmed) {
        applying.remove(IdConfirmed);
        confirmed.add(IdConfirmed);
    }

    public HashSet<Integer> getApplying() {
        return applying;
    }

    public void addApplying(int IdApplying) {
        this.applying.add(IdApplying);
    }

    public long getID() { return id;}

    public ImageView getWishImage() {
        return wishImage;
    }

    public void setWishImage(ImageView wishImage) {
        this.wishImage = wishImage;
    }
}
