import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameWindow extends JFrame{
	JPanel cardPanel;
	JLabel cardLabel1;
	JLabel cardLabel2;
	ImageIcon card1;
	ImageIcon card2;
	JButton drawButton;
	boolean buttonPressed;
	
	GameWindow(){
		createComponents();
		addListeners();
	}
	
	public void createComponents(){
		buttonPressed = false;
		
		cardPanel = new JPanel();
		card1 = new ImageIcon(this.getClass().getResource("/Gray_back.jpg"));
		card2 = new ImageIcon(this.getClass().getResource("/Gray_back.jpg"));
		cardLabel1 = new JLabel();
		cardLabel1.setIcon(card1);
		cardLabel2 = new JLabel();
		cardLabel2.setIcon(card2);
		
		drawButton = new JButton("Play Next Card");
		
		cardPanel.add(cardLabel1);
		cardPanel.add(cardLabel2);
		cardPanel.add(drawButton);
		
		add(cardPanel);
	}
	
	
	public void addListeners() {
		drawButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buttonPressed = true;
			}
		});
	}
	
	public boolean getButtonStatus() {
		return buttonPressed;
	}
	
	public void resetButtonStatus() {
		buttonPressed = false;
	}
	
	public void setCards(String c1, String c2) {
		card1 = new ImageIcon(this.getClass().getResource("/" + c1 + ".jpg"));
		card2 = new ImageIcon(this.getClass().getResource("/" + c2 + ".jpg"));
		cardLabel1.setIcon(card1);
		cardLabel2.setIcon(card2);
	}
	
	public void setScoreboard(int s1, int s2) {
		
	}
	
}

