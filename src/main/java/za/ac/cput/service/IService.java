package za.ac.cput.service;

public interface IService <S, ID> {

    S create(S t);
    S read(ID id);
    S update(S s);
    boolean delete();
}
