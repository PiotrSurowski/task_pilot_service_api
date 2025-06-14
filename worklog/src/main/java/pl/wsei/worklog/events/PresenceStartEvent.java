package pl.wsei.worklog.events;
public class PresenceStartEvent {
    private final Integer userId;
    public PresenceStartEvent(Integer userId) { this.userId = userId; }
    public Integer getUserId() { return userId; }
}
