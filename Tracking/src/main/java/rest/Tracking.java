package rest;

import service.EventService;
import util.JsonHelper;

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
	public JsonObject createNewActionFromJson(JsonObject json) {
		String time = json.getString("time");
		eventService.addEvent(time);
		return JsonHelper.toJson("time", time);
	}

	@GET
	@Path("logs")
	@Produces(MediaType.TEXT_PLAIN)
	public String printLast20() {
		return "Last20Logs";
	}
}
