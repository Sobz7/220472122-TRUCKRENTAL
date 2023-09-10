package za.ac.cput.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import za.ac.cput.domain.Brand;
import za.ac.cput.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService service;

    @Autowired
    public BrandController(BrandService service) {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<Brand> save(@RequestBody Brand brand)
    {
        Brand brandRecord = null;
        try {
            brandRecord = service.create(brandRecord);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(brandRecord);
    }

    @GetMapping("read/{brandId}")
    public ResponseEntity<Brand> read(@PathVariable String brandId)
    {
        Brand brandRecord = service.read(brandId);
        return ResponseEntity.ok(brandRecord);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Brand>> findAll(@PathVariable String brandId)
    {
        List<Brand> brandRecord = service.getAll();
        return ResponseEntity.ok(brandRecord);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Brand brand)
    {
        service.delete(String.valueOf(brand.getBrandId())); 
        return ResponseEntity.noContent().build();
    }

}
