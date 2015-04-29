package src;

/**
 * @author Konrad
 */
public class User {
        String imie, nazwisko, mail, password, pesel, login;

    public User() {
    }

    public User(String imie, String nazwisko, String mail, String password, String pesel, String login) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.password = password;
        this.pesel = pesel;
        this.login = login;
    }

    public String getImie() {
        return imie;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
