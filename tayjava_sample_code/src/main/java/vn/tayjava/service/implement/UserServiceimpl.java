package vn.tayjava.service.implement;

import org.springframework.stereotype.Service;
import vn.tayjava.dto.request.UserRequestDTO;
import vn.tayjava.exception.ResourceNotFoundException;
import vn.tayjava.service.UserService;

@Service
public class UserServiceimpl implements UserService {
    @Override
    public int addUser(UserRequestDTO userRequestDTO) {
        System.out.println("save user to db");
        if(userRequestDTO.getFirstName().equals("Tay")){
            throw new ResourceNotFoundException("Tay khong ton tai ");

        }
        return 0;
    }
}
