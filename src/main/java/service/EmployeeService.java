package service;

import dto.EmployeeDto;
import entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EmployeeRepository;

import java.io.IOException;

public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private S3Service s3Service;

    public Employee createEmployee(EmployeeDto employeeDto) throws IOException {
        Employee employee = modelMapper.map(employeeDto, Employee.class);

        //Combine email with resume
        String fileName = employee.getEmail()+ "_" +employeeDto.getResume().getOriginalFilename();

        //store the resume in amazon S3 and get the link
        String resumeLink = null;
        try {
            resumeLink = S3Service.uploadResume(fileName, employeeDto.getResume());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        employee.setResumeLink(resumeLink);
        return employeeRepository.save(employee);
    }
}
