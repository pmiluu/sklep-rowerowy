package pl.skleprowerowy.projekt.Person;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Data
public class RegistrationForm {
    private String username;
    private String password;

    public Person toPerson(PasswordEncoder passwordEncoder){
        Person p = new Person();
        p.setUsername(username);
        p.setPassword(password);
        p.setFirstName("piotr");
        p.setLastName("m");
        p.setPhoneNumber("12313123");
        p.setBirthDate(LocalDate.now());
        return p;
    }
}
