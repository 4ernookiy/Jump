package jmp.training.nosql.converter;

import jmp.training.nosql.entity.Adress;
import org.bson.Document;

/**
 * Created by d4 on 18.10.2016.
 */
public class AdressConverter implements Converter<Adress> {

    public Document toDocument(Adress adress) {
        Document doc = new Document();
        appendField(doc, "city", adress.getCity());
        appendField(doc, "zip", adress.getZip());
        appendField(doc, "street", adress.getStreet());
        return doc;
    }

    @Override
    public Adress toObject(Document doc) {
        Adress obj = new Adress();
        obj.setCity((String) doc.get("city"));
        obj.setZip((String) doc.get("zip"));
        obj.setStreet((String) doc.get("street"));
        return obj;
    }


}
