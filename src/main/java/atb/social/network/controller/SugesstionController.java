package atb.social.network.controller;


import atb.social.network.dto.*;
import atb.social.network.service.SugesstionsService.SugesstionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SugesstionController {


@Autowired
private SugesstionsService sugesstionsService;



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/check/email" , method = RequestMethod.POST)
    public ResponseEntity<Object> checkEmail(@RequestBody CheckEmailRequest checkEmailRequest) throws Exception {
        CheckEmailResponse checkEmailResponse;
        try{
            checkEmailResponse  = sugesstionsService.checkEmail(checkEmailRequest.getEmail());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(checkEmailResponse, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveSuggestion(@RequestBody SugesstionSaveDTO sugesstionSaveDTO) throws Exception {
        try{
           sugesstionsService.save(sugesstionSaveDTO);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/remove/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeSuggestion(@PathVariable("id") String id) throws Exception {
        try{
            sugesstionsService.delete(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> editSuggestion(@RequestBody SuggestionEditDTO suggestionEditDTO,@PathVariable("id") String id) throws Exception {
        try{
            sugesstionsService.edit(suggestionEditDTO,Integer.parseInt(id));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/approve/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> approveSuggestion(@PathVariable("id") String id) throws Exception {
        try{
            sugesstionsService.approve(Integer.parseInt(id));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/whole" , method = RequestMethod.GET)
    public ResponseEntity<Object> listOfSuggestionsForAdmin() throws Exception {
        List<SuggestionViewDTO> suggestionViewDTOS;
        try{
            suggestionViewDTOS=  sugesstionsService.getList();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(suggestionViewDTOS, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests" , method = RequestMethod.GET)
    public ResponseEntity<Object> listOfSuggestions() throws Exception {
        List<SuggestionViewDTO> suggestionViewDTOS;
//        try{
            suggestionViewDTOS=  sugesstionsService.getListForView();
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
        return new ResponseEntity(suggestionViewDTOS, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/comment/add/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> addComment(@RequestBody CommentDTO commentDTO , @PathVariable("id") String id) throws Exception {
        try{


           sugesstionsService.saveComment(commentDTO,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/comment/remove/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeComment( @PathVariable("id") String id) throws Exception {
        try{


            sugesstionsService.deleteComment(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/suggests/comment/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> removeComment( @RequestBody CommentDTO commentDTO , @PathVariable("id") String id) throws Exception {
        try{


            sugesstionsService.editComment(commentDTO,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }
}
