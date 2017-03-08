package biometrix_login;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saarrah_Isthikar
 */
public class DatabaseHandler {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static Connection DBConnect() {

        try {

            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL + "/biometric_authentication", USER, PASS);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean checkUsername(String username, Connection conn) throws SQLException {
        boolean flag = false;

        String query = "select username from users";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

//        String name = result.getString(1);
        while (result.next()) {
            String name = result.getString(1);
            if (username.equals(name)) {
                flag = true;
            }
        }
        return flag;
    }

    public static void addToDatabase(User user, Connection conn) {

        try {
            String insertTableSQL = "INSERT INTO users (username,biometric_pass) VALUES (?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String[] getData(Connection con, String username) {

        try {
            String[] userDetails = new String[11];

            String query = "select * from users where username=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);

            // Statement statement = con.createStatement();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userDetails[0] = rs.getString(1);
                userDetails[1] = rs.getString(2);

            }

            return userDetails;
        } catch (SQLException ex) {
            System.out.print(ex);
            return null;
        }

    }

    static void closeConnection(Connection conn) throws SQLException {

        conn.close();
    }

    static void initialize() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

       

        String[] querySet ={ "CREATE DATABASE IF NOT EXISTS biometric_authentication","use biometric_authentication", "CREATE TABLE IF NOT EXISTS users (username varchar[255] not null,biometric_pass varchar[255] not null)"};

        for(String query:querySet){
             Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
        System.out.print("successful");}
        conn.close();
    }

}
