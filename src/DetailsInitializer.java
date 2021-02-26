import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Munin
 * Created by Munin on 2021/2/25
 */
public class DetailsInitializer {


    private String url;

    public DetailsInitializer(String fundCode) {
        this.url = "https://fundf10.eastmoney.com/F10DataApi.aspx?type=lsjz&code="
                + fundCode
                + "&sdate=2018-09-05&edate=2021-02-24&per=40&page=";
    }

    public List<FundDetailBean> initFundDetail() throws Exception {
        int pageSize = getPage();
        List<FundDetailBean> beans = new ArrayList<>();
        for (int i = 1; i < pageSize; i++) {
            beans.addAll(getDetailBeanPerPage(i));
        }
        return beans;
    }

    private int getPage() throws IOException {
        Document document = Jsoup.connect(url + "1").get();
        Elements bodyElements = document.select("body");
        String wholeStr = bodyElements.get(0).text();
        int strIndex = wholeStr.lastIndexOf("pages:");
        int endIndex = wholeStr.lastIndexOf(",");
        String pageStr = wholeStr.substring(strIndex + 6, endIndex);
        return Integer.parseInt(pageStr);
    }

    private List<FundDetailBean> getDetailBeanPerPage(int page) throws IOException, ParseException {
        String urlPerPage = url + String.valueOf(page);
        Document document = Jsoup.connect(urlPerPage).get();
        List<FundDetailBean> fundDetailBeans = new ArrayList<>();
        Elements trElements = document.select("tr");
        for (int i = 1; i < trElements.size(); i++) {
            Element tr = trElements.get(i);
            Elements tdElements = tr.select("td");
            fundDetailBeans.add(handleTdElement(tdElements));
        }
        return fundDetailBeans;
    }

    private FundDetailBean handleTdElement(Elements tdElements) throws ParseException {
        return FundDetailBean.create(
                tdElements.get(0).text(),
                strToDouble(tdElements.get(1).text()),
                strToDouble(tdElements.get(2).text()),
                percentageToDouble(tdElements.get(3).text()),
                tdElements.get(4).text(),
                tdElements.get(5).text()
        );
    }

    private double strToDouble(String str) {
        if (str == null || str.equals("")) {
            return Double.MIN_VALUE;
        }
        double d = Double.parseDouble(str);
        BigDecimal bigDecimal = new BigDecimal(d);
        return bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private double percentageToDouble(String str) {
        if (str == null || str.equals("")) {
            return Double.MIN_VALUE;
        }
        double d = Double.parseDouble(str.replace("%", "")) / 100;
        BigDecimal bigDecimal = new BigDecimal(d);
        return bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
