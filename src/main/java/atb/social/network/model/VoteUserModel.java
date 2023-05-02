package atb.social.network.model;


import javax.persistence.*;

@Entity
public class VoteUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userIp;


    private int  voteId;

    @ManyToOne
    @JoinColumn(name="question_model_id", nullable=false)
    private QuestionModel questionModels;

    public VoteUserModel() {
    }

    public int getId() {
        return id;
    }


    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public QuestionModel getQuestionModels() {
        return questionModels;
    }

    public void setQuestionModels(QuestionModel questionModels) {
        this.questionModels = questionModels;
    }
}
