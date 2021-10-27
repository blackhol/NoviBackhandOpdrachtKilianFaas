package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.DTO.UserDTO;

import java.util.ArrayList;

public interface UserService {

    public ArrayList<UserDTO> gettAllUsers();

    public void saveUser(UserDTO userDTO);

    public void deleteUser(UserDTO userDTO);

    public void saveCustomer(UserDTO userDTO);

    public void saveEmployee(UserDTO userDTO);

    public void adjustUser(UserDTO userDTO);

}
