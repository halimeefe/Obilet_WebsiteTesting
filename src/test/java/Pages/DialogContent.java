package Pages;

import Utilities.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.security.cert.X509Certificate;
import java.util.List;

public class DialogContent extends Parent{

    public DialogContent(){
        PageFactory.initElements(PageDriver.getDriver(),this);

    }

    @FindBy (className = "login")
    public WebElement memberLogin;


    @FindBy (css = "[type='email']")
    public WebElement inputEmail;

    @FindBy (css = "[type='password']")
    public WebElement inputPassword;

    @FindBy (css = "[class='login login-button']")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@class='menu right']//li[1]/a")
    public WebElement myTrips;

    @FindBy (css = "[data-event-action='Bus']")
    public WebElement busCategory;

    @FindBy (css = "[id='origin-input']")
    public WebElement cityAndCountryInput;

    @FindBy (xpath = "(//*[@class='results'])[1]/ul/li[1]")
    public WebElement selectCityAndCountry;

    @FindBy (css = "[id='destination-input']")
    public WebElement destinationInput;

    @FindBy (xpath = "(//*[@class='results'])[2]//ul/li[6]")
    public WebElement selectDestination;

    @FindBy (css = "[id='departure-input']")
    public WebElement date;

    @FindBy (css = "[data-date='2023-10-31']")
    public WebElement travelDate;

    @FindBy (css = "[class='circle']")
    public WebElement findBusTicket;

    @FindBy (css = "[id='sorting']")
    public WebElement sort;

    @FindBy (css = "[data-text='Fiyat']")
    public WebElement byPrice;

    @FindBy (xpath = "//*[text()=' Tüm Filtreler ']")
    public WebElement allFilters;

    @FindBy (css = "[class='partner']")
    public WebElement byCompany;

    @FindBy (xpath = "//*[@data-filter='partner']//ul/li[14]")
    public WebElement company;

    @FindBy (xpath = "(//*[@class='partner col'])[1]")
    public WebElement firstCompany;

    @FindBy (xpath = "//*[@class='menu right']//li[2]")
    public WebElement myCount;

    @FindBy (css = "[data-event-action='Logout']")
    public WebElement logout;

    @FindBy (xpath = "//*[text()='Üye Girişi']")
    public WebElement verifyLogout;
























}
