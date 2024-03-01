package com.aston.statisticsservice.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonRootName("statistic")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDto {
    private Long userId;
    private Long foodId;
    private Integer number;
    private LocalDate boughtDate;
}
