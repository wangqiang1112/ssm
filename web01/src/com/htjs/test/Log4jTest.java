package com.htjs.test;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Log4jTest {
	static Logger log = Logger.getLogger(Log4jTest.class.getName());

	public static void main(String[] args)throws IOException,SQLException{
		//PropertyConfigurator.configure("D:\\code\\javaPro\\web01\\src\\log4j.properties");
		log.debug("Hello this is an debug message");
		log.info("Hello this is an info message");
		log.warn("Hello this is an WARN message");
	}

}
