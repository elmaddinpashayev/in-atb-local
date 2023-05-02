package atb.social.network.service.BranchTimeService;


import atb.social.network.dto.BranchTimeDTO;
import atb.social.network.dto.BranchTimeMainDTO;
import atb.social.network.model.BranchTimeModel;
import atb.social.network.repository.BranchTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BranchTimeServiceImpl implements BranchTimeService{

    @Autowired
    private BranchTimeRepository branchTimeRepository;


    @Override
    public  Map<String, List<BranchTimeModel>> getBranchData() throws Exception {
        Map<String, List<BranchTimeModel>> studlistGrouped;

        List<BranchTimeModel> branchTimeModels;
        try{

            branchTimeModels = branchTimeRepository.findAll();
            studlistGrouped =
                    branchTimeModels.stream().collect(Collectors.groupingBy(w -> w.getBranchName()));


        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return studlistGrouped;
    }




    @Override
    public void  saveBranchData(List<BranchTimeMainDTO> branchTimeDTO) throws Exception{
        try {

            for (int i = 0 ; i<branchTimeDTO.size();i++) {
                for (int t = 0; t < branchTimeDTO.get(i).getWorkTimes().size(); t++) {
                    BranchTimeModel branchTimeModel = branchTimeRepository.findByBranchNameAndType(branchTimeDTO.get(i).getBranchName(), branchTimeDTO.get(i).getWorkTimes().get(t).getType());
                    if (branchTimeModel == null) {
                        BranchTimeModel branchTimeModel1 = new BranchTimeModel();
                        branchTimeModel1.setBranchName(branchTimeDTO.get(i).getBranchName());
                        branchTimeModel1.setStartTime(branchTimeDTO.get(i).getWorkTimes().get(t).getStart());
                        branchTimeModel1.setEndTime(branchTimeDTO.get(i).getWorkTimes().get(t).getEnd());
                        branchTimeModel1.setType(branchTimeDTO.get(i).getWorkTimes().get(t).getType());
                        branchTimeRepository.save(branchTimeModel1);
                    } else {
                        branchTimeModel.setStartTime(branchTimeDTO.get(i).getWorkTimes().get(t).getStart());
                        branchTimeModel.setEndTime(branchTimeDTO.get(i).getWorkTimes().get(t).getEnd());
                        branchTimeRepository.save(branchTimeModel);
                    }

                }
            }

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }


    }

}
