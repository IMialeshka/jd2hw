import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LogVisits {
    private final String nameFile;
    private final String nameFileDel;

    public LogVisits() {
        Calendar calendar = new GregorianCalendar();
        Calendar calendarT = new GregorianCalendar();
        calendarT.add(Calendar.DAY_OF_MONTH, -1);
        this.nameFile = "LogVisitCookie"+calendar.get(Calendar.YEAR)
                        +String.format("%2d", calendar.get(Calendar.MONTH)+1).replace(' ', '0')
                        +String.format("%2d", calendar.get(Calendar.DAY_OF_MONTH)).replace(' ', '0')
                        +".txt";

        this.nameFileDel = "LogVisitCookie"+calendarT.get(Calendar.YEAR)
                +String.format("%2d", calendarT.get(Calendar.MONTH)+1).replace(' ', '0')
                +String.format("%2d", calendarT.get(Calendar.DAY_OF_MONTH)).replace(' ', '0')
                +".txt";
    }

    private static String nameDir (String name) {
        return System.getProperty("user.home") + File.separator + name;
    }

    public void write(int value){
        try(PrintWriter logPrint = new PrintWriter(new FileWriter(nameDir(this.nameFile), false))){
            logPrint.print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(){
        String result = "0";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(nameDir(this.nameFile))))){
            if(reader.ready()){
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void dellPLog(){
        File file = new File(nameDir(this.nameFileDel));
        file.delete();
    }
}
