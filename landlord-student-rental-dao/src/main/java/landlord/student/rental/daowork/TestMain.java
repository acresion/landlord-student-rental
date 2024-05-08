package landlord.student.rental.daowork;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.*;

public class TestMain {

  public static void main(String[] args) throws SQLException {
    TenantFacade tenantFacade = new TenantFacade();
    List<Tenant> allTenants = tenantFacade.getAllTenants();
    for (Tenant tenant : allTenants) {
      System.out.println(tenant.getFirstName());
      System.out.println(tenant.getLastName());
    }
    Logger logger = Logger.getLogger(Tenant.class.getCanonicalName());

    Tenant tena = allTenants.get(0);
    System.out.println(tena.hashCode());

    logger.log(Level.INFO, tena.toString());

  }
}
