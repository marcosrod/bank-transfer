package com.banktransfer.userapi.modules.user.dto;

public record UserRequest(String name, String cpf, String cnpj, String email, String password) {
}
