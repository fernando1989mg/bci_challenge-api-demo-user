package cl.demo.user.service;

import cl.demo.user.domain.exception.ResourceNotFoundException;
import cl.demo.user.repository.IGenericRepo;
import cl.demo.user.domain.exception.RegisterException;

import java.util.Optional;

public abstract class GenericService<T, ID>{

    protected abstract IGenericRepo<T, ID> getRepo();

    public T register(T obj) {

        T data = getRepo().save(obj);

        Optional<T> optionalData = Optional.of(data);

        return optionalData.orElseThrow(() -> new RegisterException("the data could not be stored"));
    }

    public T modify(T obj) {
        return getRepo().save(obj);
    }

    public T getById(ID id) {

        T data = getRepo().findById(id).orElse(null);

        if(data == null){
            throw new ResourceNotFoundException("Resource with id " + id +" not found");
        }

        return data;
    }
}
