package desafiotecnicojr.desafiotecnico.entity.user;

import desafiotecnicojr.desafiotecnico.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

@Entity
@Table(name = "user_app")
@Getter
@Setter
public class User implements UserDetails {
    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Instant createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    protected Instant modifiedDate;
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email", unique = true)
    private String email;
    private String password;
    private String name;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;


    private String providerId;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


}