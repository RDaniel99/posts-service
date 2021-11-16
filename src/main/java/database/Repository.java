package database;

public interface Repository<T> {

    T create(T object);
    T read(Integer id);
    T update(T originalObject, T newObject);
    boolean delete(Integer id);
}
