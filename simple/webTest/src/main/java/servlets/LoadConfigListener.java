package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Properties p = new Properties();
		
		System.out.println("First Piece of code that will be executed ...");
		System.out.println("Loading... Config... Done...");
		System.out.println("Creating database Connection Pools ....");
		ServletContext application = sce.getServletContext();
		
		try(InputStream input = application.getResourceAsStream("/WEB-INF/config.properties")){
			if(input == null) {
				throw new RuntimeException("file not found");
			}
			p.load(input);
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String driver = p.getProperty("driver");
			
			Class.forName(driver);
			application.setAttribute("url", url);
			application.setAttribute("username", username);
			application.setAttribute("password", password);
			
		} catch(IOException | ClassNotFoundException e) {
			throw new RuntimeException("Database connection failed: " +e.getMessage(), e);
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all Database connections in the connection pools...");
	}

}
