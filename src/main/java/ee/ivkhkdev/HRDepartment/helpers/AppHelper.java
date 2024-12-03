package ee.ivkhkdev.HRDepartment.helpers;

import java.util.List;
import java.util.Optional;

public interface AppHelper<T> {
    Optional<T> create();
    boolean pirintLits();
    boolean update(T t);
}
