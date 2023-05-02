package atb.social.network.repository;


import atb.social.network.model.BankDepartmenModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDepartmentRepository extends CrudRepository<BankDepartmenModel,Integer> {

    List<BankDepartmenModel> findAll();

    List<BankDepartmenModel> findAllByAvailableOnBranchId(int id);

}
