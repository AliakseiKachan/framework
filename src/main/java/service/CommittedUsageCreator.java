package service;

import model.CommittedUsage;

public class CommittedUsageCreator {

    public static final String COMMITTED_USAGE = "1";

    /**
     * Committed usage
     * 0 - None
     * 1 - 1 Year
     * 2 - 3 Years
     */

    public static CommittedUsage withCredentialsFromProperty() {
        return new CommittedUsage(COMMITTED_USAGE);
    }
}