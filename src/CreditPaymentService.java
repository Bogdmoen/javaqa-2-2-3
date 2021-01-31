import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditPaymentService {

    public long calculate(long loan_amount, int years) {

        BigDecimal interest = new BigDecimal(0.008325); // ежемесячная процентая ставка 9.99 / 12 /100

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

        BigDecimal interest_sum = interest.add(BigDecimal.valueOf(1));  // (i+1)
        BigDecimal int_sum_degree = interest_sum.pow(mounth_period); // (1+i)^n
        BigDecimal mult_res = interest.multiply(int_sum_degree); // i*(1+i)^n
        BigDecimal subst_res = int_sum_degree.subtract(BigDecimal.valueOf(1)); // ((1+i)^n-1)
        BigDecimal ann_coeff = mult_res.divide(subst_res, 25, RoundingMode.HALF_DOWN); // i*(1+i)^n/((1+i)^n-1)
        BigDecimal loan_amount_D = new BigDecimal(loan_amount);
        BigDecimal ann_month_payment = loan_amount_D.multiply(ann_coeff);


        long result = ann_month_payment.longValue();

        return result;

    }


}
