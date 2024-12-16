package com.du.gsfw.model.dto.request;

import com.du.gsfw.annotation.IsEmailExist;
import com.du.gsfw.annotation.IsPhone;
import com.du.gsfw.annotation.IsPhoneExist;
import com.du.gsfw.annotation.PasswordEqual;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@PasswordEqual
public class DemoUserAddRequestDTO {

    @NotBlank(message = "userName is not empty")
    @Schema(name = "userName", description = "user name", example = "")
    private String userName;

    @NotBlank(message = "password is not empty")
    @Schema(name = "password", description = "password", example = "")
    private String password;

    @NotBlank(message = "confirm password is not empty")
    @Schema(name = "confirmPassword", description = "confirm password", example = "")
    private String confirmPassword;

    @NotBlank(message = "email is not empty")
    @Email(message = "this email format is incorrect")
    @IsEmailExist
    @Schema(name = "email", description = "email", example = "")
    private String email;


    @NotBlank(message = "mobile is not empty")
    @IsPhone
    @IsPhoneExist
    @Schema(name = "mobile", description = "mobile", example = "")
    private String mobile;
}
