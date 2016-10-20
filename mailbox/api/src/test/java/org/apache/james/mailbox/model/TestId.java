/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/
package org.apache.james.mailbox.model;

public class TestId implements MailboxId {

    public static class Factory implements MailboxId.Factory {
        
        @Override
        public MailboxId fromString(String serialized) {
            return TestId.of(Long.valueOf(serialized));
        }
    }
    
    public static TestId of(long id) {
        return new TestId(id);
    }

    public final Long id;

    private TestId(long id) {
        this.id = id;
    }

    @Override
    public String serialize() {
        return String.valueOf(id);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof TestId
            && id.equals(((TestId)other).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}