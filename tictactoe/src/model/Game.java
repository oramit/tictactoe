package model;

public class Game 
{
	private int gameId;	
	
	private static final int TABLE_SIZE = 9;
	private eMark[] table;
	private eMark nextMark;
	
	private boolean isOngoing;
	private boolean isOver;

	public Game() 
	{
		super();
		initGameData();
	}

	private void initGameData() 
	{
		nextMark = eMark.X;
		table = new eMark[TABLE_SIZE];
		for (int index = 0; index < table.length; index++) 
		{
			table[index] = eMark.EMPTY;			
		}
	}

	public eMark[] getTable() 
	{
		return table;
	}

	public void setTable(eMark[] table) 
	{
		this.table = table;
	}
	
	public boolean isOngoing() 
	{
		return isOngoing;
	}

	public void setOngoing(boolean isOngoing) 
	{
		this.isOngoing = isOngoing;
	}

	public boolean isOver()
	{
		return isOver;
	}

	public void setOver(boolean isOver)
	{
		this.isOver = isOver;
	}
	
	public eMark getNextMark()
	{
		return nextMark;
	}

	public void setNextMark(eMark nextMark)
	{
		this.nextMark = nextMark;
	}

	public int getGameId() 
	{
		return gameId;
	}
	
	public void setGameId(int gameId) 
	{
		this.gameId = gameId;
	}
	
	public boolean isAvailable()
	{
		boolean isGameAvailable = true;		
		if(this.isOngoing() || this.isOver())
		{
			isGameAvailable = false;
		}
		return isGameAvailable;
	}
	
	public void exectuteTurn(eMark mark, int value) 
	{
		getTable()[value] = mark;
		setNextMark(mark.switchMark());
	}
	
	public boolean checkVictoryAndUpdateGameStatus() 
	{
		boolean isVictoryOccured = false;
		if(checkRows() || checkColumns() || checkDiagonals())
		{
			setOver(true);
			isVictoryOccured = true;
		}	
		return isVictoryOccured;
	}
	
	private boolean checkRows() 
	{
		boolean isVictoryOccured = false;
		for (int i = 0; i < this.getTable().length; i = i + 3) 
		{
			if (checkForVictory(i, i + 1, i + 2)) 
			{
				isVictoryOccured = true;
				break;
			}
		}
		return isVictoryOccured;
	}

	private boolean checkColumns() 
	{
		boolean isVictoryOccured = false;
		for (int i = 0; i <= 2; i++) 
		{
			if (checkForVictory(i, i + 3, i + 6)) 
			{
				isVictoryOccured = true;
				break;
			}
		}
		return isVictoryOccured;
	}

	private boolean checkDiagonals()
	{
		return checkForVictory(0, 4, 8) || 	checkForVictory(2, 4, 6);
	}
	
	private boolean checkForVictory(int firstCell, int secondCell, int thirdCell) 
	{
		boolean isVictoryOccured = false;
	
		if (table[firstCell].equals(eMark.EMPTY) ||
			table[secondCell].equals(eMark.EMPTY)||
			table[thirdCell].equals(eMark.EMPTY)) 
			{
				return isVictoryOccured;
			}
		
		if (table[firstCell].equals(table[secondCell]) && 
			table[secondCell].equals(table[thirdCell])) 
		{
			isVictoryOccured = true;
		}
		return isVictoryOccured;
	}
}

