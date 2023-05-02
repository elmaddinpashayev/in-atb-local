package atb.social.network.service.HistoryService;

import atb.social.network.dto.EmployeePositionChangesDto;
import atb.social.network.model.EmployeeEditHistory;
import atb.social.network.model.EmployeeModel;
import atb.social.network.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private EmployeeEditHistoryRepository employeeEditHistoryRepository;


    @Autowired
    private BankBranchRepository bankBranchRepository;

    @Autowired
    private BankDepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;



    @Override
    public List<EmployeePositionChangesDto> getDetails() throws Exception {
        List<EmployeePositionChangesDto> employeePositionChangesDtos=new ArrayList<>();
//        try{
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String date = simpleDateFormat.format(new Date());
            String result = date.substring(5);
            result = result.replaceAll("-", "");
            List<EmployeeEditHistory> employeeEditHistories = employeeEditHistoryRepository.findAllByDateWithoutYear(result);

            for(int i=0;i<employeeEditHistories.size();i++){
                EmployeePositionChangesDto employeePositionChangesDto = new EmployeePositionChangesDto();
                EmployeeModel employeeModel = employeeRepository.findById(employeeEditHistories.get(i).getEmployeeId());
                employeePositionChangesDto.setName(employeeModel.getName());
                employeePositionChangesDto.setSurname(employeeModel.getSurname());
                if(employeeEditHistories.get(i).getfPosition()!=0) {
                    employeePositionChangesDto.setfPosition(positionRepository.findById(employeeEditHistories.get(i).getfPosition()).get().getPositionName());
                }
                if(employeeEditHistories.get(i).getlPosition()!=0) {
                    employeePositionChangesDto.setlPosition(positionRepository.findById(employeeEditHistories.get(i).getlPosition()).get().getPositionName());
                }
                if(employeeEditHistories.get(i).getfBranch()!=0) {

                    employeePositionChangesDto.setfBranch(bankBranchRepository.findById(employeeEditHistories.get(i).getfBranch()).get().getBranchName());
                }
                if(employeeEditHistories.get(i).getlBranch()!=0) {

                    employeePositionChangesDto.setlBranch(bankBranchRepository.findById(employeeEditHistories.get(i).getlBranch()).get().getBranchName());
                }
                if(employeeEditHistories.get(i).getfDepartment()!=0) {

                    employeePositionChangesDto.setfDepartment(departmentRepository.findById(employeeEditHistories.get(i).getfDepartment()).get().getDepartmentName());
                }
                if(employeeEditHistories.get(i).getlDepartment()!=0) {

                    employeePositionChangesDto.setlDepartment(departmentRepository.findById(employeeEditHistories.get(i).getlDepartment()).get().getDepartmentName());
                }
                employeePositionChangesDto.setPhoto(employeeModel.getPhotosImagePath());
                employeePositionChangesDto.setEmpId(employeeModel.getId());
                employeePositionChangesDto.setInternalNumber(employeeModel.getInternalNumber());
                employeePositionChangesDto.setStatus(employeeEditHistories.get(i).getStatus());
                employeePositionChangesDtos.add(employeePositionChangesDto);
            }
//        }catch (Exception e){
//            throw  new Exception(e.getMessage());
//        }
        return employeePositionChangesDtos;
    }
}
