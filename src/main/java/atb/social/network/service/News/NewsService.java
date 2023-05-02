package atb.social.network.service.News;

import atb.social.network.dto.NewsDTO;
import atb.social.network.dto.NewsResultDto;
import atb.social.network.dto.NewsViewDTO;
import atb.social.network.model.NewsModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NewsService {

    NewsResultDto getAllNews(int count, int page, String userIP) throws Exception;

    NewsModel getNewsById(int id,String userIp) throws Exception;

    void saveNews(NewsDTO newsDTO, MultipartFile mainPhoto, MultipartFile m1, MultipartFile m2, MultipartFile m3, MultipartFile m4) throws Exception;

    void editNews(int id, NewsDTO newsDTO, MultipartFile mainPhoto,MultipartFile m1,MultipartFile m2,MultipartFile m3,MultipartFile m4) throws Exception;

    void removeNews(int id) throws Exception;

    void likeNews(int id,String userIp) throws Exception;


    void dislikeNews(int id,String userIp) throws Exception;


}
