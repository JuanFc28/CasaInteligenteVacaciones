
import javax.swing.*;
import java.awt.*;

public class SmartHomeUI extends JFrame {
    private JButton lightButton;
    private JButton fanButton;
    private JButton garageButton;
    private JButton stereoButton;
    private JButton tvButton;
    private JButton cameraButton;
    private JButton lockButton;
    private JButton hottubButton;

    public SmartHomeUI() {
        setTitle("Smart Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una imagen de la casa (puedes personalizarla según tus necesidades)
        ImageIcon houseIcon = new ImageIcon("casa.jpg");
        JLabel houseLabel = new JLabel(houseIcon);
        houseLabel.setBounds(0, 0, houseIcon.getIconWidth(), houseIcon.getIconHeight());
        add(houseLabel);

        // Crear botones en la posición deseada en la casa
        lightButton = new JButton("Light");
        lightButton.setBounds(410, 255, 100, 30);
        add(lightButton);
        fanButton = new JButton("Fan");
        fanButton.setBounds(280, 120, 100, 30);
        add(fanButton);
        garageButton = new JButton("Garage");
        garageButton.setBounds(100, 270, 100, 30);
        add(garageButton);
        stereoButton = new JButton("Stereo");
        stereoButton.setBounds(500, 70, 100, 30);
        add(stereoButton);
        tvButton = new JButton("TV");
        tvButton.setBounds(410, 380, 100, 30);
        add(tvButton);
        cameraButton = new JButton("Camera");
        cameraButton.setBounds(550, 150, 100, 30);
        add(cameraButton);
        lockButton = new JButton("Lock");
        lockButton.setBounds(550, 270, 100, 30);
        add(lockButton);
        hottubButton = new JButton("Hottub");
        hottubButton.setBounds(100, 120, 100, 30);
        add(hottubButton);

        // Configurar el diseño de la interfaz de la casa
        setLayout(null);
        add(houseLabel);



        pack();
        setLocationRelativeTo(null);
        setTitle("Mostrar Imagen");
        setSize(730, 510); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Llamar al método para cargar y mostrar la imagen
        //mostrarImagen();
    }

    // Métodos para actualizar el estado de los botones en la interfaz de la casa
    public void setLightButton(boolean state) {
        lightButton.setBackground(state ? Color.GREEN : null);
    }

    public void setFanButton(boolean state) {
        fanButton.setBackground(state ? Color.GREEN : null);
    }

    public void setGarageButton(boolean state) {
        garageButton.setBackground(state ? Color.GREEN : null);
    }

    public void setStereoButton(boolean state) {
        stereoButton.setBackground(state ? Color.GREEN : null);
    }

    public void setTvButton(boolean state) {
        tvButton.setBackground(state ? Color.GREEN : null);
    }

    public void setCameraButton(boolean state) {
        cameraButton.setBackground(state ? Color.GREEN : null);
    }

    public void setLockButton(boolean state) {
        lockButton.setBackground(state ? Color.GREEN :null);
    }

    public void setHottubButton(boolean state) {
        hottubButton.setBackground(state ? Color.GREEN :null);
    }
}
