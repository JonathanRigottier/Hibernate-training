package model;

import javax.persistence.*;

@Entity
public class EmployeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeProjectId")
    private int employeeProjectId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public int getEmployeeProjectId() {
        return employeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        this.employeeProjectId = employeeProjectId;
    }
}
