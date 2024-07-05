package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
@SuppressWarnings("serial")
public class getNameP extends JFrame implements ActionListener {
	JTextField inputName1,inputName2;
	JButton back,sub;
	
	getNameP(){
		this.setTitle("Joker's War card");
		this.setSize(1280, 720); //Frame size
		
		//Logo of the game
		ImageIcon logo = new ImageIcon("OtherImage/Logo.png");
		this.setIconImage(logo.getImage()); //Set logo
		
		//Background 
		JLabel gNameP = new JLabel("", new ImageIcon("Background/BG01-3-2.png"), JLabel.CENTER);
		gNameP.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.add(gNameP);
		
		//Buttons
		back = new JButton();
		back.setIcon(new ImageIcon("Button/back.png")); //Set Button image
		back.setBounds(1160, 0, 90, 33); //Set location & size
		back.addActionListener(this);
		gNameP.add(back);  //Add button to label
		
		sub = new JButton();
		sub.setIcon(new ImageIcon("Button/subP.png"));
		sub.setBounds(1110, 430, 120, 55);
		sub.addActionListener(this);
		gNameP.add(sub);
		
		
		
		//TextField
		inputName1 = new JTextField();
		inputName1.setBounds(500, 175, 535, 55); //Set location & size
		inputName1.setFont(new Font("time new roman",Font.PLAIN,45)); //Set font & size
		inputName1.setForeground(new Color(216,16,128)); //Set font color
		inputName1.setText("Player1"); //Set default text
		gNameP.add(inputName1); //add to label
		
		inputName2 = new JTextField();
		inputName2.setBounds(500, 400, 545, 55);
		inputName2.setFont(new Font("time new roman",Font.PLAIN,45));
		inputName2.setForeground(new Color(216,16,128)); 
		inputName2.setText("Player2"); 
		gNameP.add(inputName2);
		
		this.setVisible(true); //Show Frame
		this.setResizable(false);//Preventing from resize
		this.setLocationRelativeTo(null); //In the middle
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) { //If the button back is clicked
			this.dispose(); //Close this window
			new GameChoice(); //Open GameChoice window
		}
		if(e.getSource()==sub) { //need to be add reciving of player name
			inputName1.setEditable(false); //can't edit name after submit
			inputName2.setEditable(false);
			sub.setEnabled(false); //prevent the button from being clicked again
			this.dispose(); //Close this window
			new pvpGame(); //Open Game window
		}
		
			
		
	}

}