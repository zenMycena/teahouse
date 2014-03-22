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
package com.mycena.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.mycena.data.MenuItemRepository;
import com.mycena.data.Message;
import com.mycena.data.MessageRepository;
import com.mycena.data.OrderListRepository;
import com.mycena.data.OrderRepository;
import com.mycena.data.UserRepository;

/**
 * Initializes spring Configuration for Spring Data and our {@link DataSource}.
 *
 * @author Rob Winch
 *
 */
@Configuration
@EnableJpaRepositories(basePackages="com.mycena.data",
includeFilters = {@ComponentScan.Filter(value = {UserRepository.class}, type = FilterType.ASSIGNABLE_TYPE),
							  @ComponentScan.Filter(value = {MessageRepository.class}, type = FilterType.ASSIGNABLE_TYPE),
							  @ComponentScan.Filter(value = {OrderListRepository.class}, type = FilterType.ASSIGNABLE_TYPE),
							  @ComponentScan.Filter(value = {OrderRepository.class}, type = FilterType.ASSIGNABLE_TYPE),
							  @ComponentScan.Filter(value = {MenuItemRepository.class}, type = FilterType.ASSIGNABLE_TYPE)
						})
public class DataConfiguration {
    @Bean
    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();        
//        return builder.setType(EmbeddedDatabaseType.H2).build();
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:mem:teapatea;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;INIT=CREATE SCHEMA IF NOT EXISTS TEST");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.H2);
        vendorAdapter.setGenerateDdl(true);
        
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.mycena.data");
        factory.setDataSource(dataSource());

        return factory;
    }

    @Bean
    @DependsOn("entityManagerFactory")
    public ResourceDatabasePopulator initDatabase(DataSource dataSource) throws Exception {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("data.sql"));
        populator.populate(dataSource.getConnection());
        return populator;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }
}
