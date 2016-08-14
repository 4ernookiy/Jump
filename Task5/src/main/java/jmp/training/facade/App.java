package jmp.training.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class App {
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {

            FacadeConnection facade = new FacadeConnectionImpl();
            FacadeTest test = new FacadeTestImpl();
            Connection connection = facade.get();
            test.testOne(connection);

            logger.info("more connection!");
            facade.get();

        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }

    }
}
