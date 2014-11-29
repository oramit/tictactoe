package services;

import java.util.HashMap;
import java.util.Map;

import model.Game;
import model.Player;

public class GamesManager 
{
	private static Map<Integer,Game> games = new HashMap<Integer, Game>();
	private static Map<String,Player> players = new HashMap<String, Player>();

	public static Player addPlayerIfRequired(String name)
	{
		Player player = players.get(name);
		if(player == null)
		{
			player = new Player(name);
			players.put(name,player);	
		}
		return player;
	}
	
	public static Player addPlayer(String playerName)
	{
		Player player = null;
		if(! players.containsKey(playerName))
		{
			player = new Player(playerName);
			players.put(playerName,player);	
		}
		return player;
	}
	
	public static Player getPlayerByName(String playerName)
	{
		Player requiredPlayer = players.get(playerName);
		return requiredPlayer;
	}
	
	public static Game addGame(int gameId)
	{
		Game game = null;
		Integer id = (Integer)gameId;
		if(! games.containsKey(id))
		{
			game = new Game();
			game.setGameId(gameId);
			games.put(id,game);	
		}
		return game;
	}
	
	public static Game getGameById(int gameId)
	{
		Integer id = (Integer)gameId;
		Game requiredGame = games.get(id);
		return requiredGame;
	}
}
