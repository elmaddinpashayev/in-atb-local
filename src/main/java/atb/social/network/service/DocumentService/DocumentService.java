package atb.social.network.service.DocumentService;

import atb.social.network.dto.DocumentDTO;
import atb.social.network.model.DocumentsModel;

import java.util.List;

public interface DocumentService {


    void save(DocumentDTO documentDTO) throws Exception;

    void edit(DocumentDTO documentDTO, int id) throws Exception;

    void remove(int id) throws Exception;

    List<DocumentsModel> getAllDocument() throws Exception;

    DocumentsModel getExactDocument(int id) throws Exception;






}
