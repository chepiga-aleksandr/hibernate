package ua.edu.khibs.resalex.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.edu.khibs.resalex.Dao.DishDao;
import ua.edu.khibs.resalex.model.Dish;
import ua.edu.khibs.resalex.model.DishCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController  {

    private DishDao dishDao;

    @Transactional
    public void createDish() {

        Dish plov = new Dish();

        plov.setName("Plov");
        plov.setCategory(DishCategory.FirstDish);
        plov.setPrice(10.0F);
        plov.setWeight(300F);

        Dish salad = new Dish();

        salad.setName("Salad");
        salad.setCategory(DishCategory.SecondDish);
        salad.setPrice(2.0F);
        salad.setWeight(150F);

        Dish potato = new Dish();

        potato.setName("Potato");
        potato.setCategory(DishCategory.TrhridDish);
        potato.setPrice(5.0F);
        potato.setWeight(200F);

        Set<Dish> dishes = new HashSet<>(dishDao.findAll());

        if (!dishes.contains(plov)) {
            dishDao.save(plov);
        }

        if (!dishes.contains(salad)) {
            dishDao.save(salad);
        }

        if (!dishes.contains(potato)) {
            dishDao.save(potato);
        }
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishesByName (String name) {
        return dishDao.findByName(name);
    }


    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
