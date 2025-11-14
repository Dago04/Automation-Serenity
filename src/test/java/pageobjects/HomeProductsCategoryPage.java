package pageobjects;

import actions.ElementActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class HomeProductsCategoryPage extends PageObject {
    ElementActions elementActions;

    @FindBy (xpath = "//*[contains(@class,'listContainer')]")
    WebElementFacade categoryListContainer;

    @FindBy(xpath = "//div[contains(@class,'listItem')]")
    List<WebElementFacade> categoryList;

    public void selectCategory(String categoryName) {

        elementActions.scrollToElement(() -> categoryListContainer);

        boolean categoryFound = false;

        for(WebElementFacade category : categoryList){
            try {
                if (category.isVisible()) {
                    WebElementFacade categoryTextElement = category.find(By.xpath(".//button/div"));
                    String categoryText = categoryTextElement.getText().trim();

                    if(categoryText.equals(categoryName)) {
                        String elementClass = category.getDomAttribute("class");

                        if(elementClass != null && elementClass.contains("listItemActive")) {
                            System.out.println("The category is already selected: " + categoryName);
                        } else {
                            elementActions.safeClick(() -> category);
                            return;
                        }
                        categoryFound = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error, category is not in the list " + e.getMessage());
            }
        }

        if (!categoryFound) {
            throw new RuntimeException("Category not found: " + categoryName);
        }
    }

    public String getSelectedCategoryName() {
        try {
            for(WebElementFacade category : categoryList) {
                if (category.isVisible()) {
                    String elementClass = category.getDomAttribute("class");
                    if(elementClass != null && elementClass.contains("listItemActive")) {
                        WebElementFacade categoryTextElement = category.find(By.xpath(".//button/div"));
                        return categoryTextElement.getText().trim();
                    }
                }
            }
            throw new RuntimeException("No active category found");
        } catch (Exception e) {
            throw new RuntimeException("Error getting selected category", e);
        }
    }
}
