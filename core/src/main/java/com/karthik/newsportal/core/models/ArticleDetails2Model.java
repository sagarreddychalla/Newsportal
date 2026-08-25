package com.karthik.newsportal.core.models;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
resourceType = "/newsportal/components/Article-details2",
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(extensions = "json" ,name = "jackson")
public class ArticleDetails2Model {

	@ValueMapValue
    public String text;

    @ValueMapValue
    public String textarea;

    @ValueMapValue
    public String image;

    @ValueMapValue
    public Date dob;

  
    
    public String getText() {
		return text;
	}


	public String getTextarea() {
		return textarea;
	}


	public String getImage() {
		return image;
	}


	public Date getDob() {
		return dob;
	}

	private boolean articleExpired = false;

    public boolean isArticleExpired() {
		return articleExpired;
	}
    
     
	
	public List<RelatedArticleImpModel> getCompositeField() {
		return compositeField;
	}

	@ChildResource
    List<RelatedArticleImpModel> compositeField;
    
	@PostConstruct
    public void init() {
    	Date today = new Date();
    	if(dob != null && dob.compareTo(today)<0) {
    		articleExpired = true;
    		
    	}
    		
}  
}

