package atb.social.network.service.QuoteService;

import atb.social.network.dto.CounterDTO;
import atb.social.network.dto.QuoteDTO;
import atb.social.network.model.QuoteModel;

public interface QuoteService {

    QuoteModel getQuote() throws Exception;

    void save (QuoteDTO quoteDTO) throws Exception;

    void saveIp(String ip);

    void saveGuestIp(String ip, String empId);

    CounterDTO getUniqueIp();
}
