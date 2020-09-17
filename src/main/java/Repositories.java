public class Repositories {
    private String id;
    private String name;
    private double numofPushEvent;
    private double numofIssueCommentEvent;
    private double numofIssuesEvent;
    private double numofPullRequestEvent;

    public void addEventtimes(String type) {
        if (type.equals("PushEvent")) {
            numofPushEvent++;
        } else if (type.equals("IssueCommentEvent")) {
            numofIssueCommentEvent++;
        } else if (type.equals("IssuesEvent")) {
            numofIssuesEvent++;
        } else if (type.equals("PullRequestEvent")) {
            numofPullRequestEvent++;
        }
    }

    public double getEventtimes(String type) {
        if (type.equals("PushEvent")) {
            return numofPushEvent;
        } else if (type.equals("IssueCommentEvent")) {
            return numofIssueCommentEvent;
        } else if (type.equals("IssuesEvent")) {
            return numofIssuesEvent;
        } else if (type.equals("PullRequestEvent")) {
            return numofPullRequestEvent;
        } else {
            return -1;
        }
    }

    public Repositories() {
        this.id = "";
        this.name = "";
        this.numofPushEvent = 0;
        this.numofIssueCommentEvent = 0;
        this.numofIssuesEvent = 0;
        this.numofPullRequestEvent = 0;
    }

    public Repositories(String id, String name, double numofPushEvent, double numofIssueCommentEvent, double numofIssuesEvent, double numofPullRequestEvent) {
        this.id = id;
        this.name = name;
        this.numofPushEvent = numofPushEvent;
        this.numofIssueCommentEvent = numofIssueCommentEvent;
        this.numofIssuesEvent = numofIssuesEvent;
        this.numofPullRequestEvent = numofPullRequestEvent;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumofPushEvent(double numofPushEvent) {
        this.numofPushEvent = numofPushEvent;
    }

    public void setNumofIssueCommentEvent(double numofIssueCommentEvent) {
        this.numofIssueCommentEvent = numofIssueCommentEvent;
    }

    public void setNumofIssuesEvent(double numofIssuesEvent) {
        this.numofIssuesEvent = numofIssuesEvent;
    }

    public void setNumofPullRequestEvent(double numofPullRequestEvent) {
        this.numofPullRequestEvent = numofPullRequestEvent;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getNumofPushEvent() {
        return numofPushEvent;
    }

    public double getNumofIssueCommentEvent() {
        return numofIssueCommentEvent;
    }

    public double getNumofIssuesEvent() {
        return numofIssuesEvent;
    }

    public double getNumofPullRequestEvent() {
        return numofPullRequestEvent;
    }
}
