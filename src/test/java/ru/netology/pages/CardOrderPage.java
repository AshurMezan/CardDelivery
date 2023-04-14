package ru.netology.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static ru.netology.utils.DateTimeUtils.RUSSIAN_FULL_DATE_WITH_DOTS;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.time.LocalDate;

public class CardOrderPage extends BasePage {

  private static final String NOTIFICATION_SUCCESS = "Успешно!";
  private static final String ORDER_NOTIFICATION_BODY_PATTERN = "Встреча успешно забронирована на %s";

  private final SelenideElement cityTextBox = $x("//span[@data-test-id='city']//input");
  private final SelenideElement datepicker = $x("//span[@data-test-id='date']//input");
  private final SelenideElement nameAndSurnameTextBox = $x("//span[@data-test-id='name']//input");
  private final SelenideElement phoneTextBox = $x("//span[@data-test-id='phone']//input");
  private final SelenideElement agreementCheckbox = $x("//input[@name='agreement']//ancestor::span");
  private final SelenideElement orderButton = $x("//span[@class='button__text' and text()='Забронировать']//ancestor::button");
  private final SelenideElement notificationModal = $x("//div[@data-test-id='notification']");
  private final SelenideElement notificationTitle = notificationModal.$x(".//div[@class='notification__title']");
  private final SelenideElement notificationContent = notificationModal.$x(".//div[@class='notification__content']");


  public CardOrderPage enterCity(String cityName) {
    cityTextBox.val(cityName);
    return this;
  }

  public CardOrderPage selectDate(LocalDate date) {
    inputNativeClear(datepicker);
    datepicker.val(date.format(RUSSIAN_FULL_DATE_WITH_DOTS));
    return this;
  }

  public CardOrderPage enterNameAndSurname(String nameAndSurname) {
    nameAndSurnameTextBox.val(nameAndSurname);
    return this;
  }

  public CardOrderPage enterPhone(String phone) {
    phoneTextBox.val(phone);
    return this;
  }

  public CardOrderPage clickToAgreementCheckbox() {
    agreementCheckbox.click();
    return this;
  }

  public CardOrderPage clickToOrderButton() {
    orderButton.click();
    return this;
  }

  public CardOrderPage checkThatOrderComplete(LocalDate expectedDateOfOrdering) {
    String dateString = format(ORDER_NOTIFICATION_BODY_PATTERN, expectedDateOfOrdering.format(RUSSIAN_FULL_DATE_WITH_DOTS));
    notificationModal.shouldBe(visible, Duration.ofSeconds(15));
    notificationTitle.shouldBe(text(NOTIFICATION_SUCCESS));
    notificationContent.shouldBe(text(dateString));
    return this;
  }
}
