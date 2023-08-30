package landlord.student.rental.daowork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Alexandru Here is our implementation of the LandlordDAO class
 */
public class LandlordDAOImplementation implements LandlordDAO {
	// Below, we just create some constants to improve the clarity of the code
	private static final String GET_LANDLORD_SQL = "SELECT  " + "landlordId" + ", buildingName"
			+ ", buildingNumberOfRooms" + ", buildingNumberOfStories" + ", rent"
			+ "FROM rentalDataBase.Landlord WHERE landlordID = ?";
	private static final String GET_ALL_LANLORDS_SQL = "SELECT  " + "landlordId" + ", buildingName"
			+ ", buildingNumberOfRooms" + ", buildingNumberOfStories" + ", rent" + "FROM rentalDataBase.Landlord";
	private static final String INSERT_LANDLORD_SQL = "insert into Landlord values(?,?,?,?,?)";
	private static final String DELETE_ONE_LANDLORD_SQL = "delete from Landlord where landlordId = ?";
	private static final String UPDATE_LANLORD_SQL = "update Landlord set " + ", buildingName = ?"
			+ ", buildingNumberOfRooms = ?" + ", buildingNumberOfStories = ?" + ", rent = ?" + "where landlordId = ?";

	/**
	 * The method below returns all of the landlords in the database
	 */

	@Override
	public List<Landlord> getAllLandlords(Connection con) throws SQLException {
		List<Landlord> getLandlords = new ArrayList<>();
		try (PreparedStatement p = con.prepareStatement(GET_ALL_LANLORDS_SQL)) {
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Landlord lord = createLandlord(rs);
				getLandlords.add(lord);
			}

		}
		return getLandlords;
	}

	private Landlord createLandlord(ResultSet rs) throws SQLException {
		int landlordId = rs.getInt("landlordId");
		String buildingName = rs.getString("buildingName");
		int buildingNumberOfRooms = rs.getInt("buildingNumberOfRooms");
		int buildingNumberOfStories = rs.getInt("buildingNumberOfStories");
		int rent = rs.getInt("rent");
		return new Landlord.LandlordBuilder(landlordId).buildingName(buildingName)
				.buildingNumberOfRooms(buildingNumberOfRooms).buildingNumberOfStories(buildingNumberOfStories)
				.rent(rent).builder();

	}

	/**
	 * The method gets the desired landlord after the user inputs in the landlordID.
	 * I primarily coded this method, (similarly with getTenant in
	 * TenantDAOImplementation), where I just got the full list and told it to
	 * return the exact landlord on that list.
	 */
	@Override
	public Landlord getLandlord(Connection con, int landlordId) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(GET_LANDLORD_SQL)) {
			p.setInt(1, landlordId);
			try (ResultSet rs = p.executeQuery()) {
				return createLandlord(rs);
			}

		}
	}

	/**
	 * The primary goal behind this method is to add a Landlord object to your
	 * database
	 */
	@Override
	public void addLandlord(Connection con, Landlord landlord) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(INSERT_LANDLORD_SQL)) {
			p.setInt(1, landlord.getLandlordId());
			p.setString(2, landlord.getBuildingName());
			p.setInt(3, landlord.getBuildingNumberOfRooms());
			p.setInt(4, landlord.getBuildingNumberOfStories());
			p.setInt(5, landlord.getRent());
			p.execute();

		}
	}

	/**
	 * This method allows you to alter the details of an existing Landlord object
	 */
	@Override
	public void updateLandlord(Connection con, Landlord landlord) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(UPDATE_LANLORD_SQL)) {
			p.setString(1, landlord.getBuildingName());
			p.setInt(2, landlord.getBuildingNumberOfRooms());
			p.setInt(3, landlord.getBuildingNumberOfStories());
			p.setInt(4, landlord.getRent());
			p.setInt(5, landlord.getLandlordId());
			p.execute();

		}

	}

	/**
	 * This merely deletes a landlord from the server.
	 */
	@Override
	public void deleteLandlord(Connection con, int landlordId) throws SQLException {
		try (PreparedStatement p = con.prepareStatement(DELETE_ONE_LANDLORD_SQL)) {
			p.setInt(1, landlordId);
			p.execute();

		}
	}

}
