package com.liuchen.models.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Package: com.liuchen.models
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 12:37 PM
 * @Version: v1.0
 */

@Data
@MappedSuperclass
public class DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_modified")
    private Date lastModified;

    @Column(name = "last_modifiedBy")
    private String lastModifiedBy;
}
