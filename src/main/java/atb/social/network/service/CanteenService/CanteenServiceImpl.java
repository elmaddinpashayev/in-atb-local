package atb.social.network.service.CanteenService;


import atb.social.network.dto.CanteenDetailsDto;
import atb.social.network.dto.CanteenDto;
import atb.social.network.dto.CanteenRequestDTO;
import atb.social.network.dto.CategoryDTO;
import atb.social.network.model.MealCategory;
import atb.social.network.model.MealModel;
import atb.social.network.repository.MealCategoryRepository;
import atb.social.network.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService{

    @Autowired
    private MealCategoryRepository mealCategoryRepository;

    @Autowired
    private MealRepository mealRepository;

    private String date;


    @Override
    public CanteenDetailsDto getCanteenData() throws Exception {
        List<CanteenDto> canteenDtos = new ArrayList<>();
        List<Integer> categoryId = new ArrayList<>();
        CanteenDetailsDto canteenDetailsDto = new CanteenDetailsDto();


        try{

            List<MealModel> mealModels = mealRepository.findAll();

            for(int i =0;i<mealModels.size();i++){

                categoryId.add(mealModels.get(i).getCategoryId());
            }

            HashSet<Integer> hset = new HashSet<>(categoryId);


            for(Integer strNumber : hset) {
                CanteenDto canteenDto = new CanteenDto();
                canteenDto.setCategory(mealCategoryRepository.findById(strNumber).get().getCategory());
                List<MealModel> mealModels1 = mealRepository.findAllByCategoryId(strNumber);
                canteenDto.setMealModels(mealModels1);
                canteenDtos.add(canteenDto);


            }

            canteenDetailsDto.setCanteenDtos(canteenDtos);
            canteenDetailsDto.setDate(date);





        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }


        return canteenDetailsDto;
    }


    @Override
    public void saveMeal(CanteenRequestDTO canteenRequestDTO) throws Exception{

        try{
            MealModel mealModel = new MealModel();

            mealModel.setCategoryId(canteenRequestDTO.getCategoryId());
            mealModel.setMealName(canteenRequestDTO.getName());
            mealModel.setPrice(canteenRequestDTO.getPrice());

            mealRepository.save(mealModel);
            String pattern = "dd.MM.yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            date = simpleDateFormat.format(new Date());




        }
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }


    @Override
    public void saveCategory(CategoryDTO categoryDTO) throws Exception{
        try{
            MealCategory mealCategory = new MealCategory();
            mealCategory.setCategory(categoryDTO.getName());


            mealCategoryRepository.save(mealCategory);





        }
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }


    @Override
    public void editMeal(int id,CanteenRequestDTO canteenRequestDTO) throws Exception{
        try{
            MealModel mealModel =mealRepository.findById(id).get();
            mealModel.setCategoryId(canteenRequestDTO.getCategoryId());
            mealModel.setMealName(canteenRequestDTO.getName());
            mealModel.setPrice(canteenRequestDTO.getPrice());

            mealRepository.save(mealModel);
            String pattern = "dd.MM.yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            date = simpleDateFormat.format(new Date());




        }
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }


    }


    @Override
    public void editCategory(CategoryDTO categoryDTO, int id) throws Exception{

        try{
            MealCategory mealCategory = mealCategoryRepository.findById(id).get();
            mealCategory.setCategory(categoryDTO.getName());


            mealCategoryRepository.save(mealCategory);




        }
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }


    }



    @Override
    public void removeCategory(int id) throws  Exception{
        try{
            MealCategory mealCategory = mealCategoryRepository.findById(id).get();


            mealCategoryRepository.delete(mealCategory);




        }
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }


    @Override
    public void removeMeal(int id) throws  Exception{


        try{
            MealModel mealModel =mealRepository.findById(id).get();

            mealRepository.delete(mealModel);




        }
        catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }


    @Override
    public List<MealCategory> getCategory( ) throws  Exception{
        List<MealCategory> mealCategories;
        try {

            mealCategories = mealCategoryRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }


return mealCategories;
    }


    @Override
    public  List<MealModel> getMealsByCategory(int id) throws Exception{
        List<MealModel> mealModels;
        try {

            mealModels = mealRepository.findAllByCategoryId(id);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }


        return mealModels;
    }













}
