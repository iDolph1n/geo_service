package sender;

import geo.GeoService;
import geo.Location;
import localization.LocalizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MessageSenderImplTest {

    GeoService geoService;
    LocalizationService localizationService;
    MessageSender messageSender;

    @BeforeEach
    void setUp() {
        geoService = mock(GeoService.class);
        localizationService = mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void testSendRussianMessage() {
        when(geoService.byIp("172.0.0.1")).thenReturn(new Location("Moscow", null, "Russia", 0));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.0.1");

        String message = messageSender.send(headers);
        assertEquals("Добро пожаловать", message);
    }

    @Test
    void testSendEnglishMessage() {
        when(geoService.byIp("96.0.0.1")).thenReturn(new Location("New York", null, "USA", 0));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.0.0.1");

        String message = messageSender.send(headers);
        assertEquals("Welcome", message);
    }
}