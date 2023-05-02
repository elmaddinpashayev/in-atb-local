package atb.social.network.repository;

import atb.social.network.model.QuoteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<QuoteModel,Integer> {
}
