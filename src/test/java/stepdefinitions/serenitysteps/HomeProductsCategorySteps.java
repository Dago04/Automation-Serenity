package stepdefinitions.serenitysteps;

import assertions.ElementAssertions;
import net.serenitybdd.annotations.Step;
import pageobjects.HomeProductsCategoryPage;

public class HomeProductsCategorySteps {

    HomeProductsCategoryPage homeProductsCategoryPage;

    @Step("Select the product category {0}" )
    public void selectProductCategory(String categoryName) {
        homeProductsCategoryPage.selectCategory(categoryName);
    }

    @Step("The selected category should be {0}")
    public void validateSelectedCategory(String expectedCategoryName) {
        String selectedCategory = homeProductsCategoryPage.getSelectedCategoryName();
        ElementAssertions.assertEqualsText(selectedCategory, expectedCategoryName);
    }
}
