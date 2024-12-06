package ee.ivkhkdev.HRDepartment.service;

import java.util.List;

public interface AppService<T> {
    boolean add() throws Exception;
    boolean edit();
    boolean print();

}
