
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mariusz
 */
public class rezerwacjaSalBean {

    /**
     * Creates a new instance of rezerwacjaSalBean
     */
    public DB dbConnection = new DB();
    private List<Sala> listaSal = new ArrayList<>();
    
    public rezerwacjaSalBean() {
    }

    public String getWszystkieSaleForUser(Integer userId){
        return null;
    }
    
    public List<Sala> getWszystkieSale() throws SQLException{
        listaSal = dbConnection.listaSal("select * from sale");
        return listaSal;
    }
}
