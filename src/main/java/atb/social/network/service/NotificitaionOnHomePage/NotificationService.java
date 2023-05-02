package atb.social.network.service.NotificitaionOnHomePage;

import atb.social.network.dto.NotificationDTO;
import atb.social.network.model.NotificationOnHomePageModel;

import java.util.List;

public interface NotificationService {


    List<NotificationOnHomePageModel> getNotificationByDate() throws Exception;

    List<NotificationOnHomePageModel> getAllNotification() throws Exception;

    List<NotificationOnHomePageModel> getAllNotificationAll() throws Exception;


    void save (NotificationDTO notificationDTO) throws Exception;

    void update (NotificationDTO notificationDTO, int id) throws Exception;

    void statusUpdate(int id) throws Exception;

    void remove (int id) throws Exception;









}
