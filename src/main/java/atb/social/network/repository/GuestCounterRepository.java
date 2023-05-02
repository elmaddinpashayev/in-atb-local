package atb.social.network.repository;

import atb.social.network.model.CounterModel;
import atb.social.network.model.MatchMakerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestCounterRepository extends CrudRepository<MatchMakerModel,Integer> {
}
