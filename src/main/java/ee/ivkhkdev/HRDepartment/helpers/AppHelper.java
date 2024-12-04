package ee.ivkhkdev.HRDepartment.helpers;

import java.util.Optional;

public interface AppHelper<T> {
    Optional<T> create();
    boolean pirintLits();
    T update();
}
