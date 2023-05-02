package atb.social.network.controller;

import atb.social.network.model.ZodiacModel;
import atb.social.network.service.Zodiac.ZodiacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ZodiacController {

    @Autowired
    ZodiacService zodiacService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/zodiac/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllZodiacs() throws Exception {
        List<ZodiacModel> allZodiacs;
        try {
            allZodiacs = zodiacService.getAllZodiacs();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(allZodiacs, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/zodiac", method = RequestMethod.GET)
    public ResponseEntity<Object> getZodiacByName(@RequestParam(name = "zodiac") String zodiac) throws Exception {
        ZodiacModel zodiacByName;
        try {
            zodiacByName = zodiacService.getZodiacByName(zodiac);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(zodiacByName, HttpStatus.OK);
    }


}
