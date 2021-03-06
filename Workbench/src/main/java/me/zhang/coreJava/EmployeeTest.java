package me.zhang.coreJava;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Zhang on 10/6/2017 3:41 PM.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Carl Cracker", 100_000, 2013, 5, 3);
        staff[1] = new Employee("Harry Hacker", 500_000, 2012, 2, 24);
        Manager boss = new Manager("Tony Tester", 1_000_000, 2010, 8, 17);
        boss.setBonus(5_000);
        staff[2] = boss;
        staff[3] = new Employee();
        printEmployees(staff);

//        Employee e = new Employee("Lily", 1_000_000, 2013, 4, 8);
//        Manager m = new Manager("Lily", 1_000_000, 2013, 4, 8);
//        System.out.println(e.equals(m)); // false
//        System.out.println(m.equals(e)); // false

        System.out.println("****************************");
        // raise salary
        for (Employee employee : staff) {
            employee.raiseSalary(5);
        }
        printEmployees(staff);

        System.out.println("****************************");
        staff[2] = new Employee();
        Arrays.sort(staff);
        printEmployees(staff);

        System.out.println("****************************");
        Employee zhang = staff[3];
        zhang.setName("Zhang");
        zhang.setSalary(300_000);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.AUGUST, 31);
        zhang.setHireDay(calendar.getTime());
        System.out.println(zhang);

        System.out.println("****************************");
        Employee carl = staff[0];
        Date hireDay = carl.getHireDay();
        double tenYearsInMilliSeconds = 10 * 365.25 * 24 * 60 * 60 * 1000;
        hireDay.setTime((long) (hireDay.getTime() - tenYearsInMilliSeconds));
        // give Carl ten years of added seniority
        // hireDay is a copy of the real one, it doesn't work!
        System.out.println(carl);

        System.out.println("****************************");
        Manager tim = new Manager("Tim", 2_000_000, 2002, 4, 12);
        Manager bill = new Manager("Bill", 2_200_000, 2002, 3, 12);
        tim.setBonus(25_000);
        bill.setBonus(18_000);
        int res = tim.compareTo(bill);
        System.out.println(bill);
        System.out.println("Bonus: tim " + (res >= 0 ? (res == 0 ? "=" : ">") : "<") + " bill");

        System.out.println("****************************");
        try {
            carl = new Employee("Carl Cracker", 100_000, 2003, 5, 13);
            Employee clonedCarl = carl.clone();
            System.out.println(System.identityHashCode(carl));
            System.out.println(System.identityHashCode(clonedCarl));
            System.out.println(carl);
            System.out.println(clonedCarl);

            clonedCarl.setSalary(200_000);
            /* deep clone. hireDay is a brand new object */
            clonedCarl.getHireDay1().setTime(calendar.getTime().getTime());

            System.out.println(carl);
            System.out.println(clonedCarl);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("****************************");
        int[] luckyNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] clonedNumbers = luckyNumbers.clone();
        clonedNumbers[5] = -1;
        System.out.println(Arrays.toString(luckyNumbers));
        System.out.println(Arrays.toString(clonedNumbers));

        System.out.println("****************************");
        Thread hook = new Thread(() -> System.out.println("Hook thread has been called."));
        Runtime.getRuntime().addShutdownHook(hook);

        System.runFinalizersOnExit(true);
    }

    private static void printEmployees(Employee[] employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

}
