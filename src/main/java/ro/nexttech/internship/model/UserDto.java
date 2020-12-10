package ro.nexttech.internship.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String userRole;

}
