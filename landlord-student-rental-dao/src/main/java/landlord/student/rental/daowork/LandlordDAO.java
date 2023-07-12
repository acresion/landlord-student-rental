package landlord.student.rental.daowork;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface LandlordDAO {
	public List<Landlord> getAllLandlords(Connection con)throws SQLException;
	public Landlord getLandlord(Connection con, int landlordId) throws SQLException;
	public void addLandlord(Connection con, Landlord landlord) throws SQLException;
	public void updateLandlord(Connection con, Landlord landlord) throws SQLException;
	public void deleteLandlord(Connection con, int landlordId) throws SQLException;

}
