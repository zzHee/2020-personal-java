import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.security.PublicKey;
import java.util.*;

public class Data {
    private JSONArray jsonarray;
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
                    FileReader fileReader = new FileReader(f);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        JSONObject itemjsonline = JSON.parseObject(line);
                        String event = itemjsonline.getString("type");
                        String user = itemjsonline.getJSONObject("actor").getString("login");
                        String repo = itemjsonline.getJSONObject("repo").getString("name");
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.fluentPut("event", event);
                        jsonObject.fluentPut("user", user);
                        jsonObject.fluentPut("repo", repo);
                        System.out.println(jsonObject.toJSONString() + "yeeeeeeeee");
                        jsonarray.add(jsonObject);
                        System.out.println(jsonarray.size());
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
            System.out.print(auser);
            String aevent = (String) jsonObject.get("event");
            System.out.println(aevent);
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
