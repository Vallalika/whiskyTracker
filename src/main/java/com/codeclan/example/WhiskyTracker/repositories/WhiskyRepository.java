package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    @Query("select w from Whisky w where w.year = ?1")
    List<Whisky> findByYear(int year);

    @Query("select w from Whisky w where w.distillery.id = ?1 and w.age = ?2")
    List<Whisky> findByDistillery_IdAndAge(Long id, int age);

    @Query("select w from Whisky w where w.distillery.region = ?1")
    List<Whisky> findByDistillery_Region(String region);



}
