/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import facades.UserFacade;

/**
 *
 * @author Kristian
 */
public class Test {
    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        
//        String password = "kristian";
//        
//        String hashedpw = PasswordStorage.createHash(password);
//        
//        
//        
//        System.out.println(PasswordStorage.verifyPassword(password, hashedpw));
        
        UserFacade uf = new UserFacade();
        
        System.out.println(uf.getUserByUserId("1"));
        
    }
}
