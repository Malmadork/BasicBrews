package com.malmadork.BasicBrews.models.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is a model for a RequestBody received through the
 * APIUserController
 *
 * @author Marie Schwartz
 */
@Getter
@Setter
@NoArgsConstructor
public class UserContext {

    /** Field for the users email */
    //@JsonProperty(value = "email")
    String email;

    /** Field for the users password */
    //@JsonProperty (value = "password")
    String password;

}
