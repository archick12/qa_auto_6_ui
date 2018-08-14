package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UserAvatarPage {


    private String userAvatar = "//*[@id=\"details-user-avatar-trigger\"]";
    private String buttonNewAvatar = "//*[@id=\"jira-avatar-uploader\"]";
    private String buttonConfirm = "//*[@id=\"avataror\"]/div[3]/div/input";

    public static void setClipboard(String str) {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }

    public void clickOnUserAvatar() {
        $(By.xpath(userAvatar)).waitUntil(Condition.visible, 3000).click();
    }

    public void UploadNewAvatar() {
        $(By.xpath(userAvatar)).waitUntil(Condition.visible, 3000).click();
        $(By.xpath(buttonNewAvatar)).waitUntil(Condition.visible, 3000).click();

        File file = new File("src/img/ava.png");
        setClipboard(file.getAbsolutePath());

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);

        $(By.xpath(buttonConfirm)).click();

    }
}

