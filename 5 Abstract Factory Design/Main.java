import java.util.Scanner;

interface IButton {
    void press();
}

class MacButton implements IButton {
    @Override
    public void press() {
        System.out.println("Mac button pressed");
    }
}

class WinButton implements IButton {
    @Override
    public void press() {
        System.out.println("Win button pressed");
    }
}

interface ITextBox {
    void showText();
}

class MacTextBox implements ITextBox {
    @Override
    public void showText() {
        System.out.println("Showing Mac TextBox");
    }
}

class WinTextBox implements ITextBox {
    @Override
    public void showText() {
        System.out.println("Showing Win TextBox");
    }
}

interface IFactory {
    IButton createButton();
    ITextBox createTextBox();
}

class WinFactory implements IFactory {
    @Override
    public IButton createButton() {
        return new WinButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new WinTextBox();
    }
}

class MacFactory implements IFactory{
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacTextBox();
    }
}

class GUIAbstractFactory {
    public static IFactory createFactory(String osType) {
        if (osType.equals("mac")) {
            return new MacFactory();
        }
        else if (osType.equals("windows")) {
            return new WinFactory();
        }
        else {
            return new MacFactory(); //default to MacFactory
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your machine OS: ");
        String osType = scanner.nextLine();

        IFactory factory = GUIAbstractFactory.createFactory(osType);

        IButton button = factory.createButton();
        button.press();

        ITextBox textBox = factory.createTextBox();
        textBox.showText();

        scanner.close();
    }
}
