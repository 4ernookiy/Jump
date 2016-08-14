package jmp.training.facade;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by d4 on 14.08.2016.
 */
public interface FacadeConnection {

    Connection get() throws SQLException;
}
