package org.primefaces.showcase.view.input;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private static Connection conn = null;
    private static Statement stmt = null;
    public static String driver = "org.apache.derby.jdbc.ClientDriver";
    public static String username = "root";
    public static String password = "toor";
    public static String url = "jdbc:derby://localhost:1527/systemRezerwacjiDB";

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

    public boolean sreachUsers(String login, String haslo) {
        try {
            takeDriver();
            connect();
            PreparedStatement preparedStatement = 
                    conn.prepareStatement("select * from uzytkownicy");
                    //conn.prepareStatement("SELECT '" +login+ "' as login, '" +haslo+ "' from uzytkownicy");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String resultLogin = result.getString("login");
                String resultHaslo = result.getString("haslo");
                if (login.equals(resultLogin) && haslo.equals(resultHaslo))
                    return true; //jesli sie pokrywa to mozna zalogowac
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return false; //nie znaleziono pasujacego uzytkownika
    }

    public List<Sala> listaSal(String sql) throws SQLException {

        takeDriver();
        connect();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();
        List<Sala> sale = new ArrayList<Sala>();

        while (result.next()) {
            Sala sala = new Sala();

            sala.setId(result.getInt("id"));
            sala.setIlosc_miejsc(result.getInt("ilosc_miejsc"));
            sala.setLokalizacja(result.getString("lokalizacja"));
            sala.setNazwa(result.getString("nazwa"));
            sala.setNumer_sali(result.getInt("numer_sali"));
            sala.setTyp(result.getString("typ"));

            sale.add(sala);
        }

        return sale;
    }

    public void exectueQuery(String sql) throws SQLException {
        takeDriver();
        connect();
        stmt.executeUpdate(sql);
        close();

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

    private void takeDriver() {
        try {
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private void connect() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    private void close() throws SQLException {
        stmt.close();
        conn.close();
    }
}
