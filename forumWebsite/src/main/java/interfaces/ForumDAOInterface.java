/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import DTOS.Forum;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public interface ForumDAOInterface {
    
    public ArrayList<Forum> getAllForums();
    
    public ArrayList<Forum> getForumsByTitle(String title);
    
    public Forum getForumByID(int ID);
}
