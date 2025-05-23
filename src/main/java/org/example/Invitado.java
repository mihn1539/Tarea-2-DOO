package org.example;

public abstract class Invitado implements Invitable {
    public Invitacion invitacion = null;

    public Invitado(){
    }

    public abstract void invitar(Reunion reunion);
}
