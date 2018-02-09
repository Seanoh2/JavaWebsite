/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Seanoh
 */
public class Comment {
    private int commentID;
    private Post post;
    private User sender;
    private User receiver;
    private LocalDate time;
    private int score;
    private String content;

    public Comment(int commentID, Post post, User sender, User receiver, LocalDate time, int score, String content) {
        this.commentID = commentID;
        this.post = post;
        this.sender = sender;
        this.receiver = receiver;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.commentID;
        hash = 53 * hash + Objects.hashCode(this.sender);
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
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", post=" + post + ", sender=" + sender + ", receiver=" + receiver + ", time=" + time + ", score=" + score + ", content=" + content + '}';
    }

    
    
    
    
    
    
}
