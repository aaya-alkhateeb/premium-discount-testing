package discount;

public class DiscountCalculator {

    public static int calculateDiscount(
            String customerType,
            int totalOrdersInLastYear,
            boolean isSubscribedToNewsletter) {

        if (totalOrdersInLastYear < 0) {
            throw new IllegalArgumentException("Orders cannot be negative");
        }

        if (!customerType.equals("NEW") &&
            !customerType.equals("REGULAR") &&
            !customerType.equals("PREMIUM")) {
            throw new IllegalArgumentException("Invalid customer type");
        }

        if (customerType.equals("NEW") && totalOrdersInLastYear >= 10) {
            throw new IllegalArgumentException("Invalid combination");
        }

        int discount = 5; // base discount

        if (isSubscribedToNewsletter) {
            discount += 2;
        }

        switch (customerType) {
            case "REGULAR":
                discount += 3;
                break;

            case "PREMIUM":
                discount += 5;
                break;

            case "NEW":
                break;
        }

        if (totalOrdersInLastYear >= 10) {
            discount += 5;
        }

        if (discount > 15) {
            discount = 15;
        }

        return discount;
    }
}