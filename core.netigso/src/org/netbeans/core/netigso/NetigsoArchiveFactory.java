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

package org.netbeans.core.netigso;

import org.netbeans.core.netigso.spi.NetigsoArchive;
import org.openide.util.Exceptions;

/**
 *
 * @author Jaroslav Tulach <jtulach@netbeans.org>
 */
public abstract class NetigsoArchiveFactory {
    static NetigsoArchiveFactory DEFAULT;
    static {
        try {
            Class.forName(NetigsoArchive.class.getName(), true, NetigsoArchive.class.getClassLoader());
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    protected NetigsoArchiveFactory() {
        DEFAULT = this;
    }

    protected abstract NetigsoArchive create(Netigso n);
}
