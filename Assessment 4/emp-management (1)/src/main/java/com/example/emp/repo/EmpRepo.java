
package com.example.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.emp.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer> {}
