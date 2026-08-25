package com.karthik.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {Resource.class})
public class RelatedArticleImpModel {

	@ValueMapValue
	public String textcomp;
	
	@ValueMapValue
	public String numcomp;

	public String getTextcomp() {
		return textcomp;
	}

	public String getNumcomp() {
		return numcomp;
	}
	 
}
