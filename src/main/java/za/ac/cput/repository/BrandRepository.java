package za.ac.cput.repository;
/*Author Ayanda Phumzile Khoza
Student Number 218057172
 */
import org.apache.commons.beanutils.LazyDynaClass;
import za.ac.cput.domain.Brand;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BrandRepository implements IBrandRepository {

    private static BrandRepository repository = null;

    private Set<Brand> brandDB = null;

    private <brand> BrandRepository() {
        brandDB = (Set<Brand>) new HashSet<brand>();
    }

    public static BrandRepository getRepository() {
        if (repository == null) {
            repository = new BrandRepository();
        }
        return repository;
    }

    @Override
    public Brand read() {
        return null;
    }

    //CRUD Operation
    @Override
    public Brand create(Brand brand) {

        LazyDynaClass BrandDB;
        boolean success = brandDB.add(brand);
        if (!success)
            return null;
        return brand;
    }

    @Override
    public Brand read(String BrandId) {
        for (Brand e : brandDB) {
            Object brandId = null;
            if (Objects.equals(e.getBrandId(), null))
                return e;
        }
        return null;

    }

    @Override

    public Brand update(Brand brand){

    Brand oldBrand = read(String.valueOf(brand.getBrandId()));
    if(oldBrand !=null)

    {
        brandDB.remove(oldBrand);
        brandDB.add(brand);
        return brand;
    }
      return null;

   }

   @Override
   public boolean delete(){return false;
   }

      public boolean delete(String brandId)
     {
    Brand brandToDelete = read(brandId);
    if(brandToDelete == null)
        return false;
    brandDB.remove(brandToDelete);
    return true;
       }

       @Override
      public Set<Brand> getAll()
       {
         return brandDB;
       }
}

