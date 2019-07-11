package com.antonelli.restjersey;

/**
 * Web Service that returns the day of week passing a full date (day, month, year).
 * @author antonelli
 */

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.GET;

@Path("/xmldowservice")
public class XMLDayOfWeekService {
	 
		@GET
		@Produces("application/xml")
		public String informDayOfWeek(){
	 
			String dayOfWeek = DayOfWeek.dayOfWeek(1, 1, 1970);
			String result = dayOfWeek;
			return "<xmldowservice>" 
							+ "<date>" + "1-1-1970" + "</date>" 
							+ "<dayofweek>" + result + "</dayofweek>" 
							+ "</xmldowservice>";
		}
		
		@Path("{d}")
		@GET
		@Produces("application/xml")
		public String informDayOfWeekWithParam(@PathParam("d") String d){
	 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

			LocalDate localDate = LocalDate.parse(d, formatter);
			
			String dayOfWeek = DayOfWeek.dayOfWeek(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
			String result = dayOfWeek;
			return "<xmldowservice>" 
							+ "<date>" + d + "</date>" 
							+ "<dayofweek>" + result + "</dayofweek>" 
							+ "</xmldowservice>";
		}
}
