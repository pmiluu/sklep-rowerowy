package pl.skleprowerowy.projekt.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonRepositoryPersonDetailsService implements PersonDetailsService{
    private PersonRepository personRepository;

    @Autowired
    public PersonRepositoryPersonDetailsService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.findByUsername(username);
        if(person !=null){
            return person;
        }
        throw new UsernameNotFoundException("Użytkownik '" + username + "' nie został znaleziony.");
    }
}
