package jmp.training.facade;

import jmp.training.facade.db.ManageDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by d4 on 15.08.2016.
 */
public class FacadeTestImpl implements FacadeTest {
    private final static Logger logger = LoggerFactory.getLogger(FacadeTestImpl.class);

    @Override
    public void testOne(Connection connection) {
        try (Statement stmt = connection.createStatement()) {

            //stmt.executeUpdate( "DROP TABLE table1" );
            stmt.executeUpdate("CREATE TABLE table1 ( user varchar(50) )");
            stmt.executeUpdate("INSERT INTO table1 ( user ) VALUES ( 'Dima' )");
            stmt.executeUpdate("INSERT INTO table1 ( user ) VALUES ( 'Aleh' )");

            ResultSet rs = stmt.executeQuery("SELECT * FROM table1");
            while (rs.next()) {
                String name = rs.getString("user");
                logger.info("loaded from db:{}", name);
            }
            ManageDB.closeResource(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
