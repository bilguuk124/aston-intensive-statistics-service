package com.aston.statisticsservice.controller;

import com.aston.statisticsservice.entity.FoodDto;
import com.aston.statisticsservice.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stat")
@AllArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;
    private final static int PAGE_DEFAULT = 0;
    private final static int PAGE_SIZE_DEFAULT = 5;

    @GetMapping("/user/{id}/history")
    public ResponseEntity<?> getUserHistory(@PathVariable("id") Long id,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        if (page == null) page = PAGE_DEFAULT;
        if (pageSize == null) pageSize = PAGE_SIZE_DEFAULT;
        List<FoodDto> userHistory = statisticsService.getUserHistory(id, page, pageSize);
        return ResponseEntity.ok(userHistory);
    }

    @GetMapping("/top/week")
    public ResponseEntity<?> getWeeklyTopFood(){
        List<FoodDto> weeklyTop = statisticsService.getWeeklyTopFood();
        return ResponseEntity.ok(weeklyTop);
    }

    @GetMapping("/top/month")
    public ResponseEntity<?> getMonthlyTopFood(){
        List<FoodDto> monthlyTop = statisticsService.getMonthlyTopFood();
        return ResponseEntity.ok(monthlyTop);
    }
}
