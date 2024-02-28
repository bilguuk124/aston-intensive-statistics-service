package com.aston.statisticsservice.controller;

import com.aston.statisticsservice.entity.FoodStat;
import com.aston.statisticsservice.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaController {
    private final StatisticsService service;

    @KafkaListener(topics = "statisticTopic", groupId = "statistics")
    public void getNewStatistic(FoodStat foodStat){
        service.addNewStatistic(foodStat);
    }
}
