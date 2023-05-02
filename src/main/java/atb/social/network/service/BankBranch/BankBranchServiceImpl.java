package atb.social.network.service.BankBranch;

import atb.social.network.dto.BranchDto;
import atb.social.network.model.BankBranchModel;
import atb.social.network.model.BankDepartmenModel;
import atb.social.network.repository.BankBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankBranchServiceImpl implements BankBranchService {

    @Autowired
    private BankBranchRepository bankBranchRepository;

    @Override
    public List<BankBranchModel> getAllBranches() throws Exception {
        List<BankBranchModel> bankBranchModels = new ArrayList<>();
        try{
            bankBranchModels = bankBranchRepository.findAll();
            bankBranchModels = bankBranchModels.stream().sorted(Comparator.comparing(BankBranchModel::getImportance)).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return bankBranchModels;
    }

    @Override
    public void save(BranchDto branchDto) throws Exception {
        try{
            BankBranchModel bankBranchModel = new BankBranchModel();
            bankBranchModel.setBranchName(branchDto.getBranchName());
            bankBranchModel.setIsMainBranch(branchDto.getIsMain());
            if (branchDto.getImportance() != null) bankBranchModel.setImportance(branchDto.getImportance());
            else bankBranchModel.setImportance(Integer.MAX_VALUE);
            bankBranchRepository.save(bankBranchModel);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void edit(BranchDto branchDto, int id) throws Exception {

        try{
            BankBranchModel bankBranchModel = bankBranchRepository.findById(id).get();
            bankBranchModel.setBranchName(branchDto.getBranchName());
            bankBranchModel.setIsMainBranch(branchDto.getIsMain());
            if (branchDto.getImportance() != null) bankBranchModel.setImportance(branchDto.getImportance());
            bankBranchRepository.save(bankBranchModel);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public void remove(int id) throws Exception {

        try {

            BankBranchModel bankBranchModel = bankBranchRepository.findById(id).get();

            bankBranchRepository.delete(bankBranchModel);


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}

