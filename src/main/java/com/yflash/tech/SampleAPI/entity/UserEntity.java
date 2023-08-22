package com.yflash.tech.SampleAPI.entity;

import com.yflash.tech.SampleAPI.common.CommonConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "USER")
@Data
@ToString
public class UserEntity {

    @Id
    @Column(name = CommonConstants.USER_ID)
    private Integer id;

    @Column(name = CommonConstants.FIRST_NAME)
    private String firstName;

    @Column(name = CommonConstants.LAST_NAME)
    private String lastName;

}
