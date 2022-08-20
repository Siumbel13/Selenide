import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {

    String SimpleDateFormat = String.valueOf(new SimpleDateFormat("dd.MM.yyyy"));

    String planningDate = SimpleDateFormat + 3; // т.к. не ранее трёх дней с текущей даты

    @Test
    void test1() {
        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999/");
        $("[placeholder=\"Город\"]").setValue("Казань");
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[name=\"name\"]").setValue("Михаил Салтыков-Щедрин");
        $("[name=\"phone\"]").setValue("+79655884953");
        $("[data-test-id=\"agreement\"]").click();
        $x("//*[text()=\"Забронировать\"]").click();
        $(withText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }
}
