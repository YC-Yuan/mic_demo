import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class testAPI {
    public static void main(String[]args) throws IOException {
        String talk = talk("晚上吃什么");
    }

    public static String talk(String question) throws IOException {
        String info = URLEncoder.encode(question, "utf-8");
        String APIkey = "4fedeb6d58814f1f934821e33892151f";
        String getUrl = "http://www.tuling123.com/openapi/api?key="
                +APIkey+"&info="+info;
        URL url = new URL(getUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while((line = br.readLine()) != null){
            stringBuilder.append(line);
        }
        String result = stringBuilder.substring(stringBuilder.lastIndexOf(":")+2,stringBuilder.length()-2);
        System.out.print(result);
        return  result;
    }
}
