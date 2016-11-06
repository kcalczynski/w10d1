package pl.akademiakodu.repository;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users= Arrays.asList(new User(1, "Krzysztof", "Calczynski", "kc@test.pl"),
            new User(2, "Jurek", "Janeczek", "jj@gmail.com")
    );

    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }
}
