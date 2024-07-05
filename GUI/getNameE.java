package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")
public class getNameE extends JFrame implements ActionListener {
	JTextField inputName;
	JButton back, sub;
	getNameE(){
		this.setTitle("Joker's War card");
		this.setSize(1280, 720); //Frame size
		
		//Logo of the game
		ImageIcon logo = new ImageIcon("OtherImage/Logo.png");
		this.setIconImage(logo.getImage()); //Set logo
		
		//Background 
		JLabel gNameE = new JLabel("", new ImageIcon("Background/BG01-3-1.png"), JLabel.CENTER);
		gNameE.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.add(gNameE); //Add label to frame
		
		//Buttons
		back = new JButton();
		back.setIcon(new ImageIcon("Button/back.png")); //Set button image
		back.setBounds(1160, 0, 90, 33); //Set location & size
		back.addActionListener(this); 
		gNameE.add(back); //Add button to label
		
		sub = new JButton();
		sub.setIcon(new ImageIcon("Button/subE.png"));
		sub.setBounds(675, 305, 195, 50);
		sub.addActionListener(this);
		gNameE.add(sub);
		
		//TextField
		inputName = new JTextField();
		inputName.setBounds(500, 175, 535, 55); //Set location & size
		inputName.setFont(new Font("time new roman",Font.PLAIN,45)); //Set font & size
		inputName.setForeground(new Color(216,16,128)); //Set font color
	  //inputName.setText("You"); //Set default text
		gNameE.add(inputName); //add to label
		
		this.setVisible(true); //Show Frame
		this.setResizable(false);//Preventing from resize
		this.setLocationRelativeTo(null); //In the middle
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Temporary
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) { //If the button back is clicked
			this.dispose(); //Close this window
			new GameChoice(); //Open GameChoice window
		} 
		if(e.getSource()==sub) { //need to be add reciving of player name
			this.dispose();
			new pveGame();
			
		}
		
	}

}
