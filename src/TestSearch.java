import lib.CoreTestCase;
import lib.UI.MainPageObject;
import lib.UI.SearchPageObject;
import org.junit.Test;

public class TestSearch extends CoreTestCase {
    private MainPageObject MainPageObject;
    public void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearchElement(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Хоббит, или Туда и обратно}");
        SearchPageObject.waitForSearchResultAndClick("Хоббит, или Туда и обратно");
        SearchPageObject.createListAndAddToBookmarks("Хоббит");
        SearchPageObject.goToListAndDelete();
    }
}
