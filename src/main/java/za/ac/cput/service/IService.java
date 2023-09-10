//Domain  Customer class
// Pojo Customer
// Author: Jordy Meye (220072841)
// Date: 10 06 2023

package za.ac.cput.service;

<<<<<<< HEAD
public interface IService  <T, ID> {
=======
public interface IService<T, ID> {
>>>>>>> 76685f55c2dfca669fefd840bee826eb1458435e

    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);


}