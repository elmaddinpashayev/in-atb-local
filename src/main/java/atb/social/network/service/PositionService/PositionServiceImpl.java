package atb.social.network.service.PositionService;

import atb.social.network.dto.PositionDto;
import atb.social.network.model.PositionModel;
import atb.social.network.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;


    @Override
    public List<PositionModel> getAllPosition(int branchId, int departId, int subDepartId) throws Exception {
        List<PositionModel> getAllPosition;
        try{
            getAllPosition = positionRepository.findAllByBranchIdAndDepartIdAndSubDepartId(branchId,departId,subDepartId);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return getAllPosition;
    }

    @Override
    public void savePosition(PositionModel positionModel) throws Exception {
        try{
            positionRepository.save(positionModel);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }

    @Override
    public void removePosition(int id) throws Exception {
        try{
            PositionModel positionModel = positionRepository.findById(id).get();
            positionRepository.delete(positionModel);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }

    @Override
    public void editPosition(PositionDto positionModel, int id) throws Exception {
        try{
            PositionModel po = positionRepository.findById(id).get();
           po.setSubDepartId(positionModel.getSubDepartId());
           po.setPositionName(positionModel.getPositionName());
           po.setDepartId(positionModel.getDepartId());
           po.setBranchId(positionModel.getBranchId());
           po.setImportance(positionModel.getImportance());
           positionRepository.save(po);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
