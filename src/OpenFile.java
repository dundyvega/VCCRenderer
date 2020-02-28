import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	private String[] idiots;
	private String hosszu;
	private int length;
	private String[] deleting;
	private String[] words;
	private String[] move;
	private String[] legordulo;
	private ArrayList<LineFromExcelFile> husszuUgyek;
	private ArrayList<LineFromExcelFile> normUgyek;
	private String[] uresMappak;
	private String[] uresFajlokVege;
	private String[] nemKizart;
	private String mobilXlsX;
	private String mobilTxt;
	private String masXLSX;
	private String maxTxt;
	private ArrayList<LineFromExcelFile> duplaUgyek;
	private String vezetekes;
	private String vezetekes1;

	/**
	 * Launch the application.
	 */
	
	
	public void configBetoltes() {
			// TODO Auto-generated method stub
			
			
			
			try {
			
				BufferedReader br = new BufferedReader(new FileReader("series.conf"));
				
				String line = br.readLine(); 
				
				ertekek = line.split("=")[1].split(",");
				
				idiots = br.readLine().split("=")[1].split(",");
				
				hosszu = br.readLine().split("=")[1];
				
				uresMappak = br.readLine().split("=")[1].split(",");
				uresFajlokVege = br.readLine().split("=")[1].split(",");
				
				length = Integer.parseInt(br.readLine().split("=")[1]);
				
				move = br.readLine().split(":")[1].split(",");
				deleting = br.readLine().split(":")[1].split(",");
				words = br.readLine().split("=")[1].split(",");
				legordulo= br.readLine().split("=")[1].split(",");
				nemKizart=br.readLine().split(":")[1].split("\\|\\|");
				
				mobilXlsX = br.readLine().split("=")[1];
				mobilTxt = br.readLine().split("=")[1];
				masXLSX =  br.readLine().split("=")[1];
				maxTxt = br.readLine().split("=")[1];
				
				vezetekes = br.readLine().split("=")[1];
				vezetekes1 = br.readLine().split("=")[1];
				
				
				
				
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
		try {
			
			configBetoltes();
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bűbájos OTG Excel Varázsló");
		
		btnVCC = new JButton("VCC Fájl Betöltése");
		
		btnVCC.setEnabled(false);
		btnVCC.setVisible(false);
		
		BufferedImage image = ImageIO.read(getClass().getResource("/img/Image.png"));
		
		JPanel jpanel = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(image, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
			}
			
		};
		
		//BufferedImage iconImage = ImageIO.read(getClass().getResource("/img/Icon.ico"));
		
		
		frame.setIconImage(image);
		
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
			            	  
			            	 // System.out.println("itt még jó");
			            	  
			            	  megjegyzesAtmasolasa();
			            	  
			            	  deletingItems();
			            	  
			            	  lines = normUgyek;
			            	  
			            	 // System.out.println("itt már nem jó");
			            	  
			            	  duplaugyekKiszedese();
			            	  
			            	  felbontas();
			            	  lines = normUgyek;
			            	  
			            	  
			            	  //System.out.println(husszuUgyek.get(0));
			            	  
			            	 
			            	  //átmásolja a megjegyzést
			            	 
			            	  
			            	  
			            	  
			            	 /* for (int i = 0; i < husszuUgyek.size(); ++i) {
			            		  System.out.println(husszuUgyek.get(i));
			            	  }*/
			            	  
			            	  telefonszamokRenderelese();
			            	 
			            	 FileOperator.setLines(chooser.getSelectedFile().getParent(), chooser.getSelectedFile().getName(), 
			            			 lines, husszuUgyek, uresMappak, uresFajlokVege, hosszu, legordulo);
			            	  
			            	 // System.out.println(lines.get(0).toString());
			            	 
			            	 JOptionPane.showMessageDialog(null, "kész!");
			            	  
			            	  } catch (Exception ex) {
			            		  
			            		  JOptionPane.showMessageDialog(null, ex.toString(), "Hibaüzenet", JOptionPane.ERROR_MESSAGE);
			            		  
			            	  }
			            	  
			              }
			        }
				 
			}

			private void duplaugyekKiszedese() {
				// TODO Auto-generated method stub
				
				Collections.sort(lines);
				duplaUgyek = new ArrayList<LineFromExcelFile>();
				//duplaUgyek.add(lines.get(0));
				
				for (int i = 1; i < lines.size() - 1; ++i) {
					if (lines.get(i).getAccount_number().equals(lines.get(i+1).getAccount_number())) {
						
						if (!duplaUgyek.contains(lines.get(i))) {
							duplaUgyek.add(lines.get(i));
						}
						
						if (!duplaUgyek.contains(lines.get(i+1))) {
							duplaUgyek.add(lines.get(i+1));
						}
						
						System.out.println("dupla: " + lines.get(i).getAccount_number());
					}
					
				}
				
				ArrayList<LineFromExcelFile> masUgy = new ArrayList<LineFromExcelFile>();
				masUgy.add(lines.get(0));
				
				for (int i = 1; i < lines.size(); ++i) {
					if (!duplaUgyek.contains(lines.get(i))) {
						masUgy.add(lines.get(i));
					}
				}
				
				lines = masUgy;
				
				
				
			}

		});
		frame.getContentPane().add(btnVCC, BorderLayout.NORTH);
		
		frame.getContentPane().add(jpanel, BorderLayout.CENTER);
		
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
			            	  
			            	  phone2();
			            	  
			            	  
			            	  /**
			            	   * mobilXlsX = br.readLine().split("=")[1];
								mobilTxt = br.readLine().split("=")[1];
								masXLSX =  br.readLine().split("=")[1];
								maxTxt = br.readLine().split("=")[1];
								vezetekes = br.readLine().split("=")[1];
								vezetekes1 = br.readLine().split("=")[1];
			            	   */
			            	  
			            	  FileOperator.setLines2(mobilXlsX, mobilTxt, masXLSX, maxTxt, vezetekes, vezetekes1, lines2);
			            	 
			            	// FileOperator.setLines(chooser.getSelectedFile().getPath(), lines);
			            	  
			            	 // System.out.println(lines.get(0).toString());
			            	 
			            	 JOptionPane.showMessageDialog(null, "kész!");
			            	  
			            	  } catch (Exception ex) {
			            		  
			            		  JOptionPane.showMessageDialog(null, ex.toString(), "Hibaüzenet", JOptionPane.ERROR_MESSAGE);
			            		  
			            	  }
			            	  
			              }
			}
			
		}


			/*
			 * a függvény beállítja a phone2 mezőt
			 */
			private void phone2() {
				// TODO Auto-generated method stub
				
				lines2.get(0).setPhone2("phone2");
				
				for (int i = 1; i < lines2.size(); ++i) {
					
					if (lines2.get(i).getPhone1().equals("") || lines2.get(i).getPhone1() == null) {
					
						lines2.get(i).setPhone2(getPhone2(i)); 
						
					}
						
					
					
					
				}
				
			}


			private String getPhone2(int i) {
				// TODO Auto-generated method stub
				
				String phone2 = "";
				
				String bus = lines2.get(i).getBusiness();
				String mobil2 = lines2.get(i).getMobil2();
				String otthon1 = lines2.get(i).getOtthoni1();
				String otthon2 = lines2.get(i).getOtthoni2();
				String mobil1 = lines2.get(i).getMobil1();
				
				
				
				
				phone2 = ( !otthon1.equals("") && !otthon1.contains("111111"))?otthon1:"";
				
				if (phone2.equals(""))
					phone2 = (!otthon2.equals("") && !otthon2.contains("111111"))?otthon2:"";
				
				if (phone2.equals(""))
					phone2 = (!bus.equals("") && !bus.contains("111111"))?bus:"";
				
				if (phone2.equals(""))
					phone2 = (!mobil1.equals("") && !mobil1.contains("111111"))?mobil1:"";
				
				if (phone2.equals(""))
					phone2 = (!mobil2.equals("") && !mobil2.contains("111111"))?mobil2:"";
				
				
				
				//if (!phone2.equals(""))
				//System.out.println(phone2);
				
				return phone2;
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
		
		
		String telszam = "";
		//System.out.println(mobil1 + " " +mobil2 + " " + otthoni1 + " " + otthoni2 + "  "  + munkahelyi + " " + business);
		
		//ArrayList<String> telszamok = new ArrayList<String>();

		
		if (!vezetekes(mobil1) && !mobil1.equals("") && !mobil1.contains("1111111")) {
			//System.out.println(mobil1);
			telszam = mobil1;
		}
		
		if (!vezetekes(business) && !business.equals("") && !business.contains("1111111") && telszam.equals("")) {
			telszam = business;
		}
		
		if (!vezetekes(mobil2) && !mobil2.equals("") && !mobil2.contains("1111111") && telszam.equals("")) {
			telszam = mobil2;
		}
		
		if (!vezetekes(otthoni1) && !otthoni1.equals("") && !otthoni1.contains("1111111") && telszam.equals("")) {
			telszam = otthoni1;
		}
		
		if (!vezetekes(otthoni2) && !otthoni2.equals("") && !otthoni2.contains("1111111") && telszam.equals("")) {
			telszam= otthoni2;
		}
		
		if (!vezetekes(munkahelyi) && !munkahelyi.equals("") && !munkahelyi.contains("1111111") && telszam.equals("")) {
			telszam= munkahelyi;
		}
		

		
		//System.out.println("lófaszok");
	

		
		return telszam;
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
			return true;
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
			////if (lines.get(i).getMegjegyzes_2().equals("") && ! lines.get(i).getMeg)
			lines.get(i).setMegjegyzes(lines.get(i).getMegjegyzes_2());
			
		}
		
		
		
	}
	
	//felbontja az ügyeket norm + hosszú ügyekre
	private void felbontas() {
		
		husszuUgyek = new ArrayList<LineFromExcelFile>();
		normUgyek = new ArrayList<LineFromExcelFile>();
		//duplaUgyek = new ArrayList<LineFromExcelFile>();
		
		husszuUgyek.add(lines.get(0));
		normUgyek.add(lines.get(0));
		
		for (int i = 1; i < lines.size(); ++i) {
			
			if (!lines.get(i).equals(lines.get(i - 1)))
				if (isHosszu(lines.get(i))) {
					husszuUgyek.add(lines.get(i));
				} else {
					normUgyek.add(lines.get(i));
				}
			
			
		}
		
		for (int i = 0; i < duplaUgyek.size(); ++i) {
			husszuUgyek.add(duplaUgyek.get(i));
		}
		
	}
	
	
	private void deletingItems() {
		
		normUgyek = new ArrayList<>();
		
		for (int i = 0; i < lines.size(); ++i) {
			
			if (!deleting(lines.get(i))) {
				
				normUgyek.add(lines.get(i));
			}
		}
		
	}

	private boolean deleting(LineFromExcelFile ln) {
		// TODO Auto-generated method stub
		
		boolean hosszu = false;
		
		
		
		
		for (int i = 0; i < deleting.length && !hosszu; ++i) {
			//System.out.println(deleting[i]);
			
			
			String a = deleting[i].split("=")[0];
			String b = deleting[i].split("=")[1];
			
			//System.out.println(a + "lesz a "  + b);
			
			if (ln.getValueOf(a).equals(b)) {
				hosszu = true;
			}
			
		}
		
		if (hosszu) {
			return hosszu;
		}
		
		return false;
	}

	private boolean isHosszu(LineFromExcelFile ln) {
		// TODO Auto-generated method stub
		
		boolean hosszu = false;
		
		//idióták vizsgálata
		
		for (int i = 0; i < idiots.length && !hosszu; ++i) {
			
			if (ln.getAccount_number().equals((idiots[i]))) {
				hosszu = true;
			}
		}
		
		if (hosszu) {
			return hosszu;
		}
		
		if (ln.getMegjegyzes_2().length() >= this.length) {
			return true;
		}
		
		if ((ln.getPhone1().equals("") || ln.getPhone1() == null) && (ln.getPhone2().equals("") || ln.getPhone2() == null)) {
			return true;
		}
		
		
		for (int i = 0; i < words.length && !hosszu; ++i) {
			
			if (ln.getMegjegyzes().contains(words[i])) {
				hosszu = true;
			}
			
		}
		
		
		if (hosszu) {
			return hosszu;
		}
		
		
		//ezeket kell hosszúba mozgatni
		
		for (int i = 0; i < move.length && !hosszu; ++i) {
			
			String a = move[i].split("=")[0];
			String b = move[i].split("=")[1];
			
			//System.out.println(a + " és " +  b);
			
			if (ln.getValueOf(a).equals(b)) {
				hosszu = true;
				//System.out.println(a + "= "  + b);
				//System.out.println(a + " egyenlő "  + b);
				
			}
			
		
			
		}
		
		if (hosszu) {
			return hosszu;
		}
		
		
		
		for (int i = 0; i < nemKizart.length && !hosszu; ++i) {
			
			String a = nemKizart[i].split("~")[0];
			
			//System.out.println(nemKizart[i] + "ez a legjobb");
			
		
			
			String a1 = a.split("&&")[0];
			
			//System.out.println("a1 " +a1);
			
			String a2 = a.split("&&")[1];
			
			//System.out.println("a2" + a2);
			
			String b = nemKizart[i].split("~")[1];
			
			String b1 = b.split("&&")[0];
			
			//System.out.println("b1 " + b1);
			
			String b2 = b.split("&&")[1];
			
			//System.out.println("b2: " + b2);
			
			//System.out.println(a1 + " " + a2 + " " + b1 + " " + b2);
			
			if (!ln.getValueOf(a1).equals(a2) && !ln.getValueOf(b1).equals(b2)) {
				hosszu = true;
				
			}
			
			
		}
		
		
		
		
		
		return hosszu;
		
		
		
	}
	
	
	
	//részben maradjon
	
	
	

}
