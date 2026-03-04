public class Console {
 
    
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }   

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }

    public static void hideCursor() {
        System.out.print("\033[?25l");
    }

    public static void showCursor() {
        System.out.print("\033[?25h");
    }   
}
