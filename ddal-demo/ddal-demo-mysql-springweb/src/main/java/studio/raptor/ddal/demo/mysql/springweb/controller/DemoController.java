/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package studio.raptor.ddal.demo.mysql.springweb.controller;

import java.sql.Timestamp;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import studio.raptor.ddal.demo.mysql.springweb.service.interfaces.DemoService;

/**
 * @author Sam
 * @since 3.0.0
 */
@Controller
public class DemoController {

  @Resource
  private DemoService demoService;

  @ResponseBody
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String sayHello() {
    return "Hello @" + new Timestamp(System.currentTimeMillis());
  }

  @ResponseBody
  @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
  public String queryCustomer(@PathVariable Long customerId) {
    return demoService.queryCustomer(customerId).toString();
  }
}