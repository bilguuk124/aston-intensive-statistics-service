package com.aston.statisticsservice.controller;

import com.aston.statisticsservice.entity.StatisticDto;
import com.aston.statisticsservice.service.StatisticsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class KafkaController {
    private final StatisticsService service;

    // Listener from OrderService
    @KafkaListener(topics = "statisticTopic", groupId = "statistics")
    public void getNewStatistic(StatisticDto dto){
        log.info("Got a new kafka message");
        service.addNewStatistic(dto);
    }
}
