package com.trabalho.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequestDto {

    @Size(min = 2, max = 50, message = "campo usuario precisa ter mais de 2 caracteres e menos de 50 caracteres")
    @NotBlank(message = "campo usuario é obrigatório!")
    private String usuario;
    @Size(min = 2, max = 50, message = "campo senha precisa ter mais de 2 caracteres e menos de 50 caracteres")
    @NotBlank(message = "campo senha é obrigatório!")
    private String senha;

    public UsuarioRequestDto(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
