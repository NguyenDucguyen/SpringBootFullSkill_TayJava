package vn.tayjava.controller;


import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.UserRequestDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

//    @PostMapping(value="/",headers ="/apiKey=v1.0")
    @RequestMapping(method = POST, path ="/",headers ="/apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDTO userDTO){
        return "user added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("Request user with userId=" + userId);
        return "user updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status){
        System.out.println("Request change user status, userId=" + userId);
        return "user status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
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
