package com.project.robotmate.domain.entity;

import com.project.robotmate.core.types.UserType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_ADMIN")
public class Admin extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id", length = 20)
    private String adminId;

    @Column(name = "admin_pwd", length = 500)
    private String password;

    @Column(name = "nm", length = 100)
    private String name;
}
