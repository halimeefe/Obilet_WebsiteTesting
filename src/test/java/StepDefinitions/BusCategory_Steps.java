package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BusCategory_Steps {

    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(20));

    @Given("Navigate to website")
    public void navigateToWebsite() {
        PageDriver.getDriver().get("https://www.obilet.com/");
        PageDriver.getDriver().manage().window().maximize();

    }

    @And("Click on the member login")
    public void clickOnTheMemberLogin() {
        dc.clickFunc(dc.memberLogin);

    }
    @And("Write a valid email")
    public void writeAValidEmail() {
        dc.sendKeysFunc(dc.inputEmail, dc.findFromExcel("email"));
    }

    @And("Write a valid password")
    public void writeAValidPassword() {
        dc.sendKeysFunc(dc.inputPassword, dc.findFromExcel("password"));
    }

    @And("Click on the login button")
    public void clickOnTheLoginButton() {
        dc.clickFunc(dc.loginButton);
    }

    @When("Verify you are on the site")
    public void verifyYouAreOnTheSite() {
        dc.verifyContainsTextFunction(dc.myTrips, "Seyahatlerim");


    }

    @And("Click on the bus category")
    public void clickOnTheBusCategory() {
        dc.clickFunc(dc.busCategory);

    }

    @And("Select departure point")
    public void selectDeparturePoint() {

        dc.clickFunc(dc.cityAndCountryInput);
        dc.clickFunc(dc.selectCityAndCountry);

    }

    @And("Choose a destination")
    public void chooseADestination() {
        dc.clickFunc(dc.destinationInput);
        dc.clickFunc(dc.selectDestination);

    }

    @And("Choose your travel date")
    public void chooseYourTravelDate() {
        Actions actions = new Actions(PageDriver.getDriver());
        actions.moveToElement(dc.date).click().build().perform();
        actions.moveToElement(dc.travelDate).click().build().perform();

    }

    @And("Click to find bus ticket")
    public void clickToFindBusTicket() {

        JavascriptExecutor executor = (JavascriptExecutor) PageDriver.getDriver();
        executor.executeScript("arguments[0].click();", dc.findBusTicket);


    }
    @And("Click to sort by price")
    public void clickToSortByPrice() {
        dc.clickFunc(dc.sort);
        dc.clickFunc(dc.byPrice);

    }

    @And("Click on all filters and select by company")
    public void clickOnAllFiltersAndSelectByCompany() {

        dc.clickFunc(dc.allFilters);
        dc.clickFunc(dc.byCompany);
        dc.clickFunc(dc.company);
    }

    @And("Choose the first company")
    public void chooseTheFirstCompany() {
        dc.clickFunc(dc.firstCompany);

    }

    @And("Export only vacant seat numbers to Excel file")
    public void exportOnlyVacantSeatNumbersToExcelFile() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.available.active.not-single-seat")));

        List<WebElement> emptySeats = PageDriver.getDriver().findElements(By.cssSelector("[class='available active not-single-seat']"));

        // Boş koltuk numaralarını ve elementlerini saklamak için bir liste
        List<String> seatNumbers = new ArrayList<>();

        for (WebElement emptySeat : emptySeats) {
            // JavaScript ile koltuk numarasını al
            String seatNumber = (String) ((JavascriptExecutor) PageDriver.getDriver()).executeScript(
                    "return arguments[0].querySelector('.s-seat-n').textContent;", emptySeat); // boş koltuk numaralarının elementi (.s-seat-n)
            seatNumbers.add(seatNumber);
        }

        // Boş koltuk numaralarını Excel dosyasına eklemek için bir Workbook oluştur
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Boş Koltuklar");

        int rowNum = 0;
        for (String seatNumber : seatNumbers) {
            // Excel sayfasına boş koltuk numarasını ekle
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue("Boş Koltuk No: " + seatNumber);
        }

        // Excel dosyasını kaydet
        try (FileOutputStream outputStream = new FileOutputStream("BoşKoltuklar.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Boş koltuk numaraları Excel dosyasına aktarıldı");

    }

    @When("Log out succesfully")
    public void logOutSuccesfully() {
        dc.clickFunc(dc.myCount);
        dc.clickFunc(dc.logout);
    }


    @Then("Verify that you are the logout")
    public void verifyThatYouAreTheLogout() {
        dc.verifyContainsTextFunction(dc.verifyLogout,"Üye Girişi");
    }
}






