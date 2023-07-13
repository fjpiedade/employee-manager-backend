package phi.raiztech.employeemanager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        employeeModel.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public void deleteEmployeeV1(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    public void deleteEmployee(Long id){
        EmployeeModel employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found"));
        employeeRepository.delete(employee);
    }
    public EmployeeModel findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }
}
