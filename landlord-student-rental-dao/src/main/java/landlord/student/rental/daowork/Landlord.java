package landlord.student.rental.daowork;

import java.util.Objects;

import landlord.student.rental.daowork.Tenant.TenantBuilder;

/**
 * @author Alexandru The primary purpose behind this class is to act as a data
 *         object for the Landlord
 *
 */
public class Landlord {

	private final int landlordId;
	private final String buildingName;
	private final int buildingNumberOfRooms;
	private final int buildingNumberOfStories;
	private final int rent;

	/**
	 * This is the general constructor for the Landlord class
	 * 
	 * @param landlordBuilder We use a builder object as a parameter here
	 */
	public Landlord(LandlordBuilder landlordBuilder) {
		this.landlordId = landlordBuilder.landlordId;
		this.buildingName = landlordBuilder.buildingName;
		this.buildingNumberOfRooms = landlordBuilder.buildingNumberOfRooms;
		this.buildingNumberOfStories = landlordBuilder.buildingNumberOfStories;
		this.rent = landlordBuilder.rent;

	}

	/**
	 * A getter method getting the Landlord ID
	 * 
	 * @return the ID of the landlord
	 */

	public int getLandlordId() {
		return landlordId;
	}

	/**
	 * A getter method getting the name of the building
	 * 
	 * @return the name of the building
	 */

	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * A getter method
	 * 
	 * @return the ID of the landlord
	 */

	public int getBuildingNumberOfRooms() {
		return buildingNumberOfRooms;
	}

	/**
	 * A getter method getting the amount of stories that the building has
	 * 
	 * @return the amount of stories for the building
	 */

	public int getBuildingNumberOfStories() {
		return buildingNumberOfStories;
	}

	/**
	 * A getter method getting the rent that the building complex charges per month
	 * 
	 * @return the rent
	 */

	public int getRent() {
		return rent;
	}

	/**
	 * A simple toString method outputting all of the content of the data object
	 */

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", buildingName=" + buildingName + ", buildingNumberOfRooms="
				+ buildingNumberOfRooms + ", buildingNumberOfStories=" + buildingNumberOfStories + ", rent=" + rent
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(buildingName, buildingNumberOfRooms, buildingNumberOfStories, landlordId, rent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Landlord other = (Landlord) obj;
		return Objects.equals(buildingName, other.buildingName) && buildingNumberOfRooms == other.buildingNumberOfRooms
				&& buildingNumberOfStories == other.buildingNumberOfStories && landlordId == other.landlordId
				&& rent == other.rent;
	}

	/**
	 *
	 * @author Alexandru Here is our builder object. This way, we can make our new
	 *         class while simultaneously keeping the object immutable
	 */
	public static class LandlordBuilder {
		private int landlordId;
		private String buildingName;
		private int buildingNumberOfRooms;
		private int buildingNumberOfStories;
		private int rent;

		/**
		 * This is the basic constructor of the LandlordBuilder object
		 * 
		 * @param landlordId the ID of the landlord object
		 */
		public LandlordBuilder(int landlordId) {
			this.landlordId = landlordId;
		}

		/**
		 * 
		 * @param lord The Landlord that you want to build
		 * @return
		 */
		public LandlordBuilder landlord(Landlord lord) {
			this.landlordId = lord.landlordId;
			this.buildingName = lord.buildingName;
			this.buildingNumberOfRooms = lord.buildingNumberOfRooms;
			this.buildingNumberOfStories = lord.buildingNumberOfStories;
			this.rent = lord.rent;
			return this;
		}

		public LandlordBuilder buildingName(String buildingName) {
			this.buildingName = buildingName;
			return this;
		}

		public LandlordBuilder buildingNumberOfRooms(int buildingNumberOfRooms) {
			this.buildingNumberOfRooms = buildingNumberOfRooms;
			return this;
		}

		public LandlordBuilder buildingNumberOfStories(int buildingNumberOfStories) {
			this.buildingNumberOfStories = buildingNumberOfStories;
			return this;
		}

		public LandlordBuilder rent(int rent) {
			this.rent = rent;
			return this;
		}

		/**
		 * This builds a new Landlord object when the method is called
		 * 
		 * @return
		 */

		public Landlord builder() {
			return new Landlord(this);
		}
	}

}
