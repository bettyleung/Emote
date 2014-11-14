package com.davishacks.emote;

/**
 * Created by 1 on 11/14/2014.
 */
public class DbService {

    private static DbService dbServiceInstance;
    private DataSource mDataSource;

    private DbService() {
        mDataSource = new DataSource(MainApplication.getAppContext());
    }

    public static DbService getInstance() {
        if(null == dbServiceInstance) {
            dbServiceInstance = new DbService();
        }
        return dbServiceInstance;
    }

    public DataSource getDataSource() {
        return mDataSource;
    }

}
