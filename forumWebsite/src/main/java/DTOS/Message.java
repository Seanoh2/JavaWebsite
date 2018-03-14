/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Seanoh
 */
public class Message {

    private int messageID;
    private User sender;
    private User reciever;
    private int type;
    private Date time;
    private String content;

    public Message() {
    }

    public Message(int messageID, User sender, User reciever, int type, Date time, String content) {
        this.messageID = messageID;
        this.sender = sender;
        this.reciever = reciever;
        this.type = type;
        this.time = time;
        this.content = content;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.messageID;
        hash = 97 * hash + Objects.hashCode(this.sender);
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
        final Message other = (Message) obj;
        if (this.messageID != other.messageID) {
            return false;
        }
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Message{" + "messageID=" + messageID + ", sender=" + sender + ", reciever=" + reciever + ", type=" + type + ", time=" + time + ", content=" + content + '}';
    }

}
