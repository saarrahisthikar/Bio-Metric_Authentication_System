package biometrix_login;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saarrah_Isthikar
 */
public class DatabaseHandler {

    public static Connection DBConnect() {

        try {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/biometric_login", "root", "");
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
            String insertTableSQL = "INSERT INTO users (username,bio_metric_auth) VALUES (?,?)";

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

    static void closeConnection() {
    }

}
