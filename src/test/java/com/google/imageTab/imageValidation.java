package com.google.imageTab;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class imageValidation {

    ChromeOptions options = new ChromeOptions();
    ChromeDriver wd = new ChromeDriver(options);

    public void test(String searchItem) {

        wd.get("https://www.google.com/search?q=" + searchItem.replace(" ", "+") + "&tbm=isch&ved=2");
        /*
         * Important: the size must be greater than one.
         * The account icon uses the <img></img> tag and an extra step is required.
         * Google logo using <svg></svg>
         */
        List<WebElement> imageValidation = wd.findElements(By.tagName("img"));
        assertTrue(imageValidation.size() > 1);
    }

    @Test
    public void testRunner() {
        test("My little pony");
    }
}
