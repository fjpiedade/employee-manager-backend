package phi.raiztech.employeemanager.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    void deleteEmployeeById(Long id);

    Optional<EmployeeModel> findEmployeeById(Long id);
}
