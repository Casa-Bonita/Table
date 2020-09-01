import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Dimension dimensionFrame = new Dimension(1000, 1000);
        Dimension dimensionContent = new Dimension(950, 950);
        Dimension dimensionTable = new Dimension(950, 950);

        UserInterface ui = new UserInterface(dimensionFrame, dimensionContent, dimensionTable);
        ui.createUI();

    }
}
