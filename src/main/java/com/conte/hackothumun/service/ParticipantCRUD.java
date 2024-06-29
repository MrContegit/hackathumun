package com.conte.hackothumun.service;

import com.conte.hackothumun.entity.Participant;

public class ParticipantCRUD implements ServiceCRUD<Participant>,UserAppService<Participant>{

    @Override
    public Participant select(String name) {
        return null;
    }

    @Override
    public Participant insert(Participant value) {
        return null;
    }

    @Override
    public Participant update(Participant value) {
        return null;
    }

    @Override
    public void delete(Participant value) {

    }

    @Override
    public Participant login(Participant user) {
        return null;
    }

    @Override
    public void logout() {

    }

    public void registerForEvent(){

    }
    public void provideFeedBack(Participant user){

    }
}
