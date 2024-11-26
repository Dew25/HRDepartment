package ee.ivkhkdev.HRDepartment.helpers;

import java.util.List;

public interface AppHelper<T> {
    T create();
    boolean pirintLits(List<T> entities);
    List<T> update(List<T> entities);
}
