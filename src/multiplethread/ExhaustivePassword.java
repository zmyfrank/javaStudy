package multiplethread;

import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/15 14:08
 */
public class ExhaustivePassword extends Thread {
    private List<String> passWorlds;
    private String passWorld;
    private boolean found = false;

    public ExhaustivePassword(List<String> passWorlds, String passWorld) {
        this.passWorlds = passWorlds;
        this.passWorld = passWorld;
    }

    @Override
    public void run() {
        guessPassWorld(this.passWorlds, 0, passWorld);
    }

    public void guessPassWorld(char[] chars, int index, String passWorld) {
        if (found) {
            return;
        }
        for (short i = '0'; i < 'z'; i++) {
            char a = (char) i;
            if (!Character.isLetterOrDigit(a)) {
                continue;
            }
            chars[index] = a;
            if (index < passWorld.length() - 1) {
                guessPassWorld(chars, index + 1, passWorld);
            } else {
                String guessPassWorld = new String(chars);
                passWorlds.add(guessPassWorld);
                if (guessPassWorld.equals(passWorld)) {
                    System.out.println("找到了真正的密码，密码是:" + guessPassWorld);
                    found = false;
                }
            }
        }
    }
}
