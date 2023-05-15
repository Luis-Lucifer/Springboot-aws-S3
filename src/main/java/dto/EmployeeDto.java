package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

    private String name;
    private String email;
    private String phoneNo;
    private String department;
    private MultipartFile resume;
//
//    public MultipartFile getResume() {
//        return resume;
//    }
//
//    public void setResume(MultipartFile resume) {
//        this.resume = resume;
//    }

}
