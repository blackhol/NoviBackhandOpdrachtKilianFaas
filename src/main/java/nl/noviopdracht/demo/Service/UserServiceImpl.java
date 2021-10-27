package nl.noviopdracht.demo.Service;


import nl.noviopdracht.demo.DTO.UserDTO;
import nl.noviopdracht.demo.Model.User;
import nl.noviopdracht.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

    public class UserServiceImpl implements UserService {
    private final UserRepository repos;
    public UserServiceImpl(UserRepository repos){
        this.repos = repos;
    }

    @Override
    public ArrayList<UserDTO> gettAllUsers() {
        List<User> usersList = repos.findAll();
        ArrayList<UserDTO> userDTOList = new ArrayList<UserDTO>();

        for
        (
                User user:usersList
        )
        {
                UserDTO userconver = new UserDTO(user.getId() ,user.getName(), user.getEmail(), user.getPassword(), user.getNote() , user.getBirthday() , user.getProfession());
                userDTOList.add(userconver);
        }

        return userDTOList;
    }

    @Override
    public void saveUser( UserDTO userDTO) {
        User user = new User(userDTO.getName(),userDTO.getEmail(),userDTO.getPassword(),userDTO.getNote(),userDTO.getBirthday(),userDTO.getProfession());
        repos.save(user);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {

    }

    @Override
    public void adjustUser(UserDTO userDTO) {

    }

    @Override
    public void saveCustomer(UserDTO userDTO) {
        User user = new User(userDTO.getName(),userDTO.getEmail(),userDTO.getPassword(),userDTO.getNote(),userDTO.getBirthday(),userDTO.getProfession());
        repos.save(user);
    }

    @Override
    public void saveEmployee(UserDTO userDTO) {

    }
}
