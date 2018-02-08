/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author Seanoh
 */
public class Forum {

    private int forumID;
    private String title;
    private String description;
    private String sidebar;
    private String wiki;

    public Forum(int forumID, String title, String description, String sidebar, String wiki) {
        this.forumID = forumID;
        this.title = title;
        this.description = description;
        this.sidebar = sidebar;
        this.wiki = wiki;
    }

    public Forum() {
    }

    public int getForumID() {
        return forumID;
    }

    public void setForumID(int forumID) {
        this.forumID = forumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSidebar() {
        return sidebar;
    }

    public void setSidebar(String sidebar) {
        this.sidebar = sidebar;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.forumID;
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
        final Forum other = (Forum) obj;
        if (this.forumID != other.forumID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Forum{" + "forumID=" + forumID + ", title=" + title + ", description=" + description + ", sidebar=" + sidebar + ", wiki=" + wiki + '}';
    }

}
