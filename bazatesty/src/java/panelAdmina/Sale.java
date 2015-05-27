/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelAdmina;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bartosz
 */
@Entity
@Table(name = "SALE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s"),
    @NamedQuery(name = "Sale.findById", query = "SELECT s FROM Sale s WHERE s.id = :id"),
    @NamedQuery(name = "Sale.findByNazwa", query = "SELECT s FROM Sale s WHERE s.nazwa = :nazwa"),
    @NamedQuery(name = "Sale.findByLokalizacja", query = "SELECT s FROM Sale s WHERE s.lokalizacja = :lokalizacja"),
    @NamedQuery(name = "Sale.findByNumerSali", query = "SELECT s FROM Sale s WHERE s.numerSali = :numerSali"),
    @NamedQuery(name = "Sale.findByIloscMiejsc", query = "SELECT s FROM Sale s WHERE s.iloscMiejsc = :iloscMiejsc"),
    @NamedQuery(name = "Sale.findByTyp", query = "SELECT s FROM Sale s WHERE s.typ = :typ")})
public class Sale implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsali")
    private Collection<Szczegolysali> szczegolysaliCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOKALIZACJA")
    private String lokalizacja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUMER_SALI")
    private String numerSali;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ILOSC_MIEJSC")
    private int iloscMiejsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TYP")
    private String typ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsali")
    private Collection<Rezerwacja> rezerwacjaCollection;

    public Sale() {
    }

    public Sale(Integer id) {
        this.id = id;
    }

    public Sale(Integer id, String nazwa, String lokalizacja, String numerSali, int iloscMiejsc, String typ) {
        this.id = id;
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
        this.numerSali = numerSali;
        this.iloscMiejsc = iloscMiejsc;
        this.typ = typ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public String getNumerSali() {
        return numerSali;
    }

    public void setNumerSali(String numerSali) {
        this.numerSali = numerSali;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @XmlTransient
    public Collection<Rezerwacja> getRezerwacjaCollection() {
        return rezerwacjaCollection;
    }

    public void setRezerwacjaCollection(Collection<Rezerwacja> rezerwacjaCollection) {
        this.rezerwacjaCollection = rezerwacjaCollection;
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
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "panelAdmina.Sale[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Szczegolysali> getSzczegolysaliCollection() {
        return szczegolysaliCollection;
    }

    public void setSzczegolysaliCollection(Collection<Szczegolysali> szczegolysaliCollection) {
        this.szczegolysaliCollection = szczegolysaliCollection;
    }
    
}
