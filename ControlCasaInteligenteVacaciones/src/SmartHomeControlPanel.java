import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class SmartHomeControlPanel extends JFrame implements HomeObserver {
    private RemoteControl remoteControl;
    private CommandsStack commandStack;
    private SmartHomeUI smartHomeUI;
    
    

    public SmartHomeControlPanel(RemoteControl remoteControl, CommandsStack commandStack, SmartHomeUI smartHomeUI) {
        this.remoteControl = remoteControl;
        this.commandStack = commandStack;
        this.smartHomeUI = smartHomeUI;
        

        setTitle("Smart Home Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10));

        // Crear los botones
        JButton lightOnButton = new JButton("Turn On Light");
        JButton lightOffButton = new JButton("Turn Off Light");
        JButton undoButton = new JButton("Undo");
        JButton ceilingFanOnButton = new JButton("Turn On Ceiling Fan");
        JButton ceilingFanOffButton = new JButton("Turn Off Ceiling Fan");
        JButton garageDoorUpButton = new JButton("Open Garage Door");
        JButton garageDoorDownButton = new JButton("Close Garage Door");
        JButton stereoOnButton = new JButton("Turn On Stereo");
        JButton stereoOffButton = new JButton("Turn Off Stereo");
        JButton hottubOnButton = new JButton("Turn On Hottub");
        JButton hottubOffButton = new JButton("Turn Off Hottub");
        JButton tvOnButton = new JButton("Encender TV");
        JButton tvOffButton = new JButton("Apagar TV");
        JButton securityCameraOnButton = new JButton("Turn On Security Camera");
        JButton securityCameraOffButton = new JButton("Turn Off Security Camera");
        JButton doorLockLockButton = new JButton("Lock Door Lock");
        JButton doorLockUnlockButton = new JButton("Unlock Door Lock");
        JButton vacationModeButton = new JButton("Modo Vacaciones");

        // Encender luz
        lightOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command lightOnCommand = new LivingRoomLightOnCommand(new Light("Living Room"));
                lightOnCommand.execute();
                commandStack.push(lightOnCommand);

                updateLight(true);
                
            }
        });

        // Apagar luz
        lightOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command lightOffCommand = new LivingroomLightOffCommand(new Light("Living Room"));
                lightOffCommand.execute();
                commandStack.push(lightOffCommand);
                updateLight(false);
            }
        });

        //Undo
        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!commandStack.isEmpty()) {
                    Command lastCommand = commandStack.pop();
                    lastCommand.undo();     
                    if(lastCommand.getClass().getName().equals("LivingroomLightOffCommand")) {
                        updateLight(true);
                    }
                    if(lastCommand.getClass().getName().equals("LivingRoomLightOnCommand")) {
                        updateLight(false);
                    }   
                    if(lastCommand.getClass().getName().equals("CeilingFanOnCommand")) {
                        updateFan(false);
                    }   
                    if(lastCommand.getClass().getName().equals("CeilingFanOffCommand")) {
                        updateFan(true);
                    }                
                    if(lastCommand.getClass().getName().equals("GarageDoorUpCommand")) {
                        updateGarage(false);
                    }   
                    if(lastCommand.getClass().getName().equals("GarageDoorDownCommand")) {
                        updateGarage(true);
                    }  
                    if(lastCommand.getClass().getName().equals("StereoOnWithCDCommand")) {
                        updateStereo(false);
                    }   
                    if(lastCommand.getClass().getName().equals("StereoOffCommand")) {
                        updateStereo(true);
                    }  
                    if(lastCommand.getClass().getName().equals("HottubOnCommand")) {
                        updateHottub(false);
                    }   
                    if(lastCommand.getClass().getName().equals("HottubOffCommand")) {
                        updateHottub(true);
                    } 
                    if(lastCommand.getClass().getName().equals("tvOnCommand")) {
                        updateTV(false);
                    }   
                    if(lastCommand.getClass().getName().equals("tvOffCommand")) {
                        updateTV(true);
                    } 
                    if(lastCommand.getClass().getName().equals("SecurityCameraOnCommand")) {
                        updateCamera(false);
                    }   
                    if(lastCommand.getClass().getName().equals("SecurityCameraOffCommand")) {
                        updateCamera(true);
                    } 
                    if(lastCommand.getClass().getName().equals("DoorLockLockCommand")) {
                        updateLock(false);
                    }   
                    if(lastCommand.getClass().getName().equals("DoorLockUnlockCommand")) {
                        updateLock(true);
                    }   
                }
            }
        });

        ceilingFanOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command ceilingFanOnCommand = new CeilingFanOnCommand(new CeilingFan("Living Room"));
                ceilingFanOnCommand.execute();
                commandStack.push(ceilingFanOnCommand);
                updateFan(true);
            }
        });

        ceilingFanOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command ceilingFanOffCommand = new CeilingFanOffCommand(new CeilingFan("Living Room"));
                ceilingFanOffCommand.execute();
                commandStack.push(ceilingFanOffCommand);
                updateFan(false);
            }
        });

        // Garage open
        garageDoorUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command garageDoorUpCommand = new GarageDoorUpCommand(new GarageDoor("Garage"));
                garageDoorUpCommand.execute();
                commandStack.push(garageDoorUpCommand);
                updateGarage(true);
            }
        });

        // Gagare close 
        garageDoorDownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command garageDoorDownCommand = new GarageDoorDownCommand(new GarageDoor("Garage"));
                garageDoorDownCommand.execute();
                commandStack.push(garageDoorDownCommand);
                updateGarage(false);
            }
        });

        //Stereo
        stereoOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command stereoOnCommand = new StereoOnWithCDCommand(new Stereo("Living Room"));
                stereoOnCommand.execute();
                commandStack.push(stereoOnCommand);
                updateStereo(true);
            }
        });

        // Stereo
        stereoOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command stereoOffCommand = new StereoOffCommand(new Stereo("Living Room"));
                stereoOffCommand.execute();
                commandStack.push(stereoOffCommand);
                updateStereo(false);
            }
        });

        hottubOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command hottubOnCommand = new HottubOnCommand(new Hottub());
                hottubOnCommand.execute();
                commandStack.push(hottubOnCommand);
                updateHottub(true);
            }
        });

        hottubOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command hottubOffCommand = new HottubOffCommand(new Hottub());
                hottubOffCommand.execute();
                commandStack.push(hottubOffCommand);
                updateHottub(false);
            }
        });

        // Encender TV
        tvOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command tvOnCommand = new tvOnCommand(new Tv("Sala de estar"));
                tvOnCommand.execute();
                commandStack.push(tvOnCommand);
                updateTV(true);
            }
        });

        
        // Apagar TV
        tvOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command tvOffCommand = new tvOffCommand(new Tv("Sala de estar"));
                tvOffCommand.execute();
                commandStack.push(tvOffCommand);
                updateTV(false);
            }
        });
        // Agregar acciones para cámaras de seguridad
        securityCameraOnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command securityCameraOnCommand = new SecurityCameraOnCommand(new SecurityCamera("Front Yard"));
                securityCameraOnCommand.execute();
                commandStack.push(securityCameraOnCommand);
                updateCamera(true);
            }
        });

        securityCameraOffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command securityCameraOffCommand = new SecurityCameraOffCommand(new SecurityCamera("Front Yard"));
                securityCameraOffCommand.execute();
                commandStack.push(securityCameraOffCommand);
                updateCamera(false);
            }
        });

        // Agregar acciones para seguros de puertas
        doorLockLockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command doorLockLockCommand = new DoorLockLockCommand(new DoorLock("Main Door"));
                doorLockLockCommand.execute();
                commandStack.push(doorLockLockCommand);
                updateLock(true);
            }
        });

        doorLockUnlockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Command doorLockUnlockCommand = new DoorLockUnlockCommand(new DoorLock("Main Door"));
                doorLockUnlockCommand.execute();
                commandStack.push(doorLockUnlockCommand);
                updateLock(false);
            }
        });

        vacationModeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    public void run() {
                        while (!commandStack.isEmpty()) {
                            Command command = commandStack.pop();
                            command.execute();
                            
                    if(command.getClass().getName().equals("LivingroomLightOffCommand")) {
                        updateLight(true);
                    }
                    if(command.getClass().getName().equals("LivingRoomLightOnCommand")) {
                        updateLight(false);
                    }   
                    if(command.getClass().getName().equals("CeilingFanOnCommand")) {
                        updateFan(true);
                    }   
                    if(command.getClass().getName().equals("CeilingFanOffCommand")) {
                        updateFan(false);
                    }                
                    if(command.getClass().getName().equals("GarageDoorUpCommand")) {
                        updateGarage(true);
                    }   
                    if(command.getClass().getName().equals("GarageDoorDownCommand")) {
                        updateGarage(false);
                    }  
                    if(command.getClass().getName().equals("StereoOnWithCDCommand")) {
                        updateStereo(true);
                    }   
                    if(command.getClass().getName().equals("StereoOffCommand")) {
                        updateStereo(false);
                    }  
                    if(command.getClass().getName().equals("HottubOnCommand")) {
                        updateHottub(true);
                    }   
                    if(command.getClass().getName().equals("HottubOffCommand")) {
                        updateHottub(false);
                    } 
                    if(command.getClass().getName().equals("tvOnCommand")) {
                        updateTV(true);
                    }   
                    if(command.getClass().getName().equals("tvOffCommand")) {
                        updateTV(false);
                    } 
                    if(command.getClass().getName().equals("SecurityCameraOnCommand")) {
                        updateCamera(true);
                    }   
                    if(command.getClass().getName().equals("SecurityCameraOffCommand")) {
                        updateCamera(false);
                    } 
                    if(command.getClass().getName().equals("DoorLockLockCommand")) {
                        updateLock(true);
                    }   
                    if(command.getClass().getName().equals("DoorLockUnlockCommand")) {
                        updateLock(false);
                    }  
                            try {
                                Thread.sleep(5000); // Retraso de 10 segundos
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                };
                timer.schedule(task, 0); // Comenzar la ejecución inmediatamente
            }
        });
        
        
    

        // Agregar botones
        mainPanel.add(lightOnButton);
        mainPanel.add(lightOffButton);
        mainPanel.add(ceilingFanOnButton);
        mainPanel.add(ceilingFanOffButton);
        mainPanel.add(garageDoorUpButton);
        mainPanel.add(garageDoorDownButton);
        mainPanel.add(stereoOnButton);
        mainPanel.add(stereoOffButton);
        mainPanel.add(hottubOnButton);
        mainPanel.add(hottubOffButton);
        mainPanel.add(tvOnButton);
        mainPanel.add(tvOffButton);
        mainPanel.add(securityCameraOnButton);
        mainPanel.add(securityCameraOffButton);
        mainPanel.add(doorLockLockButton);
        mainPanel.add(doorLockUnlockButton);
        mainPanel.add(undoButton);
        mainPanel.add(vacationModeButton);
       
        

        add(mainPanel);
        pack();
        



        
    }

    @Override
    public void updateLight(boolean state) {
        smartHomeUI.setLightButton(state);
    }

    @Override
    public void updateFan(boolean state) {
        smartHomeUI.setFanButton(state);
    }

    @Override
    public void updateGarage(boolean state) {
        smartHomeUI.setGarageButton(state);
    }

    @Override
    public void updateStereo(boolean state) {
        smartHomeUI.setStereoButton(state);
    }

    @Override
    public void updateTV(boolean state) {
        smartHomeUI.setTvButton(state);
    }

    @Override
    public void updateCamera(boolean state) {
        smartHomeUI.setCameraButton(state);
    }

    @Override
    public void updateLock(boolean state) {
        smartHomeUI.setLockButton(state);
    }

    @Override
    public void updateHottub(boolean state) {
        smartHomeUI.setHottubButton(state);
    } 

    
    



    public static void main(String[] args) {
        CommandsStack commandStack = new CommandsStack();
        RemoteControl remoteControl = new RemoteControl();
        SmartHomeUI smartHomeUI = new SmartHomeUI();
        SmartHomeControlPanel controlPanel = new SmartHomeControlPanel(remoteControl, commandStack,smartHomeUI);
        controlPanel.setVisible(true);
        smartHomeUI.setVisible(true);
    }
}