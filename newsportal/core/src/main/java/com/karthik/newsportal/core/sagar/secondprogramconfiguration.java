package com.karthik.newsportal.core.sagar;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition

public @interface secondprogramconfiguration {
	@AttributeDefinition(name = "secondprogram URL Path", description ="This is a sample URL path" )
	public String restAPIurl() default "https://gorest.co.in/public/v2/posts";
}
