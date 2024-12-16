package com.du.gsfw.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DemoUserResponseDTO {

    private Long id;

    @NotBlank(message = "userName is not empty")
    @Schema(name = "userName", description = "user name", example = "")
    private String userName;


    @Schema(name = "email", description = "email", example = "")
    private String email;


    @Schema(name = "mobile", description = "mobile", example = "")
    private String mobile;
}
