package jmp.training.nosql.converter;

import org.bson.Document;

/**
 * Created by Dzmitry_Charnavoki on 10/20/2016.
 */
public interface Converter<T>
{
    Document toDocument(T t);
    T toObject(Document doc);
}
