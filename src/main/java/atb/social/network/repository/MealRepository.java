package atb.social.network.repository;

import atb.social.network.model.MealModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<MealModel,Integer> {

    List<MealModel> findAll();


    List<MealModel> findAllByCategoryId(int id);




}
