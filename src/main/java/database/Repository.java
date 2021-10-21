package database;

public interface Repository<T, K> {

    // TODO: schimbat numele la metode
    T createT(T object);
    T readT(String id);
    T updateT(T object);
    boolean deleteT(String id);

    K createK(K object);
    K readK(String id);
    K updateK(K object);
    boolean deleteK(String id);
}
