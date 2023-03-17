package com.mk.managers;

import com.mk.dataProviders.ConfigFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;

public class FileReaderManager {
    private static final Logger logger = LoggerFactory.getLogger(FileReaderManager.class);

    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager() { }

    public static FileReaderManager getInstance(){
        //return (fileReadManager == null)? fileReadManager = new FileReadManager():fileReadManager;
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader(){
        return (configFileReader == null)? configFileReader = new ConfigFileReader():configFileReader;
    }

}


