package dumpWebService.jaxrs.filters;

/*
 * #%L
 * elab4-backend
 * =======
 * Copyright (C) 2011 - 2019 Huygens ING
 * =======
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;



class LoggingResourceFilter implements ResourceFilter, ContainerRequestFilter, ContainerResponseFilter {

	private static final Logger logger = LoggerFactory.getLogger(FilterFactory.class);
	@Override
	public ContainerRequestFilter getRequestFilter() {		
		return this;
	}

	@Override
	public ContainerRequest filter(ContainerRequest request) {		
		return request;
	}

	@Override
	public ContainerResponseFilter getResponseFilter() {	
		return this;
	}

	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
	
	
	
		return response;
	}
	

	/*private String commonLogLine(ContainerRequest request, ContainerResponse response) {
		// 127.0.0.1 user-identifier frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326
		return MessageFormat.format(//
				"{0} {1} {2} [{3}] \"{4} /{5} {6}\" {7} {8}", //
				"?", //
				// req.getRemoteAddr(),//
				"-", //
				"?", //
				// req.getRemoteUser(),//
				"test",
				//new DateTime().toString("dd/MMM/yyyy:HH:mm:ss ZZ"), //
				request.getMethod(), //
				request.getPath(), //
				"?", //
				// req.getProtocol(),//
				response.getStatus(), //
				"?"//
		);
	}*/

}