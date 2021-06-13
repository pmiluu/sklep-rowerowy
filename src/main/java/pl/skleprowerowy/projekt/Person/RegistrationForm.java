package pl.skleprowerowy.projekt.Person;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public Person toPerson(PasswordEncoder passwordEncoder){
        Person p = new Person();
        p.setUsername(username);
        p.setPassword(password);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setBirthDate(birthDate);
        p.setPersonType(PersonType.Client);
        return p;
    }
}
