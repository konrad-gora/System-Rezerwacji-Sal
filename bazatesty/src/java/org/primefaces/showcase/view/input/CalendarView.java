package org.primefaces.showcase.view.input;
 
import com.google.common.collect.Lists;
import src.UserBean;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import panelAdmina.Rezerwacja;
import src.RezerwacjaSalBean;
 
@ManagedBean
public class CalendarView {
         
    private Date dateStart;
    private Date dateEnd;
    @ManagedProperty(value = "#{user}")
    private UserBean userBean;
    @ManagedProperty(value = "#{rezerwacjaSalBean}")
    private RezerwacjaSalBean rezerwacjaSalBean;
    private Rezerwacja rezerwacja  = new  Rezerwacja();
    
    
    public void setUserBean(UserBean userBean){
        this.userBean = userBean;
    }

    public void setRezerwacjaSalBean(RezerwacjaSalBean rezerwacjaSalBean) {
        this.rezerwacjaSalBean = rezerwacjaSalBean;
    }
     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() throws SQLException {
        
        RequestContext requestContext = RequestContext.getCurrentInstance();
        DB dbConnection = new DB();
        dbConnection.createConnection();
        List<Rezerwacja> rezerwacje = Lists.newArrayList(); 
        rezerwacje = getRezerwacjeSal(rezerwacjaSalBean.getAkutalneIdSali());
        
        Integer userId = dbConnection.getUserId(userBean.getLogin());
        
        java.sql.Date sqlDateStart = new java.sql.Date(dateStart.getTime());
        java.sql.Time sqlTimeStart = new java.sql.Time(dateStart.getTime());
        java.sql.Date sqlDateEnd = new java.sql.Date(dateEnd.getTime());
        java.sql.Time sqlTimeEnd = new java.sql.Time(dateEnd.getTime());       
        String insertDoBazy = "insert into REZERWACJA (IDSALI, DATAOD, DATADO, ZAREZERWOWANEPRZEZ) "
                + "values ("+rezerwacjaSalBean.getAkutalneIdSali()+", "+
                "'" + sqlDateStart + " " +sqlTimeStart + "'," +
                "'" + sqlDateEnd + " " +sqlTimeEnd + "'," + 
                userId + ")";
        dbConnection.exectueQuery(insertDoBazy);
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    private List<Rezerwacja> getRezerwacjeSal(Integer idSali) throws SQLException{
        List<Rezerwacja> rezerwacje = Lists.newArrayList();
        DB dbConnection = new DB();
        rezerwacje = dbConnection.saleRezerwacje(idSali);
        System.out.println("Liczba rez: " + rezerwacje.size());
        return rezerwacje;   
    }

    public Date getDateStart() {
        return dateStart;
    }
 
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    
    public Date getDateEnd() {
        return dateEnd;
    }
 
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}