package atb.social.network.repository;


import atb.social.network.model.BranchTimeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchTimeRepository extends CrudRepository<BranchTimeModel,Integer> {

    List<BranchTimeModel> findAll();

    BranchTimeModel findByBranchName(String name);

    BranchTimeModel findByBranchNameAndType(String branchName, String type);
}
