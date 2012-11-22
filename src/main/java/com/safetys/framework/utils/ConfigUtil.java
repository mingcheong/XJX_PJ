package com.safetys.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigUtil {
	private static Properties getEnv() throws Exception {
		Properties prop = new Properties();
		String OS = System.getProperty("os.name").toLowerCase();
		Process p = null;
		if (OS.indexOf("windows") > -1) {
			p = Runtime.getRuntime().exec("cmd /c set");
		} else {
			p = Runtime.getRuntime().exec("env");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = br.readLine()) != null) {
			int i;
			if ((i = line.indexOf("=")) > -1) {
				String key = line.substring(0, i);

				String value = line.substring(i + 1);

				prop.setProperty(key, value);
			}
		}
		return prop;
	}

	@SuppressWarnings("unused")
    private static String getProjectConfigHome() {
		String projectConfigHome;
		if ((projectConfigHome = System.getProperty("PROJECT_CONFIG_HOME")) == null) try {
			Properties env;
			projectConfigHome = (env = getEnv()).getProperty("PROJECT_CONFIG_HOME");
		} catch (Exception e) {
			throw new RuntimeException("Get \"PROJECT_CONFIG_HOME\" occur error by Env");
		}
		if (projectConfigHome == null) { throw new RuntimeException("The system property \"PROJECT_CONFIG_HOME\" was not found!"); }
		return projectConfigHome;
	}

	public static Properties getProperties(String serviceName) {
		Properties props = new Properties();
		String configPath;
		if (((configPath = getProjectConfigHome()) == null) || (configPath.length() == 0)) throw new RuntimeException("The system property \"PROJECT_CONFIG_HOME\" was not found!");
		File file;
		if (!(file = new File(configPath + "/" + serviceName + ".properties")).exists()) { throw new RuntimeException("Config file \"" + file + "\" not exists!"); }
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Config file \"" + file + "\" not exists!");
		} catch (IOException e) {
			throw new RuntimeException("Load file \"" + file + "\" failed!", e);
		}
		return props;
	}

	public static String getGlobalPropertyValue(String propertyName) {
		return getProperties("global").getProperty(propertyName);
	}
}