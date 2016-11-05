package pl.akademiakodu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.model.Gif;
import pl.akademiakodu.repository.GifRepository;

import java.time.LocalDate;

@Controller
public class GifController {

    @Autowired
    private GifRepository repo;

    @RequestMapping("/gif/{name}")
    public String getGif(@PathVariable String name, ModelMap model)
    {
        Gif finded = repo.findByName(name);

        model.put("gif", finded);
        return "gif-details";
    }
}
