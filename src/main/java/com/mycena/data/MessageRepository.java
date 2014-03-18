/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.mycena.data;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

/**
 * Manages {@link Message} instances
 *
 * @author Rob Winch
 *
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findByToId(Long id);

    //@PostAuthorize("returnObject?.to?.id == principal?.id")
    Message findOne(Long id);
    @Query("from Message where id > :id")
    List<Message> findWithMaxOrder(long id);
}
