
/**
 * @author Munin
 * Created by Munin on 2021/2/25
 */
public class FundDetailBean {

    // 日期
    private String dateStr;
    // 单位净值
    private double unitNV;
    // 累计净值
    private double accumulativeNV;
    // 日增长率
    private double rateOfRaise;
    // 申购状态
    private String subStat;
    // 赎回状态
    private String redeemStat;

    private FundDetailBean(String dateStr, double unitNV, double accumulativeNV, double rateOfRaise, String subStat, String redeemStat) {
        this.dateStr = dateStr;
        this.unitNV = unitNV;
        this.accumulativeNV = accumulativeNV;
        this.rateOfRaise = rateOfRaise;
        this.subStat = subStat;
        this.redeemStat = redeemStat;
    }

    public static FundDetailBean create(String date, double unitNV, double accumulativeNV, double rateOfRaise, String subStat, String redeemStat) {
        return new FundDetailBean(date, unitNV, accumulativeNV, rateOfRaise, subStat, redeemStat);
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public double getUnitNV() {
        return unitNV;
    }

    public void setUnitNV(double unitNV) {
        this.unitNV = unitNV;
    }

    public double getAccumulativeNV() {
        return accumulativeNV;
    }

    public void setAccumulativeNV(double accumulativeNV) {
        this.accumulativeNV = accumulativeNV;
    }

    public double getRateOfRaise() {
        return rateOfRaise;
    }

    public void setRateOfRaise(double rateOfRaise) {
        this.rateOfRaise = rateOfRaise;
    }

    public String getSubStat() {
        return subStat;
    }

    public void setSubStat(String subStat) {
        this.subStat = subStat;
    }

    public String getRedeemStat() {
        return redeemStat;
    }

    public void setRedeemStat(String redeemStat) {
        this.redeemStat = redeemStat;
    }
}
