package atb.social.network.repository;

import atb.social.network.model.ZodiacModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZodiacRepository extends CrudRepository<ZodiacModel, Integer> {

    ZodiacModel findByName(String name);

}
