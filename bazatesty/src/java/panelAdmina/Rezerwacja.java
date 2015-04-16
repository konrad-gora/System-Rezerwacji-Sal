/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelAdmina;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz
 */
@Entity
@Table(name = "REZERWACJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezerwacja.findAll", query = "SELECT r FROM Rezerwacja r"),
    @NamedQuery(name = "Rezerwacja.findById", query = "SELECT r FROM Rezerwacja r WHERE r.id = :id"),
    @NamedQuery(name = "Rezerwacja.findByDataod", query = "SELECT r FROM Rezerwacja r WHERE r.dataod = :dataod"),
    @NamedQuery(name = "Rezerwacja.findByDatado", query = "SELECT r FROM Rezerwacja r WHERE r.datado = :datado")})
public class Rezerwacja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datado;
    @JoinColumn(name = "IDSALI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sale idsali;
    @JoinColumn(name = "ZAREZERWOWANEPRZEZ", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Uzytkownicy zarezerwowaneprzez;

    public Rezerwacja() {
    }

    public Rezerwacja(Integer id) {
        this.id = id;
    }

    public Rezerwacja(Integer id, Date dataod, Date datado) {
        this.id = id;
        this.dataod = dataod;
        this.datado = datado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataod() {
        return dataod;
    }

    public void setDataod(Date dataod) {
        this.dataod = dataod;
    }

    public Date getDatado() {
        return datado;
    }

    public void setDatado(Date datado) {
        this.datado = datado;
    }

    public Sale getIdsali() {
        return idsali;
    }

    public void setIdsali(Sale idsali) {
        this.idsali = idsali;
    }

    public Uzytkownicy getZarezerwowaneprzez() {
        return zarezerwowaneprzez;
    }

    public void setZarezerwowaneprzez(Uzytkownicy zarezerwowaneprzez) {
        this.zarezerwowaneprzez = zarezerwowaneprzez;
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
        if (!(object instanceof Rezerwacja)) {
            return false;
        }
        Rezerwacja other = (Rezerwacja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "panelAdmina.Rezerwacja[ id=" + id + " ]";
    }
    
}
