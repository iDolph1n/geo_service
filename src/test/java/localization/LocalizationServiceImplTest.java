package localization;

import org.junit.jupiter.api.Test;
import sender.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalizationServiceImplTest {

    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void testLocaleRussia() {
        String message = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", message);
    }

    @Test
    void testLocaleUSA() {
        String message = localizationService.locale(Country.USA);
        assertEquals("Welcome", message);
    }
}