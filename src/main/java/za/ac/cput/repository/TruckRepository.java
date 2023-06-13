package za.ac.cput.repository;

import za.ac.cput.domain.Truck;

import java.util.HashSet;
import java.util.Set;

public abstract class TruckRepository implements ITruckRepository {
    private static TruckRepository respository = null;
    private Set<Truck> truckDB = null;

    private TruckRepository() {
        truckDB = new HashSet<Truck>();
    }

    public static TruckRepository getRespository() {
        if (respository == null) {
            respository = new TruckRepository() {
                @Override
                public boolean delete() {
                    return false;
                }
            };
        }
        return respository;
    }


    @Override
    public Truck create(Truck truck) {
        boolean success = truckDB.add(truck);
        if (!success)
            return null;
        return truck;
    }

    @Override
    public Truck read(String truckId) {
        for (Truck e : truckDB) {
            if (e.getTruckId().equals(truckId))
                return e;
        }

        return null;
    }

    @Override
    public Truck update(Truck truck) {
        Truck oldTruck = read(truck.getTruckId());
        if (oldTruck != null) {
            truckDB.remove(oldTruck);
            truckDB.add(truck);
            return truck;
        }

        return null;
    }
    @Override
    public boolean delete(String truckId) {
        Truck truckToDelete = read(truckId);
        if (truckToDelete == null)
            return false;
        truckDB.remove(truckToDelete);
        return true;
    }


    @Override
    public Set<Truck> getAll(){
        return  truckDB;
}


}
