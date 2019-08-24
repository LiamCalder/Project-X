import java.io.*; 
import javax.swing.*;
public class Mode {
	
	Mode() {
		//outputs to JFrame instead of console
		JFrame f=new JFrame("Bob");
		
		//JButton b=new JButton("click");
		JLabel l = new  JLabel("room");		
		l.setBounds(130,100,100, 40);    
		
		f.add(l);
		
		f.setSize(300,400);    
		f.setLayout(null);    
		f.setVisible(true);    
				
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JFrame f = new JFrame("ASCII");
        JLabel l = new  JLabel("room");
        l.setBounds(300,100,100,100);
        f.add(l);
        f.setSize(101,101);
        f.setLayout(null);
        f.setVisible(true);*/
	}
	
	public static void main(String[] args)throws Exception { 
		new Mode();
		Dungeon d = new Dungeon();
		DungeonT dt = new DungeonT();
		
		BufferedReader br = new BufferedReader(new FileReader("Save.txt")); 
		System.out.println("hello");
		String st; 
		if ((st = br.readLine()).equalsIgnoreCase("tutorial")) { 
			//d.main(null);
			System.exit(1);
		} 
		else { 
			//dt.main(null);
			System.exit(1);
		}
	}
} 