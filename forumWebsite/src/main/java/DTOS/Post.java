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
public class Post implements Comparable<Post> {

    private int postID;
    private User poster;
    private int forumID;
    private boolean isLink;
    private String title;
    private String content;

    /**
     * Fully constructed Post object Main constructor.
     *
     * @param postID
     * @param poster
     * @param forumID
     * @param isLink
     * @param title
     * @param content
     */
    public Post(int postID, User poster, int forumID, boolean isLink, String title, String content) {
        this.postID = postID;
        this.poster = poster;
        this.forumID = forumID;
        this.isLink = isLink;
        this.title = title;
        this.content = content;
    }

    /**
     *
     */
    public Post() {
    }

    /**
     *
     * @return
     */
    public int getPostID() {
        return postID;
    }

    /**
     *
     * @param postID
     */
    public void setPostID(int postID) {
        this.postID = postID;
    }

    /**
     *
     * @return
     */
    public User getPoster() {
        return poster;
    }

    /**
     *
     * @param poster
     */
    public void poser(User poster) {
        this.poster = poster;
    }

    /**
     *
     * @return
     */
    public int getForumID() {
        return forumID;
    }

    /**
     *
     * @param forumID
     */
    public void setForumID(int forumID) {
        this.forumID = forumID;
    }

    /**
     *
     * @return
     */
    public boolean isIsLink() {
        return isLink;
    }

    /**
     *
     * @param isLink
     */
    public void setIsLink(boolean isLink) {
        this.isLink = isLink;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(Post o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
