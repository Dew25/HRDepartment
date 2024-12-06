package ee.ivkhkdev.HRDepartment.helpers;

import ee.ivkhkdev.HRDepartment.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface AppHelper<T> {
    Optional<T> create() throws Exception;
    boolean pirintLits(List<T> ts);
    T update(List<T> ts);
}
