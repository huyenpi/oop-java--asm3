import java.util.ArrayList;
import java.util.Scanner;
public class HumanResoucres {
    public static void main(String[] args) {
        // tạo danh sách các bộ phận trong công ty
        ArrayList<Department> listD = new ArrayList<>();

        Department personelAd = new Department("Hành Chính - Nhân Sự");
        Department technical = new Department("Kĩ Thuật");
        Department qualityMn = new Department("Quản Lí Chất Lượng");
        Department sales = new Department("Kinh Doanh");
        Department customerSv = new Department("Chăm Sóc Khách Hàng");

        listD.add(personelAd);
        listD.add(technical);
        listD.add(qualityMn);
        listD.add(sales);
        listD.add(customerSv);

        // tạo danh sách quản lí hiện có
        ArrayList<Manager> listM = new ArrayList<>();

        Manager m1 = new Manager("Nguyễn Thị A", "Business Leader");
        m1.setYearOfBirth(1990);
        m1.setCoSalary(6.4);
        m1.setDepartment(sales);
        listM.add(m1);

        Manager m2 = new Manager("Lê Văn B", "Project Leader");
        m2.setYearOfBirth(1992);
        m2.setCoSalary(6.1);
        m2.setDepartment(personelAd);
        listM.add(m2);

        Manager m3 = new Manager("Lê Văn C ", "Technical Leader");
        m3.setYearOfBirth(1993);
        m3.setCoSalary(6.0);
        m3.setDepartment(technical);
        listM.add(m3);

        Manager m4 = new Manager("Nguyễn Thị D ", "Project Leader");
        m4.setYearOfBirth(1994);
        m4.setCoSalary(5.8);
        m4.setDepartment(qualityMn);
        listM.add(m4);

        Manager m5 = new Manager("Lê Văn E ", "Technical Leader");
        m5.setYearOfBirth(1994);
        m5.setCoSalary(5.9);
        m5.setDepartment(customerSv);
        listM.add(m5);

        // tạo danh sách nhân viên hiện có
        ArrayList<Employee> listE = new ArrayList<>();

        Employee e1 = new Employee("Trần Minh Huyền");
        e1.setYearOfBirth(1999);
        e1.setDepartment(customerSv);
        e1.setOtHours(6);
        listE.add(e1);

        Employee e2 = new Employee("Trần Hải Anh");
        e2.setYearOfBirth(1998);
        e2.setDepartment(qualityMn);
        e2.setOtHours(4);
        listE.add(e2);

        Employee e3 = new Employee("Phan Hà Vy");
        e3.setYearOfBirth(2000);
        e3.setDepartment(technical);
        listE.add(e3);

        Employee e4 = new Employee("Hoa Thiên Thạch");
        e4.setYearOfBirth(1997);
        e4.setDepartment(personelAd);
        e4.setOtHours(7);
        listE.add(e4);

        Employee e5 = new Employee("Phạm Kim Chi");
        e5.setYearOfBirth(1994);
        e5.setDepartment(sales);
        listE.add(e5);

        // Dùng Scanner để nhập dữ liệu/ thêm nv mới
        Scanner scan = new Scanner(System.in);
        int number;
        String yourAnswer;
        String name;
        int yearOfBirth;
        double coSalary;
        String date;
        String nameOfDepartment;
        int dayOff;
        int otHours;
        String title;
        // dùng do while cho phép người dùng chọn lại tính năng
        do {
            do {
                System.out.println("Nhập 1: Để hiển thị danh sách nhân viên hiện có trong công ty.");
                System.out.println("Nhập 2: Để hiển thị các bộ phận trong công ty.");
                System.out.println("Nhập 3: Để hiển thị các nhân viên theo từng bộ phận.");
                System.out.println("Nhập 4: Để thêm nhân viên mới vào công ty.");
                System.out.println("Nhập 5: Để tìm kiếm thông tin nhân viên hoặc mã nhân viên.");
                System.out.println("Nhập 6: Để hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần.");
                System.out.println("Nhập 7: Để hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
                System.out.print("Nhập số để chọn tính năng: ");
                number = scan.nextInt();
                System.out.println();
            } while (number <= 0 || number >= 8);
            if (number == 1) { // tính năng 1: hiển thị ds nhân viên hiện có
                System.out.println("Danh sách " + Staff.getCount() + " nhân viên hiện có trong công ty: ");
                System.out.println();
                for (Manager m : listM) {
                    m.displayInformation();
                    System.out.println();
                }
                for (Employee e : listE) {
                    e.displayInformation();
                    System.out.println();
                }
            } else if (number == 2) { //tính năng 2: hiển thị các bộ phận trong công ty
                System.out.println("Danh sách " + Department.getCountDpm() + " bộ phận trong công ty: ");
                System.out.println();


                for (Manager m : listM) {
                    Department x = m.getDepartment();
                    x.setNumberOfPeople();       //numberOfPeople tăng lên 1 khi nhân viên thuộc bộ phận đó
                }

                for (Employee e : listE) {
                    Department x = e.getDepartment();
                    x.setNumberOfPeople();       //numberOfPeople tăng lên 1 khi nhân viên thuộc bộ phận đó
                }
                for (Department d : listD) { // hiển thị thông tin bộ phận
                    System.out.println(d);
                    System.out.println();
                }
                // reset numberofdepartment
                for (Manager m : listM) {
                    Department x = m.getDepartment();
                    x.resetNumberOfPeople();       //đặt lại numberOfDepartment = 0
                }

                for (Employee e : listE) {
                    Department x = e.getDepartment();
                    x.resetNumberOfPeople();       //đặt lại numberOfDepartment = 0
                }


            } else if (number == 3) { //tính năng 3: hiển thị các nhân viên theo từng bộ phận
                System.out.println("Danh sách các nhân viên theo từng bộ phận.");
                System.out.println();
                System.out.println("Bộ phận Hành Chính - Nhân Sự: ");
                System.out.println();
                for (Manager m : listM) {
                    if(m.getNameOfDepartment().equals("Hành Chính - Nhân Sự")) {
                        m.displayInformation();
                        System.out.println();
                    }
                }
                for (Employee e : listE) {
                    if(e.getNameOfDepartment().equals("Hành Chính - Nhân Sự")) {
                        e.displayInformation();
                        System.out.println();
                    }
                }

                System.out.println("Bộ phận Kĩ Thuật: ");
                System.out.println();
                for (Manager m : listM) {
                    if(m.getNameOfDepartment().equals("Kĩ Thuật")) {
                        m.displayInformation();
                        System.out.println();
                    }
                }
                for (Employee e : listE) {
                    if(e.getNameOfDepartment().equals("Kĩ Thuật")) {
                        e.displayInformation();
                        System.out.println();
                    }
                }
                System.out.println("Bộ phận Quản Lí Chất Lượng: ");
                System.out.println();
                for (Manager m : listM) {
                    if(m.getNameOfDepartment().equals("Quản Lí Chất Lượng")) {
                        m.displayInformation();
                        System.out.println();
                    }
                }
                for (Employee e : listE) {
                    if(e.getNameOfDepartment().equals("Quản Lí Chất Lượng")) {
                        e.displayInformation();
                        System.out.println();
                    }
                }
                System.out.println("Bộ phận Kinh Doanh: ");
                System.out.println();
                for (Manager m : listM) {
                    if(m.getNameOfDepartment().equals("Kinh Doanh")) {
                        m.displayInformation();
                        System.out.println();
                    }
                }
                for (Employee e : listE) {
                    if(e.getNameOfDepartment().equals("Kinh Doanh")) {
                        e.displayInformation();
                        System.out.println();
                    }
                }
                System.out.println("Bộ phận Chăm Sóc Khách Hàng: ");
                System.out.println();
                for (Manager m : listM) {
                    if(m.getNameOfDepartment().equals("Chăm Sóc Khách Hàng")) {
                        m.displayInformation();
                        System.out.println();
                    }
                }
                for (Employee e : listE) {
                    if(e.getNameOfDepartment().equals("Chăm Sóc Khách Hàng")) {
                        e.displayInformation();
                        System.out.println();
                    }
                }
            } else if(number == 4) { // tính năng 4: thêm nhân viên mới vào công ty
                int num;
                do {
                    do {
                        System.out.println("Nhập 1: Để thêm nhân viên thông thường.");
                        System.out.println("Nhập 2: Để thêm nhân viên quản lí.");
                        System.out.print("Nhập số để chọn tính năng: ");
                        num = scan.nextInt();
                    } while(num != 1 && num != 2);
                    if(num == 1) { // thêm nhân viên thông thường
                        System.out.print("Số lượng nhân viên cần thêm: ");
                        int n = scan.nextInt();
                        scan.nextLine();// nhận lấy enter của input trên để nextLine() dưới không bị trôi lệnh
                        for(int i = 1; i <= n; i++) {
                            System.out.println("Nhập thông tin cho nhân viên thứ " + i);
                            System.out.print("\tHọ tên: ");
                            name = scan.nextLine();
                            System.out.print("\tNăm sinh: ");
                            yearOfBirth = scan.nextInt();
                            scan.nextLine();// nhận lấy enter của input trên để nextLine() dưới không bị trôi lệnh
                            System.out.print("\tBộ phận làm việc: ");
                            nameOfDepartment = scan.nextLine();
                            System.out.print("\tNgày vào công ty: ");
                            date = scan.next();
                            System.out.print("\tHệ số lương: ");
                            coSalary = scan.nextDouble();
                            System.out.print("\tSố ngày nghỉ phép :");
                            dayOff = scan.nextInt();
                            System.out.print("\tSố giờ làm thêm: ");
                            otHours = scan.nextInt();
                            scan.nextLine();// nhận lấy enter của input trên để nextLine() dưới không bị trôi lệnh
                            //khởi tạo đối tượng nhân viên mới
                            Employee newE = new Employee(name);
                            newE.setYearOfBirth(yearOfBirth);
                            newE.setDate(date);
                            newE.setCoSalary(coSalary);
                            newE.setDayOff(dayOff);
                            newE.setOtHours(otHours);
                            switch (nameOfDepartment) {
                                case "Hành Chính - Nhân Sự" -> newE.setDepartment(personelAd);
                                case "Kĩ Thuật" -> newE.setDepartment(technical);
                                case "Quản Lí Chất Lượng" -> newE.setDepartment(qualityMn);
                                case "Kinh Doanh" -> newE.setDepartment(sales);
                                case "Chăm Sóc Khách Hàng" -> newE.setDepartment(customerSv);
                            }
                            listE.add(newE); // lưu đối tượng vào list
                        }
                    } else { // thêm nhân viên quản lí
                        System.out.print("Số lượng quản lí cần thêm: ");
                        int n = scan.nextInt();
                        scan.nextLine();
                        for(int i = 1; i <= n; i++) {
                            System.out.println("Nhập thông tin cho quản lí thứ " + i);
                            System.out.print("\tHọ tên: ");
                            name = scan.nextLine();
                            System.out.print("\tNăm sinh: ");
                            yearOfBirth = scan.nextInt();
                            scan.nextLine();
                            System.out.print("\tChức vụ: ");
                            title = scan.nextLine();
                            System.out.print("\tBộ phận làm việc: ");
                            nameOfDepartment = scan.nextLine();
                            System.out.print("\tNgày vào công ty: ");
                            date = scan.next();
                            System.out.print("\tHệ số lương: ");
                            coSalary = scan.nextDouble();
                            System.out.print("\tSố ngày nghỉ phép :");
                            dayOff = scan.nextInt();
                            scan.nextLine();
                            //khởi tạo đối tượng quản lí mới
                            Manager newM = new Manager(name, title);
                            newM.setYearOfBirth(yearOfBirth);
                            newM.setDate(date);
                            newM.setCoSalary(coSalary);
                            newM.setDayOff(dayOff);
                            switch (nameOfDepartment) {
                                case "Hành Chính - Nhân Sự" -> newM.setDepartment(personelAd);
                                case "Kĩ Thuật" -> newM.setDepartment(technical);
                                case "Quản Lí Chất Lượng" -> newM.setDepartment(qualityMn);
                                case "Kinh Doanh" -> newM.setDepartment(sales);
                                case "Chăm Sóc Khách Hàng" -> newM.setDepartment(customerSv);
                            }
                            listM.add(newM); // lưu đối tượng vào list
                        }
                    }
                    System.out.print("Tiếp tục thêm nhân viên mới vào công ty? nhập có hoặc không: ");
                    yourAnswer = scan.next();
                }while(yourAnswer.equalsIgnoreCase("có"));
            } else if (number == 5) { // tính năng 5: tìm kiếm nhân viên theo tên hoặc mã nhân viên
                int num;
                do {
                    System.out.println("Nhập 1: Tìm kiếm theo tên nhân viên.");
                    System.out.println("Nhập 2: Tìm kiếm theo mã nhân viên.");
                    num = scan.nextInt();
                } while (num != 1 && num != 2);
                if(num == 1) { // tìm kiếm nhân viên theo tên
                    scan.nextLine();
                    System.out.print("Tên nhân viên muốn tìm kiếm: ");
                    String searchName = scan.nextLine();
                    int checkM = 0;   // checkM và checkE sẽ tăng lên 1 khi
                    int checkE = 0;   // có nhân viên trong công ty trùng với nhân viên được tìm kiếm
                    for (Manager m : listM) {
                        if (m.getName().equalsIgnoreCase(searchName)) {
                            checkM++;
                            m.displayInformation();
                            System.out.println();
                        }
                    }
                    for (Employee e : listE) {
                        if (e.getName().equalsIgnoreCase(searchName)) {
                            checkE++;
                            e.displayInformation();
                            System.out.println();
                        }
                    }
                    if (checkM == 0 && checkE == 0) {
                        System.out.println("Tên nhân viên không tồn tại.");
                    }
                } else { // tìm kiếm nhân viên theo mã id
                    System.out.print("Mã nhân viên muốn tìm kiếm: ");
                    String searchId = scan.next();
                    int checkM = 0;
                    int checkE = 0;
                    for (Manager m : listM) {
                        if (m.getId().equals(searchId)) {
                            checkM++;
                            m.displayInformation();
                            System.out.println();
                        }
                    }
                    for (Employee e : listE) {
                        if (e.getId().equals(searchId)) {
                            checkE++;
                            e.displayInformation();
                            System.out.println();
                        }
                    }
                    if (checkM == 0 && checkE == 0) {
                        System.out.println("Mã nhân viên không tồn tại.");
                    }
                }
            } else if(number == 6) { //tính năng 6: hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần
                for (int i = 0; i < listM.size() -1; i++) { // sắp xếp danh sách quản lí theo bảng lương giảm dần
                    for(int j = i+1; j < listM.size(); j++) {
                        if(listM.get(i).calculateSalary() < listM.get(j).calculateSalary()) {
                           Manager tempM = listM.get(j);
                            listM.set(j,listM.get(i));
                            listM.set(i,tempM);
                        }
                    }
                }
                for (int i = 0; i < listE.size() -1; i++) { // sắp xếp danh sách nhân viên theo bảng lương giảm dần
                    for(int j = i+1; j < listE.size(); j++) {
                        if(listE.get(i).calculateSalary() < listE.get(j).calculateSalary()) {
                          Employee  tempE = listE.get(j);
                            listE.set(j,listE.get(i));
                            listE.set(i,tempE);
                        }
                    }
                }
                System.out.println("Bảng lương của nhân viên toàn công ty theo thứ tự giảm dần:");
                for (Manager m : listM) {
                    m.displayInformation();
                    System.out.println();
                }
                for (Employee e : listE) {
                    e.displayInformation();
                    System.out.println();
                }
            } else { // tính năng 7: hiển thị bảng lương của nhân viên theo thứ tự tăng dần.
                for (int i = 0; i < listE.size() -1; i++) { // sắp xếp danh sách nhân viên theo bảng lương tăng dần
                    for(int j = i+1; j < listE.size(); j++) {
                        if(listE.get(i).calculateSalary() > listE.get(j).calculateSalary()) {
                           Employee tempE = listE.get(j);
                            listE.set(j,listE.get(i));
                            listE.set(i,tempE);
                        }
                    }
                }
                System.out.println("Bảng lương của nhân viên theo thứ tự tăng dần:");
                for (Employee e : listE) {
                    e.displayInformation();
                    System.out.println();
                }
            }
                System.out.print("Tiếp tục chọn tính năng? nhập có hoặc không: ");
                yourAnswer = scan.next();
            System.out.println();
            } while (yourAnswer.equalsIgnoreCase("có")) ;



    }
}

