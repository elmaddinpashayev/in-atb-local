package atb.social.network.service.PollService;

import atb.social.network.dto.PollEditDTO;
import atb.social.network.dto.PollSaveRequest;
import atb.social.network.dto.PollsDTO;

import java.util.List;

public interface PollService {

void save(PollSaveRequest pollSaveRequest);

int voteThePool(String userIp, int qid, int cid);

List<PollsDTO> getPollsData(String userIp);
    List<PollsDTO> getPollsDataForAdmin();


void edit(PollEditDTO pollEditDTO);

    void delete(int id);

    void status(int id);



}
