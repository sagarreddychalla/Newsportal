package com.karthik.newsportal.core.servlets;

	import java.io.IOException;

	import javax.servlet.Servlet;
	import javax.servlet.ServletException;

	import org.apache.sling.api.SlingHttpServletRequest;
	import org.apache.sling.api.SlingHttpServletResponse;
	import org.apache.sling.api.servlets.SlingAllMethodsServlet;
	import org.apache.sling.servlets.annotations.SlingServletPaths;
	import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
	import org.osgi.service.component.annotations.Component;


	@Component(service = Servlet.class , immediate = true)
//	@SlingServletPaths(value = {"/bin/newsportal/service/sagar"})
	@SlingServletResourceTypes(resourceTypes = { "newsportal/karthik/practiceServ" })
	public class SagarServlet extends SlingAllMethodsServlet{

		
		@Override	
		protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response)
				throws ServletException, IOException {
			response.getWriter().write("Response from Resource sagarServlet -- GET");
		}
		
		@Override
		protected void doPost(SlingHttpServletRequest request,SlingHttpServletResponse response)
				throws ServletException, IOException {
			response.getWriter().write("Response from Resource sagarServlet -- POST");
		}
		
		@Override
		protected void doPut(SlingHttpServletRequest request,SlingHttpServletResponse response)
				throws ServletException, IOException {
			response.getWriter().write("Response from Resource sagarServlet -- PUT");
		}
		
		@Override
		protected void doDelete(SlingHttpServletRequest request,SlingHttpServletResponse response)
				throws ServletException, IOException {
			response.getWriter().write("Response from Resource sagarServlet -- DELETE");
		}

	}

