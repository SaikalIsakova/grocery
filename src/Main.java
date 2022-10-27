import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    DbHelper dbHelper=new DbHelperImpl();
    Employee employee=new Employee(sc.next());
    dbHelper.createSeller(employee);
    }
}