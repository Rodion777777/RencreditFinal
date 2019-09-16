package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WithCalculatorPage;

import static org.junit.Assert.assertTrue;

public class CalculatorSteps {

    WithCalculatorPage calculatorPage = new WithCalculatorPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(),
            10);



    @Step("Выбрать валюту – {сurrency}")
    public void selectCollectionItem(String сurrency) {
        calculatorPage.selectCollectionItem(сurrency, calculatorPage.selectCurrency);
    }

    @Step("Выбрать сумму вклада – {amount}")
    public void selectAmountOfDeposit(String amount) {
        calculatorPage.amountOfDepositWindow.sendKeys(amount);
    }

    @Step("Выбрать срок вклада в месяцах - {termOfDeposit}")
    public void selectTermOfDeposit(String termOfDeposit) {

        Select timeSelect = new Select(calculatorPage.selectTermOfdepositButton);

        timeSelect.selectByValue(termOfDeposit);
    }

    @Step("выбрано ежемесячное пополнение на сумму - {replenishment}")
    public void selectAmountOfMonthlyReplenishment(String replenishment) {
        wait.until(ExpectedConditions.visibilityOf(calculatorPage.replenish));
        calculatorPage.monthlyReplenishment.sendKeys(replenishment);
    }

    @Step("отмечен чекбокс – {itemOfCheckBox}")
    public void checkBoxClick(String itemOfCheckBox) {

        String[] item = itemOfCheckBox.split("\",\"");

        for (int i = 0; i < item.length; i++) {
            WebElement checkBoxItem = calculatorPage.checkBox.findElement(By.xpath("//span[text()='" + item[i] + "']" +
                    "/ancestor::label//div[@class='jq-checkbox calculator__check']"));
            wait.until(ExpectedConditions.visibilityOf(checkBoxItem));
            checkBoxItem.click();
        }
    }

    @Step("проверено что автоматически заполнилось поле Ставка - {rate}")

    public void checkRateField(String rate) {
        assertTrue(String.format("В поле рассчитано значение %s. Ожидалось - %s", calculatorPage.rate.getText(),
                rate),wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualResult =  calculatorPage.rate.getText();
            return actualResult.equalsIgnoreCase(rate);}));
    }

    @Step("проверено что автоматически заполнилось поле Начислено - {accured}")

    public void checkAccuredField(String accured) {
        assertTrue(String.format("В поле рассчитано значение %s. Ожидалось - %s", calculatorPage.accured.getText(),
                accured), wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualResult =  calculatorPage.accured.getText();
            return actualResult.equalsIgnoreCase(accured);}));
    }

    @Step("проверено что автоматически заполнилось поле Пополнение за 9 месяцев - {replenish}")

    public void checkReplenishField(String replenish) {
        assertTrue(String.format("В поле рассчитано значение %s. Ожидалось - %s", calculatorPage.replenish.getText(),
                replenish), wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualResult =  calculatorPage.replenish.getText();
            return actualResult.equalsIgnoreCase(replenish);}));
    }

    @Step("проверено что автоматически заполнилось поле К снятию через 9 месяцев – {result}")

    public void checkCalcResultField(String result) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        assertTrue(String.format("В поле рассчитано значение %s. Ожидалось - %s", calculatorPage.calcResult.getText(),
                result), wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualResult =  calculatorPage.calcResult.getText();
            return actualResult.equalsIgnoreCase(result);}));
    }
}
