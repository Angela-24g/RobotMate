package com.project.robotmate.admin.domain.common.home.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    private String adminId;
    private String password;
}
