package atb.social.network.repository;


import atb.social.network.model.EmployeeEditHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEditHistoryRepository extends CrudRepository<EmployeeEditHistory,Integer> {

    List<EmployeeEditHistory> findAllByDateWithoutYear(String date);

    EmployeeEditHistory findByEmployeeId(int id);
}
