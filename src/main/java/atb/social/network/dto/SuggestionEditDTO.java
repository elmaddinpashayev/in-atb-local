package atb.social.network.dto;

public class SuggestionEditDTO {

    private int empId;


    private String text;

    public SuggestionEditDTO() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
