package sender;

import geo.GeoService;
import geo.Location;
import localization.LocalizationService;

import java.util.Map;

public class MessageSenderImpl implements MessageSender {

    public static final String IP_ADDRESS_HEADER = "x-real-ip";

    private final GeoService geoService;
    private final LocalizationService localizationService;

    public MessageSenderImpl(GeoService geoService, LocalizationService localizationService) {
        this.geoService = geoService;
        this.localizationService = localizationService;
    }

    @Override
    public String send(Map<String, String> headers) {
        String ip = headers.get(IP_ADDRESS_HEADER);
        Location location = geoService.byIp(ip);

        Country country;
        if ("Russia".equals(location.getCountry())) {
            country = Country.RUSSIA;
        } else {
            country = Country.USA;
        }

        return localizationService.locale(country);
    }
}