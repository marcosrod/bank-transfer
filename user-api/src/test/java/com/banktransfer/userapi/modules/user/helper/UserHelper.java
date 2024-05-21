package com.banktransfer.userapi.modules.user.helper;

import com.banktransfer.userapi.modules.user.dto.UserRequest;
import com.banktransfer.userapi.modules.user.dto.UserResponse;
import com.banktransfer.userapi.modules.user.model.User;

public class UserHelper {

    private static final String CPF = "144.523.214-12";
    private static final String CNPJ = "87.559.364/0001-94";
    private static final String TEST_NAME = "test";
    private static final String TEST_EMAIL = "test@gmail.com";

    public static UserResponse oneCpfUserResponse() {
        return new UserResponse(TEST_NAME, TEST_EMAIL,
                CPF, null);
    }

    public static UserResponse oneCnpjUserResponse() {
        return new UserResponse(TEST_NAME, TEST_EMAIL,
                null, CNPJ);
    }

    public static UserRequest oneCpfUserRequest() {
        return new UserRequest(TEST_NAME, CPF,
                null, TEST_EMAIL, TEST_NAME);
    }

    public static UserRequest oneCnpjUserRequest() {
        return new UserRequest(TEST_NAME, null,
                CNPJ, TEST_EMAIL, TEST_NAME);
    }

    public static User oneCpfUser() {
        return new User(1L, TEST_NAME, CPF, null,
                TEST_EMAIL, TEST_NAME);
    }

    public static User oneCnpjUser() {
        return new User(1L, TEST_NAME, null, CNPJ,
                TEST_EMAIL, TEST_NAME);
    }

    public static UserRequest oneUserRequestWithoutDocument() {
        return new UserRequest(TEST_NAME, null, null, TEST_EMAIL, TEST_NAME);
    }
}
