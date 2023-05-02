package atb.social.network.service.DocumentService;


import atb.social.network.dto.DocumentDTO;
import atb.social.network.model.DocumentsModel;
import atb.social.network.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentsRepository documentsRepository;


    @Override
    public void save(DocumentDTO documentDTO) throws Exception {

        try {
            DocumentsModel documentsModel = new DocumentsModel();
            documentsModel.setDocument(documentDTO.getDocument());
            documentsModel.setName(documentDTO.getName());
            documentsRepository.save(documentsModel);



        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }

    @Override
    public void edit(DocumentDTO documentDTO, int id) throws Exception {
        try {
            DocumentsModel documentsModel = documentsRepository.findById(id).get();
            documentsModel.setDocument(documentDTO.getDocument());
            documentsModel.setName(documentDTO.getName());
            documentsRepository.save(documentsModel);



        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }


    }

    @Override
    public void remove(int id) throws Exception {
        try {
            DocumentsModel documentsModel = documentsRepository.findById(id).get();

            documentsRepository.delete(documentsModel);



        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public List<DocumentsModel> getAllDocument() throws Exception {
        List<DocumentsModel> documentsModels;
        try {
            documentsModels = documentsRepository.findAll();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return documentsModels;
    }

    @Override
    public DocumentsModel getExactDocument(int id) throws Exception {
        DocumentsModel documentsModels;
        try {
            documentsModels = documentsRepository.findById(id).get();
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
        return documentsModels;
    }
}
