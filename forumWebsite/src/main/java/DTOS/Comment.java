/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.sql.Date;
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
    private Date time;
    private String content;

    public Comment(int commentID, Post post, User sender, User receiver, Date time, String content) {
        this.commentID = commentID;
        this.post = post;
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
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


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}
