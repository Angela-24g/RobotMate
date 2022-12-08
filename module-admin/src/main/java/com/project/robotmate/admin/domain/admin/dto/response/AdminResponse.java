package com.project.robotmate.admin.domain.admin.dto.response;

import com.project.robotmate.domain.entity.Admin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminResponse {
    private Long id;
    private String adminId;
    private String name;

    public AdminResponse(Admin admin) {
        this.id = admin.getId();
        this.adminId = admin.getAdminId();
        this.name = admin.getName();
    }
}
