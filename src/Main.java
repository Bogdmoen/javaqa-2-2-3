public class Main {
    public static void main(String[] args) {

        CreditPaymentService service = new CreditPaymentService();

        long oneYear = service.calculate(1000000, 1);
        System.out.println(oneYear);


        long twoYears = service.calculate(1000000, 2);
        System.out.println(twoYears);


        long threeYears = service.calculate(1000000, 3);
        System.out.println(threeYears);


    }
}
