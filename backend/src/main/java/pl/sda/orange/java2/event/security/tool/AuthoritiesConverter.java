package pl.sda.orange.java2.event.security.tool;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthoritiesConverter {
    public List<String> convert(Collection<? extends GrantedAuthority> authorities) {
        List<String> roles = authorities.stream().map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.toList());
        return roles;
    }
}
