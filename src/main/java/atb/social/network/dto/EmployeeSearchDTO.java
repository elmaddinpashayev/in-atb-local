package atb.social.network.dto;

import atb.social.network.model.EmployeeModel;

public class EmployeeSearchDTO extends EmployeeModel {

    private String positionName;

    public EmployeeSearchDTO() {
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
