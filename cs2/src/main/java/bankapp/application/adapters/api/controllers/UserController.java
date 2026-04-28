package bankapp.application.adapters.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bankapp.application.adapters.api.request.UserRequest;
import bankapp.application.adapters.api.response.UserResponse;
import bankapp.domain.models.User;
import bankapp.domain.services.CreateUser;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/users")
@Getter
@Setter

public class UserController {
    
    private CreateUser createUser;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        User user = new User();
        user.setDocument(request.getDocument());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setUserState(request.getUserState());

        createUser.createUser(user);

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setDocument(user.getDocument());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setAddress(user.getAddress());
        response.setUsername(user.getUsername());
        response.setRole(user.getRole());
        response.setUserState(user.getUserState());

        return response;
    }
}