package za.ac.cput.util;

import org.apache.commons.validator.EmailValidator;

import java.util.Random;
import java.util.UUID;

public class Helper {


    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullorEmpty(String s){
        return (s== null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static boolean isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }


    public static long generaterandomId(){
        Random random = new Random();
        long randomLog = random.nextLong();
        return Math.abs(randomLog);

    }


}
