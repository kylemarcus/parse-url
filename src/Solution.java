import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Map<String, String> urlArgs = getUrlArgs("http://www.google.com/foo?a=aaa&b=bbb");

        System.out.println("Num of args: " + urlArgs.size());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry urlArgument : urlArgs.entrySet()) {
            sb.append("Key: ").append(urlArgument.getKey()).append("\n");
            sb.append("Value: ").append(urlArgument.getValue()).append("\n\n");
        }
        System.out.println(sb);
    }

    /***
     * Parses out arguments from a url, special characters must be url encoded.
     * @param url
     * @return Map of key value argument pairs
     */
    public static Map<String, String> getUrlArgs(String url) {
        Map<String, String> urlArgumentsMap = new HashMap<>();

        if (url == null) {
            return urlArgumentsMap;
        }

        String[] urlSplitByQuestion = url.split("\\?");
        if (urlSplitByQuestion.length != 2){
            return urlArgumentsMap;
        }

        String[] urlArgumentsList = urlSplitByQuestion[1].split("&");

        for (String urlArgument : urlArgumentsList) {
            String[] argumentSplitByEquals = urlArgument.split("=");
            String argKey = argumentSplitByEquals[0];
            String argValue = (argumentSplitByEquals.length < 2) ? null : argumentSplitByEquals[1];
            urlArgumentsMap.put(argKey, argValue);
        }

        return urlArgumentsMap;
    }

}
