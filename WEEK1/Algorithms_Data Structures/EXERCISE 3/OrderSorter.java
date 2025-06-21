class Order {
    int orderId;
    String customer;
    double price;
    
    Order(int id, String name, double p) {
        orderId = id;
        customer = name;
        price = p;
    }
}

public class OrderSorter {
    // Bubble Sort
    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length-1; i++) {
            for (int j = 0; j < orders.length-i-1; j++) {
                if (orders[j].price > orders[j+1].price) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }
    
    // Quick Sort helper
    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].price;
        int i = low-1;
        
        for (int j = low; j < high; j++) {
            if (arr[j].price < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    
    // Quick Sort
    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "John", 99.99),
            new Order(102, "Alice", 49.99),
            new Order(103, "Bob", 149.99)
        };
        
        // Bubble sort
        bubbleSort(orders);
        System.out.println("After Bubble Sort:");
        for (Order o : orders) {
            System.out.println(o.price);
        }
        
        // Quick sort
        quickSort(orders, 0, orders.length-1);
        System.out.println("\nAfter Quick Sort:");
        for (Order o : orders) {
            System.out.println(o.price);
        }
    }
}