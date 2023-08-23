package landlord.student.rental;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import landlord.student.rental.daowork.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.*;
import java.util.UUID;


/**
 * Servlet implementation class AddTenant
 */

public class AddTenant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static Logger logger = Logger.getLogger(AddTenant.class.getCanonicalName());
    public AddTenant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * This method takes information from the web browser and internally summons the facade to add a new tenant
	 * 
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String x = request.getParameter("submit");
		

		if(x!= null && x.equals("Confirm")){
			TenantFacade facade = new TenantFacade();
			AddTenantRequestMapper mapper = new AddTenantRequestMapper();
			Tenant newTenant = mapper.map(request);
			try {
				facade.addTenant(newTenant);
			} catch (SQLException e) {
			    logger.log(Level.INFO, "Failed to add a tenant to db", e);
				throw new ServletException("Could not save the new tenant");
			}
			
			
			
			
		}	
			
			
			
		
	}

}
