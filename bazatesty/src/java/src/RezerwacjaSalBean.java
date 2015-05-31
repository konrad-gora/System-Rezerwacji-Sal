package src;


import com.google.common.collect.Lists;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "rezerwacjaSalBean")
@SessionScoped
public class RezerwacjaSalBean {

    /**
     * Creates a new instance of rezerwacjaSalBean
     */
    public DB dbConnection = new DB();
    private List<Sala> listaSal = new ArrayList<>();
    public Integer akutalneIdSali;
    
    @ManagedProperty(value = "#{user}")
    private UserBean userBean;
    
    public void setUserBean(UserBean userBean){
        this.userBean = userBean;
    }
    
    public RezerwacjaSalBean() {
    }

    public Integer getAkutalneIdSali() {
        return akutalneIdSali;
    }

    public void setAkutalneIdSali(Integer akutalneIdSali) {
        this.akutalneIdSali = akutalneIdSali;
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
    
    public String personalizacjaRezerwacjiSali(Sala sala){
        akutalneIdSali = sala.getId();
        return "rezerwacjaSalPersonalizacja.xhtml";
    }
}
