/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package studio.raptor.sqlparser.ast.statement;

import studio.raptor.sqlparser.ast.SQLStatementImpl;
import studio.raptor.sqlparser.visitor.SQLASTVisitor;

/**
 * MySql cursor close statement
 */
public class SQLCloseStatement extends SQLStatementImpl {

  //cursor name
  private String cursorName;

  public String getCursorName() {
    return cursorName;
  }

  public void setCursorName(String cursorName) {
    this.cursorName = cursorName;
  }

  @Override
  protected void accept0(SQLASTVisitor visitor) {
    visitor.visit(this);
    visitor.endVisit(this);

  }

}
