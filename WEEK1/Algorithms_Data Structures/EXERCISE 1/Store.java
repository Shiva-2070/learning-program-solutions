
class Item {
    String id;
    String name;
    int amount;
    double cost;

    Item(String i, String n, int a, double c) {
        id = i;
        name = n;
        amount = a;
        cost = c;
    }
}

public class Store {
    Item[] items = new Item[100];
    int count = 0;

    void addItem(String i, String n, int a, double c) {
        items[count] = new Item(i, n, a, c);
        count++;
        System.out.println("Added " + n);
    }

    void changeAmount(String i, int newAmount) {
        for (int x = 0; x < count; x++) {
            if (items[x].id.equals(i)) {
                items[x].amount = newAmount;
                System.out.println("Changed " + items[x].name);
                return;
            }
        }
        System.out.println("Not found!");
    }

    void removeItem(String i) {
        for (int x = 0; x < count; x++) {
            if (items[x].id.equals(i)) {
                System.out.println("Removed " + items[x].name);
                // Shift items after this one
                for (int y = x; y < count-1; y++) {
                    items[y] = items[y+1];
                }
                count--;
                return;
            }
        }
        System.out.println("Not found!");
    }

    void showAll() {
        System.out.println("\nSTORE ITEMS:");
        for (int x = 0; x < count; x++) {
            System.out.println(items[x].id + " " + items[x].name + 
                            " (" + items[x].amount + ") $" + items[x].cost);
        }
    }

    public static void main(String[] args) {
        Store s = new Store();
        s.addItem("101", "Phone", 10, 599.99);
        s.addItem("102", "Case", 25, 19.99);
        s.showAll();
        s.changeAmount("101", 5);
        s.removeItem("102");
        s.showAll();
    }
}