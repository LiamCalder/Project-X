import java.io.*; 
import javax.swing.*;
public class Mode {
	
	public Mode() {		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)throws Exception { 
		/*//outputs to JFrame instead of console
		JFrame f=new JFrame("Bob");
		
		//JButton b=new JButton("click");
		JLabel l = new  JLabel("room");		
		l.setBounds(130,100,100, 40);    
		
		f.add(l);
		f.setSize(300,400);    
		f.setLayout(null);    
		f.setVisible(true);*/
		Dungeon d = new Dungeon();
		DungeonT dt = new DungeonT();
		
		BufferedReader br = new BufferedReader(new FileReader("Save.txt")); 
		String st; 
		if ((st = br.readLine()).equalsIgnoreCase("tutorial")) { 
			dt.main(null);
			System.exit(1);
		} 
		else { 
			d.main(null);
			System.exit(1);
		}
	}
} 