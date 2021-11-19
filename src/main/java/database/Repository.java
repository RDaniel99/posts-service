package database;

import exceptions.CrudException;

public interface Repository<T> {

    T create(T object);
    T read(Integer id);
    T update(T originalObject, T newObject) throws CrudException;
    boolean delete(Integer id);
}
