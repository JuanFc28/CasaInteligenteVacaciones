

public interface HomeObserver {
    void updateLight(boolean state);
    void updateFan(boolean state);
    void updateGarage(boolean state);
    void updateStereo(boolean state);
    void updateTV(boolean state);
    void updateCamera(boolean state);
    void updateLock(boolean state);
    void updateHottub(boolean state);
}