package com.banktransfer.userapi.modules.user.model;

import com.banktransfer.userapi.modules.user.helper.UserHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void of_shouldReturnUser_whenRequested() {
        var expectedUser = UserHelper.oneCpfUser();
        expectedUser.setId(null);
        var actualUser = User.of(UserHelper.oneCpfUserRequest());

        assertEquals(expectedUser, actualUser);
    }
}
