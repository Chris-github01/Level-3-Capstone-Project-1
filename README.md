# Level-3-Capstone-Project-1
## Poised Program - Database handling - MySQL
### This program builds up to the original Poised Program, but makes use of Databases in MySQL instead of reading and writing to text files
### This program allows the user to generate a construction project by registerring all relevant parties (Architect, Engineer and Client) and uploading info regarding the project. 
### Defensive programming was used by means of try/catch blocks to ensure the user enters the correct info. Should the user enter an incorrect menu option as an example, the program will inform the user that an incorrect option was selected and that a correct option should be chosen
### There is a main menu with options for the user to select from. The menu options are as follow:
### *Main Menu*
1. Add project
2. Edit specific project
3. View projects status
4. View project
5. Exit
### The menu options are discussed in more details below:
### *1. Add project*
* For each relevant party the following info is needed:
  - Name
  - Contact info
  - Company address

* For each project the following info is needed
  - Project name and number
  - Project type (Building, Civils, R&E)
  - Erf number
  - Project Value
  - Amount paid to date
  - Project Deadline

### *2. Edit specific project* 
#### A menu under 'Edit specific project' gives the user the following options:
1. Change due date
2. Change total amount paid
3. Change client's details
4. Finalise project
5. Return to main menu

#### A menu under 'Change client's details' gives the user the following options:
1. Update client telephone number
2. Update client email address

#### Under 'Finalise project' an invoice will be generated and the project will be marked as complete

### *3. View projects status*
#### A menu under 'View projects status' gives the user the following options:
1. View incomplete projects
2. View projects overdue

### *4. View project*
#### This option allows the user to search for a specific project by project number to view the project information

###  *5 Exit*
#### The program will terminate
