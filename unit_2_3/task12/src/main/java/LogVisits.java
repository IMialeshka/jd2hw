import java.io.*;

public class LogVisits {
    private static String nameDir () {
        return System.getProperty("user.home") + File.separator + "LogVisit.txt";
    }

    public static void write(int value){
        try(PrintWriter logPrint = new PrintWriter(new FileWriter(nameDir(), false))){
            logPrint.print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(){
        String result = "0";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(nameDir())))){
            if(reader.ready()){
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
