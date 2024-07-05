package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
@SuppressWarnings("serial")
public class pvpGame extends JFrame implements ActionListener {
	JButton battle,battle2,save,exit;
	pvpGame(){
		this.setTitle("Joker's War card");
		this.setSize(1280, 720); //Frame size
		
		//Logo of the game
		ImageIcon logo = new ImageIcon("OtherImage/Logo.png");
		this.setIconImage(logo.getImage()); //Set logo
		
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, 1280, 720);
		
		//Background 
		JLabel Pgame = new JLabel("", new ImageIcon("Background/BG02-extra1.png"), JLabel.CENTER);
		Pgame.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		
		
		//Buttons
		battle = new JButton();
		battle.setIcon(new ImageIcon("Button/battle2.png")); //Set button image
		battle.setBounds(240,512, 140, 55); //Set location & size
		battle.addActionListener(this); 
		Pgame.add(battle); //Add button to label
		
		battle2 = new JButton();
		battle2.setIcon(new ImageIcon("Button/battle2.png")); //Set button image
		battle2.setBounds(955,512, 140, 55); //Set location & size
		battle2.addActionListener(this); 
		Pgame.add(battle2); //Add button to label
		
		save = new JButton();
		save.setIcon(new ImageIcon("Button/save.png"));
		save.setBounds(1030, 10, 110, 40); 
		save.addActionListener(this); 
		Pgame.add(save); 
		
		exit = new JButton();
		exit.setIcon(new ImageIcon("Button/exit.png"));
		exit.setBounds(1150, 10, 110, 40); 
		exit.addActionListener(this); 
		Pgame.add(exit);
		
		//Text total cards
		JLabel text = new JLabel("Total cards:");
		text.setBounds(125, 105, 245, 43);
		text.setFont(new Font("time new roman",Font.PLAIN,45)); //Set font & size
		text.setForeground(Color.white); //Set font color
		text.setBackground(new Color(65,70,60)); //Set bg (text) color
		
		JLabel text2 = new JLabel("Total cards:");
		text2.setBounds(810, 105, 245, 43);
		text2.setFont(new Font("time new roman",Font.PLAIN,45)); 
		text2.setForeground(Color.white);
		text2.setBackground(new Color(65,70,60));
		
	
		//Add label to layeredPane
		Pgame.setOpaque(true); //
		layer.add(Pgame, Integer.valueOf(0)); //the lower value is the deeper 
		text.setOpaque(true);
		layer.add(text, Integer.valueOf(1));
		text2.setOpaque(true);
		layer.add(text2, Integer.valueOf(1));
		this.add(layer); //Add layeredPane to frame
		
		
		this.setVisible(true); //Show Frame
		this.setResizable(false);//Preventing from resize
		this.setLocationRelativeTo(null); //In the middle
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Temporary
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==battle) { //If the button battle is clicked
			
		}
		if(e.getSource()==battle2) {
			
		}
		if(e.getSource()==save) {
			
		}
		if(e.getSource()==exit) {
			System.exit(0); //Exit programm
		}
		
	}

}
