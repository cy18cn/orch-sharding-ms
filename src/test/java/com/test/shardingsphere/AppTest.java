package com.test.shardingsphere;

import static org.junit.Assert.assertTrue;

import com.airparking.cloud.common.utils.APDateUtils;
import com.airparking.cloud.common.utils.HashUtils;
import com.airparking.cloud.common.utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Data
    class TestJSONDate {
        @JSONField(format="yyyy-MM-dd HH:mm:ss")
        private Date now;
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException, ParseException {
        TestJSONDate jsonDate = new TestJSONDate();
        jsonDate.setNow(new Date());

        Map<String, Object> msg = JsonUtils.toMap(JSON.toJSONString(jsonDate));
        Date now = APDateUtils.parseDateTime(msg.get("now").toString());
    }

    @Test
    public void testMD5() {
//        Executors.newCachedThreadPool()
        System.out.println(String.format("appId=%s&timestamp=%s", "apphVPWVBVgY35GibD", "1578369676465"));
        System.out.println(
                HashUtils.md5(String.format("appId=%s&timestamp=%s", "apphVPWVBVgY35GibD", "1578369676465")));
    }

}
