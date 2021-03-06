package me.zhang.iterator;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by Zhang on 11/21/2015 9:44 下午.
 */
public class CafeMenu implements Iterable<MenuItem> {

    Hashtable<String, MenuItem> menuItems = new Hashtable<>();

    public CafeMenu() {
        addItem(
                "Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99
        );

        addItem(
                "Soup of the day",
                "A cup of the soup of the day, with a side salad",
                false, 3.69
        );

        addItem(
                "Burrito",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29
        );
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator<MenuItem> iterator() {
        return menuItems.values().iterator();
    }
}
