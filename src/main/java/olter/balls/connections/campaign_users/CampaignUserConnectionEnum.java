package olter.balls.connections.campaign_users;

public enum CampaignUserConnectionEnum {
  GAME_MASTER("game_master"),
  PLAYER("player"),
  SPECTATOR("spectator");

  private final String value;

  private CampaignUserConnectionEnum(String value) {
    this.value = value;
  }

  private String getValue() {
    return this.value;
  }
}
