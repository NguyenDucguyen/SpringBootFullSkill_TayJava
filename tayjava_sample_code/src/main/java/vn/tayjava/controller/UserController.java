package vn.tayjava.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.UserRequestDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO user) {
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("Request user with userId=" + userId);
        return "user updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @Min(1) @RequestParam int status){
        System.out.println("Request change user status, userId=" + userId);
        return "user status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable int userId){
        System.out.println("Request delete userId=" + userId);
        return "user deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId){
        System.out.println("Request get user detail by userID=" + userId);
        return new UserRequestDTO("Tay","Java","email","phone");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getUserList(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("Request get user list");
        return List.of(new UserRequestDTO("Tay","Java","email","phone"),
                new UserRequestDTO("Tay","Python","email","phone"));
    }



}
