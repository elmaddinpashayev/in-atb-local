package atb.social.network.dto;

public class BranchDto {
    private String branchName;

    private int isMain;

    private Integer importance;

    public BranchDto() {
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getIsMain() {
        return isMain;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public void setIsMain(int isMain) {
        this.isMain = isMain;
    }

    @Override
    public String toString() {
        return "BranchDto{" +
                "branchName='" + branchName + '\'' +
                ", isMain=" + isMain +
                ", importance=" + importance +
                '}';
    }
}
