package com.aston.statisticsservice.controller;

import com.aston.statisticsservice.entity.FoodDto;
import com.aston.statisticsservice.service.StatisticsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stat")
@AllArgsConstructor
@Slf4j
public class StatisticsController {

    private final StatisticsService statisticsService;
    private final static int PAGE_DEFAULT = 0;
    private final static int PAGE_SIZE_DEFAULT = 5;

    // Endpoint for MenuService
    @GetMapping("/user/{id}/history")
    public ResponseEntity<?> getUserHistory(@PathVariable("id") Long id,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        log.info("Got request to get user order history!");
        if (page == null) page = PAGE_DEFAULT;
        if (pageSize == null) pageSize = PAGE_SIZE_DEFAULT;
        List<FoodDto> userHistory = statisticsService.getUserHistory(id, page, pageSize);
        return ResponseEntity.ok(userHistory);
    }

    // Endpoint for MenuService
    @GetMapping("/top/week")
    public ResponseEntity<?> getWeeklyTopFood(){
        log.info("Got request to get weekly top food");
        List<FoodDto> weeklyTop = statisticsService.getWeeklyTopFood();
        return ResponseEntity.ok(weeklyTop);
    }

    // Endpoint for MenuService
    @GetMapping("/top/month")
    public ResponseEntity<?> getMonthlyTopFood(){
        log.info("Got request to get monthly top food");
        List<FoodDto> monthlyTop = statisticsService.getMonthlyTopFood();
        return ResponseEntity.ok(monthlyTop);
    }
}
