package rest;

import service.EventService;
import util.JsonHelper;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tracking")
public class Tracking {

	@Inject
	private EventService eventService;

	@POST
	@Path("event")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject createNewActionFromJson(JsonObject json) {
		String ip = json.getString("ip");
		String type = json.getString("type");
		String link = json.getString("link");
		String time = json.getString("time");
		long id = eventService.addEvent(ip, type, link, time);
		return JsonHelper.toJson("id", id);
	}

	@GET
	@Path("logs")
	@Produces(MediaType.TEXT_PLAIN)
	public String printLast20() {
		return "Last20Logs";
	}
}
