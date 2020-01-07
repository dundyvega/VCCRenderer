import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class FileOperator {
	
	private static String cellStringValue(Cell cell) {
	
		String str = "";
		
		if (cell != null && cell.getCellType() != CellType.BLANK)
		if (cell.getCellType() == CellType.NUMERIC) {
			
			str = NumberToTextConverter.toText(cell.getNumericCellValue());
			
		} else if (cell.getCellType() == CellType.ERROR) {
			str = cell.getErrorCellValue() + "";
			
		} else if (!cell.getStringCellValue().equals("") && cell.getStringCellValue() != null) {
			
			str = cell.getStringCellValue();
			
		}
	
		return str;
	
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
			
			Iterator<Cell> cellIterator = currentRow.iterator();
			
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
			line.setPhone3(cellStringValue(currentRow.getCell(24)));
			
			//System.out.println(line.toString());	
			
			lines.add(line);
			
			//System.out.println(line.toString());
			
		}
		
		//System.out.println("valami");
		
		return lines;
		
		
	}

	public static void setLines(String string, ArrayList<LineFromExcelFile> lines) throws IOException {
		// TODO Auto-generated method stub
		
		string = string.split("\\.")[0] + "- Automata IVR.xlsx";

		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		
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
		
		
		
		FileOutputStream excelFile = new FileOutputStream(string);
		  
		  
		
		  workbook.write(excelFile);
		  
		  excelFile.close();
		
	}

	public static ArrayList<LineFromExcelFile> getLines(File selectedFile) {
		// TODO Auto-generated method stub
		System.out.println(selectedFile.toString());
		return null;
	}

}
