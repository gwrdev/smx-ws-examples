/*
 * Copyright 2012 FuseSource
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fusesource.examples.greeter.impl;

import org.slf4j.*;
import com.fusesource.examples.greeter.Greeter;
import com.fusesource.examples.greeter.PingMeFault;
import com.fusesource.examples.greeter.model.FaultDetail;

public class ConcreteGreeter implements Greeter {
  private Logger log = LoggerFactory.getLogger(this.getClass());
    
  public void greetMeOneWay(String name) {
     name += "(SvCon greetMeOneWay)";
     log.info("SvCon ==="+name);
     log.info(greet(name));
  }

  public String sayHi(String name) {
     name += "(SvCon sayHi)";
     log.info("SvCon ==="+name);
     return greet(name);
  }

  public String greetMe(String name) {
     name += "(SvCon greetMe)";
     log.info("SvCon ==="+name);
     return greet(name);
  }

  public void pingMe() throws PingMeFault {
     FaultDetail faultDetail = new FaultDetail();
     faultDetail.setMajor((short)2);
     faultDetail.setMinor((short)1);
     log.info("Executing operation pingMe, throwing PingMeFault exception\n");
     throw new PingMeFault("PingMeFault raised by server", faultDetail);
  }

  private String greet(String name) {
    return name;
  }
}
