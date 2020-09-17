import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.security.PublicKey;
import java.util.*;

public class Data {
    private JSONArray jsonarray;
    JSONObject jsonObject;
    public Data() {
        jsonarray = new JSONArray();
    }

    public JSONArray getJsonarray() {
        return jsonarray;
    }
    public void init(String dict_address) {
        File file = new File(dict_address);
        File[] fs = file.listFiles();
        for (File f:fs
        ) {
            String fileName = f.getName();
//            System.out.println(fileName.endsWith(".json"));
            if (fileName.endsWith(".json")) {
                try {
                    LineIterator iterator = null;
                    iterator = FileUtils.lineIterator(f, "UTF-8");
                    String line = null;
                    JSONObject itemjsonline = null;
                    while (iterator.hasNext()) {
                        line = iterator.nextLine();
                        itemjsonline = JSONObject.parseObject(line);
                        jsonObject = new JSONObject();
                        jsonObject.fluentPut("user", itemjsonline.getJSONObject("actor").getString("login"));
                        jsonObject.fluentPut("event", itemjsonline.getString("type"));
                        jsonObject.fluentPut("repo", itemjsonline.getJSONObject("repo").getString("name"));
                        jsonarray.add(jsonObject);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public double getEventUsers(String user, String event) {
        double count = 0;
//        System.out.println(user + event);
//        return jsonarray.size();
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject jsonObject = jsonarray.getJSONObject(i);
            String auser = (String) jsonObject.get("user");
            String aevent = (String) jsonObject.get("event");
            if (user.equals(auser)  && event.equals(aevent)
            ) {
                count += 1;
            }
        }
//        System.out.println(count);
        return count;
    }

    public double getEventsRepos(String repo, String event) {
        double count = 0;
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject jsonObject = jsonarray.getJSONObject(i);
            String arepo = (String) jsonObject.get("repo");
            String aevent = (String) jsonObject.get("event");
            if (repo.equals(arepo)  && event.equals(aevent)
            ) {
                count += 1;
            }
        }
        return count;
    }
}
