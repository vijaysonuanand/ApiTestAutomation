package local;

import java.util.HashMap;

public class ScenarioContext {
    private HashMap<String, String> map = new HashMap<>();

    public void setValue(String key, String value){
        map.put(key, value);
    }

    public String getValue(String key){
        return map.get(key);
    }
}
