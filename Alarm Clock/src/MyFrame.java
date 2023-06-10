import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements Runnable{
	private JFrame frame;
	private JPanel pan;
	private JLabel label;
	private JLabel alarm1;
	private String s = "";
	private String ahour = "";
	private String bhour = "";
	private String aminute = "";
	private String bminute = "";
	private String ym = "";
	private String hh = "";
	private String mm = "";
	private String zm = "";
	
	public MyFrame() {
		
		super();
		frame = new JFrame();
		frame.setLayout(null);
		frame.setResizable(false);
		label = new JLabel();
		label.setBackground(Color.BLACK);
		label.setBounds(100, 200, 600, 200);
		label.setOpaque(true);
		label.setForeground(Color.GREEN);
		label.setVisible(true);
		
		alarm1 = new JLabel();
		alarm1.setBackground(Color.BLACK);
		alarm1.setBounds(100, 400, 600, 150);
		alarm1.setOpaque(true);
		alarm1.setForeground(Color.GREEN);
		alarm1.setVisible(true);
		
		alarm1.setText("Alarm 1: ");
		alarm1.setFont(new Font("Calibri", Font.BOLD, 50));
		
		Integer[] hour = {null,1,2,3,4,5,6,7,8,9,10,11,12};
		JComboBox<Integer> comboBox1 = new JComboBox<>(hour);
		comboBox1.setOpaque(true);
		comboBox1.setBounds(100, 550, 100, 25);
		
		comboBox1.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==comboBox1) {
					try {
						ahour = comboBox1.getSelectedItem().toString();
					} catch (NullPointerException e1) {
						
					}
				}
			}
		});
		Integer[] minutes = new Integer[61];
		int j = 0;
		for (int i = 1; i < minutes.length; i++) {
			minutes[i] = j++;
		}
		
		JComboBox<Integer> comboBox2 = new JComboBox<>(minutes);
		comboBox2.setOpaque(true);
		comboBox2.setBounds(200, 550, 100, 25);
		
		comboBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==comboBox2) {
					try {
						aminute = comboBox2.getSelectedItem().toString();
					} catch (NullPointerException e1) {
						
					}
					
				}
				
			}
			
		});
		
		String[] xm = {null, "AM", "PM"};
		JComboBox<String> comboBox3 = new JComboBox<>(xm);
		comboBox3.setOpaque(true);
		comboBox3.setBounds(300, 550, 100, 25);
		
		comboBox3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==comboBox3) {
					try {
						ym = comboBox3.getSelectedItem().toString();
					} catch (NullPointerException e1) {
						
					}
				}
			}
		});
		
		JButton set = new JButton("SET");
		set.setOpaque(true);
		set.setBounds(400, 550, 100, 25);
		
		set.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==set) {
					if (ahour.length() == 1 && aminute.length() == 2) {
						ahour = "0" + ahour;
						alarm1.setText("Alarm 1: " + ahour + ":" + aminute + " " + ym); 

					}
					else if (aminute.length() == 1 && ahour.length() == 2) {
						aminute = "0" + aminute;
						alarm1.setText("Alarm 1: " + ahour + ":" + aminute + " " + ym); 

					}
					else if (aminute.length() == 1 && ahour.length() == 1) {
						aminute = "0" + aminute;
						ahour = "0" + ahour;
						alarm1.setText("Alarm 1: " + ahour + ":" + aminute + " " + ym); 

					}
					else {
						alarm1.setText("Alarm 1: " + ahour + ":" + aminute + " " + ym); 
					}
				}
			}
		});
		
		JButton reset = new JButton("RESET");
		reset.setOpaque(true);
		reset.setBounds(500, 550, 100, 25);
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reset) {
					alarm1.setText("Alarm 1: ");
					ahour = "";
					aminute = "";
					ym = "";
					comboBox1.setSelectedIndex(0);
					comboBox2.setSelectedIndex(0);
					comboBox3.setSelectedIndex(0);
				}
				
			}
			
		});
		

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Alarm Clock");
		frame.add(label);
		frame.add(alarm1);
		frame.add(comboBox1);
		frame.add(comboBox2);
		frame.add(comboBox3);
		frame.add(set);
		frame.add(reset);
		frame.setVisible(true);
		frame.setSize(1000,1000);
	}
	//setters
	public void setS(String s) {
		this.s = s;
		label.setText("Current Time: " + s);
		label.setFont(new Font("Calibri", Font.BOLD, 50));
	}
	public void setHH(String hh) {
		this.hh = hh;
	}
	public void setMM(String mm) {
		this.mm = mm;
	}
	public void setZM(String zm) {
		this.zm = zm;
	}
	@Override
	public void run() {
		
	}
	
	//getters
	public String getahour() {
		return ahour;
	}
	public String getaminute() {
		return aminute;
	}
	public String getym() {
		return ym;
	}
	public String getHH() {
		return hh;
	}
	public String getMM() {
		return mm;
	}
	public String getZM() {
		return zm;
	}

}
