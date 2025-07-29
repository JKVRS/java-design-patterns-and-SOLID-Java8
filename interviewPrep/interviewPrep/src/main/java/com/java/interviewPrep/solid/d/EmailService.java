package com.java.interviewPrep.solid.d;

// Bad: Tight coupling
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NotificationManager {
    private EmailService emailService = new EmailService();

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}

// Good: Use abstraction (interface)
interface MessageService {
    void sendMessage(String message);
}

class EmailService1 implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NotificationManager1 {
    private MessageService service;

    // Constructor Injection
    public NotificationManager1(MessageService service) {
        this.service = service;
    }

    public void notifyUser(String message) {
        service.sendMessage(message);
    }
}
