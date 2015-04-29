package org.primefaces.showcase.view.input;
 
import src.UserBean;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean
public class CalendarView {
         
    private Date dateStart;
    private Date dateEnd;
    @ManagedProperty(value = "#{user}")
    private UserBean userBean;
    
    public void setUserBean(UserBean userBean){
        this.userBean = userBean;
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
            
        Integer userId = dbConnection.getUserId(userBean.getLogin());
        
        java.sql.Date sqlDateStart = new java.sql.Date(dateStart.getTime());
        java.sql.Time sqlTimeStart = new java.sql.Time(dateStart.getTime());
        java.sql.Date sqlDateEnd = new java.sql.Date(dateEnd.getTime());
        java.sql.Time sqlTimeEnd = new java.sql.Time(dateEnd.getTime());
        
        System.out.println("gowno: " + sqlDateStart + sqlTimeStart);
        String insertDoBazy = "insert into REZERWACJA (IDSALI, DATAOD, DATADO, ZAREZERWOWANEPRZEZ) values (1, "+
                "'" + sqlDateStart + " " +sqlTimeStart + "'," +
                "'" + sqlDateEnd + " " +sqlTimeEnd + "'," + 
                userId + ")";
        System.out.println("blabla: " + insertDoBazy);
        dbConnection.exectueQuery(insertDoBazy);
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
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