package ee.ivkhkdev.HRDepartment.helpers;

import java.util.List;
import java.util.Optional;

public interface AppHelper<T> {
    Optional<T> create();
    boolean pirintLits(List<T> entities);
    List<T> update(List<T> entities);
}
