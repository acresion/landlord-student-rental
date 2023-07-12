package landlord.student.rental.daowork;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TenantFacade {

	public List<Tenant> getAllTenants() throws SQLException
	{
		try (Connection con = ConnectionToSQL.connectToDataBase()) {
			TenantDAO tenantDAO = new TenantDAOImplementation();
			return tenantDAO.getAllTenants(con);
		}
	}
	public void addTenant(Tenant newTenant) throws  SQLException {
		try (Connection con = ConnectionToSQL.connectToDataBase()) {
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			
			tenantDAO.addTenant(con, newTenant);
			
			
		}
		
		
	}
}
