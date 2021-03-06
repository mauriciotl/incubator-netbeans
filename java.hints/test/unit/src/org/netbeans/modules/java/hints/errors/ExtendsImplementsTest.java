/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.java.hints.errors;

import org.netbeans.modules.java.hints.infrastructure.ErrorHintsTestBase;

/**
 *
 * @author lahvac
 */
public class ExtendsImplementsTest extends ErrorHintsTestBase {

    public ExtendsImplementsTest(String name) {
        super(name, ExtendsImplements.class);
    }
    
    public void testExtends2Implements() throws Exception {
        performFixTest("test/Test.java",
                       "package test;\n" +
                       "public class Test extends Runnable {\n" +
                       "}\n",
                       -1,
                       Bundle.FIX_Extend2Implements("Runnable"),
                       ("package test;\n" +
                        "public class Test implements Runnable {\n" +
                        "}\n").replaceAll("\\s+", " "));
    }
    
    public void testImplements2Extends() throws Exception {
        performFixTest("test/Test.java",
                       "package test;\n" +
                       "public class Test implements Object {\n" +
                       "}\n",
                       -1,
                       Bundle.FIX_Implements2Extend("Object"),
                       ("package test;\n" +
                        "public class Test extends Object {\n" +
                        "}\n").replaceAll("\\s+", " "));
    }
}