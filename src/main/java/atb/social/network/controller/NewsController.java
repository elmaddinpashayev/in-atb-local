package atb.social.network.controller;

import atb.social.network.dto.NewsDTO;
import atb.social.network.dto.NewsResultDto;
import atb.social.network.dto.NewsViewDTO;
import atb.social.network.model.NewsModel;
import atb.social.network.repository.NewsRepository;
import atb.social.network.service.News.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {


    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsRepository newsRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllNews(@RequestParam String count, @RequestParam String page, HttpServletRequest httpServletRequest) throws Exception {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();
        NewsResultDto newsResultDto = new NewsResultDto();
        try {
            newsResultDto = newsService.getAllNews(Integer.parseInt(count), Integer.parseInt(page), userIp);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Page not found", e);
//            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(newsResultDto, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllNewsById(@PathVariable("id") String nId, HttpServletRequest httpServletRequest) throws Exception {
        NewsModel newsModel;
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();
        try {
            newsModel = newsService.getNewsById(Integer.parseInt(nId), userIp);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(newsModel, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> editNews(@PathVariable("id") String nId, @ModelAttribute NewsDTO newsDTO,
                                           @RequestParam(value = "mainPhoto", required = false) MultipartFile mainPhoto,
                                           @RequestParam(value = "m1", required = false) MultipartFile m1,
                                           @RequestParam(value = "m2", required = false) MultipartFile m2,
                                           @RequestParam(value = "m3", required = false) MultipartFile m3,
                                           @RequestParam(value = "m4", required = false) MultipartFile m4) throws Exception {
        try {
            newsService.editNews(Integer.parseInt(nId), newsDTO, mainPhoto, m1, m2, m3, m4);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeNews(@PathVariable("id") String nId) throws Exception {

//        try {
            newsService.removeNews(Integer.parseInt(nId));
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news/like/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> likeNews(@PathVariable("id") String nId, HttpServletRequest httpServletRequest) throws Exception {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();


        try {
            newsService.likeNews(Integer.parseInt(nId), userIp);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news/dislike/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> dislikeNews(@PathVariable("id") String nId, HttpServletRequest httpServletRequest) throws Exception {
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();

        try {
            newsService.dislikeNews(Integer.parseInt(nId), userIp);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/news/save", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<Object> saveNews(@ModelAttribute NewsDTO newsDTO,
                                           @RequestParam(value = "mainPhoto", required = false) MultipartFile mainPhoto,
                                           @RequestParam(value = "m1", required = false) MultipartFile m1,
                                           @RequestParam(value = "m2", required = false) MultipartFile m2,
                                           @RequestParam(value = "m3", required = false) MultipartFile m3,
                                           @RequestParam(value = "m4", required = false) MultipartFile m4) throws Exception {
        try {
            newsService.saveNews(newsDTO, mainPhoto, m1, m2, m3, m4);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }
}
