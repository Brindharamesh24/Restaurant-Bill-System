import java.util.Scanner;

class Bill {
    double[] items;
    double[] drinks;
    public Bill(double[] items, double[] drinks) {
        this.items = items;
        this.drinks = drinks;
    }

    double calculateTotal() {
        double total = 0;

        for (double item : items) {
            total += item;
        }

        for (double drink : drinks) {
            total += drink;
        }

        return total;
    }
}

class RegularCustomerBill extends Bill {

    public RegularCustomerBill(double[] items, double[] drinks) {
        super(items, drinks);
    }

    double calculateTotalWithDiscount() {
        double total = calculateTotal();
        double discount = total * 0.10; 
        return total - discount;
    }
}

class VIPCustomerBill extends Bill {

    public VIPCustomerBill(double[] items, double[] drinks) {
        super(items, drinks);
    }

    double calculateTotalWithDiscount() {
        double total = calculateTotal();
        double discount = total * 0.20; 
        return total - discount;
    }
}

public class RestaurantBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int itemCount = scanner.nextInt();
        double[] items = new double[itemCount];
        for (int i = 0; i < itemCount; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            items[i] = scanner.nextDouble();
        }

        System.out.print("Enter number of drinks: ");
        int drinkCount = scanner.nextInt();
        double[] drinks = new double[drinkCount];
        for (int i = 0; i < drinkCount; i++) {
            System.out.print("Enter price of drink " + (i + 1) + ": ");
            drinks[i] = scanner.nextDouble();
        }

        System.out.print("Enter customer type (regular/vip): ");
        String customerType = scanner.next().toLowerCase();

        double totalBill = 0;
        if (customerType=="vip") {
            VIPCustomerBill vipBill = new VIPCustomerBill(items, drinks);
            totalBill = vipBill.calculateTotalWithDiscount();
        } else {
            RegularCustomerBill regularBill = new RegularCustomerBill(items, drinks);
            totalBill = regularBill.calculateTotalWithDiscount();
        }

        System.out.println("Total Bill for: " + totalBill);
    }
}
