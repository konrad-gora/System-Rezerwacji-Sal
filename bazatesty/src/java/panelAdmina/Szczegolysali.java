/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelAdmina;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz
 */
@Entity
@Table(name = "SZCZEGOLYSALI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Szczegolysali.findAll", query = "SELECT s FROM Szczegolysali s"),
    @NamedQuery(name = "Szczegolysali.findById", query = "SELECT s FROM Szczegolysali s WHERE s.id = :id"),
    @NamedQuery(name = "Szczegolysali.findByOpis", query = "SELECT s FROM Szczegolysali s WHERE s.opis = :opis")})
public class Szczegolysali implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OPIS")
    private String opis;
   
   
    @JoinColumn(name = "IDSALI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sale idsali;

    public Szczegolysali() {
    }

    public Szczegolysali(Integer id) {
        this.id = id;
    }

    public Szczegolysali(Integer id, String opis) {
        this.id = id;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

   
    public Sale getIdsali() {
        return idsali;
    }

    public void setIdsali(Sale idsali) {
        this.idsali = idsali;
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
        if (!(object instanceof Szczegolysali)) {
            return false;
        }
        Szczegolysali other = (Szczegolysali) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "panelAdmina.Szczegolysali[ id=" + id + " ]";
    }
    
}
