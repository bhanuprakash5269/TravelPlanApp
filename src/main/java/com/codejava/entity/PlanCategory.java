package com.codejava.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCategory {

    @Id
    @SequenceGenerator(name="gen1",sequenceName = "category_seq",initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
    @Column(name="CATEGORY_ID")
    private Integer categoryId;
    @Column(name="CATEGORY_NAME",length = 30)
    private String categoryName;
    @Column(name="ACTIVE_SW",length = 15)
    private String activeSW;
    @Column(name="CREATED_DATE",updatable = false)
    private LocalDateTime createdDate;
    @Column(name="UPDATED_DATE",updatable = true,insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @Column(name="UPDATED_BY",length = 20)
    private String updatedBy;

    @Column(name="CREATED_BY",length = 20)
    private String createdBy;


}
