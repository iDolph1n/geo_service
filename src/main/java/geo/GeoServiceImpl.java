package geo;

public class GeoServiceImpl implements GeoService {

    @Override
    public Location byIp(String ip) {
        if (ip.startsWith("172.")) {
            return new Location("Moscow", null, "Russia", 0);
        } else if (ip.startsWith("96.")) {
            return new Location("New York", null, "USA", 0);
        }
        return new Location(null, null, "Unknown", 0);
    }
}