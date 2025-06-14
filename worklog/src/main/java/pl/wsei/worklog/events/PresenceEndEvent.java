package pl.wsei.worklog.events;

public class PresenceEndEvent {
    private final Integer userId;
    public PresenceEndEvent(Integer userId) { this.userId = userId; }
    public Integer getUserId() { return userId; }
}
