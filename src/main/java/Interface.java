import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Interface {
	
	public static JComboBox<String> interfaceHours;
	public static JComboBox<String> interfaceMinutes;
	public static JComboBox<String> interfaceSeconds;
	
	public static int updHours = 0;
	public static int updMinutes = 0;
	public static int updSeconds = 0;
	
	public static int waitFlag = 0;
	public JButton startBtn;
	public static JRadioButton tadaButton;
	public static JRadioButton pulupiRadioButton;
	public static JRadioButton tuduRadioButton;
	
	JFrame frmGigasTimer;
	private JTextField timeField;
	public static Timer updTimer1;
	
	public Interface() {
		initialize();	
	}

	private void initialize() {
		frmGigasTimer = new JFrame();
		frmGigasTimer.setTitle("The Timer");
		frmGigasTimer.getContentPane().setBackground(new Color(221, 160, 221));
		frmGigasTimer.setResizable(false);
		frmGigasTimer.setBounds(100, 100, 358, 316);
		frmGigasTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGigasTimer.getContentPane().setLayout(null);
		
		startBtn = new JButton("Start");
		startBtn.setBounds(10, 162, 89, 67);
		frmGigasTimer.getContentPane().add(startBtn);
		
		final JButton stopBtn = new JButton("Stop");
		stopBtn.setBounds(129, 162, 89, 67);
		frmGigasTimer.getContentPane().add(stopBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(249, 162, 89, 67);
		frmGigasTimer.getContentPane().add(clearBtn);
		
		interfaceHours = new JComboBox<>();
		interfaceHours.setModel(new DefaultComboBoxModel<>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		interfaceHours.setBounds(62, 32, 39, 23);
		frmGigasTimer.getContentPane().add(interfaceHours);
		
		interfaceMinutes = new JComboBox<>();
		interfaceMinutes.setModel(new DefaultComboBoxModel<>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		interfaceMinutes.setBounds(152, 32, 39, 23);
		frmGigasTimer.getContentPane().add(interfaceMinutes);
		
		interfaceSeconds = new JComboBox<>();
		interfaceSeconds.setModel(new DefaultComboBoxModel<>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		interfaceSeconds.setBounds(249, 31, 39, 23);
		frmGigasTimer.getContentPane().add(interfaceSeconds);
		
		timeField = new JTextField();
		timeField.setFont(new Font("Tahoma", Font.BOLD, 22));
		timeField.setLocation(new Point(6, 6));
		timeField.setEditable(false);
		timeField.setBounds(107, 82, 136, 60);
		frmGigasTimer.getContentPane().add(timeField);
		timeField.setColumns(10);
		timeField.setHorizontalAlignment(JTextField.CENTER);
		timeField.setText("00:00:00");
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHours.setBounds(25, 36, 28, 14);
		frmGigasTimer.getContentPane().add(lblHours);
		
		JLabel lblMinets = new JLabel("Minutes");
		lblMinets.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMinets.setBounds(108, 36, 39, 14);
		frmGigasTimer.getContentPane().add(lblMinets);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSeconds.setBounds(201, 36, 47, 14);
		frmGigasTimer.getContentPane().add(lblSeconds);
		
		tadaButton = new JRadioButton("Tada");
		tadaButton.setSelected(true);
		tadaButton.setBackground(new Color(221, 160, 221));
		tadaButton.setBounds(10, 238, 89, 23);
		frmGigasTimer.getContentPane().add(tadaButton);
		
		pulupiRadioButton = new JRadioButton("Pulupi");
		pulupiRadioButton.setBackground(new Color(221, 160, 221));
		pulupiRadioButton.setBounds(129, 238, 89, 23);
		frmGigasTimer.getContentPane().add(pulupiRadioButton);
		
		tuduRadioButton = new JRadioButton("Tudu");
		tuduRadioButton.setBackground(new Color(221, 160, 221));
		tuduRadioButton.setBounds(249, 238, 89, 23);
		frmGigasTimer.getContentPane().add(tuduRadioButton);
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    waitFlag = 0;
				    stopBtn.setText("Stope");
				    timeField.setText(String.format("%02d:%02d:%02d", 
				                      Integer.parseInt((String) interfaceHours.getSelectedItem()), 
				                      Integer.parseInt((String) interfaceMinutes.getSelectedItem()),
				                      Integer.parseInt((String) interfaceSeconds.getSelectedItem())));
				    startBtn.setEnabled(false);
					ItsTime time = new ItsTime();
					time.play();
					updatus();
			}
		});
		
		tadaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					tadaButton.setSelected(true);
					pulupiRadioButton.setSelected(false);
					tuduRadioButton.setSelected(false);
			}
		});
		
		pulupiRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					tadaButton.setSelected(false);
					pulupiRadioButton.setSelected(true);
					tuduRadioButton.setSelected(false);
			}
		});
		
		tuduRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					tadaButton.setSelected(false);
					pulupiRadioButton.setSelected(false);
					tuduRadioButton.setSelected(true);
			}
		});
		
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if("Renew".equals(stopBtn.getText())){
					stopBtn.setText("Stope");
					ItsTime.time = (updHours * 60 * 60 * 1000) + (updMinutes * 60 * 1000) + (updSeconds * 1000);
					renew();
					ItsTime time = new ItsTime();
					time.play();
					updatus();
					waitFlag = 0;
					startBtn.setEnabled(false);
				}
				else{
					if(timeField.getText().equals("00:00:00")){
						startBtn.setEnabled(true); 
					}
					else{
						if (updTimer1 != null) {
							updTimer1.cancel();
							updTimer1.purge();
						}
						if (ItsTime.timer != null) {
							ItsTime.timer.cancel();
							ItsTime.timer.purge();
						}
						stopBtn.setText("Renew");
						waitFlag = 1;
						startBtn.setEnabled(true); 
					}
				}
				
			}
		});
		
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(updTimer1 != null){
					updTimer1.cancel();
				}
				if(ItsTime.timer != null){
					ItsTime.timer.cancel();
				}
				timeField.setText("00:00:00");
				interfaceHours.setSelectedItem("0");
				interfaceMinutes.setSelectedItem("0");
				interfaceSeconds.setSelectedItem("0");
				startBtn.setEnabled(true);
			}
		});
	}
	
	public void updatus() {
		   if(waitFlag == 0){renew();}
		   
		   if(waitFlag == 0){getVariables();}
		  
		   if((updHours + updMinutes + updSeconds) != 0) {
			   updTimer1.scheduleAtFixedRate(new TimerTask() {
			   @Override
			   public void run() {			   
				   				   
				   if(updSeconds > 0) {
					   updSeconds--;
				   } else { // секунды равны 0
					   updSeconds = 59;
					   if (updMinutes > 0) {
						   updMinutes--;
					   } else { // минуты равны 0
						   updMinutes = 59;
						   if (updHours > 0) {
							   updHours--;
						   }
					   }
				   }
				   
				   timeField.setText(String.format("%02d:%02d:%02d", updHours, updMinutes, updSeconds));
				   
				   if(updHours == 0 && updMinutes == 0 && updSeconds == 0){
					   this.cancel(); 
					   startBtn.setEnabled(true);
				   }
			   }
		   }, 1000, 1000); 
		}
		else {
			startBtn.setEnabled(true);
		}
	}
	
	public void getVariables() {
		   updHours = Integer.parseInt((String) interfaceHours.getSelectedItem());
		   updMinutes = Integer.parseInt((String) interfaceMinutes.getSelectedItem());
		   updSeconds = Integer.parseInt((String) interfaceSeconds.getSelectedItem());
	}
	
	public static void renew() {
		Timer updTimer = new Timer();
		updTimer1 = updTimer;
	}
}