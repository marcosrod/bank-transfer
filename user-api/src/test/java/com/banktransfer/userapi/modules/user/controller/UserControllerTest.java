package com.banktransfer.userapi.modules.user.controller;

import com.banktransfer.userapi.modules.user.helper.UserHelper;
import com.banktransfer.userapi.modules.user.service.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.banktransfer.userapi.modules.common.util.JsonHelper.asJsonString;
import static com.banktransfer.userapi.modules.user.helper.UserHelper.oneCnpjUserRequest;
import static com.banktransfer.userapi.modules.user.helper.UserHelper.oneCpfUserRequest;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private UserController controller;
    @MockBean
    private UserService service;
    @Autowired
    private MockMvc mvc;

    @Test
    @SneakyThrows
    void save_shouldReturnUserResponse_whenCpfUserRequested() {
        doReturn(UserHelper.oneCpfUserResponse()).when(service).save(oneCpfUserRequest());

        mvc.perform(MockMvcRequestBuilders.post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(oneCpfUserRequest())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"))
                .andExpect(jsonPath("$.cpf").value("144.523.214-12"))
                .andExpect(jsonPath("$.cnpj").value(nullValue()));

        verify(service).save(eq(oneCpfUserRequest()));
    }

    @Test
    @SneakyThrows
    void save_shouldReturnUserResponse_whenCnpjUserRequested() {
        doReturn(UserHelper.oneCnpjUserResponse()).when(service).save(oneCnpjUserRequest());

        mvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(oneCnpjUserRequest())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"))
                .andExpect(jsonPath("$.cpf").value(nullValue()))
                .andExpect(jsonPath("$.cnpj").value("87.559.364/0001-94"));

        verify(service).save(eq(oneCnpjUserRequest()));
    }
}
