package pl.akademiakodu.repository;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Gif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GifRepository {
    private List<Gif> gifs= Arrays.asList(new Gif("android-explosion", LocalDate.now(), "Krzysztof Calczynski", true, 1),
    new Gif("ben-and-mike", LocalDate.now(), "Aga MAzek", true, 2),
            new Gif("book-dominos", LocalDate.now(), "Marek Jurek", false, 3),
            new Gif("compiler-bot", LocalDate.now(), "Jurek Janeczek", false, 3),
            new Gif("cowboy-coder", LocalDate.now(), "Jozef Darek", false, 2),
            new Gif("infinite-andrew", LocalDate.now(), "Albert Einstein", false, 2)
            );

    public List<Gif> findAll(){
        return gifs;
    }

    public Gif findByName(String name){
        return gifs.stream().filter(gif -> gif.getName().equals(name)).findAny().orElse(null);
    }

    public List<Gif> returnGifsWithGivenCategoryId(int id){
        return gifs.stream().filter(gif -> gif.getCategoryId()==id).collect(Collectors.toList());
    }

    public List<Gif> returnFavoriteGifs(){
        return gifs.stream().filter(gif -> gif.isFavorite()==true).collect(Collectors.toList());
    }
}
