package jmp.training.facade;

import jmp.training.facade.config.ConfigException;
import jmp.training.facade.config.LoadConfig;
import jmp.training.facade.db.ManageDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by d4 on 14.08.2016.
 */
public class FacadeConnectionImpl implements FacadeConnection {
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    private Properties p;

    @Override
    public Connection get() throws SQLException {
        try {
            // step 1 - load config
            if (p == null) {
                p = LoadConfig.getConfig("/jdbc.properties");
            }
            // step 2 - get connection
            Connection conn = ManageDB.getConnection(p);
            logger.info("get connection {}", conn);
            return conn;
        } catch (SQLException | ConfigException e) {
            throw new SQLException(e);
        }
    }
}
