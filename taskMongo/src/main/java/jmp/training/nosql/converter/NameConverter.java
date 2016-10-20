package jmp.training.nosql.converter;

import jmp.training.nosql.entity.Name;
import org.bson.Document;

/**
 * Created by d4 on 18.10.2016.
 */
public class NameConverter implements Converter<Name> {

    public Document toDocument(Name name) {
        if (null == name) {
            return null;
        }
        Document doc = new Document();
        appendField(doc, "first", name.getFirst());
        appendField(doc, "last", name.getLast());
        return doc;
    }

    @Override
    public Name toObject(Document doc) {
        Name name = new Name();
        name.setFirst((String) doc.get("first"));
        name.setLast((String) doc.get("last"));
        return name;
    }


}
