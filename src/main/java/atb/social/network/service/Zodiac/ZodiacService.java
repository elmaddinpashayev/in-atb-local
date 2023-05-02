package atb.social.network.service.Zodiac;

import atb.social.network.model.ZodiacModel;

import java.util.List;

public interface ZodiacService {

    void insertAllZodiacsToDb() throws Exception;

    List<ZodiacModel> getAllZodiacs();

    ZodiacModel getZodiacByName(String name);
}
