package com.grasimconsumer.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, adapters = ContactUsFormArticles.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ContactUsFormArticles {



	private static final Logger LOG = LoggerFactory.getLogger(ContactUsFormArticles.class);


	@Getter
	@ValueMapValue(name="ctaLabel")
	private String ctaLabel;



	@Getter
	@ValueMapValue(name="ctaURL")
	private String ctaURL;

	@Getter
	@ValueMapValue(name="submitCTALabel")
	private String submitCTALabel;

	@Getter
	@ValueMapValue(name="submitCTAURL")
	private String submitCTAURL;

	@Getter
	@ValueMapValue(name="commentsLabel")
	private String commentsLabel;

	@Getter
	@ValueMapValue(name="commentsPlaceHolder")
	private String commentsPlaceHolder;

	@Getter
	@ValueMapValue(name="commentsName")
	private String commentsName;

	@Getter
	@ValueMapValue(name="text")
	private String text;



	@Getter
	@ValueMapValue(name="text2")
	private String text2;


	@ChildResource(name="contactUsFormItems")
	Resource contactUsFormItem;

	List<Map<String, String>> contactUsFormItems=new ArrayList<>();

	public List<Map<String, String>> getContactUsFormItems() {
		List<Map<String, String>> contactDetailsMap=new ArrayList<>();
		try {
		//	Resource bookDetail=componentResource.getChild("contactUsFormItems");
			if(contactUsFormItem!=null){
				for (Resource book : contactUsFormItem.getChildren()) {
					Map<String,String> bookMap=new HashMap<>();
					bookMap.put("fieldTitle",book.getValueMap().get("fieldTitle",String.class));
					bookMap.put("name",book.getValueMap().get("name",String.class));
					bookMap.put("placeHolder",book.getValueMap().get("placeHolder",String.class));
					contactDetailsMap.add(bookMap);
				}
			}
		}catch (Exception e){
			LOG.info("\n ERROR while getting Book Details {} ",e.getMessage());
		}
		LOG.info("\n SIZE {} ",contactDetailsMap.size());
		return contactDetailsMap;
	}

}

