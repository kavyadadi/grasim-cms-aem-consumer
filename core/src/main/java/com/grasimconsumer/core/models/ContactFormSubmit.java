package com.grasimconsumer.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { Resource.class,
        SlingHttpServletRequest.class }, adapters = ContactFormSubmit.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactFormSubmit {

    private static final Logger LOG = LoggerFactory.getLogger(ContactFormSubmit.class);

    @Getter
    @ValueMapValue(name="callCenterLabel")
    private String callCenterLabel;



    @Getter
    @ValueMapValue(name="callCenterURL")
    private String callCenterURL;

    @Getter
    @ValueMapValue(name="goToHomepageLabel")
    private String goToHomepageLabel;

    @Getter
    @ValueMapValue(name="goToHomepageURL")
    private String goToHomepageURL;


}
