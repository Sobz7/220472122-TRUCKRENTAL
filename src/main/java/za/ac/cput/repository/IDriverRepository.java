/*
IDriverRepository.java
1st interface
@Author: Siyakha Manisi (219239657)
09 April 2023
* */

package za.ac.cput.repository;

import za.ac.cput.domain.Driver;

import java.util.Set;

public interface IDriverRepository extends IRepository<Driver, String> {
        public Set<Driver> getAll();

    }

