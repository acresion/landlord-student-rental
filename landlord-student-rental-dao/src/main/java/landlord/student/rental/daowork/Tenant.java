package landlord.student.rental.daowork;

import java.util.Objects;

public class Tenant {
	private final int tenantId;
	private final String firstName;
	private final String lastName;
	private final String addressBeforeMovein;
	private final String cityBeforeMovein;
	private final String stateBeforeMovein;
	private final String countryBeforeMovein;
	private final int yearOfBirth;
	private final int monthOfBirth;
	private final int dayOfBirth;
	private final int room;
	private final int floor;
	private final int landlordId;
	public Tenant(TenantBuilder tenantBuilder) {
		this.tenantId = tenantBuilder.tenantId;
		this.firstName = Objects.requireNonNull(tenantBuilder.firstName, "firstName can not be null");
		this.lastName = Objects.requireNonNull(tenantBuilder.lastName, "lastName can not be null");
		this.addressBeforeMovein = tenantBuilder.addressBeforeMovein;
		this.cityBeforeMovein = tenantBuilder.cityBeforeMovein;
		this.stateBeforeMovein = tenantBuilder.stateBeforeMovein;
		this.countryBeforeMovein = tenantBuilder.countryBeforeMovein;
		this.yearOfBirth = tenantBuilder.yearOfBirth;
		this.monthOfBirth = tenantBuilder.monthOfBirth;
		this.dayOfBirth = tenantBuilder.dayOfBirth;
		this.room = tenantBuilder.room;
		this.floor = tenantBuilder.floor;
		this.landlordId = tenantBuilder.landlordId;
	}
	
	
	
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addressBeforeMovein=" + addressBeforeMovein + ", cityBeforeMovein=" + cityBeforeMovein
				+ ", stateBeforeMovein=" + stateBeforeMovein + ", countryBeforeMovein=" + countryBeforeMovein
				+ ", yearOfBirth=" + yearOfBirth + ", monthOfBirth=" + monthOfBirth + ", dayOfBirth=" + dayOfBirth
				+ ", room=" + room + ", floor=" + floor + ", landlordId=" + landlordId + "]";
	}



	public int getTenantId() {
		return tenantId;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getAddressBeforeMovein() {
		return addressBeforeMovein;
	}



	public String getCityBeforeMovein() {
		return cityBeforeMovein;
	}



	public String getStateBeforeMovein() {
		return stateBeforeMovein;
	}



	public String getCountryBeforeMovein() {
		return countryBeforeMovein;
	}



	public int getYearOfBirth() {
		return yearOfBirth;
	}



	public int getMonthOfBirth() {
		return monthOfBirth;
	}



	public int getDayOfBirth() {
		return dayOfBirth;
	}

	public int getRoom() {
		return room;
	}

	public int getFloor() {
		return floor;
	}

	public int getLandlordId() {
		return landlordId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(addressBeforeMovein, cityBeforeMovein, countryBeforeMovein, dayOfBirth, firstName, floor,
				landlordId, lastName, monthOfBirth, room, stateBeforeMovein, tenantId, yearOfBirth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tenant other = (Tenant) obj;
		return Objects.equals(addressBeforeMovein, other.addressBeforeMovein)
				&& Objects.equals(cityBeforeMovein, other.cityBeforeMovein)
				&& Objects.equals(countryBeforeMovein, other.countryBeforeMovein) && dayOfBirth == other.dayOfBirth
				&& Objects.equals(firstName, other.firstName) && floor == other.floor && landlordId == other.landlordId
				&& Objects.equals(lastName, other.lastName) && monthOfBirth == other.monthOfBirth && room == other.room
				&& Objects.equals(stateBeforeMovein, other.stateBeforeMovein) && tenantId == other.tenantId
				&& yearOfBirth == other.yearOfBirth;
	}


	public static class TenantBuilder {
		private  int tenantId;
		private  String firstName;
		private  String lastName;
		private  String addressBeforeMovein;
		private  String cityBeforeMovein;
		private  String stateBeforeMovein;
		private  String countryBeforeMovein;
		private  int yearOfBirth;
		private  int monthOfBirth;
		private  int dayOfBirth;
		private  int room;
		private  int floor;
		private  int landlordId;
		
		public TenantBuilder(int tenantId) {
			this.tenantId = tenantId;
		}
		public TenantBuilder tenant (Tenant tenant) {
			this.tenantId = tenant.tenantId;
			this.firstName = tenant.firstName;
			this.lastName = tenant.lastName;
			this.addressBeforeMovein = tenant.addressBeforeMovein;
			this.cityBeforeMovein = tenant.cityBeforeMovein;
			this.stateBeforeMovein = tenant.stateBeforeMovein;
			this.countryBeforeMovein = tenant.countryBeforeMovein;
			this.yearOfBirth = tenant.yearOfBirth;
			this.monthOfBirth = tenant.monthOfBirth;
			this.dayOfBirth = tenant.dayOfBirth;
			this.room = tenant.room;
			this.floor = tenant.floor;
			this.landlordId = tenant.landlordId;
			return this;

		}
		public TenantBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public TenantBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public TenantBuilder addressBeforeMovein(String addressBeforeMovein) {
			this.addressBeforeMovein = addressBeforeMovein;
			return this;
		}
		public TenantBuilder cityBeforeMovein(String cityBeforeMovein) {
			this.cityBeforeMovein = cityBeforeMovein;
			return this;
		}
		public TenantBuilder stateBeforeMovein(String stateBeforeMovein) {
			this.stateBeforeMovein = stateBeforeMovein;
			return this;
		}
		public TenantBuilder countryBeforeMovein(String countryBeforeMovein) {
			this.countryBeforeMovein = countryBeforeMovein;
			return this;
		}
		public TenantBuilder yearOfBirth(int yearOfBirth) {
			this.yearOfBirth = yearOfBirth;
			return this;
		}
		public TenantBuilder monthOfBirth(int monthOfBirth) {
			this.monthOfBirth = monthOfBirth;
			return this;
		}
		public TenantBuilder dayOfBirth(int dayOfBirth) {
			this.dayOfBirth = dayOfBirth;
			return this;
		}
		public TenantBuilder room(int room) {
			this.room = room;
			return this;
		}
		public TenantBuilder floor(int floor) {
			this.floor = floor;
			return this;
		}
		public TenantBuilder landlordId(int landlordId) {
			this.landlordId = landlordId;
			return this;
		}
		public Tenant build() {
			return new Tenant(this);
		}
		
	}






	

}
