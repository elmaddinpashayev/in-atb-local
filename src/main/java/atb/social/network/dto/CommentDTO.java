package atb.social.network.dto;

public class CommentDTO {

    private int empId;

    private int anonim;

    private String text;

    public CommentDTO() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAnonim() {
        return anonim;
    }

    public void setAnonim(int anonim) {
        this.anonim = anonim;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
