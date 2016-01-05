import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.domain.Categories;
import ru.dz.labs.api.service.CategoriesService;
import ru.dz.labs.api.service.GoodsService;

import java.sql.SQLException;

public class TestHibernate {

    public static GoodsService goodsService;
    public static CategoriesService categoriesService;

    public static void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"shop-core.xml"}, true);
        System.out.println("context=" + context);
        goodsService = (GoodsService) context.getBean("goodsService");
        categoriesService = (CategoriesService) context.getBean("categoriesService");
    }

    public static void main(String[] args) throws SQLException {
        init();
        // insertCategories();
        testCategories();
        //  testSubject();
        // testTutor();
    }

    public static void insertCategories() {
        Categories category = new Categories("шоколад");
        categoriesService.addCategory(category);
        Categories categories = new Categories("шоколад на ложке", category);
        categoriesService.addCategory(categories);
        Categories categories1 = new Categories("шоколад на ложке Hotchocspoon", categories);
        categoriesService.addCategory(categories1);
        Categories categories5 = new Categories("шоколад на ложке с алкоголем", categories);
        categoriesService.addCategory(categories5);
        Categories categories2 = new Categories("шоколадные фигуры", category);
        categoriesService.addCategory(categories2);
        Categories categories3 = new Categories("конфеты");
        categoriesService.addCategory(categories3);
        Categories categories6 = new Categories("шоколадные композиции", category);
        categoriesService.addCategory(categories6);
        Categories categories7 = new Categories("фрукты в шоколаде");
        categoriesService.addCategory(categories7);
        Categories categories4 = new Categories("подарочные наборы");
        categoriesService.addCategory(categories4);
        Categories categories8 = new Categories("набор конфет", categories3);
        categoriesService.addCategory(categories8);
    }

    public static void testCategories() {
        System.out.println(categoriesService.getAllCategories());

    }
}
