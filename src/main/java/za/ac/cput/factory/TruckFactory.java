package za.ac.cput.factory;
import za.ac.cput.domain.Truck;
import za.ac.cput.util.Helper;
public class TruckFactory {
    public static Truck createTruck(String truckId, String model, int year, boolean availability, String licensePlate, double currentMileage, int brandId) {
        if (Helper.isNullorEmpty(model)|| Helper.isNullorEmpty(licensePlate))
            return null;
        return new Truck.Builder()
                .setTruckId(truckId)
                .setModel(model)
                .setYear(year)
                .setLicensePlate(licensePlate)
                .setCurrentMileage(currentMileage)
                .setBrandId(brandId)
                .build();
    }
}
