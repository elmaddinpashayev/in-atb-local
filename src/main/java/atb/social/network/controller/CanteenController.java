package atb.social.network.controller;

import atb.social.network.dto.CanteenDetailsDto;
import atb.social.network.dto.CanteenRequestDTO;
import atb.social.network.dto.CategoryDTO;
import atb.social.network.model.MealCategory;
import atb.social.network.model.MealModel;
import atb.social.network.service.CanteenService.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")

public class CanteenController {

    @Autowired
    private CanteenService canteenService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen", method = RequestMethod.GET)
    public ResponseEntity<Object> getCanteenDetails() throws Exception {
        CanteenDetailsDto canteenDtoList;
        try {
            canteenDtoList = canteenService.getCanteenData();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(canteenDtoList, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/meal/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveCanteen(@RequestBody CanteenRequestDTO canteenRequestDTO) throws Exception {
        try {
            canteenService.saveMeal(canteenRequestDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/meal/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> editCanteen(@PathVariable("id") String id, @RequestBody CanteenRequestDTO canteenRequestDTO) throws Exception {
        try {
            canteenService.editMeal(Integer.parseInt(id), canteenRequestDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/meal/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeCanteen(@PathVariable("id") String id) throws Exception {
        try {
            canteenService.removeMeal(Integer.parseInt(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/category/save", method = RequestMethod.POST)
    public ResponseEntity<Object> saveCategory(@RequestBody CategoryDTO categoryDTO) throws Exception {
        try {
            canteenService.saveCategory(categoryDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/category/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> editCategory(@PathVariable("id") String id, @RequestBody CategoryDTO categoryDTO) throws Exception {
        try {
            canteenService.editCategory(categoryDTO, Integer.parseInt(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/category/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeCategory(@PathVariable("id") String id) throws Exception {

        try {
            canteenService.removeCategory(Integer.parseInt(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity("DONE", HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/category", method = RequestMethod.GET)
    public ResponseEntity<Object> getCategories() throws Exception {

        List<MealCategory> mealCategories;
        try {
            mealCategories = canteenService.getCategory();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(mealCategories, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/canteen/meal/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getMeals(@PathVariable("id") String id) throws Exception {

        List<MealModel> mealModels;
        try {
            mealModels = canteenService.getMealsByCategory(Integer.parseInt(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return new ResponseEntity(mealModels, HttpStatus.OK);
    }
}
