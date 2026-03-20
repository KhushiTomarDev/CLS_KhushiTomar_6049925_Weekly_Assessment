package com.example.Assessment2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assessment2.entity.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
	List<Track> findByTitle(String title);
}

