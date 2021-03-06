/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author grahamm
 */
public class CommandFactory {
    
    private volatile static CommandFactory currentInstance;
    
    private CommandFactory(){
        
    }
    
    public static CommandFactory getInstance(){
        
        if(currentInstance == null){
            synchronized(CommandFactory.class)
            {
                if(currentInstance == null){
                    currentInstance = new CommandFactory();
                }
            }
        }
        return currentInstance;
    }
    
    public static Command createCommand(String action){
        // Create a command object to hold what we action we wish to take
        Command command = null;
        
        // Confirm an action variable was supplied
        if (action != null) {
            // Choose which action to carry out
            // Deal with if the user wants to update a customer
            switch (action) {
                // Deal with if the user wants to view all customer information
                case "login":
                    command = new LoginUserCommand();
                    break;
                    
                case "register":
                    command = new SignUpUserCommand();
                    break;
                    
                case "passwordrecovery":
                    command = new RequestPasswordCommand();
                    break;
                 
                case "resetpassword":
                    command = new ResetPasswordCommand();
                    break;
                
                case "sendMessage":
                    command = new SendMessageCommand();
                    break;
                    
                case "addPost":
                    command = new MakeTextPostCommand();
                    break;
                    
                case "sendComment":
                    command = new SendCommentCommand();
                    break;
                
                case "deleteUser":
                    command = new DeleteUserCommand();
                    break;
                    
                case "editTextPost":
                    command = new EditPostCommand();
                    break;
                    
                case "deletePost":
                    command = new DeletePostCommand();
                    break;
                    
                case "editUser":
                    command = new EditUserCommand();
                    break;
                    
                case "editComment":
                    command = new EditCommentCommand();
                    break;
                    
                case "deleteComment":
                    command = new DeleteCommentCommand();
                    break;
                                        
                default:
                    command = new NoValidActionCommand();
                    break;
            }

        } else {
            // Deal with where there was no action supplied as part of this request
            command = new NoActionSuppliedCommand();
        }
        
        return command;
    }
    
}
