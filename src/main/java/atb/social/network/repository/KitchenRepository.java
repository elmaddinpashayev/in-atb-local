package atb.social.network.repository;

import atb.social.network.model.KitchenModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface KitchenRepository extends CrudRepository<KitchenModel, Integer> {

    Set<KitchenModel> findAll();

    KitchenModel findByMealName(String name);

}
