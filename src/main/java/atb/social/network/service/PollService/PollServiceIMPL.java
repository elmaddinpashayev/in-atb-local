package atb.social.network.service.PollService;

import atb.social.network.dto.*;
import atb.social.network.model.QuestionModel;
import atb.social.network.model.VoteModel;
import atb.social.network.model.VoteUserModel;
import atb.social.network.repository.QuestionsRepository;
import atb.social.network.repository.VoteRepository;
import atb.social.network.repository.VoteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class PollServiceIMPL implements PollService{

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VoteUserRepository voteUserRepository;


    @Override
    public void save(PollSaveRequest pollSaveRequest) {

        QuestionModel questionModel = new QuestionModel();

        questionModel.setDescription(pollSaveRequest.getDescription());
        questionModel.setLink(pollSaveRequest.getLink());
        questionModel.setTitle(pollSaveRequest.getTitle());
        questionModel.setStatus(1);
        questionsRepository.save(questionModel);
        List<VoteModel> voteModels = new ArrayList<>();

        for(int i=0;i<pollSaveRequest.getChoices().size();i++){
            VoteModel voteModel = new VoteModel();
            voteModel.setText(pollSaveRequest.getChoices().get(i).getText());
            voteModel.setVotes(0);
            voteModel.setQuestionModels(questionModel);
            voteModel.setStatus(1);
            voteRepository.save(voteModel);
            voteModels.add(voteModel);
        }


        questionsRepository.save(questionModel);





    }

    @Override
    public int voteThePool(String userIp, int qid, int cid) {

        int result;

        QuestionModel questionModel = questionsRepository.findById(qid).get();

        VoteModel voteModel = voteRepository.findById(cid).get();

        VoteUserModel exist = voteUserRepository.findByQuestionModelsAndUserIp(questionModel,userIp);

        if(exist==null){
            VoteUserModel voteUserModel = new VoteUserModel();
            voteUserModel.setUserIp(userIp);
            voteUserModel.setQuestionModels(questionModel);
            voteUserModel.setVoteId(cid);
            voteModel.setVotes(voteModel.getVotes()+1);
            voteRepository.save(voteModel);
            voteUserRepository.save(voteUserModel);
            result=1;
        }else {
            result=0;
        }


return result;





    }

    @Override
    public List<PollsDTO> getPollsData(String userIp) {
        List<PollsDTO> pollsDTOS = new ArrayList<>();

        List<QuestionModel> questionModels = questionsRepository.findAllByStatus(1);


        for(int i = 0 ;i<questionModels.size();i++){
            PollsDTO pollsDTO = new PollsDTO();
            pollsDTO.setqId(questionModels.get(i).getId());
            pollsDTO.setDescription(questionModels.get(i).getDescription());
            pollsDTO.setLink(questionModels.get(i).getLink());
            pollsDTO.setTitle(questionModels.get(i).getTitle());
            VoteUserModel voteUserModel = voteUserRepository.findByQuestionModelsAndUserIp(questionModels.get(i),userIp);
            if(voteUserModel==null){
                pollsDTO.setAccess(1);
            }else {
                pollsDTO.setAccess(0);
            }

            List<VoteListDTO> voteListDTOS = new ArrayList<>();
            List<VoteModel> voteModels = voteRepository.findAllByQuestionModelsAndStatus(questionModels.get(i),1);
            int totalCount = 0;
            for (int t=0;t<voteModels.size();t++){
                totalCount=totalCount+voteModels.get(t).getVotes();
            }


            for (int v = 0 ; v< voteModels.size();v++){
                VoteListDTO voteListDTO = new VoteListDTO();
                voteListDTO.setCid(voteModels.get(v).getId());
                if(totalCount==0){
                    voteListDTO.setPercentage(totalCount);

                }else {
                    voteListDTO.setPercentage((double)voteModels.get(v).getVotes()*(double)100/totalCount);

                }
                voteListDTO.setText(voteModels.get(v).getText());
                voteListDTO.setUserCount(voteModels.get(v).getVotes());


                voteListDTOS.add(voteListDTO);


            }

            voteListDTOS.sort(Comparator.comparingInt(VoteListDTO::getCid));


            pollsDTO.setVotes(voteListDTOS);



            pollsDTOS.add(pollsDTO);






        }







        return pollsDTOS;
    }




    @Override
    public List<PollsDTO> getPollsDataForAdmin() {
        List<PollsDTO> pollsDTOS = new ArrayList<>();

        List<QuestionModel> questionModels = questionsRepository.findAll();


        for(int i = 0 ;i<questionModels.size();i++){
            PollsDTO pollsDTO = new PollsDTO();
            pollsDTO.setqId(questionModels.get(i).getId());
            pollsDTO.setDescription(questionModels.get(i).getDescription());
            pollsDTO.setLink(questionModels.get(i).getLink());
            pollsDTO.setTitle(questionModels.get(i).getTitle());


            List<VoteListDTO> voteListDTOS = new ArrayList<>();
            List<VoteModel> voteModels = voteRepository.findAllByQuestionModels(questionModels.get(i));
            int totalCount = 0;
            for (int t=0;t<voteModels.size();t++){
                totalCount=totalCount+voteModels.get(t).getVotes();
            }


            for (int v = 0 ; v < voteModels.size();v++){
                VoteListDTO voteListDTO = new VoteListDTO();
                voteListDTO.setCid(voteModels.get(v).getId());
                if(totalCount==0){
                    voteListDTO.setPercentage(totalCount);

                }else {
                    voteListDTO.setPercentage((double)voteModels.get(v).getVotes()*(double)100/totalCount);

                }
                voteListDTO.setText(voteModels.get(v).getText());
                voteListDTO.setUserCount(voteModels.get(v).getVotes());


                voteListDTOS.add(voteListDTO);


            }


            voteListDTOS.sort(Comparator.comparingInt(VoteListDTO::getCid));



            pollsDTO.setVotes(voteListDTOS);



            pollsDTOS.add(pollsDTO);






        }







        return pollsDTOS;
    }



    @Override
    public void edit(PollEditDTO pollEditDTO){
        QuestionModel questionModel = questionsRepository.findById(pollEditDTO.getId()).get();
        questionModel.setTitle(pollEditDTO.getTitle());
        questionModel.setLink(pollEditDTO.getLink());
        questionModel.setDescription(pollEditDTO.getDescription());
        List<VoteEditDTO> voteEditDTOS = pollEditDTO.getVotes();

        for (int i = 0 ; i <voteEditDTOS.size();i++ ){
            VoteModel voteModel = voteRepository.findById(voteEditDTOS.get(i).getCid()).get();
            voteModel.setVotes(voteModel.getVotes());
            voteModel.setQuestionModels(questionModel);
            voteModel.setText(voteEditDTOS.get(i).getText());
            voteModel.setStatus(voteModel.getStatus());
            voteRepository.save(voteModel);


        }

        questionModel.setStatus(questionModel.getStatus());

        questionsRepository.save(questionModel);



    }

    @Override
    public void delete(int id) {
        QuestionModel questionModel = questionsRepository.findById(id).get();

        List<VoteModel> voteModels = voteRepository.findAllByQuestionModels(questionModel);

        List<VoteUserModel> voteUserModels = voteUserRepository.findAllByQuestionModels(questionModel);


        for(int vMU = 0 ; vMU<voteUserModels.size();vMU++){

            voteUserRepository.delete(voteUserModels.get(vMU));


        }

        for(int vM = 0 ; vM<voteModels.size();vM++){

            voteRepository.delete(voteModels.get(vM));


        }

        questionsRepository.delete(questionModel);





    }

    @Override
    public void status(int id) {
        QuestionModel questionModel = questionsRepository.findById(id).get();

        List<VoteModel> voteModels = voteRepository.findAllByQuestionModels(questionModel);




        for(int vM = 0 ; vM<voteModels.size();vM++){
            VoteModel voteModel = voteModels.get(vM);
            voteModel.setStatus(voteModel.getStatus() == 0 ? 1 : 0);
            voteRepository.save(voteModels.get(vM));


        }

        questionModel.setStatus(questionModel.getStatus() == 0 ? 1 : 0 );
        questionsRepository.save(questionModel);



    }


}
