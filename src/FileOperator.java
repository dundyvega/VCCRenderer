import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class FileOperator {
	
	private static String cellStringValue(Cell cell) {
	
		String str = "";
		
		
		if (cell != null && cell.getCellType() != CellType.BLANK) {
			
		if (cell.getCellType() == CellType.NUMERIC) {
			
			
			if (!HSSFDateUtil.isCellDateFormatted(cell)) {
				
				str = NumberToTextConverter.toText(cell.getNumericCellValue());
				////System.out.println("semmi");
			} else {
				
				DateFormat df = new SimpleDateFormat("yyy/MM/dd");
				str = df.format(cell.getDateCellValue());
				////System.out.println("semmi");
			}
			
		} else if (cell.getCellType() == CellType.ERROR) {
			str = "error" + "";
			////System.out.println("semmi");
			////System.out.println("error");
			
		} else
			
			if (cell.getCellType() == CellType.STRING && !cell.getStringCellValue().equals("") && cell.getStringCellValue() != null) {
		
				////System.out.println("semmi");	
				
			str = cell.getStringCellValue();
			
		}
		} 
		
		////System.out.println(str);
	
		return str;
	
	}
	
	
	
	public static ArrayList<VTVLineFromExcel> getLinesVTV(String fileName) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<VTVLineFromExcel> lines = new ArrayList<VTVLineFromExcel>();
		
		FileInputStream excelFile = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();


		
		//adatok kiolvasása
		while (iterator.hasNext()) {
			

			Row currentRow = iterator.next();
			
	
			
			VTVLineFromExcel line = new VTVLineFromExcel();


			
			line.setIktato(cellStringValue(currentRow.getCell(0)));
			line.setSubject(cellStringValue(currentRow.getCell(1)));
			line.setContactDate(cellStringValue(currentRow.getCell(2)));
			line.setEszkoz(cellStringValue(currentRow.getCell(3)));
			line.setErintett(cellStringValue(currentRow.getCell(4)));
			line.setVtvHiba(cellStringValue(currentRow.getCell(5)));
			line.setHibajelenseg(cellStringValue(currentRow.getCell(6)));
			line.setHibajelensegMegnevezese(cellStringValue(currentRow.getCell(7)));
			line.setHibaOka(cellStringValue(currentRow.getCell(8)));
			line.setKivizsgalasEredmenye(cellStringValue(currentRow.getCell(9)));
			line.setNemoOTGID(cellStringValue(currentRow.getCell(10)));
			line.setEtID(cellStringValue(currentRow.getCell(11)));
			line.setEszkozellenorzesVolt(cellStringValue(currentRow.getCell(12)));
			line.setJelszintekRendben(cellStringValue(currentRow.getCell(13)));
			line.setSelfInstal(cellStringValue(currentRow.getCell(14)));
			line.setEventusIDAzonosito(cellStringValue(currentRow.getCell(15)));
			line.setMlComplaintCoda(cellStringValue(currentRow.getCell(16)));
			line.setMIWOType(cellStringValue(currentRow.getCell(17)));
			line.setMIWOStatus(cellStringValue(currentRow.getCell(18)));
			
			line.setMIResolutionType(cellStringValue(currentRow.getCell(19)));
			line.setMIDesc(cellStringValue(currentRow.getCell(20)));
			line.setUgyMegnevezese(cellStringValue(currentRow.getCell(21)));
			line.setNode(cellStringValue(currentRow.getCell(22)));
			line.setHibaKod(cellStringValue(currentRow.getCell(23)));
			
			
			////System.out.println(line.toString());	
			
			lines.add(line);
			
		
			
			////System.out.println(line.toString());
		////System.out.println(line.getName());
			
		}
		
		////System.out.println("valami");
		
		workbook.close();
		
		return lines;
		
		
	}


	
	

	public static ArrayList<LineFromExcelFile> getLines(String fileName) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<LineFromExcelFile> lines = new ArrayList<LineFromExcelFile>();
		
		FileInputStream excelFile = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();


		
		//adatok kiolvasása
		while (iterator.hasNext()) {
			

			Row currentRow = iterator.next();
			
	
			
			LineFromExcelFile line = new LineFromExcelFile();

			
			
			line.setAccount_number(cellStringValue(currentRow.getCell(0)));
			line.setIktato(cellStringValue(currentRow.getCell(1)));
			line.setErintett_szolgaltatasok(cellStringValue(currentRow.getCell(2)));
			line.setHibabejelentes_kategoriaja(cellStringValue(currentRow.getCell(3)));
			line.setHiba_oka(cellStringValue(currentRow.getCell(4)));
			line.setKivizsgalas_eredmenye(cellStringValue(currentRow.getCell(5)));
			line.setTovabbitas_hdra(cellStringValue(currentRow.getCell(6)));
			line.setMegjegyzes(cellStringValue(currentRow.getCell(7)));
			line.setCcss_contact_id(cellStringValue(currentRow.getCell(8)));
			line.setName(cellStringValue(currentRow.getCell(9)));
			line.setUgyfeltipus(cellStringValue(currentRow.getCell(10)));
			line.setPhone2(cellStringValue(currentRow.getCell(11)));
			line.setPhone1(cellStringValue(currentRow.getCell(12)));
			line.setFolyamat_indulasa(cellStringValue(currentRow.getCell(13)));
			line.setFazis_neve(cellStringValue(currentRow.getCell(14)));
			line.setFolyamat_inditoja(cellStringValue(currentRow.getCell(15)));
			line.setSzolgaltatasi_cim(cellStringValue(currentRow.getCell(16)));
			line.setFazis_indulasa(cellStringValue(currentRow.getCell(17)));
			line.setDB_TYPE(cellStringValue(currentRow.getCell(18)));
			
			line.setMEGJ_HOSSZ(cellStringValue(currentRow.getCell(19)));
			line.setBEZ(cellStringValue(currentRow.getCell(20)));
			line.setANGOL(cellStringValue(currentRow.getCell(21)));
			line.setVUI(cellStringValue(currentRow.getCell(22)));
			line.setMegjegyzes_2(cellStringValue(currentRow.getCell(23)));
			////System.out.println(line.getName());
			line.setPhone3(cellStringValue(currentRow.getCell(24)));
			
			////System.out.println(line.toString());	
			
			lines.add(line);
			
		
			
			////System.out.println(line.toString());
		////System.out.println(line.getName());
			
		}
		
		////System.out.println("valami");
		
		workbook.close();
		
		return lines;
		
		
	}

	private static void kiiratas(ArrayList<LineFromExcelFile> lines, XSSFSheet sheet) {
		
		//kiírjuk az adatokat
		int rowIndex = 0;
		int cellIndex;
		for (int i = 0; i < lines.size(); ++i) {
			
			Row row = sheet.createRow(rowIndex++);
			
			cellIndex = 0;
			
			
			//1.private String account_number;
			Cell cell = row.createCell(cellIndex++);
			cell.setCellValue(lines.get(i).getAccount_number());
			
			
			
			
			//2.private String iktato;
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(lines.get(i).getIktato());
			
			
			//3.private String erintett_szolgaltatasok;
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(lines.get(i).getErintett_szolgaltatasok());
			
			
			
			//4.private String hibabejelentes_kategoriaja;
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(lines.get(i).getHibabejelentes_kategoriaja());
			
			
			//5private String hiba_oka;
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(lines.get(i).getHiba_oka());
			
			//6private String kivizsgalas_eredmenye;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getKivizsgalas_eredmenye());
			
			//7private String tovabbitas_hdra;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getTovabbitas_hdra());
			
			//private String megjegyzes;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getMegjegyzes());
			
			//9private String ccss_contact_id;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getCcss_contact_id());
			
			//private String name;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getName());
			
			//private String ugyfeltipus;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getUgyfeltipus());
			
			//private String phone1;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getPhone1());
			
			//private String phone2;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getPhone2());
			
			//private String folyamat_indulasa;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getFolyamat_indulasa());
			
			//private String fazis_neve;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getFazis_neve());
			
			//private String folyamat_inditoja;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getFolyamat_inditoja());
			
			//private String szolgaltatasi_cim;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getSzolgaltatasi_cim());
			
			//private String fazis_indulasa;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getFazis_indulasa());
			
			//private String DB_TYPE;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getDB_TYPE());
			
			//private String MEGJ_HOSSZ;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getMEGJ_HOSSZ());
			
			//private String BEZ;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getBEZ());
			
			//private String ANGOL;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getANGOL());
			
			//private String VUI;
			 cell = row.createCell(cellIndex++);
				cell.setCellValue(lines.get(i).getVUI());
			
			
		}
		
	}
	
	public static void setLines(String folder, String string, ArrayList<LineFromExcelFile> lines, ArrayList<LineFromExcelFile> husszuUgyek, String[] uresMappak, String[] uresFajlokVege, String hosszuMappa, String[] legordulo) throws IOException {
		// TODO Auto-generated method stub
		
		string = string.split("\\.")[0] + " - Automata IVR.xlsx";
		////System.out.println(string);
		string = folder + "/" + string;
		////System.out.println(string);
		
		hosszComparable(lines);
		
		ArrayList<LineFromExcelFile> ln1 = new ArrayList<LineFromExcelFile>();
		
		for (int i = 1; i < lines.size(); ++i) {
			ln1.add(lines.get(i));
		}
		
		 Collections.sort(ln1, Collections.reverseOrder());
		 
		 ArrayList<LineFromExcelFile> ln2 = new ArrayList<LineFromExcelFile>();
		 
		 ln2.add(lines.get(0));
		 for (int i = 0; i < ln1.size(); ++i) {
			 ln2.add(ln1.get(i));
		 }
		
		 lines = ln2;
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
		kiiratas(lines, sheet);
		

		
		
		
		FileOutputStream excelFile = new FileOutputStream(string);
		  
	
		
		  workbook.write(excelFile);
		  workbook.close();
		  
		  excelFile.close();
		  
		  //hosszú ügyek
		  
		  workbook = new XSSFWorkbook();
		   sheet = workbook.createSheet("Data");
		  
		   kiiratas(husszuUgyek, sheet);
		   
		   
		   sheet = workbook.createSheet("status");
		   
		   int rowIndex = 0;
		  // Row row = sheet.createRow(rowIndex);
		   
		   for (int i = 0; i < legordulo.length; ++i) {
			   Row row = sheet.createRow(rowIndex++); 
			   Cell cell = row.createCell(0);
			   cell.setCellValue(legordulo[i]);
			   
			   
		   }
		   
		   
		   Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat formatter = new SimpleDateFormat("YYY.MM.dd");
			String dat = formatter.format(date);
			
			
			
			
			string = folder + "/"+ hosszuMappa + dat + " - Hosszú ügyek.xlsx"; 
		   
			 excelFile = new FileOutputStream(string);
			
			 workbook.write(excelFile);
			  workbook.close();
			  
			  excelFile.close();
		  
		  uresMappakElkeszitese(folder, uresMappak, uresFajlokVege);
		
	}
	
	
	

	
	private static void hosszComparable(ArrayList<LineFromExcelFile> lines) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < lines.size(); ++i) {
			lines.get(i).setHossztNez(true);
		}
		
		
		
	}

	/*
	 * Létrehozza az üres fájlokat
	 */
	private static void uresMappakElkeszitese(String folder, String[] uresMappak, String[] uresFajlokVege) throws IOException {
		// TODO Auto-generated method stub
		
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("YYY.MM.dd");
		String dat = formatter.format(date);
		for (int i = 0; i < uresMappak.length; ++i) {
			
			String string = folder + "/" + uresMappak[i] + dat + uresFajlokVege[i];
			////System.out.println(string);
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("data");
			
			FileOutputStream excelFile = new FileOutputStream(string);
			  
			
			
			  workbook.write(excelFile);
			  workbook.close();
			  
			  excelFile.close();
			
		}
 		
		
	}

	public static ArrayList<LineFromOTGSMSExcel> getLines2(File file) throws IOException {

		// TODO Auto-generated method stub
		ArrayList<LineFromOTGSMSExcel> lines = new ArrayList<LineFromOTGSMSExcel>();
		
		FileInputStream excelFile = new FileInputStream(file.getPath());
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();


		
		//adatok kiolvasása
		while (iterator.hasNext()) {
			

			Row currentRow = iterator.next();
			
	
			
			LineFromOTGSMSExcel line = new LineFromOTGSMSExcel();

			
			
			//line.setUres(cellStringValue(currentRow.getCell(0)));
			line.setIKTSZ(cellStringValue(currentRow.getCell(0)));
			line.setACCOUNT_NUMBER(cellStringValue(currentRow.getCell(1)));
			line.setW(cellStringValue(currentRow.getCell(2)));
			line.setCONTACT_TYPE(cellStringValue(currentRow.getCell(3)));
			line.setSUBJECT(cellStringValue(currentRow.getCell(4)));
			line.setSTATUSZ(cellStringValue(currentRow.getCell(5)));
			line.setINDITAS(cellStringValue(currentRow.getCell(6)));
			line.setINDITAS_NAPJA(cellStringValue(currentRow.getCell(7)));
			line.setLEZARAS_NAPJA(cellStringValue(currentRow.getCell(8)));
			line.setNemo_OTG_ID(cellStringValue(currentRow.getCell(9)));
			line.setINTERFACE_ID(cellStringValue(currentRow.getCell(10)));
			line.setOTG_STATUS_DATE(cellStringValue(currentRow.getCell(11)));
			line.setOTG_CLOSED(cellStringValue(currentRow.getCell(12)));
			line.setSTART_TIME(cellStringValue(currentRow.getCell(13)));
			line.setEND_TIME(cellStringValue(currentRow.getCell(14)));
			line.setSMS_SENT_TO(cellStringValue(currentRow.getCell(15)));
			line.setOtthoni1(cellStringValue(currentRow.getCell(16)));
			line.setOtthoni2(cellStringValue(currentRow.getCell(17)));
			line.setMobil1(cellStringValue(currentRow.getCell(18)));
			line.setMobil2(cellStringValue(currentRow.getCell(19)));
			line.setBusiness(cellStringValue(currentRow.getCell(20)));
			line.setMunkahelyi(cellStringValue(currentRow.getCell(21)));
			line.setADE(cellStringValue(currentRow.getCell(22)));
			line.setPhone1("");
			line.setPhone2("");
			//line.setOtgendDay(cellStringValue(currentRow.getCell(22)));
			//line.setName(cellStringValue(currentRow.getCell(23)));
			//line.setPhone1(cellStringValue(currentRow.getCell(24)));
			
			////System.out.println(line.getW() + line.getACCOUNT_NUMBER());	
			
			lines.add(line);
			
			////System.out.println(line.toString());
			
		}
		
		////System.out.println("valami");
		
		workbook.close();
		
		return lines;
		
		
	
	}
	
	
	public static ArrayList<LineFromOTGSMSExcel> getLines2HSSF(File file) throws IOException {

		// TODO Auto-generated method stub
		ArrayList<LineFromOTGSMSExcel> lines = new ArrayList<LineFromOTGSMSExcel>();
		
		FileInputStream excelFile = new FileInputStream(file.getPath());
		Workbook workbook = WorkbookFactory.create(file);
		Sheet datatypeSheet = (Sheet) workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();

		////System.out.println("Itt még ok");
		
		//adatok kiolvasása
		while (iterator.hasNext()) {
			

			Row currentRow = iterator.next();
			
	
			
			LineFromOTGSMSExcel line = new LineFromOTGSMSExcel();

			
			
			//line.setUres(cellStringValue(currentRow.getCell(0)));
			line.setIKTSZ(cellStringValue(currentRow.getCell(0)));
			line.setACCOUNT_NUMBER(cellStringValue(currentRow.getCell(1)));
			line.setCONTACT_TYPE(cellStringValue(currentRow.getCell(2)));
			line.setSUBJECT(cellStringValue(currentRow.getCell(3)));
			line.setSTATUSZ(cellStringValue(currentRow.getCell(4)));
			line.setINDITAS(cellStringValue(currentRow.getCell(5)));
			line.setINDITAS_NAPJA(cellStringValue(currentRow.getCell(6)));
			line.setLEZARAS_NAPJA(cellStringValue(currentRow.getCell(7)));
			line.setNemo_OTG_ID(cellStringValue(currentRow.getCell(8)));
			line.setINTERFACE_ID(cellStringValue(currentRow.getCell(9)));
			line.setOTG_STATUS_DATE(cellStringValue(currentRow.getCell(10)));
			line.setOTG_CLOSED(cellStringValue(currentRow.getCell(11)));
			line.setSTART_TIME(cellStringValue(currentRow.getCell(12)));
			line.setEND_TIME(cellStringValue(currentRow.getCell(13)));
			line.setSMS_SENT_TO(cellStringValue(currentRow.getCell(14)));
			line.setOtthoni1(cellStringValue(currentRow.getCell(15)));
			line.setOtthoni2(cellStringValue(currentRow.getCell(16)));
			line.setMobil1(cellStringValue(currentRow.getCell(17)));
			line.setMobil2(cellStringValue(currentRow.getCell(18)));
			line.setBusiness(cellStringValue(currentRow.getCell(19)));
			line.setMunkahelyi(cellStringValue(currentRow.getCell(20)));
			line.setADE(cellStringValue(currentRow.getCell(21)));
			
			////System.out.println(line.getADE() + "Ade");
			//line.setOtgendDay(cellStringValue(currentRow.getCell(22)));
			//line.setName(cellStringValue(currentRow.getCell(23)));
			//line.setPhone1(cellStringValue(currentRow.getCell(24)));
			
			////System.out.println(line.toString());	
			
			lines.add(line);
			
			//System.out.println(line.getW());
			
			////System.out.println(line.toString());
			
		}
		
		////System.out.println("valami");
		
		workbook.close();
		
		return lines;
		
		
	
	}
	
	
	
	
	
	

	public static void setLines2(String mobilXLXS, String mobilTxt, String masXLSX, String maxTxt, String vezetekesXLSX, String vezetekesTxt, String masHetvege, String masHetvege1, ArrayList<LineFromOTGSMSExcel> lines2) throws IOException {
		// TODO Auto-generated method stub
		
		////System.out.println(lines2.get(0).getW());
		
		Date date = new Date(System.currentTimeMillis());
		
		
		

		
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYY.MM.dd HH 'óra'");
		
		String mobiljaVan = mobilXLXS + "OTG -" + formatter.format(date) + " Mobil SMS.xlsx";
		String mobiljaVanTxt = mobilTxt + "OTG -" + formatter.format(date) + " Mobil SMS.txt";
		
		////System.out.print("Ez lesz: " + mobilTxt);
		
		String dayOfWeek = new SimpleDateFormat("EEE", Locale.ENGLISH).format(date);
		////System.out.println(dayOfWeek);
		
		String masVan;
		String masVanTxt;
		
		

		
		if (dayOfWeek.equals("Sat") || dayOfWeek.equals("Sun")) {
			
			
			 
			
			 
			 masVan = masHetvege + "OTG -" + formatter.format(date) + " Egyéb ügyek.xlsx";
			 masVanTxt = masHetvege1 + "OTG -" + formatter.format(date) + " Egyéb ügyek.txt";
			
		} else {
			
			 masVan = masXLSX + "OTG -" + formatter.format(date) + " Egyéb ügyek.xlsx";
			 masVanTxt = maxTxt + "OTG -" + formatter.format(date) + " Egyéb ügyek.txt";
			 
		}
		
		String vezetekesVan = vezetekesXLSX + "OTG - " + formatter.format(date) + " vezetekes.xlsx";
		String vezetekesVanTxt = vezetekesTxt + "OTG - " + formatter.format(date) + " vezetekes.txt";
		/*
		try {
			date = new SimpleDateFormat( "yyyyMMdd" ).parse( "20200307" );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
 		
		
		//fileName = fileName + "OTG -" + formatter.format(date) + ".xlsx";
		/*OTG_Lezaras_panasz_erintett
		String mobiljaVan = fileName + "OTG -" + formatter.format(date) + " Mobil SMS.xlsx";
		String emailCimeVan = fileName + "OTG - " + formatter.format(date) + " Email.xlsx";
		String vezetekesSzamaVan = fileName + "OTG - " + formatter.format(date) + " Vezetekes.xlsx";
		String ures = fileName + "OTG - " + formatter.format(date) + " Ures.xlsx";
		*/
		
		//String csv = fileName + "OTG - " + formatter.format(date) + ".txt";
		//String csvT = "";
		
		
		//
		// txt fájlok
		/*
		
		String mobiljaVanTxt = fileName + "OTG SMS - unicode/OTG - " + formatter.format(date) + " Mobil SMS.txt";
		String emailCimeVanTxt = fileName + "OTG Email - unicode/OTG - " + formatter.format(date) + " Email.txt";
		String vezetekesSzamaVanTxt = fileName + "OTG Vezetekes tel - unicode/OTG - " + formatter.format(date) + " Vezetekes.txt";
		String uresTxt = fileName + "OTG Ures - unicode/OTG - " + formatter.format(date) + " Ures.txt";
		
		String mobilM = "";
		String emailM = "";
		String vezetekesM = "";
		String uresM = "";
		
		*/
		String mas = "";
		String mobilM = "";
		String vezetekesM = "";
		
		
		////System.out.println(fileName);
		
		
		/* mobilos excel */
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
		int rowIndex = 0;
		int cellIndex;
		
		/*emailosra vonatkozó excel */
		
		
		/*XSSFWorkbook workbookEmail = new XSSFWorkbook();
		XSSFSheet sheetEmail = workbookEmail.createSheet("data");
		
		int rowIndexEmail = 0;
		int cellIndexEmail;
		
		
		
		/*vezetekes*/
		
		/*XSSFWorkbook workbookVezetekes = new XSSFWorkbook();
		XSSFSheet sheetVezetekes = workbookVezetekes.createSheet("data");
		
		int rowIndexVezetekes = 0;
		int cellIndexVezetekes;
		
		
		/**
		 * itt már meg kell várjam Örsöt, mivel ha van email címe, akkor hová kerüljön be
		 */
		
		/*üres*/
		
		/*XSSFWorkbook workbookUres = new XSSFWorkbook();
		XSSFSheet sheetUres = workbookUres.createSheet("data");
		
		int rowIndexUres = 0;
		int cellIndexUres;
		
		/*fájlok létrehozva */
		
		//System.out.println("itt");
		
		XSSFWorkbook workbookMas = new XSSFWorkbook();
		XSSFSheet sheetMas = workbookMas.createSheet("data");
		
		int rowIndexMas = 0;
		int cellIndexMas;
		
		XSSFWorkbook workbookVezetekes = new XSSFWorkbook();
		XSSFSheet sheetVezetekes = workbookVezetekes.createSheet("data");
		
		int rowIndexVezetekes = 0;
		int cellIndexVezetekes;
		
		
		lines2.get(0).setName("name");
		lines2.get(0).setPhone1("phone1");
		lines2.get(0).setOtgendDay("OTGEndDay");
		
		//első sor kiirása
		
		////System.out.println(lines2.get(0).getW() + " sfdsfd");
		
		lines2.get(0).setACCOUNT_NUMBER("account_number");
		lines2.get(0).setIKTSZ("iktato");
		
		mobilM = teddBeAfileBa(sheet, rowIndex++, lines2.get(0), mobilM);
		mas = teddBeAfileBa(sheetMas, rowIndexMas++, lines2.get(0), mas);
		vezetekesM = teddBeAfileBa(sheetVezetekes, rowIndexVezetekes++, lines2.get(0), vezetekesM);
		//emailM = teddBeAfileBa(sheetEmail, rowIndexEmail++, lines2.get(0), emailM);
		//vezetekesM = teddBeAfileBa(sheetVezetekes, rowIndexVezetekes++, lines2.get(0), vezetekesM);
		
		
		for (int i = 1; i < lines2.size(); ++i) {
			
			
			if (i == 0 || !lines2.get(i).getACCOUNT_NUMBER().equals(lines2.get(i -1).getACCOUNT_NUMBER()) ||
					lines2.get(i).getACCOUNT_NUMBER().equals(lines2.get(i-1).getACCOUNT_NUMBER()) &&
					!lines2.get(i).getNemo_OTG_ID().equals(lines2.get(i - 1).getNemo_OTG_ID())) {
			
		if (i == 0 || lines2.get(i).getSMS_SENT_TO().equals("")) {
					
					LineFromOTGSMSExcel ln = lines2.get(i);
					//csvT += ln.getIKTSZ() + ";HIB;X\n";
					
					if (!ln.getPhone1().equals("")) { // ha mobil
						
						mobilM = teddBeAfileBa(sheet, rowIndex++, ln, mobilM);
					} else if (ln.getADE().equals("") && ln.getPhone2().equals("")) { // ha üres
						mas = teddBeAfileBa(sheetMas, rowIndexMas++, ln, mas);
					} else if (!ln.getADE().equals("") && !ln.getPhone2().equals("")) { // ha mindkettő
						vezetekesM = teddBeAfileBa(sheetVezetekes, rowIndexVezetekes++, ln, vezetekesM);
						
					} else if (!ln.getADE().equals("")) { // ha emailja van csak
						
						mas = teddBeAfileBa(sheetMas, rowIndexMas++, ln, mas);
					} else {
						vezetekesM = teddBeAfileBa(sheetVezetekes, rowIndexVezetekes++, ln, vezetekesM);
					}
			
				}
			}
		}
		
	//	//System.out.println("dobozos csomag");
		
		////System.out.println(mobilM + "ez aaz");
		  
		
		kiiratasFileba(mobiljaVan, workbook, mobilM, mobiljaVanTxt);
		  
		  //kiiratasFileba(vezetekesSzamaVan, workbookVezetekes, vezetekesM, vezetekesSzamaVanTxt);
		  
		  //kiiratasFileba(emailCimeVan, workbookEmail, emailM, emailCimeVanTxt);
		  
		kiiratasFileba(masVan, workbookMas, mas, masVanTxt);
		
		kiiratasFileba(vezetekesVan, workbookVezetekes, vezetekesM, vezetekesVanTxt);
		 
		 	/*int scvLast = csvT.length() -1 ;
		 
			BufferedWriter br = new BufferedWriter(new FileWriter(csv));
			br.write(csvT.substring(0, scvLast));
			br.close();*/
		  
	}
	
	
	
	
	
	private static void kiiratasFileba(String string, XSSFWorkbook workbook, String mit, String hova) throws IOException {
		// TODO Auto-generated method stub
		
		//System.out.println(hova);
		//System.out.println(string);
		
		
		FileOutputStream excelFile = new FileOutputStream(string);
		  
		
		
		  workbook.write(excelFile);
		  workbook.close();
		  
		  excelFile.close();
		  
		  
		  //File file = new File(hova);
		  
		  //mit += "\u001a";
		  
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(hova, true), StandardCharsets.UTF_8));
			br.write(mit);
			br.close();
			
	
		
		
	}

	public static String teddBeAfileBa(XSSFSheet sheet, int rowIndex, LineFromOTGSMSExcel lines2, String txt) {
		
		
		Row row = sheet.createRow(rowIndex);
		
		int cellIndex = 0;
		
		
		////System.out.println(lines2.getW());
		
		//Cell cell = row.createCell(cellIndex++); cell.setCellValue(lines2.get(i).getUres());
				Cell cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getIKTSZ());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getACCOUNT_NUMBER());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getW());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getCONTACT_TYPE());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getSUBJECT());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getSTATUSZ());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getINDITAS());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getINDITAS_NAPJA());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getLEZARAS_NAPJA());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getNemo_OTG_ID());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getINTERFACE_ID());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getOTG_STATUS_DATE());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getOTG_CLOSED());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getSTART_TIME());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getEND_TIME());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getSMS_SENT_TO());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getOtthoni1());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getOtthoni2());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getMobil1());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getMobil2());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getBusiness());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getMunkahelyi());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getADE());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getOtgendDay());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getName());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getPhone1());
				cell = row.createCell(cellIndex++); cell.setCellValue(lines2.getPhone2());
				
				
				txt += 	lines2.getIKTSZ()+ "\t" + 
						lines2.getACCOUNT_NUMBER()+ "\t" + 
						lines2.getW() + "\t" + 
						lines2.getCONTACT_TYPE()+ "\t" + 
						lines2.getSUBJECT()+ "\t" + 
						lines2.getSTATUSZ()+ "\t" + 
						lines2.getINDITAS()+ "\t" + 
						lines2.getINDITAS_NAPJA()+ "\t" + 
						lines2.getLEZARAS_NAPJA()+ "\t" + 
						lines2.getNemo_OTG_ID()+ "\t" + 
						lines2.getINTERFACE_ID() + "\t" + 
						lines2.getOTG_STATUS_DATE()+ "\t" + 
						lines2.getOTG_CLOSED()+ "\t" + 
						lines2.getSTART_TIME()+ "\t" + 
						lines2.getEND_TIME()+ "\t" + 
						lines2.getSMS_SENT_TO()+ "\t" + 
						lines2.getOtthoni1()+ "\t" + 
						lines2.getOtthoni2()+ "\t" + 
						lines2.getMobil1()+ "\t" + 
						lines2.getMobil2()+ "\t" + 
						lines2.getBusiness()+ "\t" + 
						lines2.getMunkahelyi()+ "\t" + 
						lines2.getADE()+ "\t" + 
						lines2.getOtgendDay()+ "\t" + 
						lines2.getName()+ "\t" + 
						lines2.getPhone1()+ "\t" + 
						lines2.getPhone2()+ System.lineSeparator();
				
				////System.out.println(txt);
				
				return txt;
		
	}



	public static void setLines3(String folder, String string, ArrayList<VTVLineFromExcel> lines3,
			ArrayList<VTVLineFromExcel> hosszuUgyekVTV, String kimenetVTV, String kimenetNemVTV) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		////System.out.println(string);
		string = folder + "/" + kimenetNemVTV;
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
		kiiratas3(lines3, sheet);
		

		
		
		
		FileOutputStream excelFile = new FileOutputStream(string);
		  
	
		
		  workbook.write(excelFile);
		  workbook.close();
		  
		  excelFile.close();
		  
		  string = folder + "/" + kimenetVTV;
		
			 workbook = new XSSFWorkbook();
			 sheet = workbook.createSheet("data");
			
			kiiratas3(hosszuUgyekVTV, sheet);
			

			
			
			
			 excelFile = new FileOutputStream(string);
			  
		
			
			  workbook.write(excelFile);
			  workbook.close();
			  
			  excelFile.close();
	}



	private static void kiiratas3(ArrayList<VTVLineFromExcel> lines3, XSSFSheet sheet) {
		// TODO Auto-generated method stub
		
		int rowIndex = 0;
		int cellIndex;
		for (int i = 0; i < lines3.size(); ++i) {
			
			Row row = sheet.createRow(rowIndex++);
			
			cellIndex = 0;
			
			
			//1.private String account_number;
			Cell cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getIktato());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getSubject());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getContactDate());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getEszkoz());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getErintett());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getVtvHiba());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getHibajelenseg());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getHibajelensegMegnevezese());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getHibaOka());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getKivizsgalasEredmenye());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getNemoOTGID());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getEtID());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getEszkozellenorzesVolt());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getJelszintekRendben());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getSelfInstal());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getEventusIDAzonosito());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getMlComplaintCoda());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getMIWOType());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getMIWOStatus());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getMIResolutionType());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getMIDesc());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getUgyMegnevezese());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getNode());
			cell = row.createCell(cellIndex++); cell.setCellValue(lines3.get(i).getHibaKod());
		
	}
	}



	public static ArrayList<OrsiLineFromExcel> OrsiListGet(File file) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<OrsiLineFromExcel> lines = new ArrayList<OrsiLineFromExcel>();
		
		
		
		FileInputStream excelFile = new FileInputStream(file.getPath());
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet datatypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = datatypeSheet.iterator();


		
		//adatok kiolvasása
		while (iterator.hasNext()) {
			

			Row currentRow = iterator.next();
			
	
			
			OrsiLineFromExcel line = new OrsiLineFromExcel();

			
			
			//line.setUres(cellStringValue(currentRow.getCell(0)));
			line.setA(cellStringValue(currentRow.getCell(0)));
			line.setB(cellStringValue(currentRow.getCell(1)));
			line.setC(cellStringValue(currentRow.getCell(2)));
			line.setD(cellStringValue(currentRow.getCell(3)));
			
			
			lines.add(line);
			
			////System.out.println(line.toString());
			
		}
		
		////System.out.println("valami");
		
		workbook.close();
		
		return lines;
		
		
		
		
		
		
		
	}



	public static void kiirOrsiList(ArrayList<OrsiLineFromExcel> orsiList, File file) throws IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
		
		String string = file.getParent();
		string = file.getAbsolutePath().split(".xlsx")[0] + " - Automata IVR.xlsx";
		
		//string += "/" + "valami.xlsx";
		//kiiratas(lines, sheet);
		
		int rowIndex = 0;
		int cellIndex;
		for (int i = 0; i < orsiList.size(); ++i) {
			
			Row row = sheet.createRow(rowIndex++);
			
			cellIndex = 0;
			
			
			//1.private String account_number;
			Cell cell = row.createCell(cellIndex++);
			cell.setCellValue(orsiList.get(i).getA());
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(orsiList.get(i).getB());
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(orsiList.get(i).getC());
			 cell = row.createCell(cellIndex++);
			cell.setCellValue(orsiList.get(i).getD());
			
		}
		
		
		FileOutputStream excelFile = new FileOutputStream(string);
		  
	
		
		  workbook.write(excelFile);
		  workbook.close();
		  
		  excelFile.close();
		
	}

	

}
