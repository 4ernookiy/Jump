package jmp.training.facade.db;

import org.h2.tools.Server;
import org.h2.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by d4 on 14.08.2016.
 */
public final class InstanceH2 {
    private final static Logger logger = LoggerFactory.getLogger(InstanceH2.class);
    private static volatile Server server;

    public static Server getInstanceH2(){
        return server;
    }

        public static void startH2(Properties properties){
        try {
            if (server == null) {
                String driver = properties.getProperty("jdbc.driverClassName");
                String url = properties.getProperty("jdbc.url");
                String user = properties.getProperty("jdbc.username");
                String password = properties.getProperty("jdbc.password");

                server = Server.createTcpServer("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1").start();
                logger.info(server.getURL());
                Connection conn = JdbcUtils.getConnection(driver, url, user, password);


//                Statement statement = conn.createStatement();
//                String sql = properties.getProperty("sql.test.1");
//                logger.info("create table:{}",statement.execute(sql));
//                Server.
//                server = Server.startWebServer(conn);
//                System.out.println(conn);


//                logger.info("h2 has ran: {}",server.getURL());
//                logger.info("port:{}",server.getPort());
//                logger.info("url:{}",server.getURL());
            }
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    public static void stopH2(){
        if (server != null) {
            server.stop();
            server.shutdown();
            logger.info("h2 has stopped");
        }
    }
}
