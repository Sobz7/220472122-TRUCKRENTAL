package za.ac.cput.service;

import java.util.List;

import za.ac.cput.domain.Brand;

public interface BrandService extends IService<Brand, String>{
    List<Brand> getAll();
}
