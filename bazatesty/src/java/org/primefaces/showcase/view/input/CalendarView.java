package org.primefaces.showcase.view.input;
 
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean
public class CalendarView {
         
    private Date dateStart;
    private Date dateEnd;

     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() throws SQLException {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        DB dbConnection = new DB();
        dbConnection.createConnection();
        dbConnection.exectueQuery("insert into REZERWACJA (IDSALI, DATAOD, DATADO, ZAREZERWOWANEPRZEZ) values (1, '2015-04-25 21:56:15.776', '2015-04-25 21:56:15.776', 1)");
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