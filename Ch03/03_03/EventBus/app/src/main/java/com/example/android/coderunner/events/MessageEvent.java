package com.example.android.coderunner.events;

// To pass information around your application, create custom
// event classes. An event class is simply a plain old Java object
// with properties.
public class MessageEvent {

    // Declare String message field
    private String message;

    // Create Constructor method
    public MessageEvent(String message) {
        this.message = message;
    }

    // Create getter method
    public String getMessage() {
        return message;
    }

    // Create setter method
    public void setMessage(String message) {
        this.message = message;
    }
}
