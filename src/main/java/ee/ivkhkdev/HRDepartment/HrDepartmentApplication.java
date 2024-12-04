package ee.ivkhkdev.HRDepartment;

import ee.ivkhkdev.HRDepartment.input.Input;
import ee.ivkhkdev.HRDepartment.service.EmployeeService;
import ee.ivkhkdev.HRDepartment.service.PersonService;
import ee.ivkhkdev.HRDepartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrDepartmentApplication implements CommandLineRunner {
	@Autowired
	private Input input;
    @Autowired
    private EmployeeService employeeService;
	@Autowired
	private PersonService personService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(HrDepartmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean repeat = true;
		do{
			System.out.println("Список задач:");
			System.out.println("0. Выход:");
			System.out.println("1. Добавить пользователя:");
			System.out.println("2. Список пользователей:");
			System.out.println("3. Изменить данные пользователя:");


			System.out.print("Введите номер задачи: ");
			int task = Integer.parseInt(input.nextLine());
			switch (task){
				case 0:
					repeat = false;
					break;
				case 1:
					if(userService.add()) {
						System.out.println("Пользователь добавлен");
					}else{
						System.out.println("Пользователя добавить не удалось");
					};
					break;
				case 2:
					if(userService.print()){

					};
					break;
				case 3:
					userService.edit();
					break;
				default:
					System.out.println("Выберите номер задачи из списка!");
					break;
			}
		}while(repeat);
		System.out.println("До свидания");
	}
}
