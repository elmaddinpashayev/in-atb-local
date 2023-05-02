package atb.social.network.controller;

import atb.social.network.dto.CharityDTO;
import atb.social.network.dto.CharityResultDto;
import atb.social.network.dto.CharityDTO;
import atb.social.network.dto.CharityResultDto;
import atb.social.network.model.CharityModel;
import atb.social.network.model.CharityModel;
import atb.social.network.repository.CharityRepository;
import atb.social.network.service.Charity.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class CharityController {


    @Autowired
    private CharityService CharityService;

    @Autowired
    private CharityRepository CharityRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCharity(@RequestParam String count, @RequestParam String page, HttpServletRequest httpServletRequest) throws Exception {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();
        CharityResultDto charityResultDto = new CharityResultDto();
        try {
            charityResultDto = CharityService.getAllCharity(Integer.parseInt(count), Integer.parseInt(page), userIp);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Page not found", e);
//            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(charityResultDto, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCharityById(@PathVariable("id") String nId, HttpServletRequest httpServletRequest) throws Exception {
        CharityModel charityModel;
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();
        try {
            charityModel = CharityService.getCharityById(Integer.parseInt(nId), userIp);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(charityModel, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> editCharity(@PathVariable("id") String nId, @ModelAttribute CharityDTO charityDTO,
                                           @RequestParam(value = "mainPhoto", required = false) MultipartFile mainPhoto,
                                           @RequestParam(value = "m1", required = false) MultipartFile m1,
                                           @RequestParam(value = "m2", required = false) MultipartFile m2,
                                           @RequestParam(value = "m3", required = false) MultipartFile m3,
                                           @RequestParam(value = "m4", required = false) MultipartFile m4) throws Exception {
        try {
            CharityService.editCharity(Integer.parseInt(nId), charityDTO, mainPhoto, m1, m2, m3, m4);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeCharity(@PathVariable("id") String nId) throws Exception {

//        try {
            CharityService.removeCharity(Integer.parseInt(nId));
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity/like/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> likeCharity(@PathVariable("id") String nId, HttpServletRequest httpServletRequest) throws Exception {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();


        try {
            CharityService.likeCharity(Integer.parseInt(nId), userIp);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity/dislike/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> dislikeCharity(@PathVariable("id") String nId, HttpServletRequest httpServletRequest) throws Exception {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();

        try {
            CharityService.dislikeCharity(Integer.parseInt(nId), userIp);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/charity/save", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<Object> saveCharity(@ModelAttribute CharityDTO charityDTO,
                                           @RequestParam(value = "mainPhoto", required = false) MultipartFile mainPhoto,
                                           @RequestParam(value = "m1", required = false) MultipartFile m1,
                                           @RequestParam(value = "m2", required = false) MultipartFile m2,
                                           @RequestParam(value = "m3", required = false) MultipartFile m3,
                                           @RequestParam(value = "m4", required = false) MultipartFile m4) throws Exception {
        try {
            CharityService.saveCharity(charityDTO, mainPhoto, m1, m2, m3, m4);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }
}
