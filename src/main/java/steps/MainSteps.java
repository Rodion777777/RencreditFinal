package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    @Step(" Перейти по ссылке - https://rencredit.ru")
    public void openMainPage(){

    }

    @Step("Перейти в меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }
}
