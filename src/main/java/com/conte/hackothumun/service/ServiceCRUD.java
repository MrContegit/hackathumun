package com.conte.hackothumun.service;

public interface ServiceCRUD<T>{
     T select(String name);
     T insert(T value);
     T update(T value);
     void delete(T value);

}
