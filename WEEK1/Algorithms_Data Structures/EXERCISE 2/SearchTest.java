
class Product {
    String code;
    String title;
    String type;

    Product(String c, String t, String ty) {
        code = c;
        title = t;
        type = ty;
    }
}

public class SearchTest {
    // Normal search
    static int simpleSearch(Product[] list, String find) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].code.equals(find))
                return i;
        }
        return -1;
    }

    // Faster search (needs sorted list)
    static int fastSearch(Product[] sortedList, String find) {
        int start = 0;
        int end = sortedList.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int check = find.compareTo(sortedList[mid].code);

            if (check == 0) return mid;
            if (check < 0) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] myProducts = new Product[3];
        myProducts[0] = new Product("A101", "Tablet", "Tech");
        myProducts[1] = new Product("A102", "Chair", "Furniture");
        myProducts[2] = new Product("A103", "Lamp", "Home");

        Product[] sortedProducts = new Product[3];
        sortedProducts[0] = new Product("A101", "Tablet", "Tech");
        sortedProducts[1] = new Product("A102", "Chair", "Furniture");
        sortedProducts[2] = new Product("A103", "Lamp", "Home");

        System.out.println("Regular search:");
        int pos = simpleSearch(myProducts, "A102");
        System.out.println("Found at: " + pos);

        System.out.println("\nFast search:");
        pos = fastSearch(sortedProducts, "A102");
        System.out.println("Found at: " + pos);
    }
}