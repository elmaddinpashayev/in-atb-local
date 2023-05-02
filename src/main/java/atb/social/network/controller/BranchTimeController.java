package atb.social.network.controller;


import atb.social.network.dto.BranchTimeDTO;
import atb.social.network.dto.BranchTimeMainDTO;
import atb.social.network.dto.CanteenDto;
import atb.social.network.model.BranchTimeModel;
import atb.social.network.service.BranchTimeService.BranchTimeService;
import atb.social.network.service.CanteenService.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class BranchTimeController {
    @Autowired
    private BranchTimeService branchTimeService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/branchTime" , method = RequestMethod.GET)
    public ResponseEntity<Object> getBranchTime() throws Exception {
        Map<String, List<BranchTimeModel>> branchTimeModels;
        try{

            branchTimeModels  = branchTimeService.getBranchData();


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(branchTimeModels, HttpStatus.OK);



    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/branchTime/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> saveBranchTime(@RequestBody List<BranchTimeMainDTO> branchTimeMainDTO) throws Exception {

        try{

        branchTimeService.saveBranchData(branchTimeMainDTO);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }
}
