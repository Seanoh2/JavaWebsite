/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author Sean
 */
public class Rating {
    private int rateID;
    private int userID;
    private int postID;
    private int rating;
    
    public Rating() {
        
    }

    public Rating(int rateID, int userID, int postID, int rating) {
        this.rateID = rateID;
        this.userID = userID;
        this.postID = postID;
        this.rating = rating;
    }

    public int getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
}
