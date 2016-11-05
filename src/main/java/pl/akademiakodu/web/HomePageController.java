package pl.akademiakodu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.repository.GifRepository;

@Controller
public class HomePageController {

    @Autowired
    GifRepository repo;

    @RequestMapping("/")
    public String listGif()
    {

        return "home";
    }
}
