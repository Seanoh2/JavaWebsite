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
    private int poster;
    private int forumID;
    private boolean isLink;
    private String title;
    private String content;
    private int score;

    /**
     * Fully constructed Post object Main constructor.
     *
     * @param postID
     * @param userID
     * @param forumID
     * @param isLink
     * @param title
     * @param content
     * @param score
     */
    public Post(int postID, int userID, int forumID, boolean isLink, String title, String content, int score) {
        this.postID = postID;
        this.poster = userID;
        this.forumID = forumID;
        this.isLink = isLink;
        this.title = title;
        this.content = content;
        this.score = score;
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
    public int getPoster() {
        return poster;
    }

    /**
     *
     * @param poster
     */
    public void poser(int poster) {
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

    /**
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Post{" + "postID=" + postID + ", poster=" + poster + ", forumID=" + forumID + ", isLink=" + isLink + ", title=" + title + ", content=" + content + ", score=" + score + '}';
    }

    @Override
    public int compareTo(Post o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
