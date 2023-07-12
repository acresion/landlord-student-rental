package landlord.student.rental.daowork;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.sql.*;
class JUnitTestForDAO {

	@Test
	void test() {
		try(Connection con = ConnectionToSQL.connectToDataBase()){
			Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon"). addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			tenantDAO.addTenant(con, newTenant);
			assertNull(tenantDAO.getTenant(con, 1).getStateBeforeMovein());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	void test2()  {
		try(Connection con = ConnectionToSQL.connectToDataBase()){
			Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon"). addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			tenantDAO.addTenant(con, newTenant);
			assertEquals("Alex",tenantDAO.getTenant(con, 1).getFirstName());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	void test3(){
		try(Connection con = ConnectionToSQL.connectToDataBase()){
			Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon"). addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			tenantDAO.addTenant(con, newTenant);
			Tenant bober = new Tenant.TenantBuilder(1).tenant(tenantDAO.getTenant(con, 1)).firstName("Fernando").lastName("Alonso").build();
			tenantDAO.updateTenant(con, bober);
			assertEquals("Fernando",tenantDAO.getTenant(con, 1).getFirstName());
			assertEquals("Alonso",tenantDAO.getTenant(con, 1).getLastName());


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
