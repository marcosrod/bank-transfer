package com.banktransfer.userapi.modules.user.enums;

public enum UserError {

    NO_VALID_DOCUMENT("The user must have a valid cpf or cnpj."),
    DUPLICATED_CPF("The cpf is already registered."),
    DUPLICATED_CNPJ("The cnpj is already registered."),
    DUPLICATED_EMAIL("The email is already registered.");

    private String errorMessage;

    UserError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
