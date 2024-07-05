package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
@SuppressWarnings("serial")
public class GameChoice extends JFrame implements ActionListener {
	JButton pvp, pve;
	GameChoice(){
		this.setTitle("Joker's War card");
		this.setSize(1280, 720); //Frame size
		
		//Logo of the game
		ImageIcon logo = new ImageIcon("OtherImage/Logo.png");
		this.setIconImage(logo.getImage()); //Set logo
		
		//Background 
		JLabel gChoice = new JLabel("", new ImageIcon("Background/BG01-2.png"), JLabel.CENTER);
		gChoice.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.add(gChoice); //Add label to frame
		
		//Buttons
		pve = new JButton();
		pve.setIcon(new ImageIcon("Button/pve.png")); //Set button image
		pve.setBounds(80, 580, 365, 85); //Set location & size
		pve.addActionListener(this);
		gChoice.add(pve); //Add button to label
		
		pvp= new JButton();
		pvp.setIcon(new ImageIcon("Button/pvp.png"));
		pvp.setBounds(820, 580, 365, 85);
		pvp.addActionListener(this);
		gChoice.add(pvp);
		
		
		
		this.setVisible(true); //Show Frame
		this.setResizable(false);//Preventing from resize
		this.setLocationRelativeTo(null); //In the middle
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pve) { //If the button pve is clicked
			this.dispose(); //Close this Window
			new getNameE(); //Open input name window for pve
		}
		if(e.getSource()==pvp) {
			this.dispose();
			new getNameP(); //Open input name window for pvp
		}
		
	}

}
