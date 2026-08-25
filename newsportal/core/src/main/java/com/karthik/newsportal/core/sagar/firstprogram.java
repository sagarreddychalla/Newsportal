package com.karthik.newsportal.core.sagar;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = firstprogram.class, immediate = true)
public class firstprogram {
	private static final Logger log = LoggerFactory.getLogger(firstprogram.class);
	
	@Activate
	public void active(){
		log.info("Ongole -- Activated");	
		}

	@Deactivate
	public void deactive(){
		log.info("Bulls -- Deactivated");

	}

	@Modified
	public void update(){

		log.info("Are no1 -- Modified");
	}
}
