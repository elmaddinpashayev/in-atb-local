package atb.social.network.repository;


import atb.social.network.model.BankBranchModel;
import atb.social.network.model.BankDepartmenModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankBranchRepository extends CrudRepository<BankBranchModel,Integer> {
    List<BankBranchModel> findAll();

}
