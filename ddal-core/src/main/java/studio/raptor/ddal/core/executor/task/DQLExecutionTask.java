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

package studio.raptor.ddal.core.executor.task;

import java.sql.SQLException;
import java.util.Map;
import studio.raptor.ddal.core.connection.ContextConnectionWrapper;
import studio.raptor.ddal.core.executor.ExecutionUnit;
import studio.raptor.ddal.core.executor.resultset.ResultData;

/**
 * DQL语句执行任务
 *
 * @author Charley
 * @since 1.0
 */
public class DQLExecutionTask extends ExecutionTask {

  public DQLExecutionTask(Map<String, ContextConnectionWrapper> connectionsWrapper,
      ExecutionUnit executionUnit) {
    super(connectionsWrapper, executionUnit);
  }

  /**
   * 执行方法
   */
  @Override
  protected ResultData doExecute() throws SQLException {
    ResultData resultData;
    if (isPrepared) {
      resultData = this.executionUnit.getConnection().executePreparedQuery(sql, parameters);
    } else {
      resultData = this.executionUnit.getConnection().executeQuery(sql);
    }
    return resultData;
  }
}
