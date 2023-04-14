package ru.netology.tests.ui;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.netology.framework.Config;

public class BaseTest {

  @BeforeClass
  public void init() {
    Selenide.open("http://127.0.0.1:9999/");
  }

  @AfterClass
  public void terminate() {
    Selenide.closeWebDriver();
  }
}
