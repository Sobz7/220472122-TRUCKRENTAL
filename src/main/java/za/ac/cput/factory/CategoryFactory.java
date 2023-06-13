package za.ac.cput.factory;
import za.ac.cput.domain.Category;
import za.ac.cput.util.Helper;
public class CategoryFactory {
    public static Category createCategory ( String categoryId,  String description, int truckSize,String truckType) {
        if (Helper.isNullorEmpty(description)|| Helper.isNullorEmpty(truckType))
            return null;

        return new Category. Builder ()
                .setCategoryId(categoryId)
                . setDescription (description)
                .setTruckSize(truckSize)
                .setTruckType(truckType)
                . build() ;
    }
}
