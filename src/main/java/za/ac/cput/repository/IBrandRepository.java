package za.ac.cput.repository;
/*Author Ayanda Phumzile Khoza
Student Number 218057172
 */

import za.ac.cput.domain.Brand;

import java.util.Set;

public interface IBrandRepository extends IRepository<Brand, String>
{

    Brand read();

    Brand read(String brandId);
    
    default boolean delete(String brandId){
        return false;
    }
    
    public Set<Brand>getAll = null;

    Set<Brand> getAll();


    //CRUD Operation
    //Brand create(Brand brand);

    

    //Brand update(Brand brand)

    //abstract boolean delete();

    
}
