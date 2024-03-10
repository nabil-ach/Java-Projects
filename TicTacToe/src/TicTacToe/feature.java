package TicTacToe;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class feature {

}

class PlayerInput
{
	static String _player1;
	static String _player2;
	static int _turn;
	
	String InputDiag(String PN)
	{
		String P = (String) JOptionPane.showInputDialog(null, "Player ".concat(PN), "Player Input", 
				JOptionPane.QUESTION_MESSAGE, null, null, "Player name");
		return P;
	}
}

class GameFrame implements ActionListener
{
	JFrame mainFrame = new JFrame();
	JButton[] buttons = new JButton[9];
	boolean[] buttonfill = new boolean[9];
	JLabel turnLabel = new JLabel();
	JPanel gamePanel = new JPanel();
	
	public void BuildFrame()
	{
		/* Format */
		mainFrame.setBounds(0, 0, 500, 300);
		// Label
		JLabel viewLabel = new JLabel("------------Tic Tac Toe------------");
		viewLabel.setBackground(Color.BLACK);
		if (PlayerInput._turn == 1) turnLabel.setText(PlayerInput._player1 + "'s turn");
		if (PlayerInput._turn == 2) turnLabel.setText(PlayerInput._player2 + "'s turn");
		// Panel
		JPanel leftPanel = new JPanel();
		JPanel gamePanel = new JPanel();		// Game Panel
		JPanel turnPanel = new JPanel();		// Turn Panel
		turnPanel.setBackground(Color.green);
		turnPanel.add(turnLabel);
		JPanel viewPanel = new JPanel();		// View Panel
		viewPanel.add(viewLabel);
		// Split
		JSplitPane splitFrame = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JSplitPane splitleftPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitFrame.setRightComponent(gamePanel);
		splitFrame.setLeftComponent(leftPanel);
		splitleftPanel.setTopComponent(viewPanel);
		splitleftPanel.setBottomComponent(turnPanel);
		leftPanel.add(splitleftPanel);
		mainFrame.add(splitFrame);
		// 3x3
		gamePanel.setLayout(new GridLayout(3,3));
		for(int i=0; i<9; i++)
		{
			buttons[i] = new JButton();
			buttons[i].addActionListener(this);
			gamePanel.add(buttons[i]);
			buttonfill[i] = false;
		}
		mainFrame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.buttons[0])
		{
			System.out.println("0");
			Play(0);
		}
		if(e.getSource() == this.buttons[1])	
		{
			System.out.println("1");
			Play(1);
		}
		if(e.getSource() == this.buttons[2])	
		{
			System.out.println("2");
			Play(2);
		}
		if(e.getSource() == this.buttons[3])	
		{
			System.out.println("3");
			Play(3);
		}
		if(e.getSource() == this.buttons[4])
		{
			System.out.println("4");
			Play(4);
		}
		if(e.getSource() == this.buttons[5])	
		{
			System.out.println("5");
			Play(5);
		}
		if(e.getSource() == this.buttons[6])	
		{
			System.out.println("6");
			Play(6);
		}
		if(e.getSource() == this.buttons[7])	
		{
			System.out.println("7");
			Play(7);
		}
		if(e.getSource() == this.buttons[8])	
		{
			System.out.println("8");
			Play(8);
		}
		
	}
	
	private void Play(int j)
	{
		if(buttonfill[j] == false)
		{
			if (PlayerInput._turn == 1)		
			{
				buttons[j].setText("X");
				if(!CheckWinner())
				{
					PlayerInput._turn = 2;
					turnLabel.setText(PlayerInput._player2 + "'s turn");
				}
			}
			else
			{
				buttons[j].setText("O");
				if(!CheckWinner())
				{
					PlayerInput._turn = 1;
					turnLabel.setText(PlayerInput._player1 + "'s turn");
				}
			}
			buttonfill[j] = true;
		}
	}
	private boolean CheckWinner()
	{
		if( (buttons[0].getText() == buttons[1].getText() && buttons[0].getText() == buttons[2].getText()
				 && (buttons[0].getText() == "X" || buttons[0].getText() == "O"))
		 || (buttons[3].getText() == buttons[4].getText() && buttons[3].getText() == buttons[5].getText()
				 && (buttons[3].getText() == "X" || buttons[3].getText() == "O"))
		 || (buttons[6].getText() == buttons[7].getText() && buttons[6].getText() == buttons[8].getText()
				 && (buttons[6].getText() == "X" || buttons[6].getText() == "O"))
		 || (buttons[0].getText() == buttons[3].getText() && buttons[0].getText() == buttons[6].getText()
				 && (buttons[0].getText() == "X" || buttons[0].getText() == "O"))
		 || (buttons[1].getText() == buttons[4].getText() && buttons[1].getText() == buttons[7].getText()
				 && (buttons[1].getText() == "X" || buttons[1].getText() == "O"))
		 || (buttons[2].getText() == buttons[5].getText() && buttons[2].getText() == buttons[8].getText()
				 && (buttons[2].getText() == "X" || buttons[2].getText() == "O"))
		 || (buttons[0].getText() == buttons[4].getText() && buttons[0].getText() == buttons[8].getText()
				 && (buttons[0].getText() == "X" || buttons[0].getText() == "O"))
		 || (buttons[2].getText() == buttons[4].getText() && buttons[2].getText() == buttons[6].getText()
		 		 && (buttons[2].getText() == "X" || buttons[2].getText() == "O")))
		{
			if(PlayerInput._turn == 1)
			{
				System.out.println("P1 winner");
				turnLabel.setText(PlayerInput._player1 + " is the WINNER");
				WinnerP(PlayerInput._player1);
				mainFrame.dispose();
			}
			else
			{
				System.out.println("P2 winner");
				turnLabel.setText(PlayerInput._player2 + " is the WINNER");
				WinnerP(PlayerInput._player2);
				mainFrame.dispose();
			}
			
			return true;
		}
		else 
		{
			System.out.println("no winner");
			return false;
		}
	}
	
	private void WinnerP(String WP)
	{
		ImageIcon icon = new ImageIcon(
				"D:\\E&E\\eclipse-workspace-Java\\TicTacToe\\src\\TicTacToe\\giphy.gif");
		JOptionPane.showMessageDialog(null, "congratulations for " + WP.toUpperCase(), "Game End", 
				JOptionPane.INFORMATION_MESSAGE, icon);
	}
}

class RandomChoice
{
	Random rand = new Random();
	int randPl()
	{
		return (int) rand.nextInt(2) + 1;
	}
}