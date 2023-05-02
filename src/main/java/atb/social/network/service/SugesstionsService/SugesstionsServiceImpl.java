package atb.social.network.service.SugesstionsService;

import atb.social.network.dto.*;
import atb.social.network.model.CommentModel;
import atb.social.network.model.EmployeeModel;
import atb.social.network.model.SugesstionModel;
import atb.social.network.repository.CommentRepository;
import atb.social.network.repository.EmployeeRepository;
import atb.social.network.repository.PositionRepository;
import atb.social.network.repository.SuggestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SugesstionsServiceImpl implements SugesstionsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private SuggestRepository suggestRepository;

    @Autowired
    private CommentRepository commentRepository;




    @Override
    public List<SuggestionViewDTO> getListForView() throws Exception {
        List<SuggestionViewDTO> suggestionViewDTOS = new ArrayList<>();


        List<SugesstionModel> sugesstionModels = suggestRepository.findAllByStatus(1);
        if(sugesstionModels.size()>0) {
            for (int i = 0; i < sugesstionModels.size(); i++) {
                SuggestionViewDTO suggestionViewDTO = new SuggestionViewDTO();
                CommentViewDTO commentViewDTO = new CommentViewDTO();
                SugesstionModel sugesstionModel = sugesstionModels.get(i);
                EmployeeModel employeeModelSug = employeeRepository.findById(sugesstionModel.getEmpId());


                if(sugesstionModels.get(i).getCommentId()>0){
                    CommentModel commentModel = commentRepository.findBySuggestId(sugesstionModels.get(i).getId());
                    commentViewDTO.setEmpId(commentModel.getEmpId());
                    if(commentModel.getAnonim()==0) {

                        EmployeeModel employeeModel = employeeRepository.findById(commentModel.getEmpId());
                        commentViewDTO.setName(employeeModel.getName());
                        commentViewDTO.setSurname(employeeModel.getSurname());
                        commentViewDTO.setPosition(employeeModel.getPositionName());
                        commentViewDTO.setPhoto(employeeModel.getPhotosImagePath());
                    }
                    commentViewDTO.setAnonim(commentModel.getAnonim());
                    commentViewDTO.setText(commentModel.getText());
                }

                suggestionViewDTO.setId(sugesstionModel.getId());
                suggestionViewDTO.setCommentViewDTO(commentViewDTO);
                suggestionViewDTO.setDate(sugesstionModel.getDate());
                if(sugesstionModel.getAnonim()==0) {
                    suggestionViewDTO.setEmpId(sugesstionModel.getEmpId());
                    System.out.println(sugesstionModel.getEmpId());
                    System.out.println(employeeModelSug.toString());
                    suggestionViewDTO.setPhoto(employeeModelSug.getPhotosImagePath());
                    suggestionViewDTO.setName(employeeRepository.findById(sugesstionModel.getEmpId()).getName());
                    suggestionViewDTO.setSurname(employeeRepository.findById(sugesstionModel.getEmpId()).getSurname());
                    suggestionViewDTO.setPosition(employeeRepository.findById(sugesstionModel.getEmpId()).getPositionName());
                }
                suggestionViewDTO.setText(sugesstionModel.getText());
                suggestionViewDTO.setAnonim(sugesstionModel.getAnonim());
                suggestionViewDTOS.add(suggestionViewDTO);
            }
        }
        Collections.sort(suggestionViewDTOS, new Comparator<SuggestionViewDTO>() {


            @Override
            public int compare(SuggestionViewDTO o1, SuggestionViewDTO o2) {
                return Integer.compare(o2.getId(), o1.getId());
            }
        });


        return suggestionViewDTOS;
    }





    @Override
    public List<SuggestionViewDTO> getList() throws Exception {
        List<SuggestionViewDTO> suggestionViewDTOS = new ArrayList<>();


        List<SugesstionModel> sugesstionModels = suggestRepository.findAll();
        if(sugesstionModels.size()>0) {
            for (int i = 0; i < sugesstionModels.size(); i++) {
                SuggestionViewDTO suggestionViewDTO = new SuggestionViewDTO();
                CommentViewDTO commentViewDTO = new CommentViewDTO();
                SugesstionModel sugesstionModel = sugesstionModels.get(i);
                EmployeeModel employeeModelSug = employeeRepository.findById(sugesstionModel.getEmpId());

                if(sugesstionModels.get(i).getCommentId()>0){
                    CommentModel commentModel = commentRepository.findBySuggestId(sugesstionModels.get(i).getId());
                    commentViewDTO.setId(commentModel.getId());
                    commentViewDTO.setEmpId(commentModel.getEmpId());
                    if(commentModel.getAnonim()==0) {
                        EmployeeModel employeeModel = employeeRepository.findById(commentModel.getEmpId());
                        commentViewDTO.setName(employeeModel.getName());
                        commentViewDTO.setEmail(employeeModel.getEmail());
                        commentViewDTO.setSurname(employeeModel.getSurname());
                        commentViewDTO.setPosition(employeeModel.getPositionName());
                        commentViewDTO.setPhoto(employeeModel.getPhotosImagePath());
                    }
                    commentViewDTO.setAnonim(commentModel.getAnonim());
                    commentViewDTO.setText(commentModel.getText());


                }
                suggestionViewDTO.setId(sugesstionModel.getId());
                suggestionViewDTO.setStatus(sugesstionModel.getStatus());
                suggestionViewDTO.setDate(sugesstionModel.getDate());


                System.out.println("sugesstionModel.getEmpId() : " + sugesstionModel.getEmpId());
                suggestionViewDTO.setCommentViewDTO(commentViewDTO);
                if(sugesstionModel.getAnonim()==0) {
                    suggestionViewDTO.setEmpId(sugesstionModel.getEmpId());
                    suggestionViewDTO.setPhoto(employeeModelSug.getPhotosImagePath());
                    suggestionViewDTO.setName(employeeRepository.findById(sugesstionModel.getEmpId()).getName());
                    suggestionViewDTO.setSurname(employeeRepository.findById(sugesstionModel.getEmpId()).getSurname());
                    suggestionViewDTO.setPosition(employeeRepository.findById(sugesstionModel.getEmpId()).getPositionName());
                }
                suggestionViewDTO.setText(sugesstionModel.getText());
                suggestionViewDTO.setAnonim(sugesstionModel.getAnonim());

                suggestionViewDTOS.add(suggestionViewDTO);




            }


        }

        Collections.sort(suggestionViewDTOS, new Comparator<SuggestionViewDTO>() {


            @Override
            public int compare(SuggestionViewDTO o1, SuggestionViewDTO o2) {
                return Integer.compare(o2.getId(), o1.getId());
            }
        });


        return suggestionViewDTOS;
    }

    @Override
    public void save(SugesstionSaveDTO sugesstionSaveDTO) throws Exception {
        try{
            String pattern = "dd-MM-yyyy HH:mm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(new Date());
            SugesstionModel sugesstionModel = new SugesstionModel();
            sugesstionModel.setEmpId(sugesstionSaveDTO.getEmpId());
            sugesstionModel.setAnonim(sugesstionSaveDTO.getAnonim());
            sugesstionModel.setText(sugesstionSaveDTO.getText());
            sugesstionModel.setDate(date);
            sugesstionModel.setStatus(0);

            suggestRepository.save(sugesstionModel);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public void delete(int id) throws Exception {
        try{

            SugesstionModel sugesstionModel= suggestRepository.findById(id).get();
            CommentModel commentModel = commentRepository.findBySuggestId(id);
            if (commentModel!=null){
                commentRepository.delete(commentModel);
            }
            suggestRepository.delete(sugesstionModel);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void edit(SuggestionEditDTO suggestionEditDTO, int id) throws Exception {
        try{

            SugesstionModel sugesstionModel= suggestRepository.findById(id).get();
            sugesstionModel.setEmpId(suggestionEditDTO.getEmpId());
            sugesstionModel.setText(suggestionEditDTO.getText());
            suggestRepository.save(sugesstionModel);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public CheckEmailResponse checkEmail(String email) {
        CheckEmailResponse checkEmailResponse = new CheckEmailResponse();


        EmployeeModel employeeModel = employeeRepository.findByEmailIgnoreCase(email);
        if(employeeModel!=null){
            checkEmailResponse.setId(employeeModel.getId());
            checkEmailResponse.setName(employeeModel.getName());
            checkEmailResponse.setSurname(employeeModel.getSurname());
            checkEmailResponse.setPosition(employeeModel.getPositionName());
            checkEmailResponse.setPhoto(employeeModel.getPhotosImagePath());
        }








        return checkEmailResponse;
    }



    @Override
    public void approve(int id) {

        SugesstionModel sugesstionModel = suggestRepository.findById(id).get();
        if (sugesstionModel!=null){
            sugesstionModel.setStatus(1);

        }
        suggestRepository.save(sugesstionModel);



    }

    @Override
    public void saveComment(CommentDTO commentDTO, int id) throws Exception {

        SugesstionModel sugesstionModel =  suggestRepository.findById(id).get();


        if(sugesstionModel!=null && sugesstionModel.getCommentId()==0) {
            CommentModel commentModel = new CommentModel();

            commentModel.setAnonim(commentDTO.getAnonim());
            commentModel.setEmpId(commentDTO.getEmpId());
            commentModel.setSuggestId(sugesstionModel.getId());
            commentModel.setText(commentDTO.getText());

            commentRepository.save(commentModel);
            System.out.println(commentModel.getId());
            sugesstionModel.setCommentId(commentModel.getId());
            suggestRepository.save(sugesstionModel);
        }



    }

    @Override
    public void deleteComment(int id) throws Exception {
        CommentModel commentModel = commentRepository.findById(id).get();
        SugesstionModel sugesstionModel = suggestRepository.findByCommentId(commentModel.getId());
        sugesstionModel.setCommentId(0);
        commentRepository.delete(commentModel);

        suggestRepository.save(sugesstionModel);
    }



    @Override
    public void editComment(CommentDTO commentDTO,int id) throws Exception {
        CommentModel commentModel = commentRepository.findById(id).get();
        commentModel.setAnonim(commentDTO.getAnonim());
        commentModel.setEmpId(commentDTO.getEmpId());
        commentModel.setText(commentDTO.getText());
        commentRepository.save(commentModel);

    }

}
