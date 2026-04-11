package cg.example.User.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.example.User.Repo.UserRepository;
import cg.example.User.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User getUser(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}