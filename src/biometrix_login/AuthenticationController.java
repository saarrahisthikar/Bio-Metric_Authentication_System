/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometrix_login;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Saarrah_Isthikar
 */
public class AuthenticationController {

    public static boolean checkUserAvailability(Connection conn, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static boolean checkData(User user, Connection con) throws SQLException {

              
        boolean flag = false;

       
        
        String password =user.getPassword();
        
        String[] retrievedData = DatabaseHandler.getData(con, user.getUsername());

        System.out.println(retrievedData[0]);
        if (user.getUsername().equals(retrievedData[0]) && password.equals(retrievedData[1]) ) {
            flag = true;
        }
        return flag;
    }

    static boolean checkUsername(String userDetail, Connection con) throws SQLException {
    
        return DatabaseHandler.checkUsername(userDetail, con);
    }

}
