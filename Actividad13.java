/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad13;

/**
 *
 * @author Liliana
 */
interface AnonClass {
    public void anonMethod();
}

interface MathOperation {
    double make(double a, double b);
}

interface Mailer {
    void sendUsing(String service);
}

class Mail {
    private String sender;
    private String receiver;
    private String message;

    public Mail(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    private String compose() {
        String composeString = "From:%s|To:%s|Message:%s";
        return String.format(composeString, sender, receiver, message);
    }

    void send(String mailService) {
        System.out.println("Sending using " + mailService);
        System.out.println(compose());
    }
}

public class Actividad13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("-------------------CLASE ANONIMA----------------");     
        String localVariable = "Printing the local variable value";

        AnonClass anon = new AnonClass() {
            public void anonMethod() {
                System.out.println("Inside method of anonymous class");
                System.out.println(localVariable);
            }
        };

        anon.anonMethod();
   System.out.println("-----------------LAMBDA--------------");     
        double k = 10.0;
        double m = 5;

        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
        MathOperation prod = (a, b) -> a * b;
        MathOperation div = (a, b) -> a / b;

        System.out.println(" Add = " + add.make(k, m));
        System.out.println(" Sub = " + sub.make(k, m));
        System.out.println("Prod = " + prod.make(k, m));
        System.out.println(" Div = " + div.make(k, m));
        
        System.out.println("--------------------------------------------------------");
        
        MathOperation gcd = (x, y) -> {
            double a = Math.max(x, y);
            double b = Math.min(x, y);
            double t = 0.0;
            do {
                t = b;
                b = a % b;
                a = t;
            } while(b != 0);
            return t;
        };

        double num1 = 10.0;
        double num2 = 5;
        System.out.println("GCD = " + gcd.make(num1, num2));

        
        System.out.println("---------------------REFERENCIA---------------------");
        
        Mail fooMail = new Mail("foo@mail.com", "bar@mail.com", "Hello World!");
        Mail barMail = new Mail("bar@mail.com", "baz@mail.com", "Exception thrown");

        Mailer fooMailer = fooMail::send;
        Mailer barMailer = barMail::send;
        fooMailer.sendUsing("GMail");
        barMailer.sendUsing("Outlook");
        
        
        
    }
    
}
