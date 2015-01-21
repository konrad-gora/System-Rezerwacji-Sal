
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class DB {
    ArrayList users = new ArrayList<>();
    
    public DB(){
        users.add(new User ("imie", "nazwisko", "mail", "password", "pesel", "login"));
        users.add(new User ("Wieslaw", "Sztacheta", "sztacheta@plot.pl", "admin1", "01010155555", "admin"));
        //users.add("admin");
        //users.add("ktos");
        
    }

    public ArrayList getUsers() {
        return users;
    }

    public void setUsers(ArrayList users) {
        this.users = users;
    }
}
