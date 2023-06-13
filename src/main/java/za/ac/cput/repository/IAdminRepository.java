//Admin Repository Interface
//Author: Chenique Jacobs (220388172)
//Date: 07/04/2023
package za.ac.cput.repository;

import za.ac.cput.domain.Admin;

import java.util.Set;

public interface IAdminRepository extends IRepository<Admin, String> {
    Admin read(int adminId);

    abstract boolean delete(String adminId);

    public Set<Admin> getAll();
}
