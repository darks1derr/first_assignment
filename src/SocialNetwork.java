public class SocialNetwork {

    private String appName;
    private String description;
    private String founder;
    private String version;

    public SocialNetwork(String appName, String description, String founder, String version) {
        this.appName = appName;
        this.description = description;
        this.founder = founder;
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public String getDescription() {
        return description;
    }

    public String getFounder() {
        return founder;
    }

    public String getVersion() {
        return version;
    }

    public void showInfo() {
        System.out.println("App name: " + appName);
        System.out.println("Description: " + description);
        System.out.println("Founder: " + founder);
        System.out.println("Version: " + version);
    }
}
