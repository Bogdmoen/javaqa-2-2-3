public class Main {
    public static void main(String[] args) {

        CreditPaymentService service = new CreditPaymentService();

        long one_year = service.calculate(1000000, 1);
        System.out.println(one_year);


        long two_years = service.calculate(1000000, 2);
        System.out.println(two_years);


        long three_years = service.calculate(1000000, 3);
        System.out.println(three_years);


    }
}
