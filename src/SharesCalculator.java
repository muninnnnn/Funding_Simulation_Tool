/**
 * @author Munin
 * @version 5.1.9
 * Created by Munin on 2021/2/26
 */
public class SharesCalculator {







    private void subscribe() {

    }


    // 策略箱，通过每次循环更新策略中的参数
    class TacticsBox {
        // 昨日收益率
        private double rate_yesterday;
        // 距离上次申购后的累计收益率
        private double rate_lastSubscribe;
        // 过去5个交易日累计收益率
        private double rate_lastWeek;
        // 过去20个交易日累计收益率
        private double rate_lastMonth;


        public TacticsBox(double rate_yesterday, double rate_lastSubscribe, double rate_lastWeek, double rate_lastMonth) {
            this.rate_yesterday = rate_yesterday;
            this.rate_lastSubscribe = rate_lastSubscribe;
            this.rate_lastWeek = rate_lastWeek;
            this.rate_lastMonth = rate_lastMonth;
        }

        // 策略清零，表示一次卖出
        public void clear() {
            this.rate_yesterday = 0;
            this.rate_lastSubscribe = 0;
            this.rate_lastWeek = 0;
            this.rate_lastMonth = 0;
        }

        public double getRate_yesterday() {
            return rate_yesterday;
        }

        public void setRate_yesterday(double rate_yesterday) {
            this.rate_yesterday = rate_yesterday;
        }

        public double getRate_lastSubscribe() {
            return rate_lastSubscribe;
        }

        public void setRate_lastSubscribe(double rate_lastSubscribe) {
            this.rate_lastSubscribe = rate_lastSubscribe;
        }

        public double getRate_lastWeek() {
            return rate_lastWeek;
        }

        public void setRate_lastWeek(double rate_lastWeek) {
            this.rate_lastWeek = rate_lastWeek;
        }

        public double getRate_lastMonth() {
            return rate_lastMonth;
        }

        public void setRate_lastMonth(double rate_lastMonth) {
            this.rate_lastMonth = rate_lastMonth;
        }
    }


}
