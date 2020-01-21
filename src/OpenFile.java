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
import java.util.Collections;
import java.awt.event.ActionEvent;

public class OpenFile {

	private JFrame frame;
	private JButton btnVCC;
	private JButton btnOTG;
	private ArrayList<LineFromExcelFile> lines;
	private ArrayList<LineFromOTGSMSExcel> lines2;
	String[] ertekek;

	/**
	 * Launch the application.
	 */
	
	
	public void configBetoltes() {
			// TODO Auto-generated method stub
			
			
			
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
			            	 
			            	 FileOperator.setLines(chooser.getSelectedFile().getParent(), chooser.getSelectedFile().getName(), lines);
			            	  
			            	 // System.out.println(lines.get(0).toString());
			            	 
			            	 JOptionPane.showMessageDialog(null, "kész!");
			            	  
			            	  } catch (Exception ex) {
			            		  
			            		  JOptionPane.showMessageDialog(null, ex.toString(), "Hibaüzenet", JOptionPane.ERROR_MESSAGE);
			            		  
			            	  }
			            	  
			              }
			        }
				 
			}

		});
		frame.getContentPane().add(btnVCC, BorderLayout.NORTH);
		
		btnOTG = new JButton("OTG SMS excel");
		
		frame.getContentPane().add(btnOTG, BorderLayout.SOUTH);
		
		btnOTG.addActionListener(new ActionListener() {

			


			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				File workingDirectory = new File(System.getProperty("user.dir"));
				
				JFileChooser chooser = new JFileChooser();
				
				chooser.setCurrentDirectory(workingDirectory);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
			                "Excel fájl", "xlsx", "XLSX");
			        chooser.setFileFilter(filter);
			        int returnVal = chooser.showOpenDialog(null);
			        if(returnVal == JFileChooser.APPROVE_OPTION) {
			            
			              String fileName = chooser.getSelectedFile().getParent() + "/";
			              
			              if (fileName != null && !fileName.equals("")) {
			            	  
			            	  try {
			            
			            	  lines2 = FileOperator.getLines2(chooser.getSelectedFile());
			            	  
			            	  
			            	  //először az otg end date-t megcsináljuk + a name-t
			            	  for (int i = 1; i < lines2.size(); ++i) {
			            		  lines2.get(i).setName("UPC ügyfél");
			            		 // String []darabolt = lines2.get(i).getEND_TIME().split("\\.");
			            		  lines2.get(i).setOtgendDay(lines2.get(i).getEND_TIME());
			            		  lines2.get(i).setPhone1(
			            		  telefonSzamRendereles(i, lines2.get(i).getOtthoni1(), lines2.get(i).getOtthoni2(), 
			            				  					lines2.get(i).getMobil1(), lines2.get(i).getMobil2(), 
			            				  					lines2.get(i).getBusiness(), lines2.get(i).getMunkahelyi()));
			            		  
			            		  
			            		  
			            	  }
			            	  
			            	  //átmásolja a megjegyzést
			            	  //megjegyzesAtmasolasa();
			            	  
			            	  //telefonszamokRenderelese();
			            	  
			            	  Collections.sort(lines2);
			            	  
			            	  FileOperator.setLines2(fileName, lines2);
			            	 
			            	// FileOperator.setLines(chooser.getSelectedFile().getPath(), lines);
			            	  
			            	 // System.out.println(lines.get(0).toString());
			            	 
			            	 JOptionPane.showMessageDialog(null, "kész!");
			            	  
			            	  } catch (Exception ex) {
			            		  
			            		  JOptionPane.showMessageDialog(null, ex.toString(), "Hibaüzenet", JOptionPane.ERROR_MESSAGE);
			            		  
			            	  }
			            	  
			              }
			}
			
		}


			private void telefonszamokRenderelese() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	protected String telefonSzamRendereles(int i, String otthoni1, String otthoni2, String mobil1, String mobil2,
			String business, String munkahelyi) {
		// TODO Auto-generated method stub
		
		configBetoltes();
		otthoni1 = hulyesegekTorlese(otthoni1);   // 3
		otthoni2 = hulyesegekTorlese(otthoni2);   // 4
		mobil1 = hulyesegekTorlese(mobil1);      //1
		mobil2 = hulyesegekTorlese(mobil2);      //2
		business = hulyesegekTorlese(business);  //0  
		munkahelyi = hulyesegekTorlese(munkahelyi); // 5
		
		//System.out.println(mobil1 + " " +mobil2 + " " + otthoni1 + " " + otthoni2 + "  "  + munkahelyi + " " + business);
		
		ArrayList<String> telszamok = new ArrayList<String>();

		if (!vezetekes(business) && !business.equals("") && !business.contains("1111111")) {
			telszamok.add(business);
		}
		
		if (!vezetekes(mobil1) && !mobil1.equals("") && !mobil1.contains("1111111")) {
			//System.out.println(mobil1);
			telszamok.add(mobil1);
		}
		
		if (!vezetekes(mobil2) && !mobil2.equals("") && !mobil2.contains("1111111")) {
			telszamok.add(mobil2);
		}
		
		if (!vezetekes(otthoni1) && !otthoni1.equals("") && !otthoni1.contains("1111111")) {
			telszamok.add(otthoni1);
		}
		
		if (!vezetekes(otthoni2) && !otthoni2.equals("") && !otthoni2.contains("1111111")) {
			telszamok.add(otthoni2);
		}
		
		if (!vezetekes(munkahelyi) && !munkahelyi.equals("") && !munkahelyi.contains("1111111")) {
			telszamok.add(munkahelyi);
		}
		
		if (telszamok.size() == 0) {
			telszamok.add("");
		}
		
		//System.out.println("lófaszok");
	

		
		return telszamok.get(0);
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
	
	
	
	

}
