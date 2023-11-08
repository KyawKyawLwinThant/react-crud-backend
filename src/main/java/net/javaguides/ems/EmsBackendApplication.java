package net.javaguides.ems;

import lombok.RequiredArgsConstructor;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmsBackendApplication {
	private final EmployeeRepository employeeRepository;
	@Bean@Profile("test")
	public ApplicationRunner runner(){
		return r ->{
			List.of(
					new Employee(null,"John","Doe","john@gmail.com"),
					new Employee(null,"John","William","william@gmail.com"),
					new Employee(null,"Thomas","Hardy","hardy@gmail.com"),
					new Employee(null,"Richard","Chan","richard@gmail.com"),
					new Employee(null,"John","Updike","updike@gmail.com")
			).forEach(employeeRepository::save);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}

}
