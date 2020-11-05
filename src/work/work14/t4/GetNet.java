package work.work14.t4;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.StringTokenizer;

public class GetNet implements Runnable {
    Root data;
    String question;
    final static String BASE_URL = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=";

    public GetNet(String question) {
        this.question = question;
    }

    @Override
    public void run() {
        try {
            String url = BASE_URL + URLEncoder.encode(question, "utf-8");
            String strpar = util.getJsonString(url);
            data = util.resolveRoot(strpar);
            //·ÖÐÐ
            StringTokenizer stringTokenizer = new StringTokenizer(data.getContent(), "{br}");
            while (stringTokenizer.hasMoreTokens()) {
                System.out.println(stringTokenizer.nextToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
