/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tomek
 */
@Entity
@Table(name = "UZYTKOWNICY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uzytkownicy.findAll", query = "SELECT u FROM Uzytkownicy u"),
    @NamedQuery(name = "Uzytkownicy.findById", query = "SELECT u FROM Uzytkownicy u WHERE u.id = :id"),
    @NamedQuery(name = "Uzytkownicy.findByLogin", query = "SELECT u FROM Uzytkownicy u WHERE u.login = :login"),
    @NamedQuery(name = "Uzytkownicy.findByImie", query = "SELECT u FROM Uzytkownicy u WHERE u.imie = :imie"),
    @NamedQuery(name = "Uzytkownicy.findByNazwisko", query = "SELECT u FROM Uzytkownicy u WHERE u.nazwisko = :nazwisko"),
    @NamedQuery(name = "Uzytkownicy.findByHaslo", query = "SELECT u FROM Uzytkownicy u WHERE u.haslo = :haslo"),
    @NamedQuery(name = "Uzytkownicy.findByEmail", query = "SELECT u FROM Uzytkownicy u WHERE u.email = :email"),
    @NamedQuery(name = "Uzytkownicy.findByPesel", query = "SELECT u FROM Uzytkownicy u WHERE u.pesel = :pesel")})
public class Uzytkownicy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "HASLO")
    private String haslo;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PESEL")
    private String pesel;

    public Uzytkownicy() {
    }

    public Uzytkownicy(Integer id) {
        this.id = id;
    }

    public Uzytkownicy(Integer id, String login, String imie, String nazwisko, String haslo, String email, String pesel) {
        this.id = id;
        this.login = login;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.haslo = haslo;
        this.email = email;
        this.pesel = pesel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
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

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownicy)) {
            return false;
        }
        Uzytkownicy other = (Uzytkownicy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.Uzytkownicy[ id=" + id + " ]";
    }
    
}
