package cg.example.User.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.example.User.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
