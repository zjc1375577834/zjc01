package springboot.testng.core.dto;


import java.util.Map;

/**
 * create by zjc in 2020/5/12 0012
 */
public class ParamsMap {

    private Map<String,String> header;
    private Map<String,String> params;
    private Map<String,String> results;

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }
}
