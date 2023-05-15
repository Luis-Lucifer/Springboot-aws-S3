package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

    private int id;
    private String name;
    private String email;
    private String phoneNo;
    private String department;
    private String resumeLink;

//    public String getResumeLink() {
//        return resumeLink;
//    }
//
//    public void setResumeLink(String resumeLink) {
//        this.resumeLink = resumeLink;
//    }

}
