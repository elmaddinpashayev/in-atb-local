package atb.social.network.dto;

public class PositionDto {

    private String positionName;

    private int branchId;

    private int departId;

    private int subDepartId;

    private int importance;

    public PositionDto() {
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getSubDepartId() {
        return subDepartId;
    }

    public void setSubDepartId(int subDepartId) {
        this.subDepartId = subDepartId;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
