package landlord.student.rental.daowork;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * 
 * @author Alexandru
 * A DAO object for the Tenant class
 */
public interface TenantDAO {
	public List<Tenant> getAllTenants(Connection con) throws SQLException;
	public Tenant getTenant(Connection con, int tenantId) throws SQLException;
	public void addTenant(Connection con, Tenant tenant) throws SQLException;
	public void updateTenant(Connection con, Tenant tenant) throws SQLException;
	public void deleteTenant(Connection con, int tenantId) throws SQLException;




}
