package landlord.student.rental.daowork;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import landlord.student.rental.daowork.Tenant.TenantBuilder;

class TenantTest {

	@ParameterizedTest
	@ValueSource(strings = { "Aloc", "Mater", "Banban", "Patrica" })
	void firstNameTest(String maLongDick) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName(maLongDick).lastName("Albon").addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		assertEquals(maLongDick, newTenant.getFirstName());
	}

	@ParameterizedTest
	@ValueSource(strings = { "Nam", "tonagoa", "Asnken", "fdsfasdf" })
	void lastNameTest(String maLongDick) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName(maLongDick).addressBeforeMovein(null)
				.cityBeforeMovein("Paris").stateBeforeMovein(null).countryBeforeMovein("France").yearOfBirth(1995)
				.monthOfBirth(12).dayOfBirth(3).room(503).floor(5).landlordId(1).build();
		assertEquals(maLongDick, newTenant.getLastName());

	}

	@Test
	void testNull() {
		TenantBuilder tenantBuilder = new Tenant.TenantBuilder(1).firstName("Alex").lastName(null)
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5)
				.landlordId(1);
		assertThrows(NullPointerException.class, () -> {
			tenantBuilder.build();
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "188 Pingas Road", "Yonge Street", "1 Metropolitain Area", "pdpspdapdsadfjsdf" })
	void addressBeforeMoveInTest(String maLongDick) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(maLongDick).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5)
				.landlordId(1).build();
		assertEquals(maLongDick, newTenant.getAddressBeforeMovein());

	}

	@ParameterizedTest
	@ValueSource(strings = { "Paris", "Amsterdam", "Kabul", "pdpspdapdsadfjsdf" })
	void cityBeforeMoveInTest(String maLongDick) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein(maLongDick).stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5)
				.landlordId(1).build();
		assertEquals(maLongDick, newTenant.getCityBeforeMovein());

	}

	@ParameterizedTest
	@ValueSource(strings = { "Arkansas", "New York", "Ontario" })
	void stateBeforeMoveInTest(String maLongDick) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(maLongDick)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5)
				.landlordId(1).build();
		assertEquals(maLongDick, newTenant.getStateBeforeMovein());

	}

	@ParameterizedTest
	@ValueSource(strings = { "France", "Belarus", "Azerbaijan" })
	void countryBeforeMoveInTest(String maLongDick) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein(maLongDick).yearOfBirth(1995).monthOfBirth(12).dayOfBirth(3).room(503).floor(5)
				.landlordId(1).build();
		assertEquals(maLongDick, newTenant.getCountryBeforeMovein());

	}

	@ParameterizedTest
	@ValueSource(ints = { 1192, 2, 0 })
	void yearOfBirthTest(int testValue) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(testValue).monthOfBirth(12).dayOfBirth(3).room(503).floor(5)
				.landlordId(1).build();
		assertEquals(testValue, newTenant.getYearOfBirth());

	}

	@ParameterizedTest
	@ValueSource(ints = { 12, 2, 10 })
	void monthOfBirthTest(int testValue) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(testValue).dayOfBirth(3).room(503)
				.floor(5).landlordId(1).build();
		assertEquals(testValue, newTenant.getMonthOfBirth());

	}

	@ParameterizedTest
	@ValueSource(ints = { 12, 31 })
	void dayOfBirthTest(int testValue) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(testValue).room(503)
				.floor(5).landlordId(1).build();
		assertEquals(testValue, newTenant.getDayOfBirth());

	}

	@ParameterizedTest
	@ValueSource(ints = { 122, 311 })
	void roomTest(int testValue) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(testValue)
				.floor(5).landlordId(1).build();
		assertEquals(testValue, newTenant.getRoom());

	}

	@ParameterizedTest
	@ValueSource(ints = { 122, 311 })
	void rentTest(int testValue) {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44)
				.floor(testValue).landlordId(1).build();
		assertEquals(testValue, newTenant.getFloor());

	}

	@Test
	void landlordIdTest() {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1).build();
		assertEquals(1, newTenant.getLandlordId());

	}
	@Test
	void constructorTest() {
		TenantBuilder newTenantBuilder = new TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1);
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1).build();
		assertEquals(newTenant, newTenantBuilder.tenant(newTenant).build());

	}
	
	@Test
	void testHashCode() throws SQLException {
		TenantFacade tenantFacade = new TenantFacade();
		List<Tenant> allTenants = tenantFacade.getAllTenants();
		Tenant tena = allTenants.get(0);
		assertEquals(-2024043057, tena.hashCode());
		
	}

	@Test
	void testIfEquals() {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1).build();
		assertTrue(newTenant.equals(newTenant));
	}
	@Test
	void testifNull() {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1).build();
		assertFalse(newTenant.equals(null));
	}
	@Test
	void testForDifferentClass() {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1).build();
		Landlord landlord = new Landlord.LandlordBuilder(1).buildingName("ranneed").buildingNumberOfRooms(550)
				.buildingNumberOfStories(23).rent(1230).builder();
		assertFalse(newTenant.equals(landlord));
		
	}
	@Test
	void testToString() {
		Tenant newTenant = new Tenant.TenantBuilder(1).firstName("Alex").lastName("Petrangelo")
				.addressBeforeMovein(null).cityBeforeMovein("Paris").stateBeforeMovein(null)
				.countryBeforeMovein("France").yearOfBirth(1995).monthOfBirth(12).dayOfBirth(23).room(44).floor(1)
				.landlordId(1).build();
		String testString = "Tenant [tenantId=1, firstName=Alex, lastName=Petrangelo, addressBeforeMovein=null, cityBeforeMovein=Paris, stateBeforeMovein=null, countryBeforeMovein=France, yearOfBirth=1995, monthOfBirth=12, dayOfBirth=23, room=44, floor=1, landlordId=1]";
		assertEquals(testString, newTenant.toString());
	}
	

	}



