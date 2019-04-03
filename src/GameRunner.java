import java.util.Iterator;

import javax.swing.JFrame;

import java.util.ArrayList;

public class GameRunner {

	public static void main(String[] args) {
		GameWindow game = new GameWindow();
		game.setVisible(true);
		game.pack();
		game.setTitle("War Card Game");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Deck gamedeck = new Deck(1);
		ArrayList<Card> player1Hand = new ArrayList<Card>();
		ArrayList<Card> player2Hand = new ArrayList<Card>();
		int player1Score = 0;
		int player2Score = 0;
		
		
		for(int i=0;i<7;i++) {
			player1Hand.add(gamedeck.dealCard());
			player2Hand.add(gamedeck.dealCard());
		}
		int pointsCount = 1;
		
		while(!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(game.getButtonStatus()) {
				game.resetButtonStatus();
				
				int rand = (int) (Math.random()*player1Hand.size());
				Card player1choice = player1Hand.get(rand);
				player1Hand.remove(rand);

				rand = (int) (Math.random()*player1Hand.size());
				Card player2choice = player2Hand.get(rand);
				player2Hand.remove(rand);

				game.setCards(player1choice.getShortName(),player2choice.getShortName());

				System.out.println("------------------------------------");
				System.out.println("Player 1 Choice : " + player1choice.toString());
				System.out.println("Player 2 Choice : " + player2choice.toString());

				if(player1choice.getNumber() > player2choice.getNumber()) {
					player1Score+=pointsCount;
				}
				else if(player1choice.getNumber() < player2choice.getNumber()) {
					player2Score+=pointsCount;
				}
				else {
					pointsCount++;
					continue;
				}

				System.out.println("Scoreboard :      Player 1 : " + player1Score + "    Player 2 : " + player2Score);

				if(!gamedeck.getDeck().isEmpty()) {
					player1Hand.add(gamedeck.dealCard());
					player2Hand.add(gamedeck.dealCard());
				}

				pointsCount = 1;
			}
		}
		
		if(player1Score > player2Score) {
			System.out.println("Player 1 Wins!");
		}
		else if(player2Score > player1Score) {
			System.out.println("Player 2 Wins!");
		}
		else {
			System.out.println("It's a tie");
		}
		
		
	}
	
}
