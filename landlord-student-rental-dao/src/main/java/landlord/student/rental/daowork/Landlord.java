package landlord.student.rental.daowork;

import landlord.student.rental.daowork.Tenant.TenantBuilder;
/**
 * 
 *
 */
public class Landlord {
	

	
	private final int landlordId;
	private final String buildingName;
	private final int buildingNumberOfRooms;
	private final int buildingNumberOfStories;
	private final int rent;
	
	public Landlord(LandlordBuilder landlordBuilder) {
		this.landlordId = landlordBuilder.landlordId;
		this.buildingName = landlordBuilder.buildingName;
		this.buildingNumberOfRooms = landlordBuilder.buildingNumberOfRooms;
		this.buildingNumberOfStories = landlordBuilder.buildingNumberOfStories;
		this.rent = landlordBuilder.rent;

		
	}
	
	
	public int getLandlordId() {
		return landlordId;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public int getBuildingNumberOfRooms() {
		return buildingNumberOfRooms;
	}


	public int getBuildingNumberOfStories() {
		return buildingNumberOfStories;
	}


	public int getRent() {
		return rent;
	}


	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", buildingName=" + buildingName + ", buildingNumberOfRooms="
				+ buildingNumberOfRooms + ", buildingNumberOfStories=" + buildingNumberOfStories + ", rent=" + rent
				+ "]";
	}


	public static class LandlordBuilder{
		private  int landlordId;
		private  String buildingName;
		private  int buildingNumberOfRooms;
		private  int buildingNumberOfStories;
		private  int rent;
		
		public LandlordBuilder(int landlordId) {
			this.landlordId = landlordId;
		}
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
		
		public  Landlord builder() {
			return new Landlord(this);
		}
	} 

} 
