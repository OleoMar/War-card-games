package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener {
	JButton newG, loadG, exitG;
	MainMenu(){
		
		this.setTitle("Joker's War card");
		this.setSize(1280, 720); //Frame size
		
		//Logo of the game
		ImageIcon logo = new ImageIcon("OtherImage/Logo.png");
		this.setIconImage(logo.getImage()); //Set logo
		
		//Bkackground 
		JLabel mainMenu = new JLabel("", new ImageIcon("Background/BG01.png"), JLabel.CENTER);
		mainMenu.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.add(mainMenu); //Add label to frame
		
		//Buttons
		newG = new JButton();
		newG.setIcon(new ImageIcon("Button/NG.png")); //Set Button image
		newG.setBounds(830, 185, 310, 75); //Set location & size
		newG.addActionListener(this); 
		mainMenu.add(newG); //Add to label
		
		loadG = new JButton();
		loadG.setIcon(new ImageIcon("Button/LG.png"));
		loadG.setBounds(830, 280, 310, 75);
		mainMenu.add(loadG);
		
		exitG = new JButton();
		exitG.setIcon(new ImageIcon("Button/EG.png"));
		exitG.setBounds(830, 375, 310, 75);
		exitG.addActionListener(this);
		mainMenu.add(exitG);
		
		
		this.setVisible(true); //Show Frame
		this.setResizable(false);//Preventing from resize
		this.setLocationRelativeTo(null); //In the middle
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Temporary
	}
	@Override //Commands for Buttons
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newG) { //If the button new game is clicked
			this.dispose(); //Close this window
			new GameChoice(); //Open Gamechoice window
		}
		if(e.getSource()==exitG) {
			System.exit(0); //Exit programm
		}
		
	}
	
	
}
