package data;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    public Optional<T> getById(ObjectId id);

    public List<T> getAll();

    public void save(T o);

    public void saveAll(List<T> objs);

    public void deleteById(ObjectId id);
}
