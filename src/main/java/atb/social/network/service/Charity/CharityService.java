package atb.social.network.service.Charity;

import atb.social.network.dto.CharityDTO;
import atb.social.network.dto.CharityResultDto;
import atb.social.network.model.CharityModel;
import org.springframework.web.multipart.MultipartFile;

public interface CharityService {

    CharityResultDto getAllCharity(int count, int page, String userIP) throws Exception;

    CharityModel getCharityById(int id,String userIp) throws Exception;

    void saveCharity(CharityDTO CharityDTO, MultipartFile mainPhoto, MultipartFile m1, MultipartFile m2, MultipartFile m3, MultipartFile m4) throws Exception;

    void editCharity(int id, CharityDTO CharityDTO, MultipartFile mainPhoto,MultipartFile m1,MultipartFile m2,MultipartFile m3,MultipartFile m4) throws Exception;

    void removeCharity(int id) throws Exception;

    void likeCharity(int id,String userIp) throws Exception;


    void dislikeCharity(int id,String userIp) throws Exception;


}
