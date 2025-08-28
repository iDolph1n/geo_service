package localization;

import sender.Country;

public class LocalizationServiceImpl implements LocalizationService {

    @Override
    public String locale(Country country) {
        if (country == Country.RUSSIA) {
            return "Добро пожаловать";
        } else {
            return "Welcome";
        }
    }
}


