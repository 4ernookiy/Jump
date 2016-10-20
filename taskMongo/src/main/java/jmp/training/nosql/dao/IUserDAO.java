package jmp.training.nosql.dao;

import jmp.training.nosql.entity.User;

/**
 * Created by d4 on 18.10.2016.
 */
public interface IUserDAO extends IDAO<User>{
    User findByName(String firstName, String lastName);

}
