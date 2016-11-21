package main.java.com.stw.lib.manager;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.stw.constant.GConstant;


public class ApplicationFilter implements Serializable, Filter
{
  private static final long serialVersionUID = 1L;

  private void initStwSession(HttpSession session)
  {
    StwSession stwSession = (StwSession) session.getAttribute(GConstant.ATTR_STWSSESSION);
    stwSession = stwSession == null ? new StwSession() : stwSession;
    session.setAttribute(GConstant.ATTR_STWSSESSION, stwSession);
  }

  private void redirectHomePage(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException
  {
    httpResponse.sendRedirect(httpRequest.getContextPath() + GConstant.VIEW_INDEX_PAGE);
  }

  @Override
  public void destroy()
  {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
  {
    if (request instanceof HttpServletRequest && response instanceof HttpServletResponse)
    {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      HttpSession session = httpRequest.getSession(false);

      if (session == null || session.isNew())
      {
        this.redirectHomePage(httpRequest, httpResponse);
      }
      else
      {
        if (httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER))
        {

   	    	httpResponse.setHeader("Cache-Control", "max-age=14400, public");
        	httpResponse.setDateHeader("Expires", System.currentTimeMillis() + 604800000L);
      	  }

        this.initStwSession(session);
        chain.doFilter(request, response);
      }
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException
  {

  }

}
