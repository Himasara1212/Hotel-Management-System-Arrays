import java.util.*;

public class HotelReservationSystem {
    
    static String[] guestNames;
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
        
        guestNames = new String[0];
        
        hotelBuilding = new String[0][0][0];
        
        for (int floor = 0; floor < 0; floor++) {
            for (int room = 0; room < 0; room++) {
                for (int bed = 0; bed < 0; bed++) {
                    hotelBuilding[floor][room][bed] = "Available";
                }
            }
        }
        
        System.out.println("+=======================================================+");
        System.out.println("|            WELCOME HOTEL MANAGEMENT SYSTEM            |");
        System.out.println("+=======================================================+");
        System.out.print("Total Floors: ");
        int floors = sc.nextInt();
        System.out.print("Rooms per floor: ");
        int Rooms = sc.nextInt();
        System.out.print("Beds per room: ");
        int Beds = sc.nextInt();
        System.out.println("Total :" + (floors * Rooms * Beds));
        System.out.println("+=======================================================+\n");
        }
    
        public static void HotelMenu() {
        while (true) {
            System.out.println("+===========================================+");
            System.out.println("|                 HOTEL MENU                |");
            System.out.println("+===========================================+");
            System.out.println("1. Book a Room\t\t\t2. Cancel Booking\n3. View Available Rooms\t\t4. View All Bookings\n5. Generate Bill\t\t6. Search Guest\n7. Exit");
            System.out.println("+===========================================+");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            
            switch (choice) {
                // case 1: bookRoom(); 
                // break;
                // case 2: cancelBooking(); 
                // break;
                // case 3: viewAvailableRooms(); 
                // break;
                // case 4: viewAllBookings(); 
                // break;
                // case 5: generateBill(); 
                // break;
                // case 6: searchGuest(); 
                //break;
                case 7:
                    System.out.println("Thank you bye..");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice..");
            }
        }
    }
}