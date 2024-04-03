package desafiotecnicojr.desafiotecnico.service;


import desafiotecnicojr.desafiotecnico.dtos.user.UserList;
import desafiotecnicojr.desafiotecnico.model.user.User;
import desafiotecnicojr.desafiotecnico.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Page<UserList> listUser(Pageable pageble) {
        return userRepository.findAllAsUserList(pageble);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User userEntity) {
        return userRepository.save(userEntity);
    }

    public User update(User existingUserDTO) {
        return userRepository.save(existingUserDTO);
    }
}
