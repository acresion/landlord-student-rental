package landlord.student.rental.daowork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenantDAOImplementation implements TenantDAO {
	private static final String GET_ALL_TENANTS_SQL = "SELECT " + "tenantId" + ", firstName" + ", lastName"
			+ ", addressBeforeMovein" + ", cityBeforeMovein" + ", stateBeforeMovein" + ", countryBeforeMovein"
			+ ", yearOfBirth" + ", monthOfBirth" + ", dayOfBirth" + ", room" + ", floor" + ", landlordId\r\n"
			+ "FROM rentalDataBase.Tenant";
	private static final String GET_TENANT_SQL = "SELECT " + "tenantId" + ", firstName" + ", lastName"
			+ ", addressBeforeMovein" + ", cityBeforeMovein" + ", stateBeforeMovein" + ", countryBeforeMovein"
			+ ", yearOfBirth" + ", monthOfBirth" + ", dayOfBirth" + ", room" + ", floor" + ", landlordId\r\n"
			+ "FROM rentalDataBase.Tenant WHERE tenantId = ?";

	private static final String INSERT_TENANT_SQL = "insert into Tenant values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_ONE_TENANT_SQL = "delete from Tenant where tenantId = ?";
	private static final String UPDATE_TENANT_SQL = "update Tenant set firstName = ?" + ", lastName = ?"
			+ ", addressBeforeMovein = ?" + ", cityBeforeMovein = ?" + ", stateBeforeMovein = ?"
			+ ", countryBeforeMovein = ?" + ", yearOfBirth = ?" + ", monthOfBirth = ?" + ", dayOfBirth = ?"
			+ ", room = ?" + ", floor = ?" + ", landlordId = ?" + "  where tenantId = ?";

	@Override
	public List<Tenant> getAllTenants(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		List<Tenant> listOfTenants = new ArrayList<>();
		// Insert SQL query here
		try (PreparedStatement p = con.prepareStatement(GET_ALL_TENANTS_SQL)) {
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				// This only works on a small database.
				Tenant newTenant = createTenant(rs);
				listOfTenants.add(newTenant);
			}

		}
		return listOfTenants;
	}

	private Tenant createTenant(ResultSet rs) throws SQLException {
		int tenantId = rs.getInt("tenantId");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String addressBeforeMovein = rs.getString("addressBeforeMovein");
		String cityBeforeMovein = rs.getString("cityBeforeMovein");
		String stateBeforeMovein = rs.getString("stateBeforeMovein");
		String countryBeforeMovein = rs.getString("countryBeforeMovein");
		int yearOfBirth = rs.getInt("yearOfBirth");
		int monthOfBirth = rs.getInt("monthOfBirth");
		int dayOfBirth = rs.getInt("dayOfBirth");
		int room = rs.getInt("room");
		int floor = rs.getInt("floor");
		int landlordId = rs.getInt("landlordId");
		return new Tenant.TenantBuilder(tenantId).firstName(firstName).lastName(lastName)
				.addressBeforeMovein(addressBeforeMovein).cityBeforeMovein(cityBeforeMovein)
				.stateBeforeMovein(stateBeforeMovein).countryBeforeMovein(countryBeforeMovein)
				.yearOfBirth(yearOfBirth).monthOfBirth(monthOfBirth).dayOfBirth(dayOfBirth).room(room)
				.floor(floor).landlordId(landlordId).build();
	}

	@Override
	public Tenant getTenant(Connection con, int tenantId) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(GET_TENANT_SQL)) {
			p.setInt(1, tenantId);
			try(ResultSet rs = p.executeQuery()){
				return createTenant(rs);
			}
		}
		
	}

	@Override
	public void addTenant(Connection con, Tenant tenant) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(INSERT_TENANT_SQL)) {
			p.setInt(1, tenant.getTenantId());
			p.setString(2, tenant.getFirstName());
			p.setString(3, tenant.getLastName());
			p.setString(4, tenant.getAddressBeforeMovein());
			p.setString(5, tenant.getCityBeforeMovein());
			p.setString(6, tenant.getStateBeforeMovein());
			p.setString(7, tenant.getCountryBeforeMovein());
			p.setInt(8, tenant.getYearOfBirth());
			p.setInt(9, tenant.getMonthOfBirth());
			p.setInt(10, tenant.getDayOfBirth());
			p.setInt(11, tenant.getRoom());
			p.setInt(12, tenant.getFloor());
			p.setInt(13, tenant.getLandlordId());
			p.execute();
		}
	}

	@Override
	public void updateTenant(Connection con, Tenant tenant) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(UPDATE_TENANT_SQL)) {
			p.setString(1, tenant.getFirstName());
			p.setString(2, tenant.getLastName());
			p.setString(3, tenant.getAddressBeforeMovein());
			p.setString(4, tenant.getCityBeforeMovein());
			p.setString(5, tenant.getStateBeforeMovein());
			p.setString(6, tenant.getCountryBeforeMovein());
			p.setInt(7, tenant.getYearOfBirth());
			p.setInt(8, tenant.getMonthOfBirth());
			p.setInt(9, tenant.getDayOfBirth());
			p.setInt(10, tenant.getRoom());
			p.setInt(11, tenant.getFloor());
			p.setInt(12, tenant.getLandlordId());
			p.setInt(13, tenant.getTenantId());
			p.execute();
		}
	}

	@Override
	public void deleteTenant(Connection con, int tenantId) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(DELETE_ONE_TENANT_SQL)) {
			p.setInt(1, tenantId);
			p.execute();
		}
	}

}
