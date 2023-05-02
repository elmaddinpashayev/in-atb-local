package atb.social.network.service.PositionService;

import atb.social.network.dto.PositionDto;
import atb.social.network.model.PositionModel;

import java.util.List;

public interface PositionService {

    List<PositionModel> getAllPosition(int branchId,int departId,int subDepartId) throws Exception;

    void savePosition(PositionModel positionModel) throws Exception;

    void removePosition(int id) throws Exception;

    void editPosition(PositionDto positionModel, int id) throws Exception;




}
