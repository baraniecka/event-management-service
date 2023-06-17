package pl.sda.orange.java2.event.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.orange.java2.event.entity.Role;
import pl.sda.orange.java2.event.entity.User;
import pl.sda.orange.java2.event.exception.NoUserFoundException;
import pl.sda.orange.java2.event.repository.IUserRepository;
import pl.sda.orange.java2.event.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .map(user -> (UserDetails) new User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getEmail()))
                .orElseThrow(() -> new NoUserFoundException(username));
    }
}
