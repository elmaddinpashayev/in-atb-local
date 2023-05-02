package atb.social.network.controller;

import atb.social.network.dto.SubDepartDto;
import atb.social.network.model.SubDepartmentModel;
import atb.social.network.service.SubDepartmentService.SubDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class SubDepartmentController {

    @Autowired
    private SubDepartmentService subDepartmentService;




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/subDepart/{bid}/{did}" , method = RequestMethod.GET)
    public ResponseEntity<Object> getAllSubDepartmentsByBIDAndDID(@PathVariable("bid") String bid, @PathVariable("did") String did) throws Exception {
        List<SubDepartmentModel> subDepartmentModelList ;
        try{

            subDepartmentModelList  = subDepartmentService.getallSubDepartment(Integer.parseInt(bid),Integer.parseInt(did));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(subDepartmentModelList, HttpStatus.OK);



    }








    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/subDepart/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveSubDepartment(@RequestBody SubDepartDto subDepartDto) throws Exception {

        try{


            subDepartmentService.save(subDepartDto);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/subDepart/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> editSubDepartment(@PathVariable("id") String id, @RequestBody SubDepartDto subDepartDto) throws Exception {

        try{

            subDepartmentService.edit(subDepartDto,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/subDepart/remove/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> removeSubDepartment(@PathVariable("id") String id) throws Exception {

        try{

            subDepartmentService.remove(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }

}
