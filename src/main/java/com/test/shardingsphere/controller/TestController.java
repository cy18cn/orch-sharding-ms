/*
 * Copyright © 2019 Airparking HERE <ryan.cao@airparking.cn>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.shardingsphere.controller;

import com.airparking.cloud.common.AbstractController;
import com.alibaba.fastjson.JSONObject;
import com.test.shardingsphere.entity.ClazzS;
import com.test.shardingsphere.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ryan on 2019-04-04 17:32:45.
 */
@RestController
@RequestMapping("test")
public class TestController extends AbstractController {
    @Autowired
    private TestService testService;

    @RequestMapping("get")
    @ResponseBody
    public ClazzS get(@RequestParam("id") Long id) {
        return this.testService.get(id);
    }

    @RequestMapping("add")
    public Integer add(@RequestParam("body") String pcPriceJson) {
        return this.testService.add(JSONObject.parseObject(pcPriceJson, ClazzS.class));
    }
}