package com.banktransfer.userapi.modules.user.util;

import com.banktransfer.userapi.modules.user.helper.UserHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentUtilTest {

    @Test
    void validateCpfDigits_shouldReturnTrue_whenValidCpf() {
        assertTrue(DocumentUtil.validateCpfDigits(UserHelper.oneCpfUser().getCpf()));
    }

    @Test
    void validateCpfDigits_shouldReturnFalse_whenInvalidCpf() {
        assertFalse(DocumentUtil.validateCpfDigits(UserHelper.oneCpfUser().getCpf().substring(0, 5)));
    }

    @Test
    void validateCpfDigits_shouldReturnTrue_whenValidCnpj() {
        assertTrue(DocumentUtil.validateCnpjDigits(UserHelper.oneCnpjUser().getCnpj()));
    }

    @Test
    void validateCpfDigits_shouldReturnFalse_whenInvalidCnpj() {
        assertFalse(DocumentUtil.validateCnpjDigits(UserHelper.oneCnpjUser().getCnpj().substring(0, 5)));
    }
}
