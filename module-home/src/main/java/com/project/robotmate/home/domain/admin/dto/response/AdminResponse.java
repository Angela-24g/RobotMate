package com.project.robotmate.home.domain.admin.dto.response;

import com.project.robotmate.domain.entity.Admin;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
