package com.aston.statisticsservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "statistics")
@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
public class FoodStat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_stat_gen")
    @SequenceGenerator(name = "food_stat_gen", sequenceName = "food_stat_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private Long user_id;
    private Long food_id;
    private Integer number;
    private LocalDate boughtDate;
}
