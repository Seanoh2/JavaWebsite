/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.time.LocalDate;

/**
 *
 * @author Seanoh
 */
public class Comment {
    private int commentID;
    private int postID;
    private int senderID;
    private int ReceiverID;
    private LocalDate time;
    private int score;
    private String content;

    public Comment(int commentID, int postID, int senderID, int ReceiverID, LocalDate time, int score, String content) {
        this.commentID = commentID;
        this.postID = postID;
        this.senderID = senderID;
        this.ReceiverID = ReceiverID;
        this.time = time;
        this.score = score;
        this.content = content;
    }

    public Comment() {
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int ReceiverID) {
        this.ReceiverID = ReceiverID;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.commentID;
        hash = 53 * hash + this.postID;
        hash = 53 * hash + this.senderID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.commentID != other.commentID) {
            return false;
        }
        if (this.postID != other.postID) {
            return false;
        }
        if (this.senderID != other.senderID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", postID=" + postID + ", senderID=" + senderID + ", ReceiverID=" + ReceiverID + ", time=" + time + ", score=" + score + ", content=" + content + '}';
    }
    
    
    
}
