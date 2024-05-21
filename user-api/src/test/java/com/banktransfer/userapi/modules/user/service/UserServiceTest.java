package com.banktransfer.userapi.modules.user.service;

import com.banktransfer.userapi.modules.common.exception.ValidationException;
import com.banktransfer.userapi.modules.user.helper.UserHelper;
import com.banktransfer.userapi.modules.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.banktransfer.userapi.modules.user.enums.UserError.*;
import static com.banktransfer.userapi.modules.user.helper.UserHelper.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;

    @Test
    void save_shouldReturnUserResponse_whenUserHasValidCpf() {
        var userToSave = oneCpfUser();
        userToSave.setId(null);
        doReturn(oneCpfUser()).when(repository)
                .save(userToSave);

        assertThat(service.save(oneCpfUserRequest()))
                .isEqualTo(UserHelper.oneCpfUserResponse());

        verify(repository).existsByEmail(userToSave.getEmail());
        verify(repository).existsByCpf(userToSave.getCpf());
        verify(repository).save(userToSave);
    }

    @Test
    void save_shouldReturnUserResponse_whenUserHasValidCnpj() {
        var userToSave = oneCnpjUser();
        userToSave.setId(null);
        doReturn(oneCnpjUser()).when(repository)
                .save(userToSave);

        assertThat(service.save(oneCnpjUserRequest()))
                .isEqualTo(UserHelper.oneCnpjUserResponse());

        verify(repository).existsByEmail(userToSave.getEmail());
        verify(repository).existsByCnpj(userToSave.getCnpj());
        verify(repository).save(userToSave);
    }

    @Test
    void save_shouldThrowException_whenUserHasDuplicatedEmail() {
        var userEmail = oneCpfUser().getEmail();
        doReturn(true).when(repository)
                .existsByEmail(userEmail);

        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> service.save(oneCpfUserRequest()))
                .withMessage(DUPLICATED_EMAIL.getErrorMessage());

        verify(repository).existsByEmail(userEmail);
    }

    @Test
    void save_shouldThrowException_whenUserHasDuplicatedCpf() {
        var userToSave = oneCpfUser();
        doReturn(true).when(repository)
                .existsByCpf(userToSave.getCpf());

        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> service.save(oneCpfUserRequest()))
                .withMessage(DUPLICATED_CPF.getErrorMessage());

        verify(repository).existsByEmail(userToSave.getEmail());
        verify(repository).existsByCpf(userToSave.getCpf());
    }

    @Test
    void save_shouldThrowException_whenUserHasDuplicatedCnpj() {
        var userToSave = oneCnpjUser();
        doReturn(true).when(repository)
                .existsByCnpj(userToSave.getCnpj());

        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> service.save(oneCnpjUserRequest()))
                .withMessage(DUPLICATED_CNPJ.getErrorMessage());

        verify(repository).existsByEmail(userToSave.getEmail());
        verify(repository).existsByCnpj(userToSave.getCnpj());
    }

    @Test
    void save_shouldThrowException_whenUserHasNoDocument() {
        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> service.save(UserHelper.oneUserRequestWithoutDocument()))
                .withMessage(NO_VALID_DOCUMENT.getErrorMessage());

        verify(repository).existsByEmail(oneCpfUser().getEmail());
        verify(repository, never()).existsByCpf(any());
        verify(repository, never()).existsByCnpj(any());
    }
}
