
package com.example.emp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.emp.entity.Emp;
import com.example.emp.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo repo;

    public List<Emp> getAll() { 
		return repo.findAll();
 }

    public Emp getById(int id) { 
		return repo.findById(id).orElse(null);
 }

    public void save(Emp e) { 
		repo.save(e); 
}

    public void delete(int id) {
		 repo.deleteById(id);
 }
}
