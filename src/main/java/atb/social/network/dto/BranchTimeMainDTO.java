package atb.social.network.dto;

import java.util.List;

public class BranchTimeMainDTO {

    private String branchName;

    private List<BranchTimeDTO> workTimes;

    public BranchTimeMainDTO() {
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<BranchTimeDTO> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<BranchTimeDTO> workTimes) {
        this.workTimes = workTimes;
    }
}
