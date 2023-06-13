package za.ac.cput.factory;
/*Author Ayanda Phumzile Khoza
Student Number 218057172
 */

import za.ac.cput.domain.Brand;
import za.ac.cput.util.Helper;

public class BrandFactory {

    public static Brand createBrand(int brandId,String brandName, String model, String color){

        if(Helper.isNullorEmpty(String.valueOf(brandId)) || Helper.isNullorEmpty(brandName))
            return null;

        return new Brand.Builder()
                .setBrandId(brandId)
                .setBrandName(brandName)
                .setModel(model)
                .setColor(color)
                .build();

    }
}
