package servlets;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter (urlPatterns = "/*")
public class TimeFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		long x = System.nanoTime();
		chain.doFilter(req, resp);
		
		long diffX = System.nanoTime() - x;
		System.out.println("Time taken = " + diffX + "Nano Secs.");
		
	}

}
