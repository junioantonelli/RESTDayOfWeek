package com.antonelli.restjersey;

/**
 * Web Service that returns the day of week passing a full date (day, month, year).
 * @author antonelli
 */

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.json.JSONException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.GET;

@Path("/jsondowservice")
public class JSONDayOfWeekService {
	 
		@GET
		@Produces("application/json")
		public Response informDayOfWeek() throws JSONException {
	 
			String dayOfWeek = DayOfWeek.dayOfWeek(1, 1, 1970);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Date: ", "1-1-1970");
			jsonObject.put("Day of Week: ", dayOfWeek);
	 
			String result = jsonObject.toString();
			return Response.status(200).entity(result).build();
		}
		
		@Path("{d}")
		@GET
		@Produces("application/json")
		public Response informDayOfWeekWithParam(@PathParam("d") String d) throws JSONException {
	 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
			LocalDate localDate = LocalDate.parse(d, formatter);
			String dayOfWeek = DayOfWeek.dayOfWeek(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Date: ", d);
			jsonObject.put("Day of Week", dayOfWeek);
	 
			String result = jsonObject.toString();
			return Response.status(200).entity(result).build();
		}
	}
