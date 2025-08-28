package geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeoServiceImplTest {

    GeoService geoService = new GeoServiceImpl();

    @Test
    void testByIpRussia() {
        Location location = geoService.byIp("172.123.12.19");
        assertEquals("Russia", location.getCountry());
    }

    @Test
    void testByIpUSA() {
        Location location = geoService.byIp("96.44.183.149");
        assertEquals("USA", location.getCountry());
    }
}