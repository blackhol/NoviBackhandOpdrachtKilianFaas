package nl.noviopdracht.demo.service;

import nl.noviopdracht.demo.dto.UserDTO;
import nl.noviopdracht.demo.model.User;

public interface UserService {

    public void saveUser(UserDTO userDTO);

    public void deleteUser(UserDTO userDTO);

    public void saveCustomer(UserDTO userDTO);

    public void saveEmployee(UserDTO userDTO);

    public void adjustUser(UserDTO userDTO);

}
