package com.aston.statisticsservice.service.impl;

import com.aston.statisticsservice.entity.FoodDto;
import com.aston.statisticsservice.entity.FoodStat;
import com.aston.statisticsservice.entity.StatisticDto;
import com.aston.statisticsservice.repository.StatisticsRepository;
import com.aston.statisticsservice.scheduled.TopFoodService;
import com.aston.statisticsservice.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository repository;
    private final TopFoodService topFoodBean;


    @Override
    public List<FoodDto> getUserHistory(Long id, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<FoodStat> stats = repository.findByUser_id(id, pageable);
        return stats.stream().map(e -> new FoodDto(e.getFoodId())).toList();
    }

    @Override
    public List<FoodDto> getWeeklyTopFood() {
        return topFoodBean.getWeeklyTopFood().stream().map(e -> new FoodDto((long) e.getFoodId())).limit(10).collect(Collectors.toList());
    }

    @Override
    public List<FoodDto> getMonthlyTopFood() {
        return topFoodBean.getMonthlyTopFood().stream().map(e -> new FoodDto((long) e.getFoodId())).limit(10).collect(Collectors.toList());
    }

    @Override
    public void addNewStatistic(StatisticDto dto){
        FoodStat foodStat = FoodStat.builder()
                        .foodId(dto.getFoodId())
                        .userId(dto.getUserId())
                        .number(dto.getNumber())
                        .boughtDate(dto.getBoughtDate())
                        .build();
        repository.save(foodStat);
    }
}
