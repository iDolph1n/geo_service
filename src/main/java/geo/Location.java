package geo;

import sender.Country;

public class Location {
    private final String city;
    private final String street;
    private final String country;
    private final int building;

    public Location(String city, String street, String country, int building) {
        this.city = city;
        this.street = street;
        this.country = country;
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public int getBuilding() {
        return building;
    }
}
