package com.stackroute.movieservice.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) servletRequest;	
		HttpServletResponse response=(HttpServletResponse) servletResponse;	
		String authHeader=request.getHeader("Authorization");
		if("OPTIONS".equals(request.getMethod()))
		{
			response.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(request, response);
		}
		else
		{
			if((authHeader==null)||!authHeader.startsWith("Bearer "))
				throw new ServletException("Missing header or invalid authorization header");

		}
		String token=authHeader.substring(7);
		final Claims claims=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
		request.setAttribute("claims", claims);
		chain.doFilter(request, response);
		
	}

}
