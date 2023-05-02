package atb.social.network.controller;


import atb.social.network.dto.DocumentDTO;
import atb.social.network.model.DocumentsModel;
import atb.social.network.service.DocumentService.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class DocumentController {

    @Autowired
    private DocumentService documentService;



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/documents" , method = RequestMethod.GET)
    public ResponseEntity<Object> getDocuments() throws Exception {
        List<DocumentsModel> documentsModel;
        try{

            documentsModel  = documentService.getAllDocument();


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(documentsModel, HttpStatus.OK);



    }





    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/documents/remove/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeDocuments(@PathVariable("id") String id) throws Exception {

        try{

            documentService.remove(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/documents/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> editDocuments(@RequestBody DocumentDTO documentDTO, @PathVariable("id") String id) throws Exception {

        try{

            documentService.edit(documentDTO,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/documents/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveDocuments(@RequestBody DocumentDTO documentDTO) throws Exception {

        try{

            documentService.save(documentDTO);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/documents/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Object> getDocument(@PathVariable("id") String id) throws Exception {
        DocumentsModel documentsModel;

        try{

            documentsModel = documentService.getExactDocument(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(documentsModel, HttpStatus.OK);



    }


}
