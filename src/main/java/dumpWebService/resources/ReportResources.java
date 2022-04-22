package dumpWebService.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import dumpWebService.entity.Report;


@Path("/")
public class ReportResources {
	private static final Logger logger = LoggerFactory.getLogger(ReportResources.class);

	

	@GET
	@Path("reportTypes")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Report> reportTypeList() {
		List<Report> reports = new ArrayList<Report>();
		logger.info("here");
		Report report = new Report();
		report.setId("1");
		report.setName("report1");
		reports.add(report);
		
				
		return reports;
	}
	
}
