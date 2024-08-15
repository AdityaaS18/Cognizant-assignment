package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmployeeBatchService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();

        int batchSize = 50;
        int count = 0;

        for (Employee employee : employees) {
            session.save(employee);
            count++;

            if (count % batchSize == 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
    }
}
