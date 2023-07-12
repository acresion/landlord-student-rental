package landlord.student.rental.daowork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LandlordDAOImplementation implements LandlordDAO {
	private static final String GET_ALL_LANLORDS_SQL = 
			"SELECT  "
			+ "landlordId"
			+ ", buildingName"
			+ ", buildingNumberOfRooms"
			+ ", buildingNumberOfStories"
			+ ", rent"
			+ "FROM rentalDataBase.Landlord";	
	private static final String INSERT_LANDLORD_SQL = "insert into Landlord values(?,?,?,?,?)";
	private static final String DELETE_ONE_LANDLORD_SQL = "delete from Landlord where landlordId = ?";
	private static final String UPDATE_LANLORD_SQL = 
			"update Landlord set "
			+ ", buildingName = ?"
			+ ", buildingNumberOfRooms = ?"
			+ ", buildingNumberOfStories = ?"
			+ ", rent = ?"
			+ "where landlordId = ?";
	@Override
	public List<Landlord> getAllLandlords(Connection con) throws SQLException {
		List<Landlord> getLandlords = new ArrayList<>();
    	try(PreparedStatement p = con.prepareStatement(GET_ALL_LANLORDS_SQL)){
    		ResultSet rs = p.executeQuery();
    		while(rs.next()) {
    			int landlordId = rs.getInt("landlordId");
    			String buildingName = rs.getString("buildingName");
    			int buildingNumberOfRooms = rs.getInt("buildingNumberOfRooms");
    			int buildingNumberOfStories = rs.getInt("buildingNumberOfStories");
    			int rent = rs.getInt("rent");
    			Landlord lord = new Landlord.LandlordBuilder(landlordId).buildingName(buildingName).buildingNumberOfRooms(buildingNumberOfRooms).buildingNumberOfStories(buildingNumberOfStories).rent(rent).builder();
    			getLandlords.add(lord);
    		}

    	}
		return getLandlords;
	}
	@Override
	public Landlord getLandlord(Connection con, int landlordId) throws SQLException {
		List<Landlord > lord = getAllLandlords(con);
		return lord.get(landlordId -1);
	}
	@Override
	public void addLandlord(Connection con, Landlord landlord) throws SQLException {
		try(PreparedStatement p = con.prepareStatement(INSERT_LANDLORD_SQL)){
			p.setInt(1, landlord.getLandlordId());
			p.setString(2, landlord.getBuildingName());
			p.setInt(3, landlord.getBuildingNumberOfRooms());
			p.setInt(4, landlord.getBuildingNumberOfStories());
			p.setInt(5, landlord.getRent());
			p.execute();
			

		}
	}
	@Override
	public void updateLandlord(Connection con, Landlord landlord) throws SQLException {
		try(PreparedStatement p = con.prepareStatement(UPDATE_LANLORD_SQL)){
			p.setString(1, landlord.getBuildingName());
			p.setInt(2, landlord.getBuildingNumberOfRooms());
			p.setInt(3, landlord.getBuildingNumberOfStories());
			p.setInt(4, landlord.getRent());
			p.setInt(5, landlord.getLandlordId());
			p.execute();
			

		}
		
	}
	@Override
	public void deleteLandlord(Connection con, int landlordId) throws SQLException {
		try(PreparedStatement p = con.prepareStatement(DELETE_ONE_LANDLORD_SQL)){
			p.setInt(1, landlordId);
			p.execute();
			

		}
	}	


}
