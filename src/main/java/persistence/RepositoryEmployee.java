package persistence;

import javassist.bytecode.ExceptionsAttribute;
import model.Employee;
import model.EmployeeDepartment;
import util.DbUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryEmployee {

    private EntityManager entityManager;

    public RepositoryEmployee() {
        this.entityManager = DbUtil.getEntityManager();
    }

    public void saveEmployee(Employee employee) {  //dml
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(employee);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
    }

    public void updateEmployee (Employee employee) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(employee);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }

    }

    public void updateEmployeeSalary (int employeeId, int newSalary) {
        try {
            this.entityManager.getTransaction().begin();
            String sql = "UPDATE Employee SET salary = :nSalary WHERE employeeId = :id ";
            entityManager.createQuery(sql)
                    .setParameter("id", employeeId)
                    .setParameter("nSalary", newSalary)
                    .executeUpdate();
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }


    }

    public void deleteEmployee (Employee employee) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entityManager.merge(employee));
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public void deleteEmployeeUsingQuery(int employeeId) {

    }

    public List<Employee> listAllEmployees(){
        return this.entityManager
                .createQuery("FROM Employee", Employee.class)
                .getResultList();
    }

    public Employee findEmployeeByIdUsingQuery (int employeeId) {
        return this.entityManager.find(Employee.class, employeeId);
    }

    public Employee findEmployeeById (int employeeId) {
        String sql = "FROM Employee WHERE employeeId = :id";
        return this.entityManager.createQuery(sql, Employee.class)
                .setParameter("id", employeeId)
                .getSingleResult();
    }

    public List<Employee> findEmployeeByDepartmentName(String departmentName) {
        String sql = "FROM Employee e WHERE e.department.name = : deptName";
        return this.entityManager.createQuery(sql, Employee.class)
                .setParameter("deptName", departmentName)
                .getResultList();
    }

    public List<EmployeeDepartment> listEmployeeWithDepartmentName (){
        String sql = "SELECT new model.EmployeeDepartment(e.employeeId, e.firstName, e.salary, d.name) " +
                "FROM Employee e JOIN e.department d";

        String sql2 = "SELECT new model.EmployeeDepartment(e.employeeId, e.firstName, e.salary, e.department.name) " +
                "FROM Employee e";
        return this.entityManager.createQuery(sql, EmployeeDepartment.class)
                .getResultList();
    }



}
