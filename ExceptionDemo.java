// Custom Exception for Father class
class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

// Father Class                                                                               
class Father {
    int fatherAge;

    Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative!");
        }
        this.fatherAge = age;
        System.out.println("Father's age is: " + fatherAge);
    }
}

// Son Class
class Son extends Father {   
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge); // calling Father constructor

        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age must be less than Father's age!");
        }

        this.sonAge = sonAge;
        System.out.println("Son's age is: " + sonAge);
    }
}

// Main Class to test
public class ExpectionDemo {
    public static void main(String[] args) {

        // Test case 1 (Valid ages)
        try {
            Son s1 = new Son(40, 18);
        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println();

        // Test case 2 (Father age invalid)
        try {
            Son s2 = new Son(-5, 10);
        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println();

        // Test case 3 (Son age >= Father age)
        try {
            Son s3 = new Son(30, 30);
        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

    }
}
