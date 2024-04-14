package com.project.robotmate.domain.entity.gallery;

import com.project.robotmate.core.types.GalleryType;
import com.project.robotmate.domain.entity.admin.Admin;
import com.project.robotmate.domain.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "RM_GALLERY")
@ToString(of = {"id", "title", "contents", "delYn", "type"})
public class Gallery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String title;

    private String contents;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "gall_type")
    @Enumerated(EnumType.STRING)
    private GalleryType type;

    @Column(name = "gall_year")
    private String year;

    @Column(name = "ord")
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Admin admin;

    @Builder
    public Gallery(Long id, String title, String contents, String delYn, GalleryType type, String year, Admin admin) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.delYn = delYn != null ? delYn : "N";
        this.type = type;
        this.year = year;
        this.admin = admin;
    }

    public void changeGallery(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void changeYear(String year) {
        this.year = year;
    }

    public void changeType(GalleryType type) {
        this.type = type;
    }

    public void remove() {
        this.delYn = "Y";
    }

    public void changeOrder(int order) {
        this.order = order;
    }
}
