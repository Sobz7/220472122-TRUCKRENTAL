package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Location;

public class LocationFactoryTest {

    @Test
    public void createLocation(){

        Location location = LocationFactory.createLocation(667,"Cape Town", "Plein Street" );

        System.out.println(location);
    }
}


