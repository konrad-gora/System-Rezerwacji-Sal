/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name="user")
@RequestScoped
public class User {
    
    String imie, nazwisko, mail, password, pesel, login;
    
    public User() {
    } 
    public User(String imie, boolean czyImie){
        if(czyImie)
            this.imie = imie;
        else
            this.nazwisko= imie;
    }

    DB db = new DB();

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
    
    
    public String getImie() {
        return imie;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }



    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    
    public boolean loginExsists(){
        ArrayList al = db.getUsers();
        for(int i = 0; i<al.size(); i++){
            if(login.equals(al.get(i)))
                return true;
        }
        return false;
    }
    

    public String goSomewhere(){

       if(loginExsists()){
           if(login.equals("admin")){
               return "panelAdmina.xhtml";
           }else
               return "poZalogowaniu.xhtml";
       }else{
                return "poZalogowaniu.xhtml";
       }
    }
    
    public String getJakDzialaAjax(){
        if(login==null){
            return "Ajax jeszcze nie przechwycił danych z pola login, przechwyci po kliknięciu na button Zaloguj";
        }else{
            return "Tak działa Ajax: bez przeładowania strony pobiera dane z pola login: " + "   " +login;
        }
    }
    
}
