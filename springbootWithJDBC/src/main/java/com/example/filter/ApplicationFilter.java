package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(ApplicationFilter.class);
	@Override
	public void destroy()
	{
		System.out.println("Resource destory");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long before =System.currentTimeMillis();
		try
		{
			Base.open("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/web","root","Nareshkumar@02");
			Base.openTransaction();
			chain.doFilter(request, response);
			Base.commitTransaction();
		}
		catch(IOException | ServletException e)
		{
			Base.rollbackTransaction();
			throw e;
		}
		finally
		{
			Base.close();
		}
		
		logger.info("processing took: {} milliseconds",System.currentTimeMillis() - before);
		
	}
	@Override
	public  void init(FilterConfig arg0)throws ServletException
	{
		System.out.println("Resource opened");
	}

}
