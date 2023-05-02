package atb.social.network.dto;

import java.util.List;

public class PollSaveRequest {

    private String title;
    private String link;
    private String description;
    private List<ChoicesDTO> choices;

    public PollSaveRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChoicesDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoicesDTO> choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        return "PollSaveRequest{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", choices=" + choices +
                '}';
    }
}
