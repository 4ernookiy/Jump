package jmp.training.facade.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jmp.training.facade.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class LoadConfig.
 */
public final class LoadConfig {

	private static Properties PROPERTIES;
	/** The config property file. */
	private static final String CONFIG_PROPERTY_FILE = "/config.property";

	/** The Constant EXT_XML. */
	private static final String EXT_XML = ".xml".toUpperCase();

	/** The Constant EXT_PROPERTY. */
	private static final String EXT_PROPERTY = ".properties".toUpperCase();

	/** The Constant LOG. */
	private final static Logger logger = LoggerFactory.getLogger(App.class);

	/**
	 * Instantiates a new load config.
	 */
	private LoadConfig() {
		super();

	}

	/**
	 * Gets the config.
	 *
	 * @param file the file
	 * @return the config
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties getConfig(String file) throws ConfigException {
		if (PROPERTIES != null) {
			return PROPERTIES;
		}
		Properties properties = new Properties();
		try {
			InputStream is = LoadConfig.class.getResourceAsStream(file);
			if (is == null) {
				throw new FileNotFoundException("file not found:" + file);
			}
			if (file.toUpperCase().endsWith(EXT_PROPERTY.toUpperCase())) {
				properties.load(is);
			} else if (file.toUpperCase().endsWith(EXT_XML.toUpperCase())) {
				properties.loadFromXML(is);
			} else {
				throw new IllegalArgumentException(
						"incorrect extension of file");
			}
			is.close();
			PROPERTIES = properties;
//			properties.clear();
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
			throw new ConfigException(e);
		}
		return PROPERTIES;
	}

	/**
	 * Gets the config.
	 *
	 * @return the config
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties getConfig() throws ConfigException {
		return getConfig(CONFIG_PROPERTY_FILE);
	}
}
