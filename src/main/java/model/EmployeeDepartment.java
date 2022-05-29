package model;

public class EmployeeDepartment {

    private int employeeId;
    private String firstName;
    private int salary;
    private String departmentName;

    public EmployeeDepartment(int employeeId, String firstName, int salary, String departmentName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.salary = salary;
        this.departmentName = departmentName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
