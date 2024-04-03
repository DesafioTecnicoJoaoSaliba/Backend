package desafiotecnicojr.desafiotecnico.repositories.user;


import desafiotecnicojr.desafiotecnico.dtos.user.UserList;
import desafiotecnicojr.desafiotecnico.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    @Query("Select new desafiotecnicojr.desafiotecnico.dtos.user.UserList(u.id, u.name, u.email) from User u")
    Page<UserList> findAllAsUserList(Pageable pageble);

}
