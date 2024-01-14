package com.software.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.software.domain.BaseEntity;

@Entity
@Table(name = "PROJECT")
public class Project extends BaseEntity {

    private static final long serialVersionUID = 5184401011800440857L;

    @Column(name = "NAME", nullable = false, length = 512)
    private String name;

    public Project() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameArg) {
        this.name = nameArg;
    }

}
