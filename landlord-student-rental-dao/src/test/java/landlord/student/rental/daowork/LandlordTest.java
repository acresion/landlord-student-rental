package landlord.student.rental.daowork;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import landlord.student.rental.daowork.Landlord.LandlordBuilder;

class LandlordTest {


	@Test
	void testGetLandlordId() {
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("ranneed").buildingNumberOfRooms(550)
				.buildingNumberOfStories(23).rent(1230).builder();
		assertEquals(1, landlord.getLandlordId());
	}

	@ParameterizedTest
	@ValueSource(strings = { "Envie", "Ranee", "Nampaso", "Patrica" })
	void testGetBuildingName(String testValue) {
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName(testValue).buildingNumberOfRooms(550)
				.buildingNumberOfStories(23).rent(1230).builder();
		assertEquals(testValue, landlord.getBuildingName());

	}

	@ParameterizedTest
	@ValueSource(ints = { 550,223,3245,324 })
	void testGetBuildingNumberOfRooms(int testValue) {
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(testValue)
				.buildingNumberOfStories(23).rent(1230).builder();
		assertEquals(testValue, landlord.getBuildingNumberOfRooms());
	}

	@ParameterizedTest
	@ValueSource(ints = { 550,223,3245,324 })
	void testGetBuildingNumberOfStories(int testValue) {
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
				.buildingNumberOfStories(testValue).rent(1234).builder();
		assertEquals(testValue, landlord.getBuildingNumberOfStories());	
		}

	@ParameterizedTest
	@ValueSource(ints = { 550,223,3245,324 })
	void testGetRent(int testValue) {
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("Ranee").buildingNumberOfRooms(559)
				.buildingNumberOfStories(23).rent(testValue).builder();
		assertEquals(testValue, landlord.getRent());		
		}

	@Test
	void testToString() {
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("ranneed").buildingNumberOfRooms(550)
				.buildingNumberOfStories(23).rent(1230).builder();
		String landString = "Landlord [landlordId=1, buildingName=ranneed, buildingNumberOfRooms=550, buildingNumberOfStories=23, rent=1230]";
		assertEquals(landString, landlord.toString());
	}



	

}
