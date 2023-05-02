package atb.social.network.controller;


import atb.social.network.dto.NotificationDTO;
import atb.social.network.model.NotificationOnHomePageModel;
import atb.social.network.service.NotificitaionOnHomePage.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class NotificationOnHomePageController {
    @Autowired
    private NotificationService notificationService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications/daily" , method = RequestMethod.GET)
    public ResponseEntity<Object> getDailyNotification() throws Exception {
        List<NotificationOnHomePageModel> notificationOnHomePageModelList;
        try{

            notificationOnHomePageModelList  = notificationService.getNotificationByDate();


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(notificationOnHomePageModelList, HttpStatus.OK);



    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications" , method = RequestMethod.GET)
    public ResponseEntity<Object> getAllNotification() throws Exception {
        List<NotificationOnHomePageModel> notificationOnHomePageModelList;
        try{

            notificationOnHomePageModelList  = notificationService.getAllNotification();


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(notificationOnHomePageModelList, HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications/all" , method = RequestMethod.GET)
    public ResponseEntity<Object> getAllNotificationInAdmin() throws Exception {
        List<NotificationOnHomePageModel> notificationOnHomePageModelList;
        try{

            notificationOnHomePageModelList  = notificationService.getAllNotificationAll();


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(notificationOnHomePageModelList, HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveNotification(@RequestBody NotificationDTO notificationDTO) throws Exception {

        try{

            notificationService.save(notificationDTO);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications/update/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> updateNotification(@RequestBody NotificationDTO notificationDTO,@PathVariable("id") String id) throws Exception {

        try{

            notificationService.update(notificationDTO,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications/remove/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> removeNotification(@PathVariable("id") String id) throws Exception {

        try{

            notificationService.remove(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/notifications/status/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> changeStatusNotification(@PathVariable("id") String id) throws Exception {

        try{

            notificationService.statusUpdate(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }

}
