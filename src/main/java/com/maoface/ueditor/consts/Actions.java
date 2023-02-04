package com.maoface.ueditor.consts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuxuchao
 * @date 2020-04-16 15:21
 */
public class Actions {
    private static final Map<String, Integer> ACTIONS = new HashMap<>();
    public static final int CONFIG = 0;
    public static final int UPLOAD_IMAGE = 1;
    public static final int UPLOAD_VIDEO = 2;
    public static final int UPLOAD_FILE = 3;
    public static final int UPLOAD_SCRAWL = 4;
    public static final int CATCH_IMAGE = 5;
    public static final int LIST_FILE = 6;
    public static final int LIST_IMAGE = 7;

    static {
        
        ACTIONS.put(Constants.Action.CONFIG, CONFIG);
        ACTIONS.put(Constants.Action.UPLOAD_IMAGE, UPLOAD_IMAGE);
        ACTIONS.put(Constants.Action.UPLOAD_VIDEO, UPLOAD_VIDEO);
        ACTIONS.put(Constants.Action.UPLOAD_FILE, UPLOAD_FILE);
        ACTIONS.put(Constants.Action.UPLOAD_SCRAWL, UPLOAD_SCRAWL);
        ACTIONS.put(Constants.Action.LIST_FILE, LIST_FILE);
        ACTIONS.put(Constants.Action.LIST_IMAGE, LIST_IMAGE);
        ACTIONS.put(Constants.Action.CATCH_IMAGE, CATCH_IMAGE);
        
    }

    public static boolean containsKey(String action) {
        return ACTIONS.containsKey(action);
    }

    public static int getAction(String action) {
        return ACTIONS.get(action);
    }
}
