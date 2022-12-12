package cl.demo.user.domain.dto;

import cl.demo.user.domain.validation.ValidEmail;
import cl.demo.user.domain.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Size(min = 3, message = "{size.name}")
    @NotNull
    private String name;

    @ValidEmail(message = "{validate.email}")
    @NotNull
    private String email;

    @ValidPassword(message = "{validate.password}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;

    private String id;
    private Instant createdAt;
    private Instant modifiedAt;
    private Instant lastLogin;
    private String token;
    private Boolean isActive;

    private List<UserPhoneDto> phones;
}