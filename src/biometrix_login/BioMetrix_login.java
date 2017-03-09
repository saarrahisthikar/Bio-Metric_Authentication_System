package biometrix_login;

import java.sql.SQLException;

public class BioMetrix_login {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Login().setVisible(true);

            }
        });

        DatabaseHandler.initialize();

    }

}
