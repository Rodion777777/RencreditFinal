package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainPageSteps = new MainSteps();
    CalculatorSteps calculatorSteps = new CalculatorSteps();

    @When("Перейти по ссылке - https://rencredit.ru")
    public void goToLink(){
        mainPageSteps.openMainPage();
    }
    @When("Перейти в меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }


    @When("Выбрать валюту – \"(.+)\"$")
    public void selectCurrency(String currency){
        calculatorSteps.selectCollectionItem(currency);
    }

    @When("Сумма вклада – \"(.+)\"$")
    public void selectAmountOfDeposit(String amount){
        calculatorSteps.selectAmountOfDeposit(amount);
    }

    @When("Срок вклада в месяцах - \"(.+)\"$")
    public void selectTermOfDeposit(String termOfDeposit){
        calculatorSteps.selectTermOfDeposit(termOfDeposit);
    }
    @When("Ежемесячное пополнение на сумму - \"(.+)\"$")
    public void selectAmountOfMonthlyReplenishment(String replenishment){
        calculatorSteps.selectAmountOfMonthlyReplenishment(replenishment);
    }

    @When("Отметить чекбокс – \"(.*)\"$")
    public void selectCheckBoxClick(String itemOfCheckBox){
        calculatorSteps.checkBoxClick(itemOfCheckBox);
    }

    @Then("Проверить что автоматически заполнилось поле Ставка - \"(.*)\"$")
    public void checkRateField(String rate){
        calculatorSteps.checkRateField(rate);
    }
    @Then("Проверить что автоматически заполнилось поле Начислено - \"(.*)\"$")
    public void checkAccuredField(String accured){
        calculatorSteps.checkAccuredField(accured);
    }

    @Then("Проверить что автоматически заполнилось поле Пополнение за 6 месяцев - \"(.*)\"$")
    public void checkReplenishField(String replenish){
        calculatorSteps.checkReplenishField(replenish);
    }

    @Then("Проверить что автоматически заполнилось поле К снятию через 6 месяцев – \"(.*)\"$")
    public void checkCalcResultField(String result) {
        calculatorSteps.checkCalcResultField(result);
    }
}
