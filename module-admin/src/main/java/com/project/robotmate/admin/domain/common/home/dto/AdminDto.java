package com.project.robotmate.admin.domain.common.home.dto;

import com.project.robotmate.domain.entity.admin.Admin;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AdminDto {
    private Long id;
    private String userId;

    public AdminDto(Admin admin) {
        this.id = admin.getId();
        this.userId = admin.getAdminId();
    }
}
