package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Setup;

/**
 * Class DataDrivenTestingUsingCSVPage Page Factory
 */
public class DataDrivenTestingUsingCSVPage
{

    /** account list. */
    @FindBy(how = How.XPATH, using = "(//a[@data-toggle='dropdown'])[3]")
    private WebElement accountList;

    /** Register link. */
    @FindBy(how = How.XPATH, using = "//span[text()[normalize-space()='Register']]")
    private WebElement RegisterLink;

    /** customer first name. */
    @FindBy(how = How.ID, using = "input-firstname")
    private WebElement First_name;
    
    /** customer last name. */
    @FindBy(how = How.ID, using = "input-lastname")
    private WebElement Last_name;

    /** ap email. */
    @FindBy(how = How.ID, using = "input-email")
    private WebElement ap_email;

    /** ap password. */
    @FindBy(how = How.ID, using = "input-password")
    private WebElement ap_password;

    /** password check. */
    @FindBy(how = How.ID, using = "input-confirm")
    private WebElement password_check;

    /** checkbox. */
    @FindBy(how = How.CSS, using = "label[for='input-agree']")
    private WebElement ap_continueprivacyPoluce_checkbox;
    
    /** api_continue. */
   @FindBy(how = How.CSS, using = "input[type='submit']")
    private WebElement ap_continue;
    
    /**
     * Instanciation de data driven testing using CSV page.
     */
    public DataDrivenTestingUsingCSVPage()
    {
        super();
        PageFactory.initElements(Setup.getDriver(), this);
    }

    /**
     * methode Creates the account.
     * @throws InterruptedException 
     */
    public void createAccount() throws InterruptedException
    {
    	
    	Actions actions = new Actions(Setup.getDriver());
    	actions.moveToElement(accountList).perform();
    	WebDriverWait wait = new WebDriverWait(Setup.getDriver(),Duration.ofSeconds(10));
    	By registerLinkLocator = By.xpath("//span[text()[normalize-space()='Register']]");
    	WebElement registerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(registerLinkLocator));
    	// Cliquez sur le lien "Register"
    	registerLink.click();
        //accountList.click();
    }

    /**
     * methode Fill name.
     *
     * @param name
     */
    public void fillFName(String CustomerFName)
    {
    	  First_name.clear();
          First_name.sendKeys(CustomerFName);
    }
    /**
     * methode Fill last-name.
     *
     * @param name
     */
    public void fillLName(String CustomerLName)
    {
        Last_name.clear();
        Last_name.sendKeys(CustomerLName);
    }

    /**
     * methode Fill email.
     *
     * @param email
     */
    public void fillEmail(String CustomerEmail)
    {
        ap_email.clear();
        ap_email.sendKeys(CustomerEmail);
    }

    /**
     * methode Fill password.
     *
     * @param password
     */
    public void fillPassword(String CustomerPassword)
    {
        ap_password.clear();
        ap_password.sendKeys(CustomerPassword);
    }

    /**
     * methode Fill password check.
     *
     * @param passwordCheck 
     */
    public void fillPasswordCheck(String CustomerConfirmPassword)
    {
        password_check.clear();
        password_check.sendKeys(CustomerConfirmPassword);
    }
    
    /**
     * methode Checkbox Privacy Police.
     */
    
    public void checkboxPrivcayPolice() {
    	ap_continueprivacyPoluce_checkbox.click();
    }
    
    /**
     * methode Click on continue.
     */
    public void clickOnContinue()
    {
        ap_continue.click();
    }

}