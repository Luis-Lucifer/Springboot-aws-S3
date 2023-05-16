package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="employee")
public class Employee {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="emp_name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phoneNo")
    private String phoneNo;
    @Column(name="department")
    private String department;
    @Column(name="resumeLink")
    private String resumeLink;

//    public String getResumeLink() {
//        return resumeLink;
//    }
//
//    public void setResumeLink(String resumeLink) {
//        this.resumeLink = resumeLink;
//    }

}
