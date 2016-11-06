package pl.akademiakodu.web;

import org.springframework.beans.factory.access.BootstrapException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.User;
import pl.akademiakodu.repository.UserRepository;

import java.util.Random;

@Controller
public class UserController {

    @Autowired
    UserRepository repo;

    @RequestMapping("/user")
    public ModelAndView listUser()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", repo.findAll());
        return modelAndView;
    }



    @RequestMapping("/user/{id}")
    public String showUser(@PathVariable int id, ModelMap model,
                           @RequestParam(name="ksywka", defaultValue = "") String ksywkaValue,
                           @RequestParam(name="losuj", defaultValue = "false") boolean losValue){
        User thisUser = repo.findById(id);

        model.put("user", thisUser);
        model.put("ksywka", ksywkaValue);

        //Random random = new Random();
        //int randomVal = random.nextInt(101);
        model.put("id", losValue?(int)(Math.random()*100):thisUser.getId());
        return "user-details";
    }
}
