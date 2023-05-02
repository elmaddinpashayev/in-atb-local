package atb.social.network.service.HistoryService;

import atb.social.network.dto.EmployeePositionChangesDto;

import java.util.List;

public interface HistoryService {

    List<EmployeePositionChangesDto> getDetails() throws Exception;

}
