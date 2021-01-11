import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CountingVisits extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/jpeg");
        BufferedImage myImage = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = myImage.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 50));
        graphics.setColor(Color.RED);
        ServletOutputStream out = resp.getOutputStream();
        try{
            int countVisit = Integer.parseInt(LogVisits.read());
            countVisit ++;
            LogVisits.write(countVisit);
            graphics.drawString(Integer.toString(countVisit), 100, 100);
        } catch (NumberFormatException e){
            LogVisits.write(0);
            graphics.drawString("Counter reset.", 100, 100);
        }
        ImageIO.write(myImage, "jpeg", out);
    }


}
