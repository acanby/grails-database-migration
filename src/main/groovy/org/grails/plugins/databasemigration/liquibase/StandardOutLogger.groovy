/*
 * Copyright 2015 original authors
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
package org.grails.plugins.databasemigration.liquibase

import groovy.transform.CompileStatic
import liquibase.logging.LogLevel
//import liquibase.logging.core.DefaultLogger
import liquibase.logging.core.Slf4jLogger
import liquibase.util.StringUtils
import org.slf4j.Logger

import java.text.DateFormat

@CompileStatic
class StandardOutLogger extends Slf4jLogger {

    final int priority = 5

    String name

    StandardOutLogger(Logger logger) {
        super(logger)
    }

    protected void print(LogLevel logLevel, String message) {
        if (StringUtils.trimToNull(message) == null) {
            return
        }

        println("${logLevel} ${DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date())}: ${name}: ${message}")
    }
}
