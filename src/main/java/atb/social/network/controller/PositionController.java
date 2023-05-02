package atb.social.network.controller;


import atb.social.network.dto.PositionDto;
import atb.social.network.model.PositionModel;
import atb.social.network.service.PositionService.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class PositionController {


    @Autowired
    private PositionService positionService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/positions/{bid}/{did}/{sdid}" , method = RequestMethod.GET)
    public ResponseEntity<Object> getAllPosition(@PathVariable("bid") String bid, @PathVariable("did") String did,@PathVariable("sdid") String sdid) throws Exception {
        List<PositionModel> positionModels;
        try{

            positionModels  = positionService.getAllPosition(Integer.parseInt(bid),Integer.parseInt(did),Integer.parseInt(sdid));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity(positionModels, HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/positions/save" , method = RequestMethod.POST)
    public ResponseEntity<Object> savePosition(@RequestBody PositionDto positionDto) throws Exception {
        try{

        PositionModel positionModel = new PositionModel();

        positionModel.setBranchId(positionDto.getBranchId());
        positionModel.setDepartId(positionDto.getDepartId());
        positionModel.setPositionName(positionDto.getPositionName());
        positionModel.setSubDepartId(positionDto.getSubDepartId());
        positionModel.setImportance(positionDto.getImportance());
        positionService.savePosition(positionModel);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/positions/remove/{id}" , method = RequestMethod.POST)

    public ResponseEntity<Object> removePosition(@PathVariable("id") String id) throws Exception {
        try{

         positionService.removePosition(Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/positions/edit/{id}" , method = RequestMethod.POST)
    public ResponseEntity<Object> editPosition(@RequestBody PositionDto positionDto,@PathVariable("id") String id) throws Exception {
        try{

            positionService.editPosition(positionDto,Integer.parseInt(id));


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return new ResponseEntity("DONE", HttpStatus.OK);



    }
}
