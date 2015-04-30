/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Mariusz
 */
public class SalaIRezerwacja {
  
    private Integer id;
    private String nazwa;
    private String lokalizacja;
    private Integer numer_sali;
    private Integer ilosc_miejsc;
    private String typ;
    private String dataOd;
    private String dataDo;

    public SalaIRezerwacja() {
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

    public Integer getNumer_sali() {
        return numer_sali;
    }

    public void setNumer_sali(Integer numer_sali) {
        this.numer_sali = numer_sali;
    }

    public Integer getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(Integer ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getDataOd() {
        return dataOd;
    }

    public void setDataOd(String dataOd) {
        this.dataOd = dataOd;
    }

    public String getDataDo() {
        return dataDo;
    }

    public void setDataDo(String dataDo) {
        this.dataDo = dataDo;
    }
    
    
}
