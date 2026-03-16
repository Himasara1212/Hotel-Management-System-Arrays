import java.util.*;

public class HotelReservationSystem {
    
    static ArrayList<String> guestNamesList;
    static int[] roomRates;
    static String[][][] hotelBuilding;
    
    static Scanner sc = new Scanner(System.in);
    static int guestCount = 0;

    public static void main(String[] args) {
        initializeHotel();
        HotelMenu();
    }

    public static void initializeHotel() {
        roomRates = new int[3];
        roomRates[0] = 5000;
        roomRates[1] = 8000;
        roomRates[2] = 12000;
        
        guestNamesList = new ArrayList<>();
        
        System.out.println("+=======================================================+");
        System.out.println("|            WELCOME HOTEL MANAGEMENT SYSTEM            |");
        System.out.println("+=======================================================+");
        System.out.print("Total Floors: ");
        int floors = sc.nextInt();
        System.out.print("Rooms per floor: ");
        int rooms = sc.nextInt();
        System.out.print("Beds per room: ");
        int beds = sc.nextInt();
        
        hotelBuilding = new String[floors][rooms][beds];
        
        for (int floor = 0; floor < floors; floor++) {
            for (int room = 0; room < rooms; room++) {
                for (int bed = 0; bed < beds; bed++) {
                    hotelBuilding[floor][room][bed] = "Available";
                }
            }
        }
        
        int totalBeds = floors * rooms * beds;
        System.out.println("Total Beds: " + totalBeds);
        System.out.println("+=======================================================+\n\n");
    }
    
    public static void HotelMenu() {
        while (true) {
            System.out.println("+=======================================================+");
            System.out.println("|                       HOTEL MENU                      |");
            System.out.println("+=======================================================+");
            System.out.println("1. Book a Room\t\t\t2. Cancel Booking\n3. View Available Rooms\t\t4. View All Bookings\n5. Generate Bill\t\t6. Search Guest\n7. Exit");
            System.out.println("+=======================================================+");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: bookRoom(); 
                break;
                case 2: cancelBooking(); 
                break;
                // case 3: viewAvailableRooms(); 
                // break;
                // case 4: viewAllBookings(); 
                // break;
                // case 5: generateBill(); 
                // break;
                // case 6: searchGuest(); 
                // break;
                case 7:
                    System.out.println("Thank you bye..");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice..");
            }
        }
    }

    public static void bookRoom() {
        System.out.print("Enter floor number : ");
        int floor = sc.nextInt();
        
        if (floor < 0 || floor >= hotelBuilding.length) {
            System.out.println("Invalid floor");
            return;
        }
        
        System.out.print("Enter room number : ");
        int room = sc.nextInt();
        
        if (room < 0 || room >= hotelBuilding[0].length) {
            System.out.println("Invalid room");
            return;
        }
        
        System.out.print("Enter bed number : ");
        int bed = sc.nextInt();
        
        if (bed < 0 || bed >= hotelBuilding[0][0].length) {
            System.out.println("Invalid bed");
            return;
        }
        
        if (hotelBuilding[floor][room][bed].equals("Available")) {
            sc.nextLine();
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            
            guestNamesList.add(name); 
            hotelBuilding[floor][room][bed] = name;
            
            System.out.println("\n+=======================================================+");
            System.out.println("|                ROOM BOOKED SUCCESSFULLY                |");
            System.out.println("+=======================================================+");
            System.out.println("Location : Floor " + floor + ", Room " + room + ", Bed " + bed);
            System.out.println("Guest: " + name);
            System.out.println("Total Guests: " + guestNamesList.size()); 
            System.out.println("+=======================================================+\n");
            
        } else {
            System.out.println("This bed booked: " + hotelBuilding[floor][room][bed]);
        }
    }

    public static void cancelBooking() {
        System.out.println("\n+=======================================================+");
        System.out.println("|                  ROOM BOOKING CANCEL                  |");
        System.out.println("+=======================================================+");
            
        System.out.print("Enter floor number: ");
        int floor = sc.nextInt();

        if (floor < 0 || floor >= hotelBuilding.length) {
            System.out.println("Invalid floor");
            return;
        }

        System.out.print("Enter room number: ");
        int room = sc.nextInt();

        if (room < 0 || room >= hotelBuilding[0].length) {
            System.out.println("Invalid room");
            return;
        }

        System.out.print("Enter bed number: ");
        int bed = sc.nextInt();

        if (bed < 0 || bed >= hotelBuilding[0][0].length) {
            System.out.println("Invalid bed");
            return;
        }

        if (!hotelBuilding[floor][room][bed].equals("Available")) {
            String guestName = hotelBuilding[floor][room][bed];

            hotelBuilding[floor][room][bed] = "Available";
            
            guestNamesList.remove(guestName);
            
            System.out.println("\n+=======================================================+");
            System.out.println("|                BOOKING CANCELLED SUCCESSFULLY          |");
            System.out.println("+=======================================================+");
            System.out.println("Location : Floor " + floor + ", Room " + room + ", Bed " + bed);
            System.out.println("Guest: " + guestName);
            System.out.println("Remaining Guests: " + guestNamesList.size());
            System.out.println("+=======================================================+\n");
        } else {
            System.out.println("Bed available.");
        }
    }
}