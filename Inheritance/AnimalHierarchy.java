package Inheritance;
class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden
    void makeSound() {
        System.out.println("Some generic animal sound");
    }

    // Display info
    void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
// Dog subclass
class Dog extends Animal {

    Dog(String name, int age) {
        super(name, age); // Call superclass constructor
    }

    // Overriding makeSound()
    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Cat subclass
class Cat extends Animal {

    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

// Bird subclass
class Bird extends Animal {

    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println("Chirp! Chirp!");
    }
}
public class AnimalHierarchy {
    public static void main(String[] args) {
        // Using polymorphism
        Animal myDog = new Dog("Buddy", 3);
        Animal myCat = new Cat("Whiskers", 2);
        Animal myBird = new Bird("Tweety", 1);

        // Array of animals
        Animal[] animals = {myDog, myCat, myBird};

        // Loop through and call makeSound()
        for (Animal a : animals) {
            a.displayInfo();
            a.makeSound(); // Calls subclass-specific implementation
            System.out.println();
        }
    }
}
