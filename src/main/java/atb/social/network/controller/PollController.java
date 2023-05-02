package atb.social.network.controller;


import atb.social.network.dto.PollEditDTO;
import atb.social.network.dto.PollSaveRequest;
import atb.social.network.dto.PollsDTO;
import atb.social.network.dto.PositionDto;
import atb.social.network.model.PositionModel;
import atb.social.network.service.PollService.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PollController {


    @Autowired
    private PollService pollService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> savePoll(@RequestBody PollSaveRequest pollSaveRequest) throws Exception {
        try{

            pollService.save(pollSaveRequest);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll" , method = RequestMethod.GET)
    public ResponseEntity<Object> listOfPoll(HttpServletRequest httpServletRequest) throws Exception {
        List<PollsDTO> pollsDTOS;


        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();

        try{


            pollsDTOS = pollService.getPollsData(userIp);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(pollsDTOS, HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll/all" , method = RequestMethod.GET)
    public ResponseEntity<Object> listOfPollForAdmin() throws Exception {
        List<PollsDTO> pollsDTOS;
        try{

            pollsDTOS = pollService.getPollsDataForAdmin();

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(pollsDTOS, HttpStatus.OK);



    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll/vote/{qid}/{cid}" , method = RequestMethod.POST)
    public ResponseEntity<Object> votePoll(@PathVariable("qid") String qid, @PathVariable("cid") String cid, HttpServletRequest httpServletRequest) throws Exception {
        int result;
        String userIp = httpServletRequest.getHeaders("X-Real-IP").nextElement();

        try{

            result  = pollService.voteThePool(userIp,Integer.parseInt(qid),Integer.parseInt(cid));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(result, HttpStatus.OK);



    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll/edit" , method = RequestMethod.POST)
    public ResponseEntity<Object> editPoll(@RequestBody PollEditDTO pollEditDTO) throws Exception {

        try{
           pollService.edit(pollEditDTO);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll/remove/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePoll(@PathVariable("id") String id) throws Exception {

        try{
            pollService.delete(Integer.parseInt(id));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/poll/status/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> statusPoll(@PathVariable("id") String id) throws Exception {

        try{
            pollService.status(Integer.parseInt(id));

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }



}
