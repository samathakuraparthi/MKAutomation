package com.mk.managers;

import com.mk.dataProviders.ConfigFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReadManager {
    private static final Logger logger = LoggerFactory.getLogger(FileReadManager.class);

    private static FileReadManager fileReadManager;
    private static ConfigFileReader configFileReader;

    private FileReadManager() { }

    public  static FileReadManager getInstance(){
        return (fileReadManager == null)? fileReadManager = new FileReadManager():fileReadManager;
    }

    public ConfigFileReader getConfigFileReader(){
        return (configFileReader == null)? configFileReader = new ConfigFileReader():configFileReader;
    }

}


