import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @author Munin
 * @version 5.1.9
 * Created by Munin on 2021/2/25
 */
public class FundingSimulation {

    public static void main(String[] args) throws Exception {
        System.out.println("please enter the fund code:");
        Scanner sc = new Scanner(System.in);
        String fundCode = sc.nextLine();
        DetailsInitializer detailsInitializer = new DetailsInitializer(fundCode);
        List<FundDetailBean> beans = detailsInitializer.initFundDetail();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        printTitle();
        beans.forEach(b -> print(b, format));
    }

    private static void printTitle() {
        System.out.print("    净值日期");
        System.out.print("      单位净值");
        System.out.print("   累计净值");
        System.out.print("    日增长率");
        System.out.print("    申购状态");
        System.out.print("      赎回状态");
        System.out.println();
    }

    private static void print(FundDetailBean bean, SimpleDateFormat format) {
        System.out.printf("%-10s", " | " + format.format(bean.getDate()));
        System.out.printf("%-10s", " | " + formatDouble(bean.getUnitNV()));
        System.out.printf("%-10s", " | " + formatDouble(bean.getAccumulativeNV()));
        System.out.printf("%-10s", " | " + formatDouble(bean.getRateOfRaise()));
        System.out.printf("%-10s", " | " + bean.getSubStat());
        System.out.printf("%-10s", " | " + bean.getRedeemStat());
        System.out.println();
    }

    private static String formatDouble(double d) {
        NumberFormat nf = NumberFormat.getInstance();
        // 设置保留多少位小数
        nf.setMaximumFractionDigits(20);
        // 取消科学计数法
        nf.setGroupingUsed(false);
        return nf.format(d);
    }
}
