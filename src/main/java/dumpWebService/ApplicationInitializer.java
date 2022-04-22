package dumpWebService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * #%L
 * elab4-backend
 * =======
 * Copyright (C) 2011 - 2019 Huygens ING
 * =======
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//https://stackoverflow.com/questions/23277429/java-lang-abstractmethoderror-javax-ws-rs-core-uribuilder-uri/26767488
public class ApplicationInitializer implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);
	public static String Log4JPath = null;
	public ApplicationInitializer() {
		
		System.setProperty("application.starttime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		logger.info("initializer constructor");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//initApp();
		logger.info("initializing context");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("destroying context");
	}
	public static String getLog4JPath() {
		return Log4JPath;
	}

	public  void setLog4JPath(String log4jPath) {
		Log4JPath = log4jPath;
	}

	public  Properties getApplicationProperties() {
		

		InputStream inputStream = null;
		Properties applicationProp = null;
		try {
			inputStream = new FileInputStream(new File("./resources/application.properties"));
			applicationProp = new Properties();
			applicationProp.load(inputStream);
			inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return applicationProp;
	}

	public  void initApp() {
		Properties applicationProperties = getApplicationProperties();
		setLog4JPath(applicationProperties.getProperty("LOG4J_PATH"));
		loadLog4j();
	}

	private  void loadLog4j() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		context.setConfigLocation(new File(getLog4JPath()).toURI());
	}

}