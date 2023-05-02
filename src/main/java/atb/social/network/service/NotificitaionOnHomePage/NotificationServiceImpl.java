package atb.social.network.service.NotificitaionOnHomePage;


import atb.social.network.dto.NotificationDTO;
import atb.social.network.model.NotificationOnHomePageModel;
import atb.social.network.repository.NotificationOnHomePageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    private NotificationOnHomePageRepository notificationOnHomePageRepository;





    @Override
    public List<NotificationOnHomePageModel> getNotificationByDate() throws Exception {
        List<NotificationOnHomePageModel> notificationOnHomePageModels;
        try{
            String pattern = " ddMMyyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            notificationOnHomePageModels = notificationOnHomePageRepository.findAllByFilterDateAndStatus(date,1);
            Collections.reverse(notificationOnHomePageModels);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return notificationOnHomePageModels;
    }


    @Override
    public List<NotificationOnHomePageModel> getAllNotification() throws Exception{

        List<NotificationOnHomePageModel> notificationOnHomePageModels;
        try{

            notificationOnHomePageModels = notificationOnHomePageRepository.findAllByStatus(1);
            Collections.reverse(notificationOnHomePageModels);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return notificationOnHomePageModels;


    }


    @Override
    public List<NotificationOnHomePageModel> getAllNotificationAll() throws Exception{

        List<NotificationOnHomePageModel> notificationOnHomePageModels;
        try{

            notificationOnHomePageModels = notificationOnHomePageRepository.findAll();
            Collections.reverse(notificationOnHomePageModels);


        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return notificationOnHomePageModels;


    }



    @Override
    public void save (NotificationDTO notificationDTO) throws Exception{
       try{
           String pattern = " ddMMyyyy";
           String patternShow = " dd.MM.yyyy";

           SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
           SimpleDateFormat simpleDateFormatShow = new SimpleDateFormat(patternShow);

           String date = simpleDateFormat.format(new Date());
           String dateShow = simpleDateFormatShow.format(new Date());

           NotificationOnHomePageModel notificationOnHomePageModel = new NotificationOnHomePageModel();
           notificationOnHomePageModel.setNotificationText(notificationDTO.getText());
           notificationOnHomePageModel.setFilterDate(date);
           notificationOnHomePageModel.setDate(dateShow);
           notificationOnHomePageModel.setStatus(1);
           notificationOnHomePageRepository.save(notificationOnHomePageModel);

       }catch (Exception e){
           throw  new Exception(e.getMessage());
       }
    }

    @Override
    public void update (NotificationDTO notificationDTO, int id) throws Exception{
        try{
            String pattern = " ddMMyyyy";
            String patternShow = " dd.MM.yyyy";

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            SimpleDateFormat simpleDateFormatShow = new SimpleDateFormat(patternShow);

            String date = simpleDateFormat.format(new Date());
            String dateShow = simpleDateFormatShow.format(new Date());
            NotificationOnHomePageModel notificationOnHomePageModel = notificationOnHomePageRepository.findById(id).get();
            notificationOnHomePageModel.setNotificationText(notificationDTO.getText());
            notificationOnHomePageModel.setFilterDate(date);
            notificationOnHomePageModel.setDate(dateShow);
            notificationOnHomePageRepository.save(notificationOnHomePageModel);

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public void statusUpdate(int id) throws Exception{
        try{
            NotificationOnHomePageModel notificationOnHomePageModel = notificationOnHomePageRepository.findById(id).get();
           int status = (notificationOnHomePageModel.getStatus() ==1 ) ? 0 : 1;
           notificationOnHomePageModel.setStatus(status);
           notificationOnHomePageRepository.save(notificationOnHomePageModel);


        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }


    @Override
    public void remove(int id) throws Exception{
        try{
            NotificationOnHomePageModel notificationOnHomePageModel = notificationOnHomePageRepository.findById(id).get();
            notificationOnHomePageRepository.delete(notificationOnHomePageModel);

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }



}
