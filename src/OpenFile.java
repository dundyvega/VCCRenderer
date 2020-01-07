import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OpenFile {

	private JFrame frame;
	private JButton btnVCC;
	String[] ertekek;

	/**
	 * Launch the application.
	 */
	
	
	public void configBetoltes() {
			// TODO Auto-generated method stub
			
			File config = new File ("series.conf");
			
			try {
			
				BufferedReader br = new BufferedReader(new FileReader("series.conf"));
				
				String line = br.readLine();
				
				ertekek = line.split("=")[1].split(",");
				
				br.close();
				
			} catch (Exception ex) {}
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenFile window = new OpenFile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OpenFile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnVCC = new JButton("VCC Fájl Betöltése");
		btnVCC.addActionListener(new ActionListener() {
			private ArrayList<LineFromExcelFile> lines;

			public void actionPerformed(ActionEvent arg0) {
				
				
				File workingDirectory = new File(System.getProperty("user.dir"));
				
				JFileChooser chooser = new JFileChooser();
				
				chooser.setCurrentDirectory(workingDirectory);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
			                "Excel fájl", "xlsx", "XLSX");
			        chooser.setFileFilter(filter);
			        int returnVal = chooser.showOpenDialog(null);
			        if(returnVal == JFileChooser.APPROVE_OPTION) {
			            
			              String fileName = chooser.getSelectedFile().getName();
			              
			              if (fileName != null && !fileName.equals("")) {
			            	  
			            	  try {
			            
			            	  lines = FileOperator.getLines(chooser.getSelectedFile().getPath());
			            	  
			            	  //átmásolja a megjegyzést
			            	  megjegyzesAtmasolasa();
			            	  
			            	  telefonszamokRenderelese();
			            	 
			            	 FileOperator.setLines(chooser.getSelectedFile().getPath(), lines);
			            	  
			            	 // System.out.println(lines.get(0).toString());
			            	 
			            	 JOptionPane.showMessageDialog(null, "kész!");
			            	  
			            	  } catch (Exception ex) {
			            		  
			            		  JOptionPane.showMessageDialog(null, ex.toString(), "Hibaüzenet", JOptionPane.ERROR_MESSAGE);
			            		  
			            	  }
			            	  
			              }
			        }
				 
			}

			


			
			//a telefonszámokat rendezi, a mobilt a phone1-be, a phone2-be ha van különböző
			private void telefonszamokRenderelese() {
				// TODO Auto-generated method stub
				
				configBetoltes();
			
				String cser;
				
				for (int i = 1; i < lines.size(); ++i) {
					
					
					
					String phone1 = hulyesegekTorlese(lines.get(i).getPhone1());
					String phone2 = hulyesegekTorlese(lines.get(i).getPhone2());
					String phone3 = hulyesegekTorlese(lines.get(i).getPhone3());
					
					//System.out.println(lines.get(i).getName() + " " + phone1 + " " + phone2 + " " + phone3);
					
					
					//feltételek
					
					
					//phone3 > phone2 > phone1
					
					
					if (phone1.equals("") && !phone2.equals("")) {
						phone1 = phone2;
					}
					
					
					//első feltétel: phone1<-phone3; phone2<-phone1
					if (!phone3.equals("") && !phone1.equals(phone3)) {
					
						 cser = phone3;
						phone3 = phone1;
						phone1 = cser;
						
						
						
						if (!phone2.equals(phone3)) {
							
							if(phone2.contains("1111111")) {
								
								 cser = phone2;
								phone2 = phone3;
								phone3 = cser;
							}
							
							if (phone2.equals(phone1) && !phone2.equals(phone3)) {
								cser = phone2;
								phone2 = phone3;
								phone3 = cser;
							}
							
							if (vezetekes(phone2) && !vezetekes(phone3)) {
								
								cser = phone3;
								phone3 = phone2;
								phone2 = cser;
							}
						}
						
					}
					
					
					//feltétel: ha phone1 vezetékes, akkor phone2-vel felcseréljük (ha abban mobil van)
					
					if (vezetekes(phone1) && !vezetekes(phone2)) {
						
						 cser = phone1;
						phone1 = phone2;
						phone2 = cser;
						
					} else if (vezetekes(phone1) && !vezetekes(phone3)) {
						
						cser = phone3;
						phone3 = phone1;
						phone1 = cser;
					} else if (vezetekes(phone1)) {
						phone2 = phone1;
						phone1 = "";
					}
					
					
					if (phone2.equals("") && !phone3.equals("")) {
						phone2 = phone3;
					}
					
					

					
					
					
				
					lines.get(i).setPhone1(phone1);
					lines.get(i).setPhone2(phone2);
					lines.get(i).setPhone3(phone3);
					
					//System.out.println(lines.get(i).getName() + " phone1: " + phone1);
					
				}
				
			}
			
			//ha vezetékes true-t térít vissza
			
			private boolean vezetekes(String phone1) {
				// TODO Auto-generated method stub
				
				boolean mobil = false;
				if (phone1.length() > 4) {
				for (int i = 0; !mobil && i < ertekek.length; ++i) {
					
					//System.out.println(ertekek[i]);
					if (phone1.substring(0, 5).contains(ertekek[i])) {
						mobil = true;
					}
					
				}
				
				return !mobil;
				} else {
					return false;
				}
			}


			//ha szerepel a végén az a faszság, akkor azt törölje le

			private String hulyesegekTorlese(String phone) {
				// TODO Auto-generated method stub
				
				String[] phones = phone.split("_");
				
				if (phones.length > 0)  {
					
					return phones[0];
				}
				
				else
				{
					return phone;
				}
			}


			//átmásoljuk a megjegyzéseket
			private void megjegyzesAtmasolasa() {
				// TODO Auto-generated method stub
				
				for (int i = 1; i < lines.size(); ++i) {
					
					lines.get(i).setMegjegyzes(lines.get(i).getMegjegyzes_2());
					
				}
				
				
				
			}
		});
		frame.getContentPane().add(btnVCC, BorderLayout.NORTH);
	}

}
