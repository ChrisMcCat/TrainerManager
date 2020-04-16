package rest;

import service.ActionService;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sonar")
public class Sonar {

	@Inject
	private ActionService actionService;

	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createNewActionFromJson(JsonObject json) {
		String time = json.getString("time");
		actionService.addAction(time);
	}

}
