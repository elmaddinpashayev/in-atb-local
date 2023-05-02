package atb.social.network.controller;

import atb.social.network.dto.DepartmentDto;
import atb.social.network.model.BankDepartmenModel;
import atb.social.network.service.BankDepartment.BankDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class BankDepartmentController {









    @Autowired
    private BankDepartmentService bankDepartmentService;



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/departments/{id}" , method = RequestMethod.GET)
    public ResponseEntity<Object> getAllDepartmentsByBranchId(@PathVariable("id") String id) throws Exception {
        List<BankDepartmenModel> departmentByBranchId ;
        try{

            departmentByBranchId  = bankDepartmentService.getByBranchId(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(departmentByBranchId, HttpStatus.OK);



    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/departments/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveDepartment(@RequestBody DepartmentDto departmentDto) throws Exception {

        try{


bankDepartmentService.save(departmentDto);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/departments/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> editDepartment(@PathVariable("id") String id, @RequestBody DepartmentDto departmentDto) throws Exception {

        try{

bankDepartmentService.edit(departmentDto,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/departments/remove/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> removeDepartment(@PathVariable("id") String id) throws Exception {

        try{

bankDepartmentService.remove(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


}
