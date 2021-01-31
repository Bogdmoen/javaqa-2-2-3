import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditPaymentService {

    public long calculate(long loanAmount, int years) {

        BigDecimal interest = new BigDecimal(0.008325); // ежемесячная процентая ставка 9.99 / 12 /100

        int mounthPeriod = years * 12;

        BigDecimal interestSum = interest.add(BigDecimal.valueOf(1));  // (i+1)
        BigDecimal intSumDegree = interestSum.pow(mounthPeriod); // (1+i)^n
        BigDecimal multRes = interest.multiply(intSumDegree); // i*(1+i)^n
        BigDecimal substRes = intSumDegree.subtract(BigDecimal.valueOf(1)); // ((1+i)^n-1)
        BigDecimal annCoeff = multRes.divide(substRes, 25, RoundingMode.HALF_DOWN); // i*(1+i)^n/((1+i)^n-1)
        BigDecimal loanAmountD = new BigDecimal(loanAmount);
        BigDecimal annMonthPayment = loanAmountD.multiply(annCoeff);


        long result = annMonthPayment.longValue();

        return result;

    }


}
