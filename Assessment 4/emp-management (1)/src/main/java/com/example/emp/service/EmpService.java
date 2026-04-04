
package com.example.emp.service;

import java.util.List;
import com.example.emp.entity.Emp;

public interface EmpService {
    List<Emp> getAll();
    Emp getById(int id);
    void save(Emp e);
    void delete(int id);
}
