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

    static boolean checkData(String[] userDetails, Connection con) throws SQLException {

              
        boolean flag = false;

        String val=PasswordEncryption.encryptByte(userDetails[1])+PasswordEncryption.encryptByte(userDetails[2])+PasswordEncryption.encryptByte(userDetails[3])
                +PasswordEncryption.encryptByte(userDetails[4])+PasswordEncryption.encryptByte(userDetails[5])+PasswordEncryption.encryptByte(userDetails[6])
                +PasswordEncryption.encryptByte(userDetails[7])+PasswordEncryption.encryptByte(userDetails[8])+PasswordEncryption.encryptByte(userDetails[9])
                +PasswordEncryption.encryptByte(userDetails[10]);
        
        String password =PasswordEncryption.finalPassword(val);
        
        String[] retrievedData = DatabaseHandler.getData(con, userDetails[0]);

        System.out.println(retrievedData[0]);
        if (userDetails[0].equals(retrievedData[0]) && password.equals(retrievedData[1]) ) {
            flag = true;
        }
        return flag;
    }

    static boolean checkUsername(String userDetail, Connection con) throws SQLException {
    
        return DatabaseHandler.checkUsername(userDetail, con);
    }

}
