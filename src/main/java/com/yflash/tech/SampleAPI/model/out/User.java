package com.yflash.tech.SampleAPI.model.out;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class User extends RepresentationModel<User> {

    Integer id;
    String firstName;
    String lastName;

}
