import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest {

    @Test
    void GetUrlArgs_WithNullUrl_ReturnsEmptyMap() {
        String url = null;
        Map<String, String> expectedUrlArgs = new HashMap<>();

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithZeroArguments_ReturnsEmptyMap() {
        String url = "http://www.google.com/foo";
        Map<String, String> expectedUrlArgs = new HashMap<>();

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithZeroArgumentsPlusQuestionsMark_ReturnsEmptyMap() {
        String url = "http://www.google.com/foo?";
        Map<String, String> expectedUrlArgs = new HashMap<>();

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithOneArgument_ReturnsCorrectMapping() {
        String url = "http://www.google.com/foo?foo=bar";
        Map<String, String> expectedUrlArgs = new HashMap<>();
        expectedUrlArgs.put("foo", "bar");

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithTwoArguments_ReturnsCorrectMapping() {
        String url = "http://www.google.com/foo?a=aaa&b=bbb";
        Map<String, String> expectedUrlArgs = new HashMap<>();
        expectedUrlArgs.put("a", "aaa");
        expectedUrlArgs.put("b", "bbb");

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithTwoQuestionMarks_ReturnsEmptyMap() {
        String url = "http://www.google.com/foo?a=aa?a&b=bbb";
        Map<String, String> expectedUrlArgs = new HashMap<>();

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithTwoEqualsInValue_ReturnsCorrectMapWithFirstValueBeforeEquals() {
        String url = "http://www.google.com/foo?a=aa=a&b=bbb";
        Map<String, String> expectedUrlArgs = new HashMap<>();
        expectedUrlArgs.put("a", "aa");
        expectedUrlArgs.put("b", "bbb");

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    @Test
    void GetUrlArgs_WithNoArgValue_ReturnsCorrectMapWithNullArgValue() {
        String url = "http://www.google.com/foo?a=&b=bbb";
        Map<String, String> expectedUrlArgs = new HashMap<>();
        expectedUrlArgs.put("a", null);
        expectedUrlArgs.put("b", "bbb");

        TestGetUrlArgs(url, expectedUrlArgs);
    }

    void TestGetUrlArgs(String url, Map<String, String> expectedMap) {
        Map<String, String> urlArgs = Solution.getUrlArgs(url);
        Assertions.assertEquals(urlArgs, expectedMap);
    }
}