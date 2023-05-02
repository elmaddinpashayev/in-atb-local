package atb.social.network.controller;

import atb.social.network.dto.CounterDTO;
import atb.social.network.dto.QuoteDTO;
import atb.social.network.model.QuoteModel;
import atb.social.network.service.QuoteService.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")

public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public ResponseEntity<Object> getQuote() throws Exception {
        QuoteModel quoteModel;
        try {
            quoteModel = quoteService.getQuote();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(quoteModel, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/quote/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveQuote(@RequestBody QuoteDTO quoteDTO) throws Exception {
        try {
            quoteService.save(quoteDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public void countUser(HttpServletRequest httpServletRequest) {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();
        quoteService.saveIp(userIp);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/countGuest", method = RequestMethod.GET)
    public void countGuest(HttpServletRequest httpServletRequest, @RequestParam String empId) {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();
        quoteService.saveGuestIp(userIp, empId);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/counter", method = RequestMethod.GET)
    public ResponseEntity<Object> getCounter() throws Exception {

        CounterDTO result;
        try {
            result = quoteService.getUniqueIp();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
