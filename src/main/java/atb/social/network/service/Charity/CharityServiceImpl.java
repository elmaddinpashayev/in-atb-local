package atb.social.network.service.Charity;

import atb.social.network.config.FileConfig;
import atb.social.network.dto.CharityDTO;
import atb.social.network.dto.CharityResultDto;
import atb.social.network.dto.CharityViewDTO;
import atb.social.network.model.CharityLikeModel;
import atb.social.network.model.CharityModel;
import atb.social.network.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static atb.social.network.model.CharityModel.SORT_BY_ID;

@Service
public class CharityServiceImpl implements CharityService {

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private CharityCounterRepository charityCounterRepository;

    @Autowired
    private CharityLikeRepository charityLikeRepository;


    @Override
    public CharityResultDto getAllCharity(int count, int page, String userIP) throws Exception {
        CharityResultDto CharityResultDto = new CharityResultDto();
        List<CharityViewDTO> CharityModelsFilter = new ArrayList<>();

        try {
            List<CharityModel> CharitySize = (List<CharityModel>) charityRepository.findAll();
            int size = CharitySize.size();
            CharityResultDto.setSize(size);
            List<CharityModel> CharityModels = (List<CharityModel>) charityRepository.findAll(SORT_BY_ID);
            int lastnum;
            if (page * count > CharityModels.size()) {
                lastnum = CharityModels.size();
            } else {
                lastnum = page * count;
            }
            for (int i = (page - 1) * count; i < lastnum; i++) {
                CharityViewDTO CharityViewDTO = new CharityViewDTO();
                CharityModel CharityModel = CharityModels.get(i);
//                List<CharityCounterModel> CharityCounterModels = CharityCounterRepository.findAllByCharityId(CharityModel.getId());
                List<CharityLikeModel> like = charityLikeRepository.findAllByCharityIdAndStatus(CharityModel.getId(), 1);
                List<CharityLikeModel> dislike = charityLikeRepository.findAllByCharityIdAndStatus(CharityModel.getId(), -1);
                CharityLikeModel CharityLikeModel = charityLikeRepository.findByCharityIdAndUserip(CharityModel.getId(), userIP);
                CharityViewDTO.setId(CharityModel.getId());
                CharityViewDTO.setCounter(CharityModel.getCount());
                CharityViewDTO.setDate(CharityModel.getDate());
                CharityViewDTO.setDislike(dislike.size());
                CharityViewDTO.setLike(like.size());
                CharityViewDTO.setMainPhoto(CharityModel.getMainPhoto());
                CharityViewDTO.setPhoto1(CharityModel.getPhoto1());
                CharityViewDTO.setPhoto2(CharityModel.getPhoto2());
                CharityViewDTO.setPhoto3(CharityModel.getPhoto3());
                CharityViewDTO.setPhoto4(CharityModel.getPhoto4());
                CharityViewDTO.setText(CharityModel.getText());
                CharityViewDTO.setStatus((CharityLikeModel == null) ? 0 : CharityLikeModel.getStatus());
                CharityViewDTO.setTitle(CharityModel.getTitle());
                CharityModelsFilter.add(CharityViewDTO);
                CharityResultDto.setCharityViewDTOS(CharityModelsFilter);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return CharityResultDto;
    }

    @Override
    public CharityModel getCharityById(int id, String userIp) throws Exception {
        CharityModel CharityModels;
        try {
//            CharityCounterModel CharityCounterModel = CharityCounterRepository.findByCharityIdAndIp(id, userIp);
//            if (CharityCounterModel == null) {
//                CharityCounterModel CharityCounterModel1 = new CharityCounterModel();
//                CharityCounterModel1.setIp(userIp);
//                CharityCounterModel1.setCharityId(id);
//                CharityCounterRepository.save(CharityCounterModel1);
//            }
            CharityModels = charityRepository.findById(id);
            charityRepository.findById(id).setCount(charityRepository.findById(id).getCount() + 1);
            charityRepository.save(CharityModels);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return CharityModels;
    }


    @Override
    public void saveCharity(CharityDTO CharityDTO, MultipartFile mainPhoto, MultipartFile m1, MultipartFile m2, MultipartFile m3, MultipartFile m4) throws Exception {
        String path = "/app/photos/charity/";
        try {
            CharityModel CharityModel = new CharityModel();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd HH:mm");
            String date = simpleDateFormat.format(new Date());
            System.out.println(date);
            CharityModel.setDate(date);
            CharityModel.setText(CharityDTO.getText());
            CharityModel.setTitle(CharityDTO.getTitle());
            charityRepository.save(CharityModel);

            if (mainPhoto != null) {
                String mainPhoto1 = StringUtils.cleanPath(mainPhoto.getOriginalFilename());
                CharityModel.setMainPhoto(mainPhoto1);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, mainPhoto1, mainPhoto);
            }
            if (m1 != null) {
                String m11 = StringUtils.cleanPath(m1.getOriginalFilename());
                CharityModel.setPhoto1(m11);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m11, m1);
            }
            if (m2 != null) {
                String m22 = StringUtils.cleanPath(m2.getOriginalFilename());
                CharityModel.setPhoto2(m22);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m22, m2);
            }
            if (m3 != null) {
                String m33 = StringUtils.cleanPath(m3.getOriginalFilename());
                CharityModel.setPhoto3(m33);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m33, m3);
            }
            if (m4 != null) {
                String m44 = StringUtils.cleanPath(m4.getOriginalFilename());
                CharityModel.setPhoto4(m44);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m44, m4);
            }
            charityRepository.save(CharityModel);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void editCharity(int id, CharityDTO CharityDTO, MultipartFile mainPhoto, MultipartFile m1, MultipartFile m2, MultipartFile m3, MultipartFile m4) throws Exception {
        String path = "/app/photos/charity/";
        try {
            CharityModel CharityModel = charityRepository.findById(id);
            CharityModel.setText(CharityDTO.getText());
            CharityModel.setTitle(CharityDTO.getTitle());

            if (mainPhoto != null) {
                FileConfig.deleteFile(path + CharityModel.getId() + "/" + CharityModel.getMainPhoto());
                String mainPhoto1 = StringUtils.cleanPath(mainPhoto.getOriginalFilename());
                CharityModel.setMainPhoto(mainPhoto1);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, mainPhoto1, mainPhoto);
            }
            if (m1 != null) {
                FileConfig.deleteFile(path + CharityModel.getId() + "/" + CharityModel.getPhoto1());

                String m11 = StringUtils.cleanPath(m1.getOriginalFilename());
                CharityModel.setMainPhoto(m11);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m11, m1);
            }
            if (m2 != null) {
                FileConfig.deleteFile(path + CharityModel.getId() + "/" + CharityModel.getPhoto2());
                String m22 = StringUtils.cleanPath(m2.getOriginalFilename());
                CharityModel.setMainPhoto(m22);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m22, m2);
            }
            if (m3 != null) {
                FileConfig.deleteFile(path + CharityModel.getId() + "/" + CharityModel.getPhoto3());
                String m33 = StringUtils.cleanPath(m1.getOriginalFilename());
                CharityModel.setMainPhoto(m33);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m33, m3);
            }
            if (m4 != null) {
                FileConfig.deleteFile(path + CharityModel.getId() + "/" + CharityModel.getPhoto4());
                String m44 = StringUtils.cleanPath(m4.getOriginalFilename());
                CharityModel.setMainPhoto(m44);
                String uploadDir = path + CharityModel.getId();
                FileConfig.saveFile(uploadDir, m44, m4);
            }
            charityRepository.save(CharityModel);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void removeCharity(int id) throws Exception {
        String path = "/app/photos/charity/";
//        try {
            CharityModel CharityModel = charityRepository.findById(id);
            FileConfig.deleteDirectoryJava7(path + CharityModel.getId());
            charityRepository.delete(CharityModel);
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
    }


    @Override
    public void likeCharity(int id, String userIp) throws Exception {
        try {
            CharityLikeModel CharityLikeModel = charityLikeRepository.findByCharityIdAndUserip(id, userIp);
            CharityLikeModel CharityLikeModelDislike = charityLikeRepository.findByCharityIdAndUseripAndStatus(id, userIp, -1);
            if (CharityLikeModel == null) {
                CharityLikeModel CharityLikeModel1 = new CharityLikeModel();
                CharityLikeModel1.setCharityId(id);
                CharityLikeModel1.setUserip(userIp);
                CharityLikeModel1.setStatus(1);
                charityLikeRepository.save(CharityLikeModel1);

            } else if (CharityLikeModelDislike != null) {
                charityLikeRepository.delete(CharityLikeModelDislike);
                CharityLikeModel CharityLikeModel2 = new CharityLikeModel();
                CharityLikeModel2.setCharityId(id);
                CharityLikeModel2.setUserip(userIp);
                CharityLikeModel2.setStatus(1);
                charityLikeRepository.save(CharityLikeModel2);
            } else {
                charityLikeRepository.delete(CharityLikeModel);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public void dislikeCharity(int id, String userIp) throws Exception {
        try {
            CharityLikeModel CharityLikeModel = charityLikeRepository.findByCharityIdAndUserip(id, userIp);
            CharityLikeModel CharityLikeModelLike = charityLikeRepository.findByCharityIdAndUseripAndStatus(id, userIp, 1);

            if (CharityLikeModel == null) {
                CharityLikeModel CharityLikeModel1 = new CharityLikeModel();
                CharityLikeModel1.setCharityId(id);
                CharityLikeModel1.setUserip(userIp);
                CharityLikeModel1.setStatus(-1);

            } else if (CharityLikeModelLike != null) {
                charityLikeRepository.delete(CharityLikeModelLike);
                CharityLikeModel CharityLikeModel2 = new CharityLikeModel();
                CharityLikeModel2.setCharityId(id);
                CharityLikeModel2.setUserip(userIp);
                CharityLikeModel2.setStatus(-1);
                charityLikeRepository.save(CharityLikeModel2);
            } else {
                charityLikeRepository.delete(CharityLikeModel);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
