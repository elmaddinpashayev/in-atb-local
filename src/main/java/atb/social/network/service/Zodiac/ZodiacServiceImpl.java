package atb.social.network.service.Zodiac;

import atb.social.network.model.ZodiacModel;
import atb.social.network.repository.ZodiacRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZodiacServiceImpl implements ZodiacService {

    @Autowired
    private ZodiacRepository zodiacRepository;

    private static final Logger logger = LoggerFactory.getLogger(ZodiacServiceImpl.class);

    @Override
    @Scheduled(fixedRateString = "${zodiac.db.update.rate}")
//        @Scheduled(cron = "0 30 5 * * ?")
    public void insertAllZodiacsToDb() throws Exception {
        logger.info("schedule zodiac started");
 //       System.setProperty("https.proxyHost", "10.0.3.18");
 //      System.setProperty("https.proxyPort", "3128");
        Document doc = Jsoup.connect("https://lent.az/burc").get();
        for (int i = 1; i <= 12; i++) {
            Elements els = doc.select("body > main > div > div.horoscopes_block > div.scrolled_block > div > a:nth-child(" + i + ")");
            Document zodDoc = Jsoup.connect(els.attr("abs:href")).get();
            Elements zodEls = zodDoc.select("#daily > div > p:nth-child(1) > span");

            Elements zodNameEls = zodDoc.select("body > main > div > div.birth_page > div.main_horoscope > span.name");
            String description = zodEls.html().replace("&nbsp;", "");
            ZodiacModel zodiacModel = ZodiacModel.builder()
                    .name(zodNameEls.html())
                    .description(zodEls.html().replace("&nbsp;", ""))
                    .build();

            ZodiacModel byName = zodiacRepository.findByName(zodiacModel.getName());
            if (byName != null) {
                byName.setDescription(description);
                zodiacRepository.save(byName);
            } else {
                zodiacModel.setDescription(description);
                zodiacRepository.save(zodiacModel);
            }
        }
    }

    public List<ZodiacModel> getAllZodiacs() {
        return (List<ZodiacModel>) zodiacRepository.findAll();
    }

    public ZodiacModel getZodiacByName(String name) {
         return zodiacRepository.findByName(name);
    }

}
