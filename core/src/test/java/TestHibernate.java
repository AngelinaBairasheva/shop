import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.domain.Categories;
import ru.dz.labs.api.domain.Goods;
import ru.dz.labs.api.service.CategoriesService;
import ru.dz.labs.api.service.GoodsService;

import java.math.BigDecimal;
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
         insert();
        testCategories();
        //  testSubject();
        // testTutor();
    }
    public static void insert() {
        Categories category = new Categories("шоколад");
        categoriesService.addCategory(category);
        Categories categories = new Categories("шоколад на ложке", category);
        categoriesService.addCategory(categories);
        Categories categories1 = new Categories("шоколад на ложке Hotchocspoon", categories,"../../../resources/i/3.jpg",
                "Hotchocspoon - шоколад на ложке, наша большая гордость. Это шоколад, с которого мы начали свое дело.\n" +
                        "Твердый кусочек счастья на ложке. Чрезвычайно мягкий с пралине, с миндалем, вкусом вишни, корицей, " +
                        "перцем…");
        categoriesService.addCategory(categories1);
        Categories categories5 = new Categories("шоколад на ложке с алкоголем", categories,"../../../resources/i/4.jpg");
        categoriesService.addCategory(categories5);
        Categories categories2 = new Categories("шоколадные фигуры", category,"../../../resources/i/5.jpeg");
        categoriesService.addCategory(categories2);
        Categories categories3 = new Categories("конфеты");
        categoriesService.addCategory(categories3);
        Categories categories6 = new Categories("шоколадные композиции", category,"../../../resources/i/y.jpg");
        categoriesService.addCategory(categories6);
        Categories categories7 = new Categories("фрукты в шоколаде","../../../resources/i/8.jpg");
        categoriesService.addCategory(categories7);
        Categories categories4 = new Categories("подарочные наборы","../../../resources/i/f.jpg");
        categoriesService.addCategory(categories4);
        Categories categories8 = new Categories("набор конфет", categories3,"../../../resources/i/10.jpg");
        categoriesService.addCategory(categories8);
        Goods goods=new Goods("Сова", new BigDecimal(150),10, "../../../resources/i/2-3.jpeg", "345L",536,
                "молочный шоколад, паста для лепки (мастика)",250,"пластиковая коробка","молочный",categories6, false);
        goodsService.addGood(goods);
        Goods goods1=new Goods("Рождественский мишка", new BigDecimal(100), 11, "../../../resources/i/3-3.jpeg", "348L",537 ,
                "пудра сахарная, какао масло, молоко сухое цельное, какао тертое, молоко сухое обезжиренное, эмульгатор лецитин соевый, " +
                        "ароматизатор ванилин", 100, "пластиковая коробка","молочный",categories2, false);
        goodsService.addGood(goods1);
        Goods goods2=new Goods("Попугай Кеша", new BigDecimal(180),0,"../../../resources/i/n.jpeg", "341L",538,
                "молочный шоколад, паста для лепки (мастика)",300,"пластиковая коробка","молочный",categories6,true);
        goodsService.addGood(goods2);
        Goods goods3=new Goods("Музыкальный шоколадный набор", new BigDecimal(500), 10, "../../../resources/i/t.jpeg", "548L",537,
                "молочный шоколад, паста для лепки (мастика)",250,"деревянная коробка","молочный",categories4,false);
        goodsService.addGood(goods3);
        Goods goods4=new Goods("Шоколад на ложке тёмный \"Лесной орех\"", new BigDecimal(300),5,"../../../resources/i/c.jpg", "741L",538,
                "сахар, какао-тертое, какао-масло, обезжиренный какао- порошок,тертый лесной орех.  эмульгатор- соевый лецитин, натуральный ароматизатор- ваниль."+
                "Продукт может содержать следы орехов, молока, яичного белка.",500,"пластиковая коробка","тёмный",categories1,false);
        goodsService.addGood(goods4);
        Goods goods5=new Goods("ШОКОЛАД НА ЛОЖКЕ HOTCHOCSPOON DELUXE АМАРЕТТО", new BigDecimal(300),6,"165х155х30","../../../resources/i/4.jpg",
                "Hotchocspoon - шоколад на ложке, наша большая гордость.\n" +
                        "Твердый кусочек счастья на ложке. Чрезвычайно мягкий с пралине, с миндалем, вкусом вишни, корицей, " +
                        "перцем…Выберите своего фаворита.","G-88","CH_CO",300,
                "какао мин 36 %, сахар, какао- тертое, какао-масло, сухое цельное молоко, карамелизированный сахар, ликер Амаретто, " +
                        "тертый лесной орех, тертый миндаль, эмульгатор – соевый лецитин, натуральный ароматизатор – ваниль.", 300,"пластиковая коробка",
                "горький",categories5, false,"Белки - 5,9, Жиры - 35, Углеводы - 56,1");
        goodsService.addGood(goods5);
    }

    public static void testCategories() {
       // System.out.println(categoriesService.getAllCategories());
        System.out.println(categoriesService.getEndedCategories());
        System.out.println(goodsService.getGoodsByCategorysName("шоколадные композиции"));
    }
}
