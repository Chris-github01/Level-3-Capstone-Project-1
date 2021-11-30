import java.io.*;
import java.util.*;
import java.sql.*;
import java.text.*; // java.text package is imported to validate date format
import java.util.Date;  // java.util.Date package is imported to validate date format

import static java.lang.System.out;

public class PoisedProgram2 {
    private static boolean Value;

    // Method 'tableContentProject' is used to print all rows in the table
    public static void tableContentProject(Statement projectStatement) throws SQLException {
        ResultSet projectResults = projectStatement.executeQuery("SELECT Project_Number, Project_Name, Type, Address, " +
                "Erf_Number, Value, Paid_to_date, Deadline, Complete FROM books");

        while (projectResults.next()) {
            out.println(projectResults.getInt("Project_Number") + ", "
                    + projectResults.getString("Project_Name") + ", "
                    + projectResults.getString("Type") + ", "
                    + projectResults.getString("Address") + ", "
                    + projectResults.getString("Erf_Number") + ", "
                    + projectResults.getFloat("Value") + ", "
                    + projectResults.getFloat("Paid_to_date") + ", "
                    + projectResults.getString("Deadline") + ", "
                    + projectResults.getString("Complete") + ", ");
        }
    }
    // Method 'tableContentClient' is used to print all rows in the table
    public static void tableContentClient(Statement clientStatement) throws SQLException {
        ResultSet clientResults = clientStatement.executeQuery("SELECT Project_Number, Name, Telephone_Num, " +
                "Email, Address");

        while (clientResults.next()) {
            out.println(clientResults.getInt("Project_Number") + ", "
                    + clientResults.getString("Name") + ", "
                    + clientResults.getInt("Telephone_Num") + ", "
                    + clientResults.getString("Email") + ", "
                    + clientResults.getString("Address"));
        }
    }
    // Method 'tableContentArchitect' is used to print all rows in the table
    public static void tableContentArchitect(Statement architectStatement) throws SQLException {
        ResultSet architectResults = architectStatement.executeQuery("SELECT Project_Number, Name, Telephone_Num, " +
                "Email, Address");

        while (architectResults.next()) {
            out.println(architectResults.getInt("Project_Number") + ", "
                    + architectResults.getString("Name") + ", "
                    + architectResults.getInt("Telephone_Num") + ", "
                    + architectResults.getString("Email") + ", "
                    + architectResults.getString("Address"));
        }
    }
    // Method 'tableContentEngineer' is used to print all rows in the table
    public static void tableContentEngineer(Statement engineerStatement) throws SQLException {
        ResultSet engineerResults = engineerStatement.executeQuery("SELECT Project_Number, Name, Telephone_Num, " +
                "Email, Address");

        while (engineerResults.next()) {
            out.println(engineerResults.getInt("Project_Number") + ", "
                    + engineerResults.getString("Name") + ", "
                    + engineerResults.getInt("Telephone_Num") + ", "
                    + engineerResults.getString("Email") + ", "
                    + engineerResults.getString("Address"));
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            // Variables are defined
            String menu;
            String menuUpdate;
            String deadline = "";
            String erfNum;
            String projAddress;
            String projType;
            String projName;
            int projNum = 0;
            String engEmail;
            String cliEmail;
            String cliName;
            String projComplete;
            float projValue = 0;
            float paidToDate = 0;
            int arcTeleNum = 0;
            int cliTeleNum = 0;
            int engTeleNum = 0;

            // Connecting to the 'poisepms' database via the jdbc:mysql: channel on localhost (this pc)
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms?useSSL=false",
                    "root",
                    "Knight@MySQL01");

            // Create a direct line to the database for running queries
            Statement projectStatement = connection.createStatement();
            ResultSet projectResults = projectStatement.executeQuery("Select * from projecttable");

            System.out.println("""                        
                    Project Information
                    | Proj Number | Proj-Name | Type | Address | Erf-Number | Value | Paid-to-date | Deadline | Complete |""");

            // Project information is called from the database
            while (projectResults.next()) {
                int Project_Number = projectResults.getInt("Project_Number");
                String Project_Name = projectResults.getString("Project_Name");
                String Type = projectResults.getString("Type");
                String Address = projectResults.getString("Address");
                String Erf_Number = projectResults.getString("Erf_Number");
                float Value = projectResults.getFloat("Value");
                float Paid_to_date = projectResults.getFloat("Paid_to_date");
                String Deadline = projectResults.getString("Deadline");
                String Complete = projectResults.getString("Complete");

                // Project information is printed on the screen
                out.println(Project_Number + ", " + Project_Name + ", " + Type + ", " + Address + ", " +
                        Erf_Number + ", " + Value + ", " + Paid_to_date + ", " + Deadline + ", " + Complete);
            }
            // Create a direct line to the database for running queries
            Statement clientStatement = connection.createStatement();
            ResultSet clientResults = clientStatement.executeQuery("Select * from client");

            System.out.println("""                        
                                            
                    Client Information
                    | Proj-Number | Name | Telephone Number | Email | Address |""");

            // Client information is called from the database
            while (clientResults.next()) {
                int Project_Number = clientResults.getInt("Project_Number");
                String Name = clientResults.getString("Name");
                int Telephone_Num = clientResults.getInt("Telephone_Num");
                String Email = clientResults.getString("Email");
                String Address = clientResults.getString("Address");

                // Client information is printed on the screen
                out.println(Project_Number + ", " + Name + ", " + Telephone_Num + ", " + Email + ", " + Address);
            }
            // Create a direct line to the database for running queries
            Statement architectStatement = connection.createStatement();
            ResultSet architectResults = architectStatement.executeQuery("Select * from architect");

            System.out.println("""                        
                                            
                    Architect Information
                    | Proj-Number | Name | Telephone Number | Email | Address |""");

            // Architect information is called from the database
            while (architectResults.next()) {
                int Project_Number = architectResults.getInt("Project_Number");
                String Name = architectResults.getString("Name");
                int Telephone_Num = architectResults.getInt("Telephone_Num");
                String Email = architectResults.getString("Email");
                String Address = architectResults.getString("Address");

                // Architect information is printed on the screen
                out.println(Project_Number + ", " + Name + ", " + Telephone_Num + ", " + Email + ", " + Address);
            }
            // Create a direct line to the database for running queries
            Statement engineerStatement = connection.createStatement();
            ResultSet engineerResults = engineerStatement.executeQuery("Select * from engineer");

            System.out.println("""                        
                                            
                    Engineer Information
                    | Proj Number | Name | Telephone Number | Email | Address |""");

            // Engineer information is called from the database
            while (engineerResults.next()) {
                int Project_Number = engineerResults.getInt("Project_Number");
                String Name = engineerResults.getString("Name");
                int Telephone_Num = engineerResults.getInt("Telephone_Num");
                String Email = engineerResults.getString("Email");
                String Address = engineerResults.getString("Address");

                // Engineer information is printed on the screen
                out.println(Project_Number + ", " + Name + ", " + Telephone_Num + ", " + Email + ", " + Address);
            }

            //The following objects are created
            PersonClass2 PersonArcObj;
            PersonClass2 PersonCliObj;
            PersonClass2 PersonEngObj;
            ProjectClass2 ProjectObj;

            // A scanner object is created
            Scanner input = new Scanner(System.in);

            do {
                // A user menu is provided with multiple options to choose from
                out.println("""
                                                
                        Please select one of the following by number:
                        1 - Add project
                        2 - Edit specific project
                        3 - View projects status
                        4 - View project
                        5 - Generate invoice
                        6 - Exit""");

                menu = input.nextLine();

                // switch-while loop is used as a conditional statement for the menu options
                switch (menu) {
                    // case 1 is used to add a project
                    case "1" -> {
                        while (projNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset Scanner

                                out.println("What is the project number?");
                                projNum = input.nextInt();
                                input.nextLine();
                                break;
                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number");
                            }
                        }
                        out.println("Please enter the following info for project number " + projNum);

                        // Persons information to be recorded
                        // Architect Input
                        out.println("\nArchitect Information");

                        out.println("\nWhat is the Architect's name?");
                        String arcName = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (arcTeleNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                out.println("What is the Architect's telephone number?");
                                arcTeleNum = input.nextInt();
                                input.nextLine();
                                break;
                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        out.println("What is the Architect's email address?");
                        String arcEmail = input.nextLine();

                        out.println("What is the company address?");
                        String arcCompAddress = input.nextLine();

                        // PersonClass is called to print Architect's info
                        PersonArcObj = new PersonClass2(arcName, arcTeleNum, arcEmail, arcCompAddress);

                        // Client Input
                        out.println("\nClient Information");

                        out.println("\nWhat is the Client's name?");
                        cliName = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (cliTeleNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                out.println("What is the Client's telephone number?");
                                cliTeleNum = input.nextInt();
                                input.nextLine();
                                break;
                            }

                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        out.println("What is the Client's email address?");
                        cliEmail = input.nextLine();

                        out.println("What is the company address?");
                        String cliCompAddress = input.nextLine();

                        // PersonClass is called to print Client's info
                        PersonCliObj = new PersonClass2(cliName, cliTeleNum, cliEmail, cliCompAddress);

                        // Engineer Input
                        out.println("\nEngineer's Information");

                        out.println("\nWhat is the Engineer's name?");
                        String engName = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (engTeleNum >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                out.println("What is the Engineer's telephone number?");
                                engTeleNum = input.nextInt();
                                input.nextLine();
                                break;

                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                out.println("Invalid number. Please enter a valid number");
                            }
                        }

                        out.println("What is the Engineer's email address?");
                        engEmail = input.nextLine();

                        out.println("What is the company address?");
                        String engCompAddress = input.nextLine();

                        // PersonClass is called to print Engineer's info
                        PersonEngObj = new PersonClass2(engName, engTeleNum, engEmail, engCompAddress);

                        // All user input variables are printed by calling the objects
                        out.println("\nArchitect Information");
                        out.println(PersonArcObj);

                        out.println("\nClient Information");
                        out.println(PersonCliObj);

                        out.println("\nEngineer Information");
                        out.println(PersonEngObj);

                        // Project information to be recorded
                        out.println("\nProject information");

                        out.println("\nWhat is the project name?");
                        projName = input.nextLine();

                        out.println("What is the project type?");
                        projType = input.nextLine();

                        out.println("What is the project address?");
                        projAddress = input.nextLine();

                        out.println("What is the ERF number?");
                        erfNum = input.nextLine();

                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (projValue >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                out.println("What is the project value?");
                                projValue = input.nextFloat();
                                input.nextLine();
                                break;
                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                out.println("Invalid number. Please enter a valid number");
                            }
                        }
                        // A try-catch block inside a while loop is used to validate that the user input is a number
                        // and not a string value
                        while (paidToDate >= 0) {
                            try {
                                input = new Scanner(System.in); // Reset scanner

                                out.println("What is the total amount paid to date?");
                                paidToDate = input.nextFloat();
                                input.nextLine();
                                break;

                            }
                            // An error message will be displayed if an invalid number is entered
                            catch (InputMismatchException e) {
                                out.println("Invalid number. Please enter a valid number");
                            }
                        }
                        while (true) {
                            // The date format is set as dd/mm/yyyy
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            dateFormat.setLenient(false);

                            // A try catch block is used to validate the date format
                            try {
                                out.println("What is the project deadline? (yyyy-mm-dd)");
                                deadline = input.nextLine();
                                Date userDate = dateFormat.parse(deadline);
                                break;
                            }
                            // An error message will appear if the input format is incorrect
                            catch (ParseException e) {
                                out.println("Invalid format. Please enter correct format as yyyy-mm-dd");
                            }
                        }
                        out.println("Is the project complete? Yes/ No");
                        projComplete = input.nextLine();

                        // ProjectClass is called to print Project's info
                        ProjectObj = new ProjectClass2(projNum, projName, projType, projAddress, erfNum,
                                projValue, paidToDate, deadline, projComplete);

                        // Project object is called to print the project information
                        out.println("\nProject Information");
                        out.println(ProjectObj);

                        // The tables are updated in MySQL inside the 'PoisePMS' database
                        // Architect info is added to 'architect' table
                        architectStatement.executeUpdate("INSERT INTO architect VALUES('" + projNum + "', " +
                                "'" + arcName + "', '" + arcTeleNum + "', '" + arcEmail + "', '" +
                                arcCompAddress + "')");

                        // Client info is added to 'client' table
                        clientStatement.executeUpdate("INSERT INTO client VALUES('" + projNum + "', " +
                                "'" + cliName + "', '" + cliTeleNum + "', '" + cliEmail + "', '" +
                                cliCompAddress + "')");

                        // Engineer info is added to 'engineer' table
                        engineerStatement.executeUpdate("INSERT INTO engineer VALUES('" + projNum + "', " +
                                "'" + engName + "', '" + engTeleNum + "', '" + engEmail + "', '" +
                                engCompAddress + "')");

                        // Project info is added to 'project' table
                        projectStatement.executeUpdate("INSERT INTO projecttable VALUES('" + projNum + "', " +
                                "'" + projName + "', '" + projType + "', '" + projAddress + "', '" +
                                erfNum + "', '" + projValue + "', '" + paidToDate + "', '" + deadline +
                                "', '" + projComplete + "')");

                    }
                    // case 2 is used to edit a specific project
                    case "2" -> {
                        while (true) {

                            // Create a direct line to the database for running queries
                            projectStatement = connection.createStatement();
                            projectResults = projectStatement.executeQuery("Select * from projecttable");

                            // An arraylist is created to store the project numbers, which will be used to
                            // check if the user input matches the project numbers in the arraylist
                            List<Integer> list = new ArrayList<>();

                            // The while loop is used to loop through the table until all the project numbers
                            // are stored in the arraylist
                            while (projectResults.next()) {
                                int Project_Number = projectResults.getInt("Project_Number");
                                list.add(Project_Number);
                            }

                            // The try-catch block is used to validate the case numbers
                            try {
                                input = new Scanner(System.in); // Reset Scanner

                                // The nested try-catch block is used to validate the project number from
                                // the user input
                                try {
                                    out.println("Select the project number?");
                                    projNum = input.nextInt();
                                    input.nextLine();

                                } // An error message will be displayed if an invalid number is entered
                                catch (InputMismatchException e) {
                                    System.out.println("Invalid number. Please enter a valid number");
                                }
                                // The boolean function is used to check if the input number is true
                                boolean listNum = list.contains(projNum);

                                // If the boolean value is false, the project number is not in the arraylist which
                                // means it's not in the project table
                                if (!listNum) {
                                    System.out.println("The project number is not in the database");
                                }
                                // If the project number is in the table, the user is prompted to a new menu to edit
                                // project information
                                else {
                                    // A do-while loop is used to loop through the below menu until the user enters '5'
                                    do {
                                        input = new Scanner(System.in); // Reset scanner

                                        // User menu is created to edit information of the project and contractor
                                        out.println("""
                                                                           
                                                Please select one of the following by number:
                                                1 - Change due date
                                                2 - Change total amount paid
                                                3 - Change client's details
                                                4 - Finalise project
                                                5 - Return to main menu""");

                                        menuUpdate = input.nextLine();

                                        // A switch block is used for 'menuUpdate' to allow the user to select the options
                                        // in the given menu.
                                        switch (menuUpdate) {
                                            // Option one is used to change the due date of the project
                                            case "1" -> {
                                                while (true) {

                                                    // The date format is set as yyyy-MM-dd. If the user enters a date in a
                                                    // different format, an error message will be displayed
                                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                                    dateFormat.setLenient(false);

                                                    // The try-catch block is used to validate the date format
                                                    try {
                                                        input = new Scanner(System.in); // Reset scanner

                                                        System.out.println(deadline);
                                                        System.out.println("What is the new deadline? (yyyy-mm-dd)");
                                                        deadline = input.nextLine();

                                                        // The project table is updated with the new date that the user entered
                                                        projectStatement.executeUpdate("Update projecttable Set Deadline = '" + deadline + "' WHERE " +
                                                                "Project_Number = '" + projNum + "'");

                                                        Date userDate = dateFormat.parse(deadline);

                                                        // User is informed that the date is updated
                                                        System.out.println("\nDeadline is updated");
                                                        break;

                                                    } catch (ParseException e) {
                                                        // An error message will appear if the input date format is incorrect
                                                        System.out.println("Invalid format. Please enter correct format as yyyy-mm-dd");
                                                    }
                                                }
                                            }
                                            // Option 2 is used to change the amount paid for the project
                                            case "2" -> {
                                                while (projValue >= 0)
                                                {
                                                    // The try-catch block inside the while loop is used to validate that the input value
                                                    // is a number
                                                    try {
                                                        input = new Scanner(System.in); // Reset scanner

                                                        out.println("What is the new project value?");
                                                        projValue = input.nextFloat();
                                                        input.nextLine();

                                                        // The project table is updated with the new value that the user entered
                                                        projectStatement.executeUpdate("Update projecttable Set Paid_to_date = '" + projValue + "' WHERE " +
                                                                "Project_Number = '" + projNum + "'");

                                                        // User is informed that the payment is updated
                                                        System.out.println("\nPayment is updated");
                                                        break;
                                                    }
                                                    // An error message will be displayed if an invalid number is entered
                                                    catch (InputMismatchException e) {
                                                        out.println("Invalid number. Please enter a valid number");
                                                    }
                                                }
                                            }
                                            // Option 3 is used to change the contractor's info
                                            case "3" -> {
                                                input = new Scanner(System.in); // Reset Scanner

                                                // A second menu is created to update the contact details of the client
                                                out.println("""
                                                                                   
                                                        Please select one of the following by number:
                                                        1 - Update client telephone number
                                                        2 - Update client email address
                                                        """);
                                                String contractorInfoUpdate = input.nextLine();

                                                while (true) {

                                                    // A nested if statement is used to change the telephone number and email address
                                                    // Option 1 is used to change the telephone number
                                                    if (Objects.equals(contractorInfoUpdate, "1")) {

                                                        input = new Scanner(System.in); // Reset Scanner

                                                        while (cliTeleNum >= 0) {
                                                            // The try-catch block inside the while loop is used to validate that the input value
                                                            // is a number
                                                            try {
                                                                out.println("What is the Client's telephone number?");
                                                                cliTeleNum = input.nextInt();
                                                                input.nextLine();

                                                                // The project table is updated with the new telephone number that the user entered
                                                                projectStatement.executeUpdate("Update client Set Telephone_Num = '" + cliTeleNum + "' WHERE " +
                                                                        "Project_Number = '" + projNum + "'");

                                                                // User is informed that the telephone number is updated
                                                                System.out.println("\nTelephone number is updated");
                                                                break;
                                                            }
                                                            // An error message will be displayed if an invalid number is entered
                                                            catch (InputMismatchException e) {
                                                                out.println("Invalid number. Please enter a valid number");
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    // Option 2 is used to update the email address
                                                    else if (Objects.equals(contractorInfoUpdate, "2")) {
                                                        out.println("What is the Client's new email address?");
                                                        cliEmail = input.nextLine();

                                                        // The project table is updated with the new email address that the user entered
                                                        projectStatement.executeUpdate("Update client Set Email = '" + cliEmail + "' WHERE " +
                                                                "Project_Number = '" + projNum + "'");

                                                        // User is informed that the email address is updated
                                                        System.out.println("\nEmail address is updated");
                                                        break;
                                                    }
                                                    // An error message will be displayed if an invalid number from the menu is entered
                                                    else {
                                                        System.out.println("Invalid input. Please enter a valid number.");

                                                        // If an error message is displayed, the user will be redirected to
                                                        // contractorInfoUpdate menu
                                                        contractorInfoUpdate = input.nextLine();
                                                    }
                                                }
                                            }
                                            // Option 4 is used to finalize the project
                                            case "4" -> {
                                                // The project table is updated with the project marked as complete
                                                projectStatement.executeUpdate("Update projecttable Set Complete = 'Yes' WHERE " +
                                                        "Project_Number = '" + projNum + "'");

                                                // The user is informed that the project is marked as complete
                                                out.println("Project status is marked as complete");
                                            }
                                            // Case 5 will return to the main menu
                                            case "5" -> {
                                            }
                                            // If the user input for 'menu_update' is invalid, the user will be notified
                                            // and the loop will start at the user menu
                                            default -> out.print("\nInvalid option. Please enter correct number\n");
                                        }
                                    }
                                    // The session from menuUpdate will end if the user enters '5'
                                    while (!menuUpdate.equals("5"));
                                }
                                System.out.println("Info updated");
                                break;
                            }
                            // An error message will be displayed if the input is invalid, in this case not a number
                            catch (InputMismatchException e) {
                                System.out.println("Invalid number. Please enter a valid number.");
                            }
                        }
                    }
                    // case 3 is used to view projects status from the main menu
                    case "3" -> {

                        input = new Scanner(System.in); // Reset Scanner

                        // A third menu is created to view incomplete and past due date projects
                        System.out.println("""
                                                           
                                Please select one of the following by number:
                                1 - View incomplete projects
                                2 - View projects overdue""");
                        String projectStatus = input.nextLine();

                        while (true) {

                            // A nested if statement is used to view incomplete projects as well as projects that
                            // are overdue
                            if (Objects.equals(projectStatus, "1")) {

                                // Projects that are not complete are called from the table
                                projectResults = projectStatement.executeQuery("Select * from projecttable WHERE " +
                                        "Complete = 'No'");

                                System.out.println("The following projects are incomplete:\n");

                                // Project information is called from the database
                                while (projectResults.next()) {
                                    int Project_Number = projectResults.getInt("Project_Number");
                                    String Project_Name = projectResults.getString("Project_Name");
                                    String Type = projectResults.getString("Type");
                                    String Address = projectResults.getString("Address");
                                    String Erf_Number = projectResults.getString("Erf_Number");
                                    float Value = projectResults.getFloat("Value");
                                    float Paid_to_date = projectResults.getFloat("Paid_to_date");
                                    String Deadline = projectResults.getString("Deadline");
                                    String Complete = projectResults.getString("Complete");

                                    // The incomplete projects are displayed on the screen
                                    out.println(Project_Number + ", " + Project_Name + ", " + Type + ", " + Address + ", " +
                                            Erf_Number + ", " + Value + ", " + Paid_to_date + ", " + Deadline + ", " + Complete);
                                }
                                break;
                            }
                            // Projects that are overdue is called from the database
                            else if (Objects.equals(projectStatus, "2")) {

                                // The 'NOW()' function is used to check if a project is past its duedate
                                projectResults = projectStatement.executeQuery("Select * from projecttable WHERE Deadline < NOW()");

                                // Project information is called from the database
                                while (projectResults.next()) {
                                    int Project_Number = projectResults.getInt("Project_Number");
                                    String Project_Name = projectResults.getString("Project_Name");
                                    String Type = projectResults.getString("Type");
                                    String Address = projectResults.getString("Address");
                                    String Erf_Number = projectResults.getString("Erf_Number");
                                    float Value = projectResults.getFloat("Value");
                                    float Paid_to_date = projectResults.getFloat("Paid_to_date");
                                    String Deadline = projectResults.getString("Deadline");
                                    String Complete = projectResults.getString("Complete");

                                    // The projects that are past its duedate is printed on the screen
                                    out.println(Project_Number + ", " + Project_Name + ", " + Type + ", " + Address + ", " +
                                            Erf_Number + ", " + Value + ", " + Paid_to_date + ", " + Deadline + ", " + Complete);
                                }
                                break;
                            }
                            // An error message will be displayed if an invalid number from the menu is entered
                            else {
                                out.println("Invalid option. Please enter valid number");
                                projectStatus = input.nextLine();
                            }
                        }
                    }
                    // Case 4 will print a specific project on the screen
                    case "4" -> {
                        // A fourth menu is created to view a specific project by selecting it by name or number
                        System.out.println("""
                                                           
                                Please select one of the following by number:
                                1 - Search project by name
                                2 - Search project by number""");
                        String projectSearch = input.nextLine();

                        while (true) {

                            // This if statement will view a project by searching it by name
                            if (Objects.equals(projectSearch, "1")) {
                                out.println("What is the project name?");
                                String projNameSearch = input.nextLine();

                                projectResults = projectStatement.executeQuery("Select * from projecttable WHERE " +
                                        "Project_Name = '" + projNameSearch + "'");

                                // Project information is called from the database
                                while (projectResults.next()) {
                                    int Project_Number = projectResults.getInt("Project_Number");
                                    String Project_Name = projectResults.getString("Project_Name");
                                    String Type = projectResults.getString("Type");
                                    String Address = projectResults.getString("Address");
                                    String Erf_Number = projectResults.getString("Erf_Number");
                                    float Value = projectResults.getFloat("Value");
                                    float Paid_to_date = projectResults.getFloat("Paid_to_date");
                                    String Deadline = projectResults.getString("Deadline");
                                    String Complete = projectResults.getString("Complete");

                                    // The project info is printed on the screen
                                    out.println("Project number:\t" + Project_Number + "\n" +
                                            "Project name:\t" + Project_Name + "\n" +
                                            "Project type:\t" + Type + "\n" +
                                            "Address:\t\t" + Address + "\n" +
                                            "ERF number:\t\t" + Erf_Number + "\n" +
                                            "Project value:\t" + "R" + Value + "\n" +
                                            "Paid to date:\t" + "R" + Paid_to_date + "\n" +
                                            "Deadline:\t\t" + Deadline + "\n" +
                                            "Complete:\t\t" + Complete);
                                }
                                break;
                            }
                            // This else if statement will view a project by searching it by number
                            else if (Objects.equals(projectSearch, "2")) {
                                out.println("What is the project number?");
                                int projNumberSearch = input.nextInt();

                                projectResults = projectStatement.executeQuery("Select * from projecttable WHERE " +
                                        "Project_Number = '" + projNumberSearch + "'");

                                // Project information is called from the database
                                while (projectResults.next()) {
                                    int Project_Number = projectResults.getInt("Project_Number");
                                    String Project_Name = projectResults.getString("Project_Name");
                                    String Type = projectResults.getString("Type");
                                    String Address = projectResults.getString("Address");
                                    String Erf_Number = projectResults.getString("Erf_Number");
                                    float Value = projectResults.getFloat("Value");
                                    float Paid_to_date = projectResults.getFloat("Paid_to_date");
                                    String Deadline = projectResults.getString("Deadline");
                                    String Complete = projectResults.getString("Complete");

                                    // The project info is printed on the screen
                                    out.println("Project number:\t" + Project_Number + "\n" +
                                            "Project name:\t" + Project_Name + "\n" +
                                            "Project type:\t" + Type + "\n" +
                                            "Address:\t\t" + Address + "\n" +
                                            "ERF number:\t\t" + Erf_Number + "\n" +
                                            "Project value:\t" + "R" + Value + "\n" +
                                            "Paid to date:\t" + "R" + Paid_to_date + "\n" +
                                            "Deadline:\t\t" + Deadline + "\n" +
                                            "Complete:\t\t" + Complete);
                                }
                                break;
                            }
                            // An error message will be displayed if an invalid number from the menu is entered
                            else {
                                out.println("Invalid option. Please enter a valid number");
                                projectSearch = input.nextLine();
                            }
                        }
                    }
                    // Case 5 is used to generate an invoice by searching it by project number
                    case "5" -> {
                        System.out.println("What is the project number?");
                        projNum = input.nextInt();
                        input.nextLine();

                        // Create a direct line to the database for running queries to search client information
                        clientStatement = connection.createStatement();
                        clientResults = clientStatement.executeQuery("Select * from client WHERE " +
                                "Project_Number = '" + projNum + "'");

                        // Create a direct line to the database for running queries to search project information
                        projectStatement = connection.createStatement();
                        projectResults = projectStatement.executeQuery("Select * from projecttable WHERE " +
                                "Project_Number = '" + projNum + "'");

                        // The amount owing is calculated by subtracting paid to date from value
                        if (projectResults.next()) {
                            float contractValue = projectResults.getFloat("Value");
                            float paidValue = projectResults.getFloat("Paid_to_date");
                            float amountOwing = contractValue - paidValue;

                            // If the amount owing is larger than 0, an invoice will be generated
                            if (amountOwing > 0) {
                                if (clientResults.next()) {

                                    // Amount due is displayed
                                    out.println("R" + amountOwing + " is outstanding");
                                    out.println("\nClient information");

                                    String Name = clientResults.getString("Name");
                                    int Telephone_Num = clientResults.getInt("Telephone_Num");
                                    String Email = clientResults.getString("Email");

                                    // Client information is displayed
                                    out.println("Client name:\t\t" + Name + "\n" +
                                            "Telephone number:\t" + "0" + Telephone_Num + "\n" +
                                            "Email address:\t\t" + Email);
                                }

                                out.println("\nProject information");

                                // Project information is called from the database
                                int Project_Number = projectResults.getInt("Project_Number");
                                String Project_Name = projectResults.getString("Project_Name");
                                float Value = projectResults.getFloat("Value");
                                float Paid_to_date = projectResults.getFloat("Paid_to_date");
                                String Deadline = projectResults.getString("Deadline");
                                String Complete = projectResults.getString("Complete");

                                // Project information is displayed
                                out.println("Project number:\t" + Project_Number + "\n" +
                                        "Project name:\t" + Project_Name + "\n" +
                                        "Project value:\t" + "R" + Value + "\n" +
                                        "Paid to date:\t" + "R" + Paid_to_date + "\n" +
                                        "Deadline:\t\t" + Deadline + "\n" +
                                        "Complete:\t\t" + Complete);
                            }
                            // If the amount owing is equal to 0, no invoice will be displayed
                            else {
                                System.out.println("No invoice needed. Project is fully paid.");
                            }
                        }
                    }
                    // case 6 is used to terminate the program
                    case "6" -> {
                        out.println("Session ended");
                    }
                    // If the user input for 'menu_update' is invalid, the user will be notified
                    // and the loop will start at the user menu
                    default -> out.print("\nInvalid option. Please enter correct number\n");
                }
            }
            // The session from menu will end if the user enters '6'
            while (!menu.equals("6"));
        } catch (SQLException e) {
            out.println("SQL exception occurred " + e);
        }
    }
}
 /*
References:
https://beginnersbook.com/2013/04/oops-concepts/
https://beginnersbook.com/2013/03/constructors-in-java/
https://codescracker.com/java/java-objects-classes.htm
https://www.javatpoint.com/java-oops-concepts
https://www.w3schools.com/java/java_methods.asp
https://www.w3schools.com/java/java_classes.asp
https://beginnersbook.com/2013/05/java-date-format/
https://www.codingame.com/
 */