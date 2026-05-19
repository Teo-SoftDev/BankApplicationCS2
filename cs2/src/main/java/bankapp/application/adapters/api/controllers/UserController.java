package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.UserRequest;
import bankapp.application.adapters.api.response.UserResponse;
import bankapp.application.usecases.UserUseCase;
import bankapp.domain.models.User;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    
    private UserUseCase userUseCase;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) throws Exception {
        User user = UserRequest.toEntity(request);
        // Note: Users are typically created through authentication service
        // This is a placeholder for basic user creation
        userUseCase.createUser(user);
        return UserResponse.fromUser(user);
    }


    @GetMapping("/username/{username}")
    public UserResponse findUserByUsername(@PathVariable String username) throws Exception {
        var user = userUseCase.findUserByUsername(username);
        return UserResponse.fromUser(user);
    }

    @GetMapping("/document/{document}")
    public UserResponse findUserByDocument(@PathVariable String document) throws Exception {
        var user = userUseCase.findUserByDocument(document);
        return UserResponse.fromUser(user);
    }
}