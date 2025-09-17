package com.project.robotmate.domain.entity.admin;

import com.project.robotmate.domain.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_ADMIN")
@ToString(of = {"id", "adminId", "name"})
public class Admin extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id", length = 20)
    private String adminId;

    @Column(name = "admin_pwd", length = 500)
    private String password;

    @Column(name = "nm", length = 100)
    private String name;

    @Builder
    public Admin(Long id, String adminId, String password, String name) {
        this.id = id;
        this.adminId = adminId;
        this.password = password;
        this.name = name;
    }

    public boolean isSame(Long id) {
        return this.id.equals(id);
    }

    public void changePassword(String password ) {
        this.password = password;
    }
}
