package atb.social.network.service.BankBranch;

import atb.social.network.dto.BranchDto;
import atb.social.network.model.BankBranchModel;

import java.util.List;

public interface BankBranchService {

    List<BankBranchModel> getAllBranches() throws Exception;

    void save (BranchDto branchDto) throws Exception;

    void edit(BranchDto branchDto, int id) throws Exception;

    void remove(int id) throws Exception;

}
