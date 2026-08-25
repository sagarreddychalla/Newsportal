package com.karthik.newsportal.core.sagar;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import java.util.*;



@Component(service = SagarScheduled.class)
public class SagarScheduled{
	
	@Reference
	ResourceResolverFactory factory;
	
	public ResourceResolver getResourceResolver() {
		ResourceResolver resolver = null;
		
		try {
			
			Map<String,Object> prop = new HashMap();
			prop.put(ResourceResolverFactory.SUBSERVICE, "eHandler");
			resolver = factory.getServiceResourceResolver(prop);
		}
		catch(org.apache.sling.api.resource.LoginException e) {
			e.printStackTrace();
			
		}
		
		
		return resolver;
	}

}
