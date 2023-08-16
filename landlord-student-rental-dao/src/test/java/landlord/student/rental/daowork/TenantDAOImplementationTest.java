package landlord.student.rental.daowork;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class TenantDAOImplementationTest {

	@Test
	void testGetAllTenants() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTenant() throws SQLException{
		try (Connection con = ConnectionToSQL.connectToDataBase()) {
			Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
					.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
					.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			tenantDAO.addTenant(con, newTenant);
			assertEquals(newTenant, tenantDAO.getTenant(con, 1));

		}
	}

	@Test
	void testAddTenant() throws SQLException {
		try (Connection con = ConnectionToSQL.connectToDataBase()) {
			Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
					.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
					.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			tenantDAO.addTenant(con, newTenant);
			assertEquals(newTenant.toString(), tenantDAO.getTenant(con, 1).toString());
		}

	}

	@Test
	void testUpdateTenant() throws SQLException{
		try (Connection con = ConnectionToSQL.connectToDataBase()) {
			Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
					.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
					.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
			TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
			tenantDAO.addTenant(con, newTenant);
			Tenant bober = new Tenant.TenantBuilder(1).tenant(tenantDAO.getTenant(con, 1)).firstName("Fernando")
					.lastName("Alonso").build();
			tenantDAO.updateTenant(con, bober);
			assertEquals("Fernando", tenantDAO.getTenant(con, 1).getFirstName());
			assertEquals("Alonso", tenantDAO.getTenant(con, 1).getLastName());

		} 
	}

	@Test
	void testDeleteTenant() {
		fail("Not yet implemented");
	}

}
