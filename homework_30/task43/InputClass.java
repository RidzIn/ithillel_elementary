package task43;

import java.util.List;

public class InputClass implements Input {
    TouchEvent touchEvent;
    KeyEvent keyEvent;
    @Override
    public boolean isKeyPressed(int keyCode) {
        return false;
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return false;
    }

    @Override
    public int getTouchX(int pointer) {
        return 0;
    }

    @Override
    public int getTouchY(int pointer) {
        return 0;
    }

    @Override
    public float getAccelX() {
        return touchEvent.x;
    }

    @Override
    public float getAccelY() {
        return TouchEvent.TOUCH_DOWN;
    }

    @Override
    public float getAccelZ() {
        return 0;
    }

    @Override
    public List<KeyEvent> getKeyEvents() {
        return null;
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return null;
    }
}
