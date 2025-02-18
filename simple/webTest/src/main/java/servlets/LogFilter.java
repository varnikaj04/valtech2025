package servlets;

import java.io.IOException;
import java.text.MessageFormat;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String method = request.getMethod();
		String url = request.getRequestURI();
		String message = MessageFormat.format("Received Request for {0} from {1}", method,url);
		System.out.println(message);
		chain.doFilter(request, res);
	}

	
}
