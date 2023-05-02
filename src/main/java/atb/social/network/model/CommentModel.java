package atb.social.network.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int empId;

    private String text;

    private int suggestId;

    private int anonim;



    public CommentModel() {
    }



    public int getAnonim() {
        return anonim;
    }

    public void setAnonim(int anonim) {
        this.anonim = anonim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(int suggestId) {
        this.suggestId = suggestId;
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "id=" + id +
                ", empId=" + empId +
                ", text='" + text + '\'' +
                ", suggestId=" + suggestId +
                ", anonim=" + anonim +
                '}';
    }
}
