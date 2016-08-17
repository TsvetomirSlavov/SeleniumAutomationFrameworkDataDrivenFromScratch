package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Purpose: To provide test data from an Excel file
 */
public class TestDataProviderExcel {
	
	private String testDataFilePath;
	private FileInputStream fileStream; 
	private XSSFWorkbook testDataWorkbook;
	private XSSFSheet testDataSheet;
	
	//turns all cells to a String value
	final DataFormatter df = new DataFormatter();
	
	public TestDataProviderExcel(String testDataFilePath) throws IOException{
		this.testDataFilePath = testDataFilePath;
		fileStream = new FileInputStream(new File(this.testDataFilePath));
		testDataWorkbook = new XSSFWorkbook(fileStream);
		testDataSheet = testDataWorkbook.getSheet("TestData");
	}
	
	//I made every numeric cell to be formatted to a String with DataFormatter
	private String getData(String testCaseName, String keyName){
		int rowEnd = testDataSheet.getLastRowNum();
		String value = "";
		//int columnEnd = testDataSheet.get
		for(int i = 0; i <= rowEnd; i++){
			String testName = testDataSheet.getRow(i).getCell(0).getStringCellValue();			
			if(testName.equals(testCaseName)){
				int j = 0;
				String colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();				
				while(!colName.isEmpty()){
					colName = testDataSheet.getRow(0).getCell(j).getStringCellValue();
					if(colName.equals(keyName)){
						//value = testDataSheet.getRow(i).getCell(j).getStringCellValue();
						//I made every numeric cell to be formatted to a String with DataFormatter
						value = df.formatCellValue(testDataSheet.getRow(i).getCell(j));
						break;
					}
					j++; 
				}
				break;
			}
		}
		return value;
	}
	
	public String getUsername(String testCaseName)
	{
		return getData(testCaseName, "Username");
	}
	
	public String getPassword(String testCaseName)
	{
		return getData(testCaseName, "Password");
	}
	
	public String getFirstName(String testCaseName)
	{
		return getData(testCaseName, "FirstName");
	}
	
	public String getLastName(String testCaseName)
	{
		return getData(testCaseName, "LastName");
	}
	
	public String getEmail(String testCaseName)
	{
		return getData(testCaseName, "Email");
	}
	
	public String getProductName(String testCaseName)
	{
		return getData(testCaseName, "ProductName");
	}
	
	public String getProductID(String testCaseName)
	{
		return getData(testCaseName, "ProductID");
	}
	
	public String getPrice(String testCaseName)
	{
		return getData(testCaseName, "Price");
	}
	
	//For a future columns 
	public String getTestData(String testCaseName, String keyName)
	{
		return getData(testCaseName, keyName);
	}
	
	public void closeTestDataSheet()
	{
		try {
			testDataWorkbook.close();
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
/*
 * If what you want to do is get a String value for your numeric cell, stop!. This is not the way to do it. Instead, for fetching the string value of a numeric or boolean or date cell, use DataFormatter instead.
And according to the DataFormatter API

DataFormatter contains methods for formatting the value stored in an Cell. This can be useful for reports and GUI presentations when you need to display data exactly as it appears in Excel. Supported formats include currency, SSN, percentages, decimals, dates, phone numbers, zip codes, etc.
So, right way to show numeric cell's value is as following:

 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
 Cell cell = sheet.getRow(i).getCell(0);
 String j_username = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
 * 
 *     OR
 *     
 *     
 *     
 *     
 *     
 *     import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nirmal
 
public class ReadWriteExcel {

    public static void main(String ar[]) {
        ReadWriteExcel rw = new ReadWriteExcel();
        rw.readDataFromExcel();

    }
    Object[][] data = null;

    public File getFile() throws FileNotFoundException {
        File here = new File("test/com/javaant/ssg/tests/test/data.xlsx");
        return new File(here.getAbsolutePath());

    }

    public Object[][] readDataFromExcel() {
        final DataFormatter df = new DataFormatter();
        try {

            FileInputStream file = new FileInputStream(getFile());
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            int rownum = 0;
            int colnum = 0;
            Row r=rowIterator.next();

            int rowcount=sheet.getLastRowNum();
            int colcount=r.getPhysicalNumberOfCells();
            data = new Object[rowcount][colcount];
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                colnum = 0;
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    data[rownum][colnum] =  df.formatCellValue(cell);
                    System.out.print(df.formatCellValue(cell));
                    colnum++;
                    System.out.println("-");
                }
                rownum++;
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}







OR




switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        System.out.println(cell.getDateCellValue());
                    } else {
                        System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    System.out.println(cell.getCellFormula());
                    break;
                default:
                    System.out.println();
            }
 * 
 */
	
	
	
	
	
	

}
