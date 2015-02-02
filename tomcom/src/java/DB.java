import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class DB {

    private static String tableName = "uzytkownicy";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/systemRezerwacjiDB", "root", "toor");
        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }

    public static void insertUsers(String login, String imie, String nazwisko, String password, String mail, String pesel) {
        try {
            if (conn != null) {
                stmt = conn.createStatement();
            }
            if (stmt != null) {
                stmt.execute("insert into " + tableName + " (login, imie, nazwisko, haslo, email, pesel) values ('"
                        + login + "','" + imie + "','" + nazwisko + "','" + password + "','"
                        + mail + "','" + pesel + "')");
                stmt.close();
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    public static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection("jdbc:derby://localhost:1527/systemRezerwacjiDB" + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }
}
