package com.project.robotmate.domain.entity.price;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_PRICE")
@EntityListeners(AuditingEntityListener.class)
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teaching_course")
    private String teachingCourse;

    @Column(name = "teaching_expenses")
    private String teachingExpenses;

    @Column(name = "teaching_hour")
    private String teachingHour;

    @Column(name = "collection_unit")
    private String collectionUnit;

    @Column(name = "mock_test_cost")
    private String mockTestCost;

    @Column(name = "material_cost")
    private String materialCost;

    @Column(name = "clothes_cost")
    private String clothesCost;

    @Column(name = "lunch_money")
    private String lunchMoney;

    @Column(name = "boarding_expenses")
    private String boardingExpenses;

    @Column(name = "car_cost")
    private String carCost;

    private String type;

    @LastModifiedBy
    @Column(name = "mod_dt")
    private LocalDateTime modDate;

    @Builder
    public Price(Long id, String teachingCourse, String teachingExpenses, String teachingHour, String collectionUnit, String mockTestCost, String materialCost, String clothesCost, String lunchMoney, String boardingExpenses, String carCost, String type) {
        this.id = id;
        this.teachingCourse = teachingCourse;
        this.teachingExpenses = teachingExpenses;
        this.teachingHour = teachingHour;
        this.collectionUnit = collectionUnit;
        this.mockTestCost = mockTestCost;
        this.materialCost = materialCost;
        this.clothesCost = clothesCost;
        this.lunchMoney = lunchMoney;
        this.boardingExpenses = boardingExpenses;
        this.carCost = carCost;
        this.type = type;
    }

    public void changeTeachingCourse(String teachingCourse) {
        this.teachingCourse = teachingCourse;
    }

    public void changeTeachingExpenses(String teachingExpenses) {
        this.teachingExpenses = teachingExpenses;
    }

    public void changeTeachingHour(String teachingHour) {
        this.teachingHour = teachingHour;
    }

    public void changeCollectionUnit(String collectionUnit) {
        this.collectionUnit = collectionUnit;
    }

    public void changeCost(String mockTestCost, String materialCost, String clothesCost, String lunchMoney, String boardingExpenses, String carCost) {
        this.mockTestCost = mockTestCost;
        this.materialCost = materialCost;
        this.clothesCost = clothesCost;
        this.lunchMoney = lunchMoney;
        this.boardingExpenses = boardingExpenses;
        this.carCost = carCost;
    }

    public void changeType(String type) {
        this.type = type;
    }
}
