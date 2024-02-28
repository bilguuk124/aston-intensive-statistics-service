package com.aston.statisticsservice.service;

import com.aston.statisticsservice.entity.FoodDto;
import com.aston.statisticsservice.entity.FoodStat;

import java.util.List;

public interface StatisticsService {
    List<FoodDto> getUserHistory(Long id, Integer page, Integer pageSize);

    List<FoodDto> getWeeklyTopFood();

    List<FoodDto> getMonthlyTopFood();

    void addNewStatistic(FoodStat foodStat);
}
