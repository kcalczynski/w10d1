package pl.akademiakodu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.akademiakodu.model.Category;
import pl.akademiakodu.model.Gif;
import pl.akademiakodu.repository.CategoryRepository;
import pl.akademiakodu.repository.GifRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @Autowired
    private GifRepository repoGifs;

    @RequestMapping("/categories")
    public ModelAndView listCategories()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("categories");
        modelAndView.addObject("categories", repo.findAll());
        return modelAndView;
    }
    @RequestMapping("/category/{id}")
    public String showCategory(@PathVariable int id, ModelMap model){
        Category thisCat = repo.findById(id);
        List<Gif> gifList = repoGifs.returnGifsWithGivenCategoryId(id);

        model.put("category", thisCat);
        model.put("gifsForCategory", gifList);

        return "category";
    }

}
