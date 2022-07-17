package com.juran.bFans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juran.bFans.confing.Mail;
import com.juran.bFans.entity.FansVo;
import com.juran.bFans.task.BiliBiliMonitoring;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BFansApplication.class)
class BFansApplicationTests {
	Mail mail;

	@Autowired
	public void setMail(Mail mail) {
		this.mail = mail;
	}

	@Test
	void contextLoads() throws IOException, MessagingException {
		BiliBiliMonitoring biliBiliMonitoring = new BiliBiliMonitoring();
		biliBiliMonitoring.FansAnd();
	}

	@Test
	void converJson() throws JsonProcessingException {
		String json = "{\n" +
				"\"code\": 0,\n" +
				"\"message\": \"0\",\n" +
				"\"ttl\": 1,\n" +
				"\"data\": {\n" +
				"\"mid\": 473603326,\n" +
				"\"following\": 102,\n" +
				"\"whisper\": 0,\n" +
				"\"black\": 0,\n" +
				"\"follower\": 225826\n" +
				"}\n" +
				"}";
		ObjectMapper objectMapper = new ObjectMapper();
		Map map = null;
		try {
			map = objectMapper.readValue(json, Map.class);
			System.out.println(map + "56行");
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		//获取所有key
		/*for (Object key:map.keySet()){
			System.out.println(map.get(key));
		}*/

		//获取所有key 再 获取所有values
	/*	Set set = map.keySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
			System.out.println(map.get(iterator.next()));
		}*/

		//直接获取值
		/*Collection values = map.values();
		for (Object value:values){
			System.out.println(value);
		}*/

		Object data = map.get("data");
		//将map数据转换成json字符串格式.
		String s = JSONObject.toJSONStringWithDateFormat(data, JSON.DEFFAULT_DATE_FORMAT);
		//将json字符串转换成实体.
		FansVo fansVo = objectMapper.readValue(s, FansVo.class);
		System.out.println(fansVo);

	}

	@Test
	void params() {
		String cc = mail.sender;
		System.out.println(cc);
	}
}
