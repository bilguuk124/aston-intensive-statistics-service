package com.aston.statisticsservice.repository;

import com.aston.statisticsservice.entity.FoodStat;
import com.aston.statisticsservice.entity.TopFoodDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<FoodStat, Long> {
    List<FoodStat> findByUser_id(Long user_id, Pageable pageable);

    @Query("SELECT e.food_id, SUM(e.number) as sumOfNumbers " +
            "FROM FoodStat e WHERE e.boughtDate >= : startDate GROUP BY e.food_id ORDER BY sumOfNumbers DESC")
    List<TopFoodDto> findWeeklyTopFood(@Param("startDate")LocalDateTime startDate);

}
