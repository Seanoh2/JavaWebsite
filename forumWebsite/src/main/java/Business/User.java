/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Objects;

/**
 *
 * @author Sean
 */
public class User implements Comparable<User> {
    private int userID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;

    /**
     * Fully constructed User constructor.
     * Main constructor.
     * Should any information be missing, replace with a null where applicable.
     * 
     * @param userID Used to identify a user easily and give a unique identifier.
     * @param FirstName Used by user to provide first name to display on forum.
     * @param LastName Used by user to provide last name to display on forum.
     * @param Email Used to login to forum and to receive important information through email.
     * @param Password Used to secure account. Hashed with bCrypt.
     */
    public User(int userID, String FirstName, String LastName, String Email, String Password) {
        this.userID = userID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
    }
    
    /**
     * Default constructor.
     * Used to create blank user objects.
     */
    
    public User() {
        
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.userID;
        hash = 73 * hash + Objects.hashCode(this.Email);
        hash = 73 * hash + Objects.hashCode(this.Password);
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
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.userID, o.getUserID());
    }
    
}
