/*
 * Copyright 2022 VMware, Inc.
 * SPDX-License-Identifier: MIT
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package org.dbsp.sqlCompiler.dbsp.circuit.expression;

import org.apache.calcite.rex.RexNode;
import org.dbsp.sqlCompiler.dbsp.circuit.type.DBSPType;
import org.dbsp.sqlCompiler.dbsp.circuit.type.DBSPTypeString;
import org.dbsp.util.IndentStringBuilder;

import javax.annotation.Nullable;

public class DBSPFieldExpression extends DBSPExpression {
    private final int fieldNo;

    public DBSPFieldExpression(@Nullable RexNode node, int fieldNo, DBSPType type) {
        super(node, type);
        this.fieldNo = fieldNo;
    }

    @Override
    public IndentStringBuilder toRustString(IndentStringBuilder builder) {
        IndentStringBuilder result = builder.append("t.").append(this.fieldNo);
        if (this.getType().is(DBSPTypeString.class))
            result.append(".clone()");
        return result;
    }
}
