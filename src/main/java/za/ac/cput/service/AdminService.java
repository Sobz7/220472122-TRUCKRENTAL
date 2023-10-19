//Admin Service Interface
//Author: Chenique Jacobs (220388172)
//Date: 13/06/2023
package za.ac.cput.service;

import za.ac.cput.domain.Admin;

import java.util.Set;

public interface AdminService extends IService<Admin, String>{
    public Set<Admin> getAll();
}


