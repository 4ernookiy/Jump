package jmp.training.facade.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import jmp.training.facade.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ManageDB.
 */
public final class ManageDB {

	/** The log. */
	private final static Logger logger = LoggerFactory.getLogger(App.class);

	/**
	 * Instantiates a new mange base db.
	 */
	private ManageDB() {
	}

	/**
	 * Gets the connection.
	 * @return the connection
	 */
	public static Connection getConnection(Properties properties) throws SQLException {
		String driver = properties.getProperty("jdbc.driverClassName");
		String url = properties.getProperty("jdbc.url");
		String user = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
//		return DriverManager.getConnection(url, properties);
		 return DriverManager.getConnection(url, user, password);
	}

	/**
	 * Close connection.
	 * @param dbConnection
	 *            the db connection
	 */
	public static void closeResource(Connection dbConnection) {
		try {
			if (dbConnection != null) {
				if (!dbConnection.getAutoCommit()) {
					try {
						dbConnection.commit();
					} catch (SQLException e) {
						throw new SQLException(e);
					}
				}
				dbConnection.close();
			}
		} catch (SQLException e) {
			logger.error("Can't close connection. {}", e.getMessage());
		}
	}

	/**
	 * Close resource.
	 * @param rs
	 *            the rs
	 */
	public static void closeResource(ResultSet... rs) {
		for (ResultSet r : rs) {
			try {
				if (r != null) {
					r.close();
				}
			} catch (SQLException e) {
				logger.error("ResultSet cannot be closed", e);
			}
		}
	}

	/**
	 * Close resource.
	 * @param st
	 *            the st
	 */
	public static void closeResource(Statement... st) {
		for (Statement s : st) {
			try {
				if (s != null) {
					s.close();
				}
			} catch (SQLException e) {
				logger.error("Statement cannot be closed", e);
			}
		}
	}

}
