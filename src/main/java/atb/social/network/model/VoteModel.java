package atb.social.network.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class VoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private int votes;

    private int status;

    @ManyToOne
    @JoinColumn(name="question_model_id", nullable=false)
    private QuestionModel questionModels;

    public VoteModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public QuestionModel getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(QuestionModel questionModels) {
        this.questionModels = questionModels;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
