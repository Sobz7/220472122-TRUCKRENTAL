package za.ac.cput.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.repository.IBrandRepository;
import za.ac.cput.service.BrandService;
import za.ac.cput.service.IService;

public class BrandServiceImpl implements BrandService {

    private IBrandRepository brandRepository;
    
    @Autowired
    public BrandServiceImpl(IBrandRepository brandRepository) 
    {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(
            BrandFactory.createBrand(
                brand.getBrandId(), 
                brand.getBrandName(), 
                brand.getModel(), 
                brand.getColor())
        );
    }

    @Override
    public Brand read(String id) {
        return brandRepository.findById(id).get();
    }

    @Override
    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Boolean delete(String id) {
        brandRepository.delete(read(id));
        return true;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}