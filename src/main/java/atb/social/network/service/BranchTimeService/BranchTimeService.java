package atb.social.network.service.BranchTimeService;

import atb.social.network.dto.BranchTimeDTO;
import atb.social.network.dto.BranchTimeMainDTO;
import atb.social.network.model.BranchTimeModel;

import java.util.List;
import java.util.Map;

public interface BranchTimeService {

    Map<String, List<BranchTimeModel>> getBranchData() throws Exception;


  void  saveBranchData(List<BranchTimeMainDTO> branchTimeMainDTO) throws Exception;


}
