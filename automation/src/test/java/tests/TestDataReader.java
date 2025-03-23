//package tests;
//
//import org.testng.annotations.DataProvider;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestDataReader {
//
//    @DataProvider(name = "userData")
//    public static Object[][] userDataProvider() throws IOException {
//        List<Object[]> userData = new ArrayList<>();
//
//        // Load file from resources
//        InputStream inputStream = TestDataReader.class.getClassLoader().getResourceAsStream("user_data.txt");
//        if (inputStream == null) {
//            throw new IOException("[Error] File not found: user_data.txt");
//        }
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                line = line.trim(); // Remove extra spaces
//                if (line.isEmpty() || line.startsWith("#")) { // Ignore empty lines and comments
//                    continue;
//                }
//                String[] parts = line.split(":");
//                if (parts.length >= 2) {  // Ensure at least username and password exist
//                    String username = parts[0];
//                    String password = parts[1];
//                    String role = (parts.length > 2) ? parts[2] : "User"; // Default role is "User"
//                    String employeeName = (parts.length > 3) ? parts[3] : ""; // Default employee name is empty
//
//                    userData.add(new Object[]{username, password, role, employeeName});
//                } else {
//                    System.err.println("[Warning] Skipping invalid entry: " + line);
//                }
//            }
//        }
//
//        return userData.toArray(new Object[0][]);
//    }
//}
