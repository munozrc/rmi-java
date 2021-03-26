package main;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

  public static void main(String[] args) throws RemoteException, AlreadyBoundException {

    Remote stub = UnicastRemoteObject.exportObject(new Calculadora() {
      @Override
      public float sumar(float a, float b) throws RemoteException {
        return a + b;
      }

      @Override
      public float restar(float a, float b) throws RemoteException {
        return a - b;
      }

      @Override
      public float multiplicar(float a, float b) throws RemoteException {
        return a * b;
      }

      @Override
      public float dividir(float a, float b) throws RemoteException {
        return a / b;
      }
    }, 0);

    Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    registry.bind("Calculadora", stub);

  }
}
