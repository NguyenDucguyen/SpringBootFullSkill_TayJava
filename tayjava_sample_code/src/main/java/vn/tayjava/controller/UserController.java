package vn.tayjava.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.UserRequestDTO;
import vn.tayjava.dto.response.ResponseData;
import vn.tayjava.dto.response.ResponseSuccess;
import vn.tayjava.service.UserService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

//    @Operation(summary = "summary",description = "description",responses = {
//            @ApiResponse(responseCode = "201", description = "User added successfully",
//                         content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//                                            examples = @ExampleObject(name ="ex name", summary = "ex summary",
//                                            value = """
//                                                    {
//                                                        "status": 201,
//                                                        "message": "User added successfully",
//                                                        "data": 1
//                                                    }
//                                                    """)))
//    }
//    )
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO user) {
        System.out.println("Request add user" + user.getFirstName());
        try {
            userService.addUser(user);
            return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);

        } catch (RuntimeException e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), "save user failed");
        }
    }

//    @Operation(summary = "summary",description = "description",responses = {
//            @ApiResponse(responseCode = "202", description = "User updated successfully",
//                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//                            examples = @ExampleObject(name ="ex name", summary = "ex summary",
//                                    value = """
//                                                    {
//                                                        "status": 202,
//                                                        "message": "User updated successfully",
//                                                        "data": null
//                                                    }
//                                                    """)))
//    }
//    )
    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO){
        System.out.println("Request user with userId=" + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }


//    @Operation(summary = "summary",description = "description",responses = {
//            @ApiResponse(responseCode = "202", description = "User changed status successfully",
//                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//                            examples = @ExampleObject(name ="ex name", summary = "ex summary",
//                                    value = """
//                                                    {
//                                                        "status": 202,
//                                                        "message": "User changed status successfully",
//                                                        "data": null
//                                                    }
//                                                    """)))
//    }
//    )
    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @Min(1) @RequestParam int status){
        System.out.println("Request change user status, userId=" + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User change status successfully");
    }


    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId){
        System.out.println("Request delete userId=" + userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId){
        System.out.println("Request get user detail by userID=" + userId);
        return new ResponseData(HttpStatus.OK.value(), "User",new UserRequestDTO("Tay","Java","email","phone"));
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<List<UserRequestDTO>> getUserList(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize){
        System.out.println("Request get user list");
        return new ResponseData<>(HttpStatus.OK.value(), "User List",List.of(new UserRequestDTO("Tay","Java","email","phone"),
                new UserRequestDTO("Tay","Python","email","phone")));

    }



}
