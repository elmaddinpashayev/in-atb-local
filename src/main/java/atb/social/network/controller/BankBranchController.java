package atb.social.network.controller;


import atb.social.network.dto.BranchDto;
import atb.social.network.model.BankBranchModel;
import atb.social.network.service.BankBranch.BankBranchService;
import atb.social.network.service.EmployeeService.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class BankBranchController {

    private static final Logger logger = LoggerFactory.getLogger(BankBranchController.class);
    @Autowired
    private BankBranchService bankBranchService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/branches" , method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBranches() throws Exception {
        List<BankBranchModel> allBranches;
        logger.info("branch controller");
        try{
            allBranches  = bankBranchService.getAllBranches();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(allBranches, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @RequestMapping(value = "/branches/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveBranch(@RequestBody BranchDto branchDto) throws Exception {
        logger.info("branchDto: " + branchDto);

        try{
            bankBranchService.save(branchDto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("Done", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/branches/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> editBranch(@PathVariable String id, @RequestBody BranchDto branchDto) throws Exception {
        try{
            bankBranchService.edit(branchDto,Integer.parseInt(id));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("Done", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/branches/remove/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeBranch(@PathVariable String id) throws Exception {
        try{
            bankBranchService.remove(Integer.parseInt(id));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("Done", HttpStatus.OK);
    }
}
