package nl.noviopdracht.demo.service;


import nl.noviopdracht.demo.dto.UserDTO;
import nl.noviopdracht.demo.model.User;
import nl.noviopdracht.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repos;
    public UserServiceImpl(UserRepository repos){
        this.repos = repos;
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
