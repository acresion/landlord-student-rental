package landlord.student.rental;

import javax.servlet.http.HttpServletRequest;

import landlord.student.rental.daowork.Tenant;
import landlord.student.rental.daowork.TenantFacade;

public class AddTenantRequestMapper {

  public Tenant map(HttpServletRequest request) {
    int tenantId = Integer.parseInt(request.getParameter("tenant_id"));
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    String addressBeforeMovein = request.getParameter("address_before_movein");
    String cityBeforeMovein = request.getParameter("city_before_movein");
    String stateBeforeMovein = request.getParameter("state_before_movein");
    String countryBeforeMovein = request.getParameter("country_before_movein");
    int yearOfBirth = Integer.parseInt(request.getParameter("year_of_birth"));
    int monthOfBirth = Integer.parseInt(request.getParameter("month_of_birth"));
    int dayOfBirth = Integer.parseInt(request.getParameter("day_of_birth"));
    int room = Integer.parseInt(request.getParameter("room"));
    int floor = Integer.parseInt(request.getParameter("floor"));
    int landlordId = Integer.parseInt(request.getParameter("landlord_id"));
    return new Tenant.TenantBuilder(tenantId).firstName(firstName).lastName(lastName)
        .addressBeforeMovein(addressBeforeMovein).cityBeforeMovein(cityBeforeMovein)
        .stateBeforeMovein(stateBeforeMovein).countryBeforeMovein(countryBeforeMovein).yearOfBirth(yearOfBirth)
        .monthOfBirth(monthOfBirth).dayOfBirth(dayOfBirth).room(room).floor(floor).landlordId(landlordId).build();

  }
}
