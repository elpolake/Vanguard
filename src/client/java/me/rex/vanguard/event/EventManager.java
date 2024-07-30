package me.rex.vanguard.event;

import me.rex.vanguard.utils.EventUtil;

public class EventManager implements EventUtil {
    public void init() {
        EVENT_BUS.register(this);
    }
}
