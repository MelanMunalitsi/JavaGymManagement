/*public class PersonTest {
    public static void main(String[] args) {
        System.out.println("========== MYFITNESS: PERSON CLASS ROBUSTNESS TEST ==========");

        Person testUser = new Person(101, "Alex Smith", "alex@email.com", "SecurePass123");

        // 2. Testing Getters and Initial State
        System.out.println("\n[TEST 1] Verifying Object Creation:");
        System.out.println("ID: " + testUser.getId());
        System.out.println("Name: " + testUser.getName());
        System.out.println("Email: " + testUser.getEmail());

        // 3. Testing Logic: Login Operation (UML Method)
        System.out.println("\n[TEST 2] Testing Login Logic:");
        
        // Scenario A: Incorrect Password
        boolean wrongPass = testUser.login("alex@email.com", "WrongPassword");
        System.out.println("Login with wrong password: " + (wrongPass ? "SUCCESS (FAIL)" : "FAILED (PASS)"));

        // Scenario B: Correct Credentials
        boolean rightPass = testUser.login("alex@email.com", "SecurePass123");
        System.out.println("Login with correct credentials: " + (rightPass ? "SUCCESS (PASS)" : "FAILED (FAIL)"));

        // 4. Testing Profile Update (UML Method)
        System.out.println("\n[TEST 3] Testing Profile Update:");
        testUser.updateProfile("Alex J. Smith", "alex.smith@newmail.com");
        
        if (testUser.getName().equals("Alex J. Smith") && testUser.getEmail().equals("alex.smith@newmail.com")) {
            System.out.println("Profile Update: SUCCESS");
        } else {
            System.out.println("Profile Update: FAILED");
        }

        // 5. Robustness: Handling Null/
        System.out.println("\n[TEST 4] Robustness Check (Empty Strings):");
        testUser.updateProfile("", "");
        System.out.println("Current Name after empty update: '" + testUser.getName() + "'");
        
        System.out.println("\n================ TEST EXECUTION COMPLETE ================");
    }
} */
