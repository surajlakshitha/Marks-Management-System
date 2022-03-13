import java.util.*;
class Example{
    public static void mainMenu(String[]id, String []name, int []program, int []database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                           WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                    |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("    ");
        System.out.println("[1] Add New Student\t\t\t[2] Add Student With Marks");
        System.out.println("[3] Add Marks\t\t\t\t[4] Update Student Details");
        System.out.println("[5] Update Marks\t\t\t[6] Delete Student");
        System.out.println("[7] Print Student Details\t\t[8] Print Student Rank");
        System.out.println("[9] Best in programming Fundamental\t[10] Best in DataBase Management System\n");
        System.out.print("Enter an option to continue >");
        final int options =input.nextInt();
        switch(options){
            case 1: addNewStudent(id,name,program,database);break;
            case 2: addStudentWithMarks(id,name,program,database);break;
            case 3: addMarks(id,name,program,database);break;
            case 4: updateStudentDetails(id,name,program,database);break;
            case 5: updateMarks(id,name,program,database);break;
            case 6: deleteStudent(id,name,program,database);break;
            case 7: printStudentDetails(id,name,program,database);break;
            case 8: printStudentRank(id,name,program,database);break;
            case 9: bestInProFun(id,name,program,database);break;
            case 10: bestInDbms(id,name,program,database);break;

        }
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
// Handle any exceptions.
        }
    }

    public static int findNextIndexString(String[] array){
        int nextIndex=array.length;
        for(int x=0;x<array.length;x++){
            if(array[x]==null){
                nextIndex=x;break;
            }
        }
        return nextIndex;
    }

    public static int findNextIndexInt(int[] array){
        int nextIndex=array.length;
        for(int x=0;x<array.length;x++){
            if(array[x]==0){
                nextIndex=x;break;
            }
        }
        return nextIndex;
    }
    public static void addNewStudent(String[]id, String []name, int[] program, int[]database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                  ADD NEW STUDENT                                    |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        int index= findNextIndexString(id);
        int n=0;
        String sId;
        do{
            System.out.print("Enter Student ID : ");
            sId =input.nextLine();
            for(int x=0;x<index;x++){
                if(id[x].equals(sId)){
                    n=1;
                    System.out.println(" ");
                    System.out.println("This Student ID Already Exists.. ");
                    break;}else{
                    n=0;
                }
            }
        }while(n!=0);{
            int nextIndex= findNextIndexString(id);
            id[nextIndex]=sId;
            System.out.print("Enter Student Name : ");
            name[nextIndex]=input.nextLine();
        }
        Message1(id,name,program,database);
    }

    public static void Message1(String[]id, String []name, int[]program, int[]database){
        Scanner input=new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Student has been Add Successfully.\nDo you Want to Add New Student?(Y/n)");
        String command=input.nextLine();
        switch(command){
            case "Y":clearConsole();
                addNewStudent(id,name,program,database);break;
            case"n":clearConsole();
            mainMenu(id,name,program,database);break;
        }
    }

    public static void addStudentWithMarks(String[]id, String []name, int []program, int []database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                             ADD STUDENT WITH MARKS                                  |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        int index= findNextIndexString(id);
        int n=0;
        int nextIndex;
        String sId;
        do{
            System.out.print("Enter Student ID : ");
            sId =input.nextLine();
            for(int x=0;x<index;x++){
                if(id[x].equals(sId)){
                    n=1;
                    System.out.println(" ");
                    System.out.println("This Student ID Already Exists.. ");
                    break;}else{
                    n=0;
                }
            }

        }while(n!=0);{
            nextIndex= findNextIndexString(id);
            id[nextIndex]=sId;
            nextIndex= findNextIndexString(name);
            System.out.print("Enter Student Name : ");
            name[nextIndex]=input.nextLine();
        }int m;
        int proMarks;
        do{
            System.out.print("Enter programming Fundamentals Marks :");
            proMarks=input.nextInt();
            if(proMarks<0||proMarks>100){
                m=1;
                System.out.println("Invalid Marks,Please Enter Correct Marks");
            }else{ m=0;}
        }while(m!=0);{
            program[nextIndex]=proMarks;
        }
        int num;
        int dbmsMarks;
        do{
            System.out.print("Enter Database Management System Marks :");
            dbmsMarks=input.nextInt();
            if(dbmsMarks<0||dbmsMarks>100){
                num=1;
                System.out.println("Invalid Marks,Please Enter Correct Marks");
            }else{ num=0;}

        }while(num!=0);{

            database[nextIndex]=dbmsMarks;
        }
        Message2(id,name,program,database);
    }

    public static void Message2(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Student has been Add Successfully.Do you Want to Add New Student(Y/n)");
        String command=input.nextLine();
        switch(command){
            case "Y":clearConsole();
                addStudentWithMarks(id,name,program,database);break;
            case"n":clearConsole();
                mainMenu(id,name,program,database);break;
        }
    }

    public static void addMarks(String[]id, String []name, int []program, int[]database){
        clearConsole();
        Scanner input=new Scanner(System.in);
        String searchId;
        int temp;
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                  ADD MARKS                                          |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        int num=0;
        int index= findNextIndexString(id);
        do{
            System.out.print("Enter Student ID :");
            searchId=input.nextLine();
            for(int x=0;x<index;x++){
                if(id[x].equals(searchId)){
                    num=1;
                    temp=x;
                    System.out.println(" Student Name   :"+name[temp]);
                    marksCheck(id,name,program,database,temp);
                    checkMarks(id,name,program,database);
                }else{
                    num=0;

                }
            }
        }while(num!=0);{
            System.out.println(" ");
            System.out.print("Invalid Student ID.Do you Want to Search Again?(Y/n) ");
            String option =input.nextLine();
            switch (option){
                case "Y":
                    addMarks(id,name,program,database);
                case "n":clearConsole();
                    mainMenu(id,name,program,database);

            }
        }
    }
    public static void checkMarks(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        int m;
        int proMarks;
        do{
            System.out.print("Enter Programming Fundamentals Marks :");
            proMarks=input.nextInt();
            if(proMarks<0||proMarks>100){
                m=1;
                System.out.println("Invalid Marks,please Enter Correct Marks");
            }else{ m=0;}

        }while(m!=0);{
            int index1= findNextIndexInt(program);
            program[index1]=proMarks;
        }

        int n;
        int dbmsMarks;
        do{
            System.out.print("Enter Database Management System Marks :");
            dbmsMarks=input.nextInt();
            if(dbmsMarks<0||dbmsMarks>100){
                n=1;
                System.out.println("Invalid Marks,please Enter Correct Marks");
            }else{ n=0;}

        }while(n!=0);{

            int index2= findNextIndexInt(database);
            database[index2]=dbmsMarks;
        }
        Message3(id,name,program,database);
    }
    public static void Message3(String[]id, String []name, int[]program, int[]database){
        Scanner input=new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Marks have been Added Successfully.Do you Want to Add Marks for Another Student?(Y/n)");
        String command=input.nextLine();
        switch(command){
            case "Y":clearConsole();
                addMarks(id,name,program,database);break;
            case"n":clearConsole();
                mainMenu(id,name,program,database);break;
        }

    }
    public static void marksCheck(String[]id, String []name, int []program, int[]database, int temp){
        Scanner input=new Scanner(System.in);
        String optionYn;
        if(program[temp]>0&&0<database[temp]){
            System.out.println(" ");
            System.out.println("This Student Marks Already Added.");
            System.out.println("If you Want to Update the Marks,please use[4] Update Marks Option\n");
            System.out.print("Do you Want to Add Marks for Another Student?(Y/n)");
            optionYn=input.nextLine();
            switch(optionYn){
                case "Y":clearConsole();
                    addMarks(id,name,program,database);
                case"n":clearConsole();
                    mainMenu(id,name,program,database);
            }
        }
    }

    public static void updateStudentDetails(String[]id, String []name, int []program, int []database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        String searchId;
        int temp;
        int num=0;
        int index= findNextIndexString(id);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                               UPDATE STUDENT DETAILS                                |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        do{
            System.out.print("Enter Student ID :");
            searchId=input.nextLine();
            for(int x=0;x<index;x++){
                if(id[x].equals(searchId)){
                    num=1;
                    temp=x;
                    System.out.println("Student Name :"+name[temp]);
                    System.out.print("Enter the new Student Name :");
                    String newName=input.nextLine();
                    name[temp]=newName;
                    System.out.println(" ");
                    System.out.print("Student Details has been Updated Successfully.");
                    System.out.print("Do you Want to Update Another Student Details?(Y/n)");
                    String command=input.nextLine();
                    switch (command){
                        case "Y":
                            updateStudentDetails(id,name,program,database);
                        case "n":clearConsole();
                            mainMenu(id,name,program,database);
                    }
                }else{
                    num=0;
                }
            }
        }while(num!=0);{
            System.out.println(" ");
            System.out.print("Invalid Student ID.Do you Want to Search Again?(Y/n) ");
            String option =input.nextLine();
            switch (option){
                case "Y":
                    updateStudentDetails(id,name,program,database);
                case "n":clearConsole();
                    mainMenu(id,name,program,database);
            }
        }
    }

    public static void updateMarks(String[]id, String []name, int []program, int[]database){
        clearConsole();
        Scanner input=new Scanner(System.in);
        String searchID;
        int temp;
        int num=0;
        int index= findNextIndexString(id);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                 UPDATE MARKS                                        |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        do{
            System.out.print("Enter Student ID :");
            searchID=input.nextLine();
            for(int x=0;x<index;x++){
                if(id[x].equals(searchID)){
                    num=1;
                    temp=x;
                    System.out.println("Enter Student Name       :"+name[temp]);
                    checkmarks(id,name,program,database,temp);
                    System.out.println(" ");
                    System.out.print("Marks have been Update Successfully.\nDo you Want to update Marks for Another Student?(Y/n)");
                    String command=input.nextLine();
                    switch (command){
                        case "Y":
                            updateMarks(id,name,program,database);
                        case "n":clearConsole();
                            mainMenu(id,name,program,database);
                    }
                }else{
                    num=0;
                }
            }
        }while(num!=0);{
            System.out.println(" ");
            System.out.print("Invalid Student ID.Do you Want to Search Again?(Y/n) ");
            String option =input.nextLine();
            switch (option){
                case "Y":
                    updateMarks(id,name,program,database);
                case "n":clearConsole();
                    mainMenu(id,name,program,database);
            }
        }
    }

    public static void checkmarks(String[]id,String []name,int []program,int[]database,int temp){
        Scanner input=new Scanner(System.in);
        int number;
        do{
            if(program[temp]==0&&database[temp]==0){
                number=1;
                System.out.println(" ");
                System.out.println("This student's marks not yet to be added.");
                System.out.print("Do you Want to Update Marks of  Another Student?(Y/n)");
                String  command=input.nextLine();
                switch(command){
                    case "Y":clearConsole();
                        updateMarks(id,name,program,database);
                    case"n":clearConsole();
                        mainMenu(id,name,program,database);
                }
            }else{
                number=0;
            }
        }while(number!=0);{
            System.out.println(" Programming Fundamentals Marks       :"+program[temp]);
            System.out.println("Database Management System Marks      :"+database[temp]);
        }

        int m;
        int proMarks;
        do{
            System.out.print("Enter Programming Fundamentals Marks :");
            proMarks=input.nextInt();
            if(proMarks<0||proMarks>100){
                m=1;
                System.out.println("Invalid Marks,please Enter Correct Marks");
            }else{ m=0;}

        }while(m!=0);{
            program[temp]=proMarks;
        }

        int num1;
        int dbmsMarks;
        do{
            System.out.print("Enter Database Management System Marks :");
            dbmsMarks=input.nextInt();
            if(dbmsMarks<0||dbmsMarks>100){
                num1=1;
                System.out.println("Invalid Marks,please Enter Correct Marks");
            }else{ num1=0;}

        }while(num1!=0);{
            database[temp]=dbmsMarks;
        }
    }

    public static void deleteStudent(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                    DELETE STUDENT                                   |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        String searchID;
        int index= findNextIndexString(id);
        int num=0;
        int temp;
        do{
            System.out.print("Enter Student ID :");
            searchID=input.nextLine();
            for(int x=0;x<index;x++){
                if(id[x].equals(searchID)){
                    num=1;
                    temp=x;
                    index= findNextIndexString(id);
                    for(int i=temp; i<index;i++){
                        id[i]=id[i+1];
                        name[i]=name[i+1];
                        program[i]=program[i+1];
                        database[i]=database[i+1];
                    }
                    System.out.println(" ");
                    System.out.print("Student has been Delete Successfully.\nDo you Want to Delete Another Student?(Y/n) ");
                    String command=input.nextLine();
                    switch (command){
                        case "Y":
                            deleteStudent(id,name,program,database);
                        case "n":clearConsole();
                            mainMenu(id,name,program,database);
                    }
                }else{
                    num=0;
                }
            }
        }while(num!=0);{
            System.out.println(" ");
            System.out.print("Invalid Student ID.Do you Want to Search Again?(Y/n) ");
            String option =input.nextLine();
            switch (option){
                case "Y":
                    deleteStudent(id,name,program,database);
                case "n":clearConsole();
                    mainMenu(id,name,program,database);
            }
        }
    }



    public static void printStudentDetails(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        int num=0;
        int temp;
        double xr=2.00;
        String searchID;
        int index= findNextIndexString(id);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                Print Student Details                                |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(" ");
        do{
            System.out.print("Enter Student ID :");
            searchID=input.nextLine();

            for(int x=0;x<index;x++){
                if(id[x].equals(searchID)){
                    num=1;
                    temp=x;
                    System.out.println("Student Name :"+name[temp]);
                    if (program[temp] == 0 && 0 == database[temp]) {
                        System.out.println(" ");
                        System.out.println("THIS Student Marks Not Added. ");
                        System.out.print("Do You Want to Search Again?(Y/n) ");
                        String option = input.nextLine();
                        switch (option) {
                            case "Y":
                                printStudentDetails(id, name, program, database);
                            case "n":
                                clearConsole();
                                mainMenu(id, name, program, database);
                        }
                    }

                    System.out.println("+----------------------------------+------------------------------------+");
                    System.out.println("|Programming Fundamentals Marks    |\t\t\t\t    "+program[temp]+"  |");
                    System.out.println("|Database Management System Marks  |\t\t\t\t    "+database[temp]+"  |");
                    System.out.println("|Total Marks 			   |\t\t\t\t    "        +(program[temp]+database[temp])+" |");
                    System.out.println("|Average Marks                     |\t\t\t\t  "+((program[temp]+database[temp])/xr)+"  |");
                    System.out.println("|Total. Marks      		   | \t\t\t\t"	+(program[temp]+database[temp])+"      |");
                    System.out.println("|Rank                              |\t\t\t\t "+"                              |");
                    System.out.println("+----------------------------------+------------------------------------+");

                    System.out.print("Do you Want to Search Another Student Details?(Y/n)");
                    String option =input.nextLine();
                    switch (option){
                        case "Y":
                            printStudentDetails(id,name,program,database);
                        case "n":clearConsole();
                            mainMenu(id,name,program,database);
                    }
                }else{
                    num=0;
                }
            }

        }while(num!=0);{
            System.out.println(" ");
            System.out.print("Invalid Student ID.Do You Want to Search Again?(Y/n) ");
            String option =input.nextLine();
            switch (option){
                case "Y":
                    printStudentDetails(id,name,program,database);
                case "n":clearConsole();
                    mainMenu(id,name,program,database);
            }
        }
    }

    public static void printStudentRank(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                                  Print Student Ranks                                |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        int index= findNextIndexString(id);
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|Rank    |   ID      |    Name      |    Total Marks    |    Avg.Marks|");
        System.out.println("+---------------------------------------------------------------------+");
        for(int x=0;x<index;x++){
            System.out.print("  "+(x+1)+" \t\t"+id[x]+"\t"+name[x]+"\t\t"+(program[x]+database[x])+"\t\t  "+((program[x]+database[x])/2.0)+"\n");
        }

        System.out.println("+---------------------------------------------------------------------+");
        System.out.println(" ");
        System.out.print("Do you Want to Go Back to Main Menu?(Y/n):");
        String option=input.nextLine();
        switch(option){
            case "Y":clearConsole();
                mainMenu(id,name,program,database);
            case"n":
                printStudentRank(id,name,program,database);
        }
    }

    public static void bestInProFun(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                       BEST IN PROGRAMMING FUNDAMENTALS                              |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|     ID    |   Name        |    PF marks      |    DBMS Marks        |");
        System.out.println("+---------------------------------------------------------------------+");

        int index= findNextIndexString(id);
        for(int i=0; i<index; i++){
            System.out.print("\t"+id[i]+"\t"+name[i]+"\t\t"+program[i]+"\t\t\t"+database[i]+"\n");
        }
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println(" ");
        System.out.print("Do you Want to Go Back to Main Menu?(Y/n):");
        String option=input.nextLine();
        switch(option){
            case "Y":clearConsole();
                mainMenu(id,name,program,database);
            case"n":
                bestInProFun(id,name,program,database);
        }
    }

    public static void bestInDbms(String[]id, String []name, int []program, int[]database){
        Scanner input=new Scanner(System.in);
        clearConsole();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("|                       BEST IN DATABASE MANAGEMENT SYSTEM                            |");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("   ");
        int index= findNextIndexString(id);
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|     ID    |   Name        |    PF marks      |    DBMS Marks        |");
        System.out.println("+---------------------------------------------------------------------+");
        for(int i=0; i<index; i++){
            System.out.print("\t"+id[i]+"\t"+name[i]+"\t\t"+program[i]+"\t\t\t"+database[i]+"\n");
        }
        System.out.println("+---------------------------------------------------------------------+");

        System.out.println(" ");
        System.out.print("Do you Want to Go Back to Main Menu?(Y/n):");
        String option=input.nextLine();
        switch(option){
            case "Y":clearConsole();
                mainMenu(id,name,program,database);
            case "n":
                bestInDbms(id,name,program,database);
        }
    }

    public static void main(String[] args){
        String[] sId =new String[1000];
        String[] sName =new String[sId.length];
        int[] mProFun =new int[sId.length];
        int[] mDbms =new int[sId.length];
        mainMenu(sId,sName,mProFun,mDbms);

    }
}
