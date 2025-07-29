package com.java.interviewPrep.designPatterns.factoryDP;

/*
    The Factory Design Pattern is a creational pattern that provides a way to create objects
    without exposing the instantiation logic to the client.
    Instead, the client uses a factory method to get the object.
 */

interface MessageService{
    void sendMessage();
}

class SMS implements MessageService{

    @Override
    public void sendMessage() {
        System.out.println("Message sent through SMS !!!");
    }
}
class Email implements MessageService{

    @Override
    public void sendMessage() {
        System.out.println("Message sent through Email !!!");
    }
}
class MessageFactory{

    private MessageService messageService;
    public MessageService getObjectForMessage(String serviceType)
    {
        if(serviceType.equalsIgnoreCase("SMS")){
            messageService = new SMS();
            return messageService;
        }
        if(serviceType.equalsIgnoreCase("Email")){
            messageService = new Email();
            return messageService;
        }
        return null;
    }
}
public class FactoryMain {

    public static void main(String[] args) {
           MessageFactory messageFactory = new MessageFactory();
           MessageService service = messageFactory.getObjectForMessage("sms");
           service.sendMessage();

    }
}
