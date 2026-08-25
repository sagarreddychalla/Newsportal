package com.karthik.newsportal.core.schedulers;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.*;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.karthik.newsportal.core.sagar.SagarScheduled;

import java.util.Date;
import java.util.Iterator;

import javax.jcr.Session;
//@Component(immediate = true, service = Runnable.class, property = { "scheduler.expression = */5 * * ? * * " })
public class TestScheduled implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(TestScheduled.class);

    @Reference
    SagarScheduled karthik;

    @Reference
    Replicator replicator;

    @Override
    public void run() {
   
        log.info("I am Inside the Sling schedulers...--Malyadri");

        try (ResourceResolver resolver = karthik.getResourceResolver()) {
            PageManager pagemanager = resolver.adaptTo(PageManager.class);
            Page articlepage = pagemanager.getPage("/content/newsportal/us/en/article-details");
            Iterator<Page> childpages = articlepage.listChildren();
            while (childpages.hasNext()) {
                Page page = (Page) childpages.next();
                Resource contentResource = page.getContentResource();
                ValueMap properties = contentResource.getValueMap();
                Date articleExpiry = properties.get("articleExpiry", Date.class);
                Date today = new Date();
                if (articleExpiry != null && articleExpiry.compareTo(today) < 0) {
                    Session session = resolver.adaptTo(Session.class);
                    replicator.replicate(session, ReplicationActionType.DEACTIVATE, page.getPath());
                } 

            } 
        }

        catch (ReplicationException e) {
            e.printStackTrace();
        } 
    }

}



