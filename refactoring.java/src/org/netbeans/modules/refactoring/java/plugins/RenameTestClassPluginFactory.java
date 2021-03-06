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
package org.netbeans.modules.refactoring.java.plugins;

import com.sun.source.tree.Tree;
import java.util.EnumSet;
import org.netbeans.api.java.source.TreePathHandle;
import org.netbeans.modules.refactoring.api.AbstractRefactoring;
import org.netbeans.modules.refactoring.api.RenameRefactoring;
import org.netbeans.modules.refactoring.spi.RefactoringPlugin;
import org.netbeans.modules.refactoring.spi.RefactoringPluginFactory;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Ralph Ruijs
 */
@ServiceProvider(service=RefactoringPluginFactory.class)
public class RenameTestClassPluginFactory implements RefactoringPluginFactory {

    @Override
    public RefactoringPlugin createInstance(AbstractRefactoring refactoring) {
        if (refactoring instanceof RenameRefactoring) {
            EnumSet<Tree.Kind> supported = EnumSet.of(Tree.Kind.CLASS, Tree.Kind.ENUM, Tree.Kind.INTERFACE, Tree.Kind.METHOD);
            TreePathHandle handle = refactoring.getRefactoringSource().lookup(TreePathHandle.class);
            if (handle!=null && supported.contains(handle.getKind())) {
                return new RenameTestClassRefactoringPlugin((RenameRefactoring) refactoring);
            }
        }
        return null;
    }
    
}
