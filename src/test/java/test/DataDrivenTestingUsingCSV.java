package test;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import page.DataDrivenTestingUsingCSVPage;
import util.Setup;

/**
 * Class DataDrivenTestingUsingCSV
 */
public class DataDrivenTestingUsingCSV extends Setup
{

    /** csv path. */
    // Provide test data CSV file path
    String CSV_PATH = "src/test/resources/data/TestData.csv";

    /** csv reader. */
    private CSVReader csvReader;

    /** csv cell. */
    String[] csvCell;

    /** data driven testing using CSV page. */
     DataDrivenTestingUsingCSVPage dataDrivenTestingUsingCSVPage;

    /**
     * Instanciation de atlas step definition.
     */
   public DataDrivenTestingUsingCSV()
   {
       this.dataDrivenTestingUsingCSVPage = new DataDrivenTestingUsingCSVPage();
   }

    /**
     * methode Data read CSV
     *
     * @throws CsvValidationException the csv validation exception
     * @throws IOException            Signal qu'une execption de type I/O s'est produite.
     * @throws InterruptedException 
     */
    @Test
    public void dataRead_CSV() throws CsvValidationException, IOException, InterruptedException
    {
          
    	dataDrivenTestingUsingCSVPage = new DataDrivenTestingUsingCSVPage();
        // Create an object of CSVReader
        csvReader = new CSVReader(new FileReader(CSV_PATH));

        dataDrivenTestingUsingCSVPage.createAccount();

        // You can use while loop like below, It will be executed until the last line in CSV used.
        while ((csvCell = csvReader.readNext()) != null)
        {
        	  String CustomerFName = csvCell[0];
              String CustomerLName = csvCell[1];

              String CustomerEmail = csvCell[2];
              String CustomerPassword = csvCell[3];
              String CustomerConfirmPassword = csvCell[4];

              dataDrivenTestingUsingCSVPage.fillFName(CustomerFName);
              dataDrivenTestingUsingCSVPage.fillLName(CustomerLName);

              dataDrivenTestingUsingCSVPage.fillEmail(CustomerEmail);
              dataDrivenTestingUsingCSVPage.fillPassword(CustomerPassword);
              dataDrivenTestingUsingCSVPage.fillPasswordCheck(CustomerConfirmPassword);
              
              dataDrivenTestingUsingCSVPage.checkboxPrivcayPolice();


              dataDrivenTestingUsingCSVPage.clickOnContinue();

        }

    }

}
