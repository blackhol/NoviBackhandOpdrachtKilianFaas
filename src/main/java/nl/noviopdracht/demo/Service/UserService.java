package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.UserDTO;

import java.util.ArrayList;

public interface UserService {

    public ArrayList<UserDTO> gettAllUsers();

    public void saveUser(UserDTO userDTO);

}
