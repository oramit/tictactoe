package services;

import model.Game;

public class DataForClient 
{
	private boolean executionSuccessfullyPassed;
	private String messageForClient;
	private Game game;

	public void setDataForClient(boolean isExecutionPassOrFail,String messageForClient,Game game)
	{
		this.setExecutionSuccessfullyPassed(isExecutionPassOrFail);
		this.setMessageForClient(messageForClient);
		this.setGame(game);
	}

	public Game getGame() 
	{
		return game;
	}

	public void setGame(Game game) 
	{
		this.game = game;
	}

	public boolean isExecutionSuccessfullyPassed()
	{
		return executionSuccessfullyPassed;
	}

	public void setExecutionSuccessfullyPassed(boolean executionSuccessfullyPassed)
	{
		this.executionSuccessfullyPassed = executionSuccessfullyPassed;
	}

	public String getMessageForClient() {
		return messageForClient;
	}

	public void setMessageForClient(String messageForClient) {
		this.messageForClient = messageForClient;
	}
}
