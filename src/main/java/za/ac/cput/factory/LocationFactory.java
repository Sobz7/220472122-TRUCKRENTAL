package za.ac.cput.factory;
/*Author Ayanda Phumzile Khoza
 Student Number 218057172
 */
import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

public class LocationFactory {

    public static Location createLocation(int locationId,String locationName,String address){

        if(Helper.isNullorEmpty(String.valueOf(locationId)) || Helper.isNullorEmpty(locationName))
        return null;

        return new Location.Builder()
             .setLocationId(locationId)
             .setLocationName(locationName)
             .setAddress(address)
             .build();
    }
}
