package database;

public interface Repository<T> {

    T create(T object);
    T read(String id);
    T update(T object);
    boolean delete(String id);
}
