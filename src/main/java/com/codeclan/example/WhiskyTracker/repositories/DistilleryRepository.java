package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
    @Query("select d from Distillery d where d.region = ?1")
    List<Distillery> findByRegion(String region);

    @Query("select d from Distillery d inner join d.whiskies whiskies where whiskies.age = ?1")
    List<Distillery> findByWhiskies_Age(int age);

}
