/*
ILoginDetailRepositoru.java
2nd Interface
@Author: Siyakha Manisi (219239657)
09 April 2023
* */

package za.ac.cput.repository;

import za.ac.cput.domain.LoginDetail;

import java.util.Set;

public interface ILoginDetailRepository extends IRepository<LoginDetail, String> {
        public Set<LoginDetail> getAll();
}
