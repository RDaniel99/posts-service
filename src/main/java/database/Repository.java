package database;

public interface Repository<T> {

    T create(T object);
    T read(Integer id);
    T update(T object);
    boolean delete(Integer id);
}
