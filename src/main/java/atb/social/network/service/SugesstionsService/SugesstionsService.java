package atb.social.network.service.SugesstionsService;

import atb.social.network.dto.*;

import java.util.List;


public interface SugesstionsService {



    List<SuggestionViewDTO> getListForView() throws Exception;
    List<SuggestionViewDTO> getList() throws Exception;


    void save(SugesstionSaveDTO sugesstionSaveDTO) throws Exception;

    void delete(int id) throws Exception;

    void edit(SuggestionEditDTO suggestionEditDTO, int id) throws Exception;
    CheckEmailResponse checkEmail(String email);
    void approve(int id);


    void saveComment(CommentDTO  commentDTO, int id) throws Exception;

    void deleteComment(int id) throws Exception;

    void editComment(CommentDTO commentDTO,int id) throws Exception;






}
