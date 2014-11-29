package controller;

import model.eMark;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import services.DataForClient;
import services.GameServices;
import services.GamesManager;

@Path("/game")
public class GameController 
{	
	@GET
	@Path("/status")
	public Response getGameStatus(@QueryParam("gameId") int gameId)
	{
		DataForClient dataForClient = GameServices.tryToGetGameStatus(gameId);
		Response responseForClient = generateResponseForClient(dataForClient);
		return responseForClient;
	}

	@POST
	@Path("/init")
	@Produces(MediaType.APPLICATION_JSON)
	public Response initGame(@FormParam("name") String name,@FormParam("gameId") int gameId)
	{	
		DataForClient dataForClient = GameServices.tryToInitGame(name,gameId);
		Response responseForClient = generateResponseForClient(dataForClient);
		return responseForClient;
	}
	
	@POST
	@Path("/join")
	@Produces(MediaType.APPLICATION_JSON)
	public Response joinGame(@FormParam("name") String name,@FormParam("gameId") int gameId)

	{
		DataForClient dataForClient = GameServices.tryToJoinGame(name,gameId);
		Response responseForClient = generateResponseForClient(dataForClient);
		return responseForClient;
	}
	
	@POST
	@Path("/turn")
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeTurn(@FormParam("name") String name,@FormParam("gameId") int gameId,@FormParam("value") int value)
	{
		eMark markToDraw = GamesManager.getPlayerByName(name).getCurrentMarkToDraw();
		DataForClient dataForClient = GameServices.tryToExecuteTurn(gameId,markToDraw,value);
		Response responseForClient = generateResponseForClient(dataForClient);
		return responseForClient;
	}
	
	private Response generateResponseForClient(Object obj) 
	{
		Gson gson = new Gson(); 
		String json = gson.toJson(obj); 
		return Response.status(200).entity(json).build();
	}
}
