package jmp.training.nosql.converter;

import org.bson.Document;

import java.util.Collection;

/**
 * Created by Dzmitry_Charnavoki on 10/20/2016.
 */
public interface Converter<T> {

    Document toDocument(T t);

    T toObject(Document doc);

    default void appendField(Document doc, String field, Object obj) {
        if (null != obj) {
            if (obj instanceof Collection){
                Collection col = Collection.class.cast(obj);
                if (col.size() != 0) {
                    doc.append(field, obj);
                }
            } else if (!(obj instanceof Collection)) {
                doc.append(field, obj);
            }
        }
    }

}
