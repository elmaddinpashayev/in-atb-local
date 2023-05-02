package atb.social.network.model;
import javax.persistence.*;

@Entity
public class NotificationOnHomePageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition="TEXT")
    private String notificationText;
    private String filterDate;
    private int status;

    private String date;

    public NotificationOnHomePageModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFilterDate() {
        return filterDate;
    }

    public void setFilterDate(String filterDate) {
        this.filterDate = filterDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
