package atb.social.network.repository;

import atb.social.network.model.CounterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterRepository extends CrudRepository<CounterModel,Integer> {

    List<CounterModel> findAllByDate(String date);
}
