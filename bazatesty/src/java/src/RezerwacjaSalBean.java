package src;


import com.google.common.collect.Lists;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mariusz
 */
@Named(value = "rezerwacjaSalBean")
@ManagedBean
public class RezerwacjaSalBean {

    /**
     * Creates a new instance of rezerwacjaSalBean
     */
    public DB dbConnection = new DB();
    private List<Sala> listaSal = new ArrayList<>();
    
    @ManagedProperty(value = "#{user}")
    private UserBean userBean;
    
    public void setUserBean(UserBean userBean){
        this.userBean = userBean;
    }
    
    public RezerwacjaSalBean() {
    }

    public String getWszystkieSaleForUser(Integer userId){
        return null;
    }
    
    public List<Sala> getWszystkieSale() throws SQLException{
        listaSal = dbConnection.listaSal("select * from sale");
        return listaSal;
    }
    
    public List<SalaIRezerwacja> getZarezerwowaneSaleUzytkownika() throws SQLException{     
        List<SalaIRezerwacja> salaIRezerwacja = Lists.newArrayList();
        
        System.out.println("aaaaaaaaaa");
        Integer idUzytkownika = dbConnection.getUserId(userBean.getLogin());
        System.out.println("bbbbbbb");
        salaIRezerwacja = dbConnection.listaSalUzytkownikaZalgowanego(idUzytkownika);
        return salaIRezerwacja;
    }
    
    public void przypiszSaleDoUzytkownika(Sala sala) throws SQLException{
        //TODO zamiast 2 brac id uzytkownika zalogowanego
        String sql = "insert into rezerwacje values (2, " + sala.getId() + ")";
        dbConnection.exectueQuery(sql);
    }
    
    public String personalizacjaRezerwacjiSali(Sala sala){
        return "rezerwacjaSalPersonalizacja.xhtml";
    }
}
