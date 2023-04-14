package ru.netology.tests.ui;

import java.time.LocalDate;
import org.testng.annotations.Test;
import ru.netology.pages.CardOrderPage;

public class CardDeliveryTest extends BaseTest {

  private final CardOrderPage cardOrderPage = new CardOrderPage();
  private final LocalDate dateForTest = LocalDate.now().plusDays(3);

  @Test
  public void test() {
    cardOrderPage
        .enterCity("Петрозаводск")
        .selectDate(dateForTest)
        .enterNameAndSurname("Иванов Иван")
        .enterPhone("+79211234567")
        .clickToAgreementCheckbox()
        .clickToOrderButton()
        .checkThatOrderComplete(dateForTest);
  }
}
