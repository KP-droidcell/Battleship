import javax.swing.*;

public class BattleShipRunner
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                BattleShip game = new BattleShip();
            }
        });
    }
}
