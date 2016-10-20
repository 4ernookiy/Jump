package jmp.training.nosql.entity;

import org.bson.types.ObjectId;

/**
 * Created by Dzmitry_Charnavoki on 10/20/2016.
 */
public class BaseEntity
{
    protected ObjectId id;

    private Long version;

    public BaseEntity() {
        super();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
