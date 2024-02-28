package com.aston.statisticsservice.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TopFoodDto {
    private int foodId;
    private int numberOfPurchases;
}
