/*
LoginDetailFactory.java
2nd Factory Class
@Author: Siyakha Manisi (219239657)
09 April 2023
* */

package za.ac.cput.factory;

import za.ac.cput.domain.LoginDetail;
import za.ac.cput.util.Helper;

public class LoginDetailFactory {
    public static LoginDetail createLoginDetail(String username, String password)
    {
        if(Helper.isNullorEmpty(username) || Helper.isNullorEmpty(password))
        {
            return null;
        }

        LoginDetail ld = new LoginDetail.Builder().setUsername(username)
                .setPassword(password)
                .build();
        return ld;

    }

}
