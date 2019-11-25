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
package com.test.shardingsphere.dao;

import com.airparking.cloud.common.dao.AbstractDAO;
import com.test.shardingsphere.entity.ClazzS;

/**
 * Created by ryan on 2019-04-04 17:32:45.
 */
public interface TestDAO extends AbstractDAO<ClazzS, Long> {
}