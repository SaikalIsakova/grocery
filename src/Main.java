import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Employee;
import com.company.models.Shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbHelper dbHelper = new DbHelperImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите объект с которым хотите совершить операции.\n1-магазин ,2-продавец");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Выберите операцию.\n" +
                    "Создать магазин - 1 \n" + "Получить список магазинов - 2 \n" +
                    "Изменить название магазина - 3 \n" +
                    "Удалить магазин - 4");
            int chooseOperation = sc.nextInt();
            switch (chooseOperation) {
                case 1:
                    System.out.println("Введите название магазина.");
                    String shopName = sc.next();
                    Shop shop = new Shop(shopName);
                    dbHelper.createShop(shop);
                    System.out.println("Вы успешно создали магазин с названием " + shopName);
                    break;
                case 2:
                    System.out.println("\n Список магазинов");
                    System.out.println(dbHelper.shopList());
                    break;
                case 3:
                    System.out.println("\n Введите название");
                    dbHelper.updateShop(1);
                    break;
                case 4:
                    dbHelper.deleteShop(1);
                    System.out.println("Объект 1 удален");
                    break;

            }
        } else if (answer == 2) {
            System.out.println("Выберите операцию.\n" +
                    "Создать продавца - 1 \n" + "Получить список продавцов - 2 \n" +
                    "Изменить имя прдодавца- 3 \n" +
                    "Удалить продавца - 4");
            int chooseOperation1 = sc.nextInt();
            switch (chooseOperation1) {
                case 1:
                    System.out.println("Введите имя продавца.");
                    String sellerName = sc.next();
                    Employee emp = new Employee(sellerName);
                    dbHelper.createSeller(emp);
                    System.out.println("Вы успешно создали продавца с именем " + sellerName);
                    break;
                case 2:
                    System.out.println("\n Список продавцов");
                    System.out.println(dbHelper.empList());
                    break;
                case 3:
                    System.out.println("\n Введите имя");
                    dbHelper.updateSeller(1);
                    break;
                case 4:
                    dbHelper.deleteSeller(1);
                    System.out.println("Продавец 1 удален");
                    break;

            }

        }
    }
}