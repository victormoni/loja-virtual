package com.victormoni.ecommerce.dto.request;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Victor Moni
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @Schema(example = "fulano", description = "Nome de usuário")
    @NotBlank
    private String username;

    @Schema(example = "1234", description = "Senha do usuário")
    @NotBlank
    private String password;
}
