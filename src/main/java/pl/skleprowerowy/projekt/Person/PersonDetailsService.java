package pl.skleprowerowy.projekt.Person;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface PersonDetailsService {
    UserDetails loadByUsername(String username) throws UsernameNotFoundException;

}
