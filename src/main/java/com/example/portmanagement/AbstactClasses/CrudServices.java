package com.example.portmanagement.AbstactClasses;

import com.example.portmanagement.BaseInterfaces.IBaseCrudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudServices<T> implements IBaseCrudService<T> {

    protected abstract JpaRepository<T , Long> getRepository();

    public T create(T t){
        try {
            return  getRepository().save(t);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Override
    public T update(long id, T t) {
        if (getRepository().existsById(id)) {
            return getRepository().save(t);
        } else {
            throw new RuntimeException("Entity with id " + id + " not found");
        }
    }

    @Override
    public T findById(long id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
    }

    @Override
    public void delete(long id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }
}
