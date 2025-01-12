package com.project.robotmate.domain.entity.price;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_PRICE")
@EntityListeners(AuditingEntityListener.class)
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target")
    private String target;

    @Column(name = "contents")
    private String contents;

    @Column(name = "w1")
    private Integer w1;

    @Column(name = "w2")
    private Integer w2;

    @Column(name = "w3")
    private Integer w3;

    @Column(name = "ordr")
    private Integer ordr;

    @Builder
    public Price(Long id, String target, String contents, Integer w1, Integer w2, Integer w3, Integer ordr) {
        this.id = id;
        this.target = target;
        this.contents = contents;
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.ordr = ordr;
    }

    public void changeTarget(String target) {
        this.target = target;
    }

    public void changeContents(String contents) {
        this.contents = contents;
    }

    public void changeW1(Integer w1) {
        this.w1 = w1;
    }

    public void changeW2(Integer w2) {
        this.w2 = w2;
    }

    public void changeW3(Integer w3) {
        this.w3 = w3;
    }

    public void changeOrdr(Integer ordr) { this.ordr = ordr; }

    public void changeCost( Integer w1, Integer w2, Integer w3, Integer ordr) {

        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.ordr = ordr;

    }

    public void reoreder(int ordr) {
        this.ordr = ordr;
    }
}
