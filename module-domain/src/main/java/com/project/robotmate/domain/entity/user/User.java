package com.project.robotmate.domain.entity.user;

import com.project.robotmate.core.types.UserType;
import com.project.robotmate.domain.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_USER")
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 20)
    private String userId;

    @Column(name = "user_pwd", length = 500)
    private String password;

    @Column(name = "user_nm", length = 100)
    private String name;

    @Column(name = "user_type", length = 50)
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name = "hp_no", length = 500)
    private String phoneNumber;

    @Column(name = "user_email", length = 500)
    private String email;

    @Column(name = "user_birth_dt")
    private LocalDate birthday;

    @Column(name = "use_yn", length = 1)
    private String useYn = "Y";

    @Column(name = "sms_recv_yn", length = 1)
    private String smsReceiveYn;

    @Column(name = "user_pwd_fail_cnt")
    private int passwordFailCount;

    @Column(name = "user_pwd_upd_dt")
    private LocalDateTime passwordUpdateDate;
}
