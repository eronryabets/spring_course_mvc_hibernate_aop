package com.eronryabets.spring.mvc_hibernate_aop.dao;

import com.eronryabets.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;

    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = getEmployee(id);
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);

    }

}


/*
   public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
                List<Employee> allEmployees = session.createQuery(
                "from Employee", Employee.class).getResultList();
        return allEmployees;
    }

    ===============================
       @Override
    public void deleteEmployee(int id) {
        System.out.println("EmployeeDAOImpl++++++++ deleteEmployee");
        System.out.println("Id удаляемого работнка = " +  id);
        Employee employee = getEmployee(id);
        System.out.println("NAME +++++++++ " + employee.getName());
        Session session = sessionFactory.getCurrentSession();
        session.delete(employee);
        System.out.println("Сотрудник удален");
    }
 */