package ee.ivkhkdev.HRDepartment.service;

import java.util.List;

public interface AppService<T> {
    boolean add();
    boolean edit();
    boolean print(List<T> entities);
}
