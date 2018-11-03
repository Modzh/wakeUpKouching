import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class wakeUpCall {
    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter hour (without 0)");
        int hour = scanner.nextInt();
        System.out.println("enter minute (without 0)");
        int minute = scanner.nextInt();
        Date curDate = Calendar.getInstance().getTime();
        Date al = new Date();
        if (curDate.getHours() > hour) {
            al.setDate(curDate.getDate() + 1);
        }
        al.setHours(hour);
        al.setMinutes(minute);
        long need = al.getTime() - curDate.getTime();
        System.out.println(need);
        sleep(need);
        WebDriver browser;
        String path = new File(
                wakeUpCall.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("https://music.yandex.ru/users/uid-axna42s2/playlists/3");
        sleep(2000);
        WebElement buttonPlay = browser.findElement(
                By.xpath("//*[@id=\"nb-1\"]/body/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[2]/div/div/button"));
        buttonPlay.click();
        browser.switchTo().window((String) browser.getWindowHandles().toArray()[0]);
         browser.findElement(
                By.xpath("//*[@id=\"nb-1\"]/body/div[1]/div[10]/div[1]/div[2]/div[8]/div[2]")).click();
        browser.findElement(
                By.xpath("//*[@id=\"nb-1\"]/body/div[1]/div[10]/div[1]/div[2]/div[4]")).click();
    }
}
