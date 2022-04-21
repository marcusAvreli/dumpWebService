package dumpWebService.jaxrs.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;





public class FilterFactory implements ResourceFilterFactory {	
	private static final Logger logger = LoggerFactory.getLogger(FilterFactory.class);
	@Override
	public List<ResourceFilter> create(AbstractMethod am) {	
		List<ResourceFilter> singletonList = Lists.newArrayList();
		singletonList.add(new LoggingResourceFilter());	
		return singletonList;
	}

	

}