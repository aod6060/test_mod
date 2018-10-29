package com.derf.test;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Logger {
	private static org.apache.logging.log4j.Logger logger;
	
	public static void create(org.apache.logging.log4j.Logger logger)
	{
		Logger.logger = logger;
	}
	
	public static org.apache.logging.log4j.Logger getLogger()
	{
		return Logger.logger;
	}
}
