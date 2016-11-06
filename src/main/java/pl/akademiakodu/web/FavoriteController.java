package pl.akademiakodu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.model.Gif;
import pl.akademiakodu.repository.GifRepository;

import java.util.List;

@Controller
public class FavoriteController {
    @Autowired
    private GifRepository repo;

    @RequestMapping("/favorites")
    public String getFavoriteGifs(ModelMap model)
    {
        List<Gif> gifs = repo.returnFavoriteGifs();

        model.put("gifs", gifs);
        return "favorites";
    }
}
