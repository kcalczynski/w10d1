package pl.akademiakodu.repository;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Gif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class GifRepository {
    private List<Gif> gifs= Arrays.asList(new Gif("android-explosion", LocalDate.now(), "Krzysztof Calczynski", true),
    new Gif("ben-and-mike", LocalDate.now(), "Aga MAzek", true),
            new Gif("book-dominos", LocalDate.now(), "Marek Jurek", false),
            new Gif("compiler-bot", LocalDate.now(), "Jurek Janeczek", false),
            new Gif("cowboy-coder", LocalDate.now(), "Jozef Darek", false),
            new Gif("infinite-andrew", LocalDate.now(), "Albert Einstein", false)
            );

    public List<Gif> findAll(){
        return gifs;
    }

    public Gif findByName(String name){
        return gifs.stream().filter(gif -> gif.getName().equals(name)).findAny().orElse(null);
    }
}
