//Return Truck Respository interface
//Author: Chenique Jacobs (220388172)
//Date: 07/04/2023
package za.ac.cput.repository;

import za.ac.cput.domain.ReturnTruck;

import java.util.Set;

public interface IReturnTruckRepository extends IRepository<ReturnTruck, String> {
    ReturnTruck read(int returnId);

    boolean delete(int returnId);

    public Set<ReturnTruck> getAll();
}
