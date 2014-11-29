package services;

import model.Game;
import model.Player;
import model.eMark;

public class GameServices
{
	public static DataForClient tryToGetGameStatus(int gameId) 
	{
		DataForClient dataForClient = new DataForClient();
		Game game = GamesManager.getGameById(gameId);
		if(game == null)
		{
			dataForClient.setMessageForClient("There is no game #" + gameId);
			dataForClient.setExecutionSuccessfullyPassed(false);
		}
		else
		{
			dataForClient.setGame(game);
		}
		return dataForClient;
	}
	
	public static DataForClient tryToInitGame(String name, int gameId) 
	{
		DataForClient dataForClient = new DataForClient();
		String message;
		boolean isExecutionPassOrFail = false;
		Game game = GamesManager.addGame(gameId);
		Player player = GamesManager.addPlayerIfRequired(name);
		if(game != null)
		{
			exectuteInit(player);
			message = "Hi " + name + ". You have initialized game#" + gameId;
			isExecutionPassOrFail = true;
		}
		else
		{
			message = "Hi " + name + ". Game#" + gameId + " already exists";
		}
		dataForClient.setDataForClient(isExecutionPassOrFail, message, game);
		return dataForClient;
	}
	
	public static DataForClient tryToJoinGame(String name, int gameId) 
	{
		DataForClient dataForClient = new DataForClient();
		String message;
		boolean isExecutionPassOrFail = false;
		Game game = GamesManager.getGameById(gameId);
		Player player = GamesManager.addPlayerIfRequired(name);

		if(game != null)
		{
			if(game.isAvailable())
			{
				exectuteJoin(game,player);
				message = "Hi " + name + ". You joined game#" + gameId;
				isExecutionPassOrFail = true;
			}
			else
			{
				message = "Hi " + name + ". Game#" + gameId + " is not available";
			}
		}
		else
		{
			message = "Hi " + name + ". There is no game#" + gameId;
		}
		dataForClient.setDataForClient(isExecutionPassOrFail,message, game);
		return dataForClient;
	}

	public static DataForClient tryToExecuteTurn(int gameId,eMark mark,int value) 
	{
		DataForClient dataForClient = new DataForClient();
		String message = null;
		boolean isExecutionPassOrFail = false;
		
		Game game = GamesManager.getGameById(gameId);
		if(game != null)
		{
			if(!game.isOver())
			{
				message = "This game is over";
			}
			if(! game.getNextMark().equals(mark))
			{
				message = "It is not your turn. Wait for your turn";
			}
			else if(!game.getTable()[value].equals(eMark.EMPTY))
			{
				message = "This cell is already used";
			}
			else
			{
				game.exectuteTurn(mark, value);
				isExecutionPassOrFail = true;
				message = "You have drawn " + mark + " successfully ;)";
				if(game.checkVictoryAndUpdateGameStatus())
				{
					message += "\nYou win the game!!!";
				}
			}
		}
		else
		{
			message = "There is no game#" + gameId;
		}
		dataForClient.setDataForClient(isExecutionPassOrFail, message, game);
		return dataForClient;
	}
	
	private static void exectuteInit(Player player) 
	{
		player.setCurrentMarkToDraw(eMark.X);
		player.setAvailable(false);
	}
	
	private static void exectuteJoin(Game game, Player player) 
	{
		player.setCurrentMarkToDraw(eMark.O);
		game.setOngoing(true);	
	}
}