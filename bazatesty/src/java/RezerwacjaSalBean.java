
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
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
@Dependent
public class RezerwacjaSalBean {

    /**
     * Creates a new instance of rezerwacjaSalBean
     */
    public DB dbConnection = new DB();
    private List<Sala> listaSal = new ArrayList<>();
    
    public RezerwacjaSalBean() {
    }

    public String getWszystkieSaleForUser(Integer userId){
        return null;
    }
    
    public List<Sala> getWszystkieSale() throws SQLException{
        listaSal = dbConnection.listaSal("select * from sale");
        return listaSal;
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
