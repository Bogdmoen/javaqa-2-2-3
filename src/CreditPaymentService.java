import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_FLOOR;

public class CreditPaymentService {

    public long calculate(long loan_amount, int years) {

        double interest = 0.008325; // ежемесячная процентая ставка 9.99 / 12 /100

        int mounth_period = 0;

        if (years == 1) {
            mounth_period = 12;

        }
        if (years == 2) {
            mounth_period = 24;

        }
        if (years == 3) {
            mounth_period = 36;

        }

        double interest_sum = interest + 1;  // (i+1)

        BigDecimal interest_sum_D = new BigDecimal(interest_sum);
        BigDecimal int_sum_degree = interest_sum_D.pow(mounth_period); // (1+i)^n
        BigDecimal interest_D = new BigDecimal(interest);
        BigDecimal mult_res = interest_D.multiply(int_sum_degree); // i*(1+i)^n
        BigDecimal subst_res = int_sum_degree.subtract(BigDecimal.valueOf(1));
        BigDecimal ann_coeff = mult_res.divide(subst_res, 25, RoundingMode.HALF_DOWN);
        BigDecimal loan_amount_D = new BigDecimal(loan_amount);
        BigDecimal ann_month_payment = loan_amount_D.multiply(ann_coeff);


        long result = ann_month_payment.longValue();

        return result;

    }


}
