package ee.ivkhkdev.HRDepartment;

import ee.ivkhkdev.HRDepartment.input.Input;
import ee.ivkhkdev.HRDepartment.service.EmployeeService;
import ee.ivkhkdev.HRDepartment.service.PersonService;
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

	public static void main(String[] args) {
		SpringApplication.run(HrDepartmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean repeat = true;
		do{
			System.out.println("Список задач:");
			System.out.println("0. Выход:");
			System.out.println("1. Добавить работника:");
			System.out.println("2. Добавить персону:");
			System.out.print("Введите номер задачи: ");
			int task = Integer.parseInt(input.nextLine());
			switch (task){
				case 0:
					repeat = false;
					break;
				case 1:
					if(employeeService.add()) {
						System.out.println("Работник добавлен");
					}else{
						System.out.println("Работника добавить не удалось");
					};
					break;
				case 2:
					if(personService.add()) {
						System.out.println("Персона добавлена");
					}else{
						System.out.println("Персону добавить не удалось");
					};
					break;
				default:
					System.out.println("Выберите номер задачи из списка!");
					break;
			}
		}while(repeat);
		System.out.println("До свидания");
	}
}
