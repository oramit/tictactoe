package model;

public class Player 
{
	private String playerName;
	private boolean isAvailable;
	private eMark currentMarkToDraw;
	
	public Player(String playerName) 
	{
		super();
		this.playerName = playerName;
	}
	
	public boolean isAvailable()
	{
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) 
	{
		this.isAvailable = isAvailable;
	}
	
	public String getPlayerName() 
	{
		return playerName;
	}
	
	public Player()
	{
		super();
	}

	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}
	
	public eMark getCurrentMarkToDraw() 
	{
		return currentMarkToDraw;
	}

	public void setCurrentMarkToDraw(eMark currentMarkToDraw) 
	{
		this.currentMarkToDraw = currentMarkToDraw;
	}
}
