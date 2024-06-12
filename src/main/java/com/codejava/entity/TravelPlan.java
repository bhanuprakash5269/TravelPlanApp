package com.codejava.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="TRAVEL_PLAN")
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PLAN_ID")
    private Integer planId;
    @Column(name="PLAN_NAME",length = 30)
    private String planName;
    @Column(name="PLAN_MIN_BUDGET")
    private Double planMinBudget;

    @Column(name="PLAN_Description",length = 50)
    private String planDescription;

    @Column(name="PLAN_CATEGORY_ID")
    private Integer planCategoryId;

    @Column(name="ACTIVE_SW",length = 20)
    private String activeSW="active";
    @Column(name="CREATED_DATE",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name="UPDATED_DATE",updatable = true,insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @Column(name="UPDATED_BY",length = 20)
    private String updatedBy;

    @Column(name="CREATED_BY",length = 20)
    private String createdBy;
}