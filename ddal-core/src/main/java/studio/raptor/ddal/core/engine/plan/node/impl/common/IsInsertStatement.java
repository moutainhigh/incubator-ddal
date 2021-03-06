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

package studio.raptor.ddal.core.engine.plan.node.impl.common;

import studio.raptor.ddal.config.model.shard.Table;
import studio.raptor.ddal.core.engine.ProcessContext;
import studio.raptor.ddal.core.engine.plan.node.ForkingNode;
import studio.raptor.ddal.core.parser.result.SQLStatementType;

/**
 * @author Sam
 * @since 3.0.0
 */
public class IsInsertStatement extends ForkingNode {

  @Override
  protected int judge(ProcessContext context) {
    return judge0(context) ? 0 : 1;
  }

  private boolean judge0(ProcessContext context){
    //判断是否为Insert语句
    if(context.getSqlStatementType() == SQLStatementType.INSERT){
      Table table = context.getShardTables().get(0);
      //判断分片数量是否大于1
      if(table.getDatabaseShards().size() > 1){
        return true;
      }
    }
    return false;
  }
}
