package com.banktransfer.userapi.modules.user.service;

import com.banktransfer.userapi.modules.user.dto.UserRequest;
import com.banktransfer.userapi.modules.user.dto.UserResponse;
import com.banktransfer.userapi.modules.user.model.User;
import com.banktransfer.userapi.modules.user.repository.UserRepository;
import com.banktransfer.userapi.modules.user.util.DocumentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponse save(UserRequest request) {
        validateEmail(request.email());
        validateCpfCnpj(request.cpf(), request.cnpj());

        var savedUser = repository.save(User.of(request));

        return new UserResponse(savedUser.getName(), savedUser.getEmail(),
                savedUser.getCpf(), savedUser.getCnpj());
    }

    private void validateEmail(String email) {
        if (repository.existsByEmail(email)) {
            throw new RuntimeException("The email is already registered.");
        }
    }

    private void validateCpfCnpj(String cpf, String cnpj) {
        if (cpf != null) {
            validateCpf(cpf);
        } else if (cnpj != null) {
            validateCnpj(cnpj);
        } else {
            throw new RuntimeException("The user must have a valid cpf or cnpj.");
        }
    }

    private void validateCpf(String cpf) {
        if (DocumentUtil.validateCpfDigits(cpf)) {
            if (repository.existsByCpf(cpf)) {
                throw new RuntimeException("The cpf is already registered.");
            }
        }
    }

    private void validateCnpj(String cnpj) {
        if (DocumentUtil.validateCnpjDigits(cnpj)) {
            if (repository.existsByCnpj(cnpj)) {
                throw new RuntimeException("The cnpj is already registered.");
            }
        }
    }
}
