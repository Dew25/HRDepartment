package ee.ivkhkdev.HRDepartment.input;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);
    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
