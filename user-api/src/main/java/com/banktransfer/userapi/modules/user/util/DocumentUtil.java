package com.banktransfer.userapi.modules.user.util;

public class DocumentUtil {

    public static boolean validateCpfDigits(String cpf) {
        return cpf.matches("^(((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))?((\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2}))?)*$");
    }

    public static boolean validateCnpjDigits(String cnpj) {
        return cnpj.matches("(^\\d{3}.?\\d{3}.?\\d{3}-?\\d{2})|(^\\d{2}.?\\d{3}.?\\d{3}/?\\d{4}-?\\d{2})");
    }
}
