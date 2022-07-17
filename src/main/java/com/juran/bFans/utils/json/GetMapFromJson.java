package com.juran.bFans.utils.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juran.bFans.entity.FansVo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者： Juran on 2022-07-17 11:53
 * 作者博客：iit.la
 */
public class GetMapFromJson {
    static ObjectMapper objectMapper =null;
    static FansVo fansVo = null;

   //返回粉丝及关注者信息
    public static FansVo getInfo(String json){
        objectMapper = new ObjectMapper();
        Map map = null;
        try {
            String s = JSONObject.toJSONStringWithDateFormat(json, JSON.DEFFAULT_DATE_FORMAT);
            System.out.println(s);
            //json字符串转换map
            map = objectMapper.readValue(json, Map.class);
            fansVo = objectMapper.readValue(JSONObject.toJSONStringWithDateFormat(map.get("data"), JSON.DEFFAULT_DATE_FORMAT),
                    FansVo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return fansVo;
    }
}
