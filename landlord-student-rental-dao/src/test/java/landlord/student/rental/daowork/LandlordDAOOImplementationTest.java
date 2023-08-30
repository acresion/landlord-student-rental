package landlord.student.rental.daowork;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.mockito.ArgumentCaptor;

class LandlordDAOOImplementationTest {
	public Connection createMockConnection() throws SQLException {
		Connection con = mock(Connection.class);
		PreparedStatement ps = mock(PreparedStatement.class);
		ResultSet rs = mock(ResultSet.class);
		when(con.prepareStatement(anyString())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rs.next()).thenReturn(true, false);
		when(rs.getInt("landlordId")).thenReturn(1);
		when(rs.getString("buildingName")).thenReturn("Ranee");
		when(rs.getInt("buildingNumberOfRooms")).thenReturn(559);
		when(rs.getInt("buildingNumberOfStories")).thenReturn(5);
		when(rs.getInt("rent")).thenReturn(1234);
		return con;
	}

	@Test
	void testGetAllLandlords() throws SQLException {
		Connection con = createMockConnection();
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
				.buildingNumberOfStories(5).rent(1234).builder();
		List<Landlord> landlordList = new ArrayList<>();
		landlordList.add(landlord);
		LandlordDAOImplementation implement = new LandlordDAOImplementation();
		List<Landlord> actualList = implement.getAllLandlords(con);
		assertEquals(landlordList, actualList);
	}

	@Test
	void testGetLandlord() throws SQLException {
		Connection con = createMockConnection();
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
				.buildingNumberOfStories(5).rent(1234).builder();
		LandlordDAOImplementation implement = new LandlordDAOImplementation();
		assertEquals(landlord, implement.getLandlord(con, 1));

		
	}

	@Test
	void testAddLandlord() throws SQLException {
		//setup
		Connection con = mock(Connection.class);
		PreparedStatement ps = mock(PreparedStatement.class);
		when(con.prepareStatement(anyString())).thenReturn(ps);
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
				.buildingNumberOfStories(5).rent(1234).builder();

		
		//test
		LandlordDAOImplementation implement = new LandlordDAOImplementation();
		implement.addLandlord(con, landlord);
		
		//verification
		 ArgumentCaptor<Integer> indexCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<Integer> stringCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<String> valueStringCapture = ArgumentCaptor.forClass(String.class);
		   verify(ps, times(4)).setInt(indexCapture.capture(), valueIntCapture.capture());
		   verify(ps).setString(stringCapture.capture(), valueStringCapture.capture());
	       verify(ps).execute();
		   assertEquals(1, indexCapture.getAllValues().get(0));
		   assertEquals(1, valueIntCapture.getAllValues().get(0));
		   assertEquals(2, stringCapture.getAllValues().get(0));
		   assertEquals("Ranee", valueStringCapture.getAllValues().get(0));

	       
	}

	@Test
	void testUpdateLandlord() throws SQLException {
		//setup
				Connection con = mock(Connection.class);
				PreparedStatement ps = mock(PreparedStatement.class);
				when(con.prepareStatement(anyString())).thenReturn(ps);
				Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
						.buildingNumberOfStories(5).rent(1234).builder();

				
				//test
				LandlordDAOImplementation implement = new LandlordDAOImplementation();
				implement.updateLandlord(con, landlord);
				
				//verification
				 ArgumentCaptor<Integer> indexCapture = ArgumentCaptor.forClass(Integer.class);
			       ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor.forClass(Integer.class);
			       ArgumentCaptor<Integer> stringCapture = ArgumentCaptor.forClass(Integer.class);
			       ArgumentCaptor<String> valueStringCapture = ArgumentCaptor.forClass(String.class);
				   verify(ps, times(4)).setInt(indexCapture.capture(), valueIntCapture.capture());
				   verify(ps).setString(stringCapture.capture(), valueStringCapture.capture());
			       verify(ps).execute();
				   assertEquals(1, stringCapture.getAllValues().get(0));
				   assertEquals("Ranee", valueStringCapture.getAllValues().get(0));
				   assertEquals(2, indexCapture.getAllValues().get(0));
				   assertEquals(559, valueIntCapture.getAllValues().get(0));
	}

	@Test
	void testDeleteLandlord() throws SQLException {
		//setup
		Connection con = mock(Connection.class);
		PreparedStatement ps = mock(PreparedStatement.class);
		when(con.prepareStatement(anyString())).thenReturn(ps);
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
				.buildingNumberOfStories(5).rent(1234).builder();

		
		//test
		LandlordDAOImplementation implement = new LandlordDAOImplementation();
		implement.deleteLandlord(con, 1);
		
		//verification
		 ArgumentCaptor<Integer> indexCapture = ArgumentCaptor.forClass(Integer.class);
	       ArgumentCaptor<Integer> valueIntCapture = ArgumentCaptor.forClass(Integer.class);
		   verify(ps).setInt(indexCapture.capture(), valueIntCapture.capture());
	       verify(ps).execute();
		   assertEquals(1, indexCapture.getAllValues().get(0));
		   assertEquals(1, valueIntCapture.getAllValues().get(0));
	}

}
