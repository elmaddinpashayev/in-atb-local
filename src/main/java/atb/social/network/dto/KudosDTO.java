package atb.social.network.dto;

import java.util.List;

public class KudosDTO {

    private int kudosId;
    private String kudosName;
    private Boolean canVote;
    private int voteCount;
    private List<EmployeeKudosDTO> employeeKudosDTO;

    public List<EmployeeKudosDTO> getEmployeeKudosDTO() {
        return employeeKudosDTO;
    }

    public void setEmployeeKudosDTO(List<EmployeeKudosDTO> employeeKudosDTO) {
        this.employeeKudosDTO = employeeKudosDTO;
    }

    public int getKudosId() {
        return kudosId;
    }

    public void setKudosId(int kudosId) {
        this.kudosId = kudosId;
    }

    public String getKudosName() {
        return kudosName;
    }

    public void setKudosName(String kudosName) {
        this.kudosName = kudosName;
    }

    public Boolean getCanVote() {
        return canVote;
    }

    public void setCanVote(Boolean canVote) {
        this.canVote = canVote;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

}
