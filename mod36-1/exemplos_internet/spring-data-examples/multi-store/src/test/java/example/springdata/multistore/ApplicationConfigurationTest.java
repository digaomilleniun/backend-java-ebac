/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.springdata.multistore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;

import example.springdata.multistore.customer.Address;
import example.springdata.multistore.customer.Customer;
import example.springdata.multistore.customer.CustomerRepository;
import example.springdata.multistore.shop.LineItem;
import example.springdata.multistore.shop.Order;
import example.springdata.multistore.shop.OrderRepository;

/**
 * Integration test to check repository interfaces are assigned to the correct store modules.
 *
 * @author Oliver Gierke
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConfigurationTest {

	@Autowired ApplicationContext context;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository custumerRepository;

	@Test
	public void repositoriesAreAssignedToAppropriateStores() {

		var repositories = new Repositories(context);

		assertThat(repositories.getEntityInformationFor(Customer.class)).isInstanceOf(JpaEntityInformation.class);
		assertThat(repositories.getEntityInformationFor(Order.class)).isInstanceOf(MongoEntityInformation.class);
	}
	
	@Test
	public void cadastrarMongo() {
		LineItem itens = new LineItem("t1", 1);
		Order order = new Order("1", new Date().from(Instant.now()), List.of(itens));
		Order newOrder = orderRepository.save(order);
		
		assertNotNull(newOrder);
	}
	
	@Test
	public void cadastrarJpa() {
		Address address = new Address();
		Point point = new Point(1,2);
		address.setLocation(point);
		address.setStreet("Rua 3");
		address.setZipCode("11111000");
		
		Customer custumer = new Customer("Teste", "Rodrigo", address);
		custumerRepository.save(custumer);
	}
}
