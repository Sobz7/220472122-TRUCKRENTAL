package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {
@Test
    public void createAdmin(){
    Admin admin = AdminFactory.createAdmin(001,"Jordy", "Meye","jordymeye@gmail.com" );
    assertNotNull(admin);
    System.out.println(admin);
}
}