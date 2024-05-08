package landlord.student.rental.daowork;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class TenantDAOImplementationTest {
	private static final String INSERT_TENANT_SQL = "insert into Tenant values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_TENANT_SQL = "update Tenant set firstName = ?" + ", lastName = ?"
			+ ", addressBeforeMovein = ?" + ", cityBeforeMovein = ?" + ", stateBeforeMovein = ?"
			+ ", countryBeforeMovein = ?" + ", yearOfBirth = ?" + ", monthOfBirth = ?" + ", dayOfBirth = ?"
			+ ", room = ?" + ", floor = ?" + ", landlordId = ?" + "  where tenantId = ?";

	@Test
	void testGetAllTenants() throws SQLException {

		Connection con = createMockConnection();

		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();

		List<Tenant> expectedTenants = new ArrayList<>();
		expectedTenants.add(newTenant);
		TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
		List<Tenant> allTenants = tenantDAO.getAllTenants(con);
		assertEquals(expectedTenants, allTenants);
	}

	@Test
	void testGetAllTenantsWithZeroTenants() throws SQLException {

		Connection con = createMockEmptyConnection();

		List<Tenant> expectedTenants = new ArrayList<>();
		TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
		List<Tenant> allTenants = tenantDAO.getAllTenants(con);
		assertEquals(expectedTenants, allTenants);
	}

	@Test
	void testGetTenant() throws SQLException {

		Connection con = createMockConnection();

		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
		assertEquals(newTenant, tenantDAO.getTenant(con, 1));

	}

	private Connection createMockConnection() throws SQLException {
		Connection con = mock(Connection.class);
		PreparedStatement p = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(con.prepareStatement(anyString())).thenReturn(p);
		when(p.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getString("firstName")).thenReturn("Alex");
		when(rs.getString("lastName")).thenReturn("Albon");
		when(rs.getString("addressBeforeMovein")).thenReturn(null);
		when(rs.getString("cityBeforeMovein")).thenReturn("Paris");
		when(rs.getString("stateBeforeMovein")).thenReturn(null);
		when(rs.getString("countryBeforeMovein")).thenReturn("France");
		when(rs.getInt("yearOfBirth")).thenReturn(1995);
		when(rs.getInt("monthOfBirth")).thenReturn(12);
		when(rs.getInt("dayOfBirth")).thenReturn(3);
		when(rs.getInt("room")).thenReturn(503);
		when(rs.getInt("floor")).thenReturn(5);
		when(rs.getInt("landlordId")).thenReturn(1);
		when(rs.getInt("tenantId")).thenReturn(1);
		return con;
	}

	private Connection createMockEmptyConnection() throws SQLException {
		Connection con = mock(Connection.class);
		PreparedStatement p = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(con.prepareStatement(anyString())).thenReturn(p);
		when(p.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(false);
		return con;
	}

	
	@Test
	void testAddTenant() throws SQLException {
		
	   //setup
		Connection con = mock(Connection.class);
		PreparedStatement p = mock(PreparedStatement.class);
		when(con.prepareStatement(anyString())).thenReturn(p);
		Tenant tenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		
		// test
		TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
		tenantDAO.addTenant(con, tenant);
		
		// verification
       ArgumentCaptor<Integer> indexCapture = ArgumentCaptor.forClass(Integer.class);
       ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor.forClass(Integer.class);
       ArgumentCaptor<Integer> stringCapture = ArgumentCaptor.forClass(Integer.class);
       ArgumentCaptor<String> valueStringCapture = ArgumentCaptor.forClass(String.class);
       //The reason why we call the times(7) is that we want it to invoke this verification for as many times as there are integers in the method(which there are 7)
		verify(p, times(7)).setInt(indexCapture.capture(), valueIntCapture.capture());
		verify(p).execute();
		verify(p, times(6)).setString(stringCapture.capture(), valueStringCapture.capture());
		assertEquals(1, indexCapture.getAllValues().get(0));
		assertEquals(1, valueIntCapture.getAllValues().get(0));
		assertEquals(2, stringCapture.getAllValues().get(0));
		assertEquals("Alex", valueStringCapture.getAllValues().get(0));


	}
	
	@Test
	void testUpdateTenant() throws SQLException {
		
		//setup
		Connection con = mock(Connection.class);
		PreparedStatement p = mock(PreparedStatement.class);
		when(con.prepareStatement(anyString())).thenReturn(p);
		Tenant tenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		
		//test
		TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
		Tenant updatedTenant = new Tenant.TenantBuilder(1).firstName("Fernando").lastName("Alonso").addressBeforeMovein(null)
				.cityBeforeMovein("Barcelona").stateBeforeMovein(null).countryBeforeMovein("Spain").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		tenantDAO.updateTenant(con, updatedTenant);
		
		//verification
		 ArgumentCaptor<Integer> indexCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<Integer> stringCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<String> valueStringCapture = ArgumentCaptor.forClass(String.class);
	       //The reason why we call the times(7) is that we want it to invoke this verification for as many times as there are integers in the method(which there are 7)
			verify(p, times(7)).setInt(indexCapture.capture(), valueIntCapture.capture());
			verify(p).execute();
			verify(p, times(6)).setString(stringCapture.capture(), valueStringCapture.capture());
			assertEquals(7, indexCapture.getAllValues().get(0));
			assertEquals(1995, valueIntCapture.getAllValues().get(0));
			assertEquals(1, stringCapture.getAllValues().get(0));
			assertEquals("Fernando", valueStringCapture.getAllValues().get(0));
	}

	@Test
	void testDeleteTenant() throws SQLException {
		//setup
		Connection con = mock(Connection.class);
		PreparedStatement p = mock(PreparedStatement.class);
		when(con.prepareStatement(anyString())).thenReturn(p);
		Tenant tenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Albon").addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		
		// test
		TenantDAOImplementation tenantDAO = new TenantDAOImplementation();
		tenantDAO.deleteTenant(con, 1);


		
		// verification
		ArgumentCaptor<Integer> indexCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor.forClass(Integer.class);
			verify(p, times(1)).setInt(indexCapture.capture(), valueIntCapture.capture());
			verify(p).execute();
			assertEquals(1, indexCapture.getAllValues().get(0));
			assertEquals(1, valueIntCapture.getAllValues().get(0));	
	}

}
