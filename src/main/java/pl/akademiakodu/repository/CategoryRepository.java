package pl.akademiakodu.repository;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.model.Category;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private List<Category> categories = Arrays.asList(new Category(1, "cat1-low"),
            new Category(2, "cat2-medium"), new Category(3, "test3-high"));

    public List<Category> findAll(){
        return categories;
    }

    public Category findById(int id){
        return categories.stream().filter(category -> category.getId()==id).findFirst().orElse(null);
    }
}
