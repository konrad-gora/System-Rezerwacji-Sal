package src;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Mariusz
 */
@Named(value = "rezerwacjaBean")
@Dependent
public class RezerwacjaBean {

    /**
     * Creates a new instance of RezerwacjaBean
     */
    public RezerwacjaBean() {
    }
    
    public void przypiszSale() throws SQLException{
        DB a = null;
        a.exectueQuery("insert into UZYTKOWNICY(login, imie, nazwisko, haslo, email, pesel) VALUES ('sssssda', 'sdfa', `'asd', 'sda', 'sda', 'sad')");
    }
}
