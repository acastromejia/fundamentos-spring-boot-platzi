package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplements") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Ariel", "arielcastromejia@gmail.com", LocalDate.of(2023,01,1));
		User user2 = new User("Carlos", "carloscastromejia@gmail.com", LocalDate.of(2023,02,2));
		User user3 = new User("Laura", "laura@gmail.com", LocalDate.of(2023,03,3));
		User user4 = new User("Carla", "carla@gmail.com", LocalDate.of(2023,04,4));
		User user5 = new User("Saul", "saul@gmail.com", LocalDate.of(2023,05,5));
		User user6 = new User("Kevin", "kevin@gmail.com", LocalDate.of(2023,06,6));
		User user7 = new User("Kennet", "kennet@gmail.com", LocalDate.of(2023,07,7));
		User user8 = new User("Olvin", "olvin@gmail.com", LocalDate.of(2023,8,8));
		User user9 = new User("Hector", "hector@gmail.com", LocalDate.of(2023,9,9));
		User user10 = new User("Ana", "ana@gmail.com", LocalDate.of(2023,10,10));
		User user11 = new User("Elisa", "elisa@gmail.com", LocalDate.of(2023,11,11));
		User user12 = new User("Tiffany", "tiffany@gmail.com", LocalDate.of(2023,12,12));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		list.stream().forEach(userRepository::save);
	}

	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " " + userPojo.getAge());

		try {
			//error
			int value = 10/0;
			LOGGER.debug("Mi valor:" + value);
		}catch (Exception e) {
			LOGGER.error("esto es un error del aplicativo al dividir " + e.getStackTrace());
		}
	}

}
