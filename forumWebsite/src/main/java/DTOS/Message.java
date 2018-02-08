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
public class Message {

    private int MessageID;
    private int SenderID;
    private int ReceiverID;
    private int type;
    private LocalDate time;
    private String content;

    public Message(int MessageID, int SenderID, int ReceiverID, int type, LocalDate time, String content) {
        this.MessageID = MessageID;
        this.SenderID = SenderID;
        this.ReceiverID = ReceiverID;
        this.type = type;
        this.time = time;
        this.content = content;
    }

    public Message() {
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int MessageID) {
        this.MessageID = MessageID;
    }

    public int getSenderID() {
        return SenderID;
    }

    public void setSenderID(int SenderID) {
        this.SenderID = SenderID;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int ReceiverID) {
        this.ReceiverID = ReceiverID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" + "MessageID=" + MessageID + ", SenderID=" + SenderID + ", ReceiverID=" + ReceiverID + ", type=" + type + ", time=" + time + ", content=" + content + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.MessageID;
        hash = 23 * hash + this.SenderID;
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
        if (this.MessageID != other.MessageID) {
            return false;
        }
        if (this.SenderID != other.SenderID) {
            return false;
        }
        return true;
    }

}
