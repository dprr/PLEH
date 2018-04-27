package com.example.d.pleh;

public class Wish {
    private String wishTitle, wishDescription, rewardTitle, rewardDescription/*, author*/;
    private WishCategoryType wishCategoryType;
    private RewardCategoryType rewardCategoryType;
//    private HashSet<Integer> confirmed, applying;
    private long id, authorId;
    private WishStatusType wishStatusType;

    public Wish(String wishTitle, WishCategoryType wishCategoryType, String wishDescription, String rewardTitle, RewardCategoryType rewardCategoryType,
                String rewardDescription, /* String author, */ long authorId) {
        this.wishTitle = wishTitle;
        this.wishCategoryType = wishCategoryType;
        this.wishDescription = wishDescription;
//        this.author = author; // TODO check if needed
        this.rewardTitle = rewardTitle;
        this.rewardCategoryType = rewardCategoryType;
        this.rewardDescription = rewardDescription;
        this.authorId = authorId;
//        confirmed = new HashSet<>();
//        applying = new HashSet<>();
    }

    public WishCategoryType getWishCategoryType() {
        return wishCategoryType;
    }

    public void setWishCategoryType(WishCategoryType wishCategoryType) {
        this.wishCategoryType = wishCategoryType;
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

    public WishStatusType getWishStatusType() {
        return wishStatusType;
    }

    public void setWishStatusType(WishStatusType wishStatusType) {
        this.wishStatusType = wishStatusType;
    }

    public RewardCategoryType getRewardCategoryType() {
        return rewardCategoryType;
    }

    public void setRewardCatagory(RewardCategoryType rewardCategoryType) {
        this.rewardCategoryType = rewardCategoryType;
    }

//    public HashSet<Integer> getConfirmed() {
//        return confirmed;
//    }
//
//    public void addConfirmed(int IdConfirmed) {
//        applying.remove(IdConfirmed);
//        confirmed.add(IdConfirmed);
//    }
//
//    public HashSet<Integer> getApplying() {
//        return applying;
//    }
//
//    public void addApplying(int IdApplying) {
//        this.applying.add(IdApplying);
//    }

    public long getID() { return id;}

    public static int getRewardImage(RewardCategoryType reward) {
        if (reward == null)
            return R.drawable.cart;

        switch (reward) {
            case MONEY:
                return R.drawable.piggy_bank;

            case SWEETS:
                return R.drawable.medicine;

            case GENERAL:
                return R.drawable.network;

            case DRINK:
                return R.drawable.drink;

            case FOOD:
                return R.drawable.cookies;

            default:
                return R.drawable.cart;
        }
    }

    public static int getWishImage(WishCategoryType reward) {
        if (reward == null)
            return R.drawable.cart;

        switch (reward) {
            case ITEMS:
                return R.drawable.food_and_drink;

            case WORK:
                return R.drawable.hammer;

            case MEDICINE:
                return R.drawable.medicine;

            case VOLUNTEERS:
                return R.drawable.network;

            case TRANSLATING:
                return R.drawable.translate;

            default:
                return R.drawable.cart;
        }
    }

    public String getWishTitle() {
        return wishTitle;
    }

    public void setWishTitle(String wishTitle) {
        this.wishTitle = wishTitle;
    }

    public String getWishDescription() {
        return wishDescription;
    }

    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    public String getRewardTitle() {
        return rewardTitle;
    }

    public void setRewardTitle(String rewardTitle) {
        this.rewardTitle = rewardTitle;
    }

    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }
}
