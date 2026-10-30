package com.coding.module1introduction;

import com.coding.module1introduction.entities.ProductEntity;
import com.coding.module1introduction.entities.UserEntity;
import com.coding.module1introduction.repositories.ProductRepository;
import com.coding.module1introduction.services.JWTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class Module1introductionApplicationTests {
@Autowired
ProductRepository productRepository;
@Autowired
	JWTService jwtService;


    @Test
	void contextLoads() {
		UserEntity userEntity = new UserEntity(5L,"krishna112@gmail.com","Kpandey@123","KP");
		 String token = jwtService.generateToken(userEntity);
		System.out.println("token**********"+token);
		Long id = jwtService.getUserIdFromToken(token);
		System.out.println("My id is "+id);
	}
	@Test
	void testRepository() {
		ProductEntity entity = ProductEntity.builder()
				.title("Red-labl")
				.price(BigDecimal.valueOf(1200000))
				.quantity(800)
				.sku("Tata-Tea")
				.build();
		//productRepository.save(entity);

	}
	@Test
	void getRepository() {
		List<ProductEntity> list = productRepository.findAll();
		System.out.println(list);
	}
	@Test
	void getRepositoryByAttributes() {
		ProductEntity list = productRepository.findBytitle("Fruity");
		System.out.println(list);
	}
	@Test
	void getRepositoryBySku() {
		ProductEntity list = productRepository.findBysku("Pepsi T34");
		System.out.println(list);
	}

}
