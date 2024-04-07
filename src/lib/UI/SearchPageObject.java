package lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{
    private static final String
    SKIP_ONBOARDING = "//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]",
    SEARCH_INIT_ELEMENT = "//android.widget.TextView[@text=\"Поиск по Википедии\"]",
    SEARCH_INPUT = "//android.widget.AutoCompleteTextView[@resource-id=\"org.wikipedia:id/search_src_text\"]",
    SEARCH_RESULT = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"{SUBSTRING}\"]",
    ADD_TO_BOOKMARKS = "//android.widget.TextView[@content-desc=\"Сохранить\"]",
    SNACKBAR_ACTION = "//android.widget.Button[@resource-id=\"org.wikipedia:id/snackbar_action\"]",
    LIST_NAME_INPUT = "//android.widget.EditText[@resource-id=\"org.wikipedia:id/text_input\"]",
    CONFIRM = "//android.widget.Button[@resource-id=\"android:id/button1\"]",
    OPTION_MENU = "//android.widget.ImageView[@content-desc=\"Ещё\"]",
    DELETE_LIST = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/title\" and @text=\"Удалить список\"]";
    public SearchPageObject(AppiumDriver driver){
        super(driver);
    }

    public void initSearchInput(){
        this.waitForElementAndClick(By.xpath(SKIP_ONBOARDING),
                "Невозможно пропустить.",
                15);

        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),
                "Невозможно нажать на поле ввода.",
                15);

        this.waitForElementPresent(By.xpath(SEARCH_INPUT),
                "Невозможно найти поле ввода.",
                15);
    }

    public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,
                "Невозможно нажать на поле ввода.",
                15);
    }

    public static String getResultSearchElement(String substring){
        return SEARCH_RESULT.replace("{SUBSTRING}", substring);
    }

    public void waitForSearchResultAndClick(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),
                "Невозможно найти " + substring,
                15);
    }

    public void createListAndAddToBookmarks(String list_name){
        this.waitForElementAndClick(By.xpath(ADD_TO_BOOKMARKS), "Can't add to bookmarks", 15);
        this.waitForElementAndClick(By.xpath(SNACKBAR_ACTION), "No snackbar actions available", 15);
        this.waitForElementAndClear(By.xpath(LIST_NAME_INPUT), "No input fields available", 15);
        this.waitForElementAndSendKeys(By.xpath(LIST_NAME_INPUT), list_name, "No input fields available", 15);
        this.waitForElementAndClick(By.xpath(CONFIRM), "No snackbar actions available", 15);
    }

    public void goToListAndDelete(){
        this.waitForElementAndClick(By.xpath(SNACKBAR_ACTION), "No snackbar actions available", 15);
        this.waitForElementAndClick(By.xpath(OPTION_MENU), "No snackbar actions available", 15);
        this.waitForElementAndClick(By.xpath(DELETE_LIST), "No snackbar actions available", 15);
        this.waitForElementAndClick(By.xpath(CONFIRM), "No snackbar actions available", 15);
    }
}
