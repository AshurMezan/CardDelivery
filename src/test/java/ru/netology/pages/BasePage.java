package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public abstract class BasePage {
  public void inputNativeClear(SelenideElement input) {
    input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    input.sendKeys(Keys.BACK_SPACE);
  }
}
