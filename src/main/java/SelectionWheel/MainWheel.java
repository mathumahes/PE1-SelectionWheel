package SelectionWheel;

import SelectionWheel.SelectionWheel;
import SelectionWheel.SelectionWheel;
import javax.swing.*;
import java.util.*;

/**
 * @author Unknown
 * @version 1.1
 */

public class MainWheel {
	
        /** The method  first adds movies to the wheel, 
	 * then sets up the parameters, spins the wheel 
	 * and selects the movie the wheel has stopped on.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
                //creates window for the programm
		int windowWidth = 1000, windowHeight = 1000;
		
		JFrame border = new JFrame();
		border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                // adds movies to the list
		ArrayList<String> table = new ArrayList<String>();
		table.add("Avatar");
		table.add("The Lord of the Rings: The Return of the King");
		table.add("Pirates of the Caribbean: Dead Man's Chest");
		table.add("The Dark Knight");
		table.add("Harry Potter and the Philosopher's Stone");
		table.add("Pirates of the Caribbean: At World's End");
		table.add("Harry Potter and the Order of the Phoenix");
		table.add("Harry Potter and the Half-Blood Prince");
		table.add("The Lord of the Rings: The Two Towers");
		table.add("Shrek 2");
		table.add("Harry Potter and the Goblet of Fire");
		table.add("Spider-Man 3");
		table.add("Ice Age: Dawn of the Dinosaurs");
		table.add("Harry Potter and the Chamber of Secrets");
		table.add("The Lord of the Rings: The Fellowship of the Ring");
		table.add("Finding Nemo");
		table.add("Star Wars: Episode III - Revenge of the Sith");
		table.add("Transformers: Revenge of the Fallen");
		table.add("Spider-Man");
		table.add("Shrek the Third");
		
                // creates the wheel
		SelectionWheel wheel = new SelectionWheel(table);
		wheel.hasBorders(true);
		wheel.setBounds(10, 10, 700, 700);
		
                // creates the segments of the wheel
		JLabel lbl1 = new JLabel("Selection: ");
		JLabel lbl2 = new JLabel("Angle: ");
		JLabel lbl3 = new JLabel("Speed: ");
		JLabel lblsel = new JLabel("(selection)");
		JLabel lblang = new JLabel("(angle)");
		JLabel lblsp = new JLabel("(speed)");
		lbl1.setBounds(720, 10, 100, 20);
		lblsel.setBounds(830, 10, 150, 20);
		lbl2.setBounds(720, 30, 100, 20);
		lblang.setBounds(830, 30, 150, 20);
		lbl3.setBounds(720, 50, 100, 20);
		lblsp.setBounds(830, 50, 150, 20);
		border.add(wheel);
		border.add(lbl1);
		border.add(lblsel);
		border.add(lbl2);
		border.add(lblang);
		border.add(lbl3);
		border.add(lblsp);
		border.setSize(windowWidth, windowHeight);
		border.setLayout(null);
		border.setVisible(true);
		
                //sets the text after the spinning process
		lblsel.setText(wheel.getSelectedString());
		lblang.setText(Double.toString(wheel.getRotationAngle()));
		lblsp.setText(Double.toString(wheel.getSpinSpeed()));
		
		//wheel.setShape(Wheel.Shape.UMBRELLA);
		
                /**
                 * code for the structural process when spinning the wheel
                 * the wheel spins upon our action with the help of our mouse 
                 * then the wheel stops accordingly to the action
                 * afterwards it shows the movie where it stopped
                 */
		while(true) {
                                lblsel.setText(wheel.getSelectedString());
				lblang.setText(Double.toString(wheel.getRotationAngle()));
			// wait for action
			do{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                                
			} while (!wheel.isSpinning());
			// while spinning
			while(wheel.isSpinning())
			{
				lblsel.setText(wheel.getSelectedString());
				lblang.setText(Double.toString(wheel.getRotationAngle()));
				lblsp.setText(Double.toString(wheel.getSpinSpeed()));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			lblsp.setText(Double.toString(wheel.getSpinSpeed()));
			// show selection
			JOptionPane.showMessageDialog(border, "Selection: " + wheel.getSelectedString());
		}
	}
}