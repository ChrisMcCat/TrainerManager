package rest;

import service.EventService;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/action")
public class Tracking {

	@Inject
	private EventService eventService;

	@POST
	@Path("event")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNewActionFromJson(JsonObject json) {
		String ip = json.getString("ip");
		String type = json.getString("type");
		String link = json.getString("link");
		String time = json.getString("time");
		eventService.addEvent(ip, type, link, time);
	}

	@GET
	@Path("logs")
	@Produces(MediaType.TEXT_PLAIN)
	public String printLast20() {
		return "Last20Logs";
	}
}
