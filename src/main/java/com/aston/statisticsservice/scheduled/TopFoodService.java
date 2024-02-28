package com.aston.statisticsservice.scheduled;

import com.aston.statisticsservice.entity.TopFoodDto;
import com.aston.statisticsservice.repository.StatisticsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopFoodService {
    private final StatisticsRepository repository;
    @Getter
    private List<TopFoodDto> weeklyTopFood;
    @Getter
    private List<TopFoodDto> monthlyTopFood;


    @Scheduled(cron = "0 8 * * *", initialDelay = 0)
    private void updateWeeklyTopFood(){
        LocalDateTime sevenDays = LocalDateTime.now().minusDays(7);
        weeklyTopFood = repository.findWeeklyTopFood(sevenDays);
    }

    @Scheduled(cron = "0 8 * * *", initialDelay = 0)
    private void updateMonthlyTopFood(){
        LocalDateTime month = LocalDateTime.now().minusDays(30);
        monthlyTopFood = repository.findWeeklyTopFood(month);
    }

}
