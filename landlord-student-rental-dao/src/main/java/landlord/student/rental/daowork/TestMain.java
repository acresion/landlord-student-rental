package landlord.student.rental.daowork;

import java.sql.SQLException;
import java.util.List;

public class TestMain {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		TenantFacade tenantFacade = new TenantFacade();
		List<Tenant> allTenants = tenantFacade.getAllTenants();
		for(Tenant tenant: allTenants) {
			System.out.println(tenant.getFirstName());
			System.out.println(tenant.getLastName());
		}
	}

}
