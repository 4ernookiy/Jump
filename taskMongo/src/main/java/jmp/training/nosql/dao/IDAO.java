package jmp.training.nosql.dao;

import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by d4 on 20.10.2016.
 */
public interface IDAO<T> {
    T findOne(ObjectId id);
    List<T> findLimit(int limit);
    T insert(T t);
    T update(T t);
    void remove(ObjectId id);

}
