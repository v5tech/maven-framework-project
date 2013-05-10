/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.fengjing.framework.shiro;

import javax.sql.DataSource;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * A data populator that creates a set of security tables and test data that can be used by the
 * Shiro Spring sample application to demonstrate the use of the {@link org.apache.shiro.realm.jdbc.JdbcRealm}
 * The tables created by this class follow the default table and column names that {@link org.apache.shiro.realm.jdbc.JdbcRealm} uses.
 *
 */
public class BootstrapDataPopulator implements InitializingBean {

    private static final String CREATE_TABLES = "create table users (\n" +
            "    username varchar(255) primary key,\n" +
            "    password varchar(255) not null\n" +
            ");\n" +
            "\n" +
            "create table roles (\n" +
            "    role_name varchar(255) primary key\n" +
            ");\n" +
            "\n" +
            "create table user_roles (\n" +
            "    username varchar(255) not null,\n" +
            "    role_name varchar(255) not null,\n" +
            "    constraint user_roles_uq unique ( username, role_name )\n" +
            ");\n" +
            "\n" +
            "create table roles_permissions (\n" +
            "    role_name varchar(255) not null,\n" +
            "    permission varchar(255) not null,\n" +
            "    primary key (role_name, permission)\n" +
            ");";

    private static final Logger log = LoggerFactory.getLogger(BootstrapDataPopulator.class);

    protected DataSource dataSource = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void afterPropertiesSet() throws Exception {
        //because we're using an in-memory hsqldb for the sample app, a new one will be created each time the
        //app starts, so create the tables and insert the 2 sample users on bootstrap:

        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        //jdbcTemplate.execute(CREATE_TABLES);
        
        
        System.out.println(CREATE_TABLES);
        
        //password is 'admin' SHA hashed and base64 encoded:
        //The first argument to the hash constructor is the actual value to be hased.  The 2nd is the
        //salt.  In this simple demo scenario, the username and the password are the same, but to clarify the
        //distinction, you would see this in practice:
        //new Sha256Hash( <password>, <cryptographically strong randomly generated salt> (not the username!) )
        String query = "insert into users values ('admin', '" + new Sha256Hash("admin", "admin").toBase64() + "' )";
        jdbcTemplate.execute(query);
        log.debug("创建admin用户.");

        //password is 'user' SHA hashed and base64 encoded:
        query = "insert into users values ( 'user', '"  + new Sha256Hash("user", "user").toBase64() + "' )";
        jdbcTemplate.execute(query);
        log.debug("创建user用户.");

        query = "insert into roles values ( 'Admin' )";
        jdbcTemplate.execute(query);
        log.debug("创建 Admin角色");

        query = "insert into roles values ( 'User' )";
        jdbcTemplate.execute(query);
        log.debug("创建 User角色");

        query = "insert into roles_permissions values ( 'Admin', 'user:view')";
        jdbcTemplate.execute(query);
        log.debug("给Admin角色创建user:view权限");

        query = "insert into roles_permissions values ( 'Admin', 'user:edit')";
        jdbcTemplate.execute(query);
        log.debug("给Admin角色创建user:edit权限");

        query = "insert into roles_permissions values ( 'User', 'user:view')";
        jdbcTemplate.execute(query);
        log.debug("给User角色创建user:view权限");

        query = "insert into user_roles values ( 'admin', 'Admin' )";
        jdbcTemplate.execute(query);
        query = "insert into user_roles values ( 'admin', 'User' )";
        jdbcTemplate.execute(query);
        log.debug("给admin用户分配Admin和 User角色");

        query = "insert into user_roles values ( 'user', 'User' )";
        jdbcTemplate.execute(query);
        log.debug("给user用户分配 User角色");
    }

}
