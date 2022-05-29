package main;

import model.Employee;
import model.EmployeeDepartment;
import persistence.RepositoryEmployee;

import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setFirstName("Marek");
        employee1.setLastName("surname");
        employee1.setPhoneNumber("3333-5555");
        employee1.setSalary(5700);
        employee1.setDateOfBirth("1968-10-01");
        employee1.setEmail("mareck@gmail.com");
        //employee1.setEmployeeId(2);

        RepositoryEmployee repositoryEmployee = new RepositoryEmployee();
        //repositoryEmployee.saveEmployee(employee1);
        //repositoryEmployee.updateEmployee(employee1);
        //repositoryEmployee.updateEmployeeSalary(1,1000000);
        //repositoryEmployee.deleteEmployee(employee1);
        /*List<Employee> list = repositoryEmployee.listAllEmployees();
        for (Employee emp:list) {
            System.out.println(emp.toString());
        }*/

        //Employee employee = repositoryEmployee.findEmployeeById(3);
        //System.out.println(employee.toString());

        //Employee employee2 = repositoryEmployee.findEmployeeByIdUsingQuery(1);
        //System.out.println(employee2.toString());

        /*List <Employee> list = repositoryEmployee.findEmployeeByDepartmentName("HR");
        for (Employee emp : list){
            System.out.println(emp.toString());
        }*/

        List<EmployeeDepartment> list = repositoryEmployee.listEmployeeWithDepartmentName();
        for (EmployeeDepartment emp:list) {
            System.out.println(emp.toString());
        }
    }
}
