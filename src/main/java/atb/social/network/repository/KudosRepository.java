package atb.social.network.repository;

import atb.social.network.model.KudosSaveModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KudosRepository extends CrudRepository<KudosSaveModel,Integer> {

    KudosSaveModel findByEmpIdAndToIdAndAndKudosType(int empId, int toId, int kudos);

    KudosSaveModel findByToIdAndAndKudosType( int toId, int kudos);

    KudosSaveModel findByToIdAndAndKudosTypeAndUserIp( int toId, int kudos, String ip);

    List<KudosSaveModel>findAllByToIdAndKudosType(int toId, int kudos);

    List<KudosSaveModel>findAllByToIdAndUserIpAndAndKudosType(int toId, String ip, int kudos);
}
