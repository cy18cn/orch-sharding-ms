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
import com.test.shardingsphere.entity.Test;
import com.test.shardingsphere.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Test get(@RequestParam("id") Long id) {
        return this.testService.get(id);
    }

    @RequestMapping("add")
    public Integer add(@RequestBody Test test) {
        return this.testService.add(test);
    }
}