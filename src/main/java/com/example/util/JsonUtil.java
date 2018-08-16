package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json数据处理类
 * @Autowired constanting_F
 */
public class JsonUtil {

//    ---------------------------Map--------------------------
    /**
     * jsonStr转HashMap<></>
     * @param jsonStr
     * @return
     */
    public static Map<Object,Object> mapFromJsonStr(String jsonStr){
        Map<Object,Object> resultMap = new HashMap<>();
        resultMap = JSONObject.parseObject(jsonStr,Map.class);
        return resultMap;
    }

    /**
     * map转jsonObject
     * @param dataMap
     * @return
     */
    public static JSONObject mapToJsonObj(Map<Object,Object> dataMap){
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(dataMap));
        return jsonObject;
    }

    /**
     * mao转jsonStr
     * @param dataMap
     * @return
     */
    public static String mapToJsonStr(Map<Object,Object> dataMap){
        String JsonStr = JSON.toJSONString(dataMap);
        return JsonStr;
    }

//    -------------------------------List-------------------------------

    /**
     * list转jsonStr
     * @param dataList
     * @return
     */
    public static JSONObject listToJsonObj(List<Object> dataList){
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(dataList));
        return jsonObject;
    }

    /**
     * list转jsonStr
     * @param list
     * @return
     */
    public static String listToJsonStr(List<Object> list){
        String jsonStr = JSON.toJSONString(list);
        return jsonStr;
    }

    /**
     * jsonStr转list
     * @param jsonStr
     * @return
     */
    public List<Object> listFromJsonStr(String jsonStr){
        List<Object> list = new ArrayList<>();
        list = JSONObject.parseObject(jsonStr,List.class);
        return list;
    }

    public static void main(String[] args) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("test1","demmo1");
//        map.put("test2","demo2");
//        String str = JSONObject.toJSONString(map);
//        System.out.println(str);
//        Map<String,Object> map = JsonUtil.mapFromJsonStr("{\"test2\":\"demo2\",\"test1\":\"demmo1\"}");
//        map.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v);
//        });

    }
}
