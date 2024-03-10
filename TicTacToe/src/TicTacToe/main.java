package TicTacToe;

import TicTacToe.feature;

public class main
{
	public static void main(String[] args) 
	{		
		/* Player declaration */
		PlayerInput player = new PlayerInput();
		PlayerInput._player1 = player.InputDiag("1");
		PlayerInput._player2 = player.InputDiag("2");
		
		/* Player Turn */
		RandomChoice firstPlayer = new RandomChoice();
		if ((firstPlayer.randPl()) == 1)
		{
			player._turn = 1;
		}
		else
		{
			player._turn = 2;
		}
		
		/* Main frame */
		GameFrame gameFrame = new GameFrame();
		gameFrame.BuildFrame();
	}
}