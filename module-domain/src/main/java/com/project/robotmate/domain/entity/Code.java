package com.project.robotmate.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="RM_CODE")
public class Code {
    @Id
    @Column(name = "code_cd")
    private String code;

    @Column(name = "code_nm")
    private String name;

    @Column(name = "code_desc")
    private String description;

    @Column(name = "use_yn")
    private String useYn;
}
