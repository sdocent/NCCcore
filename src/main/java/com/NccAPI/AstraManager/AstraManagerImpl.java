package com.NccAPI.AstraManager;

import com.Ncc;
import com.NccAPI.NccAPI;
import com.NccAstraManager.*;
import com.NccSystem.NccUtils;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class AstraManagerImpl implements AstraManagerService {

    public Integer runAstraTransponder(String apiKey, Integer id) {
        final NccAstraManager astraManager = new NccAstraManager();
        final Integer transponderId = id;

        if (!new NccAPI().checkPermission(apiKey, "permRunAstraTransponder")) return null;

        astraManager.stopTransponder(id);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                astraManager.runTransponder(transponderId);
            }
        });
        t.start();

        return 0;
    }

    public ArrayList<Integer> stopAstraTransponder(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permStopAstraTransponder")) return null;

        return astraManager.stopTransponder(id);
    }

    public NccAstraManager.TransponderStatus getAstraTransponderStatus(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permAstraGetTransponderStatus")) return null;

        return astraManager.getTransponderStatus(id);
    }

    public ArrayList<ServerData> getAstraServers(String apiKey) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraServers")) return null;

        return astraManager.getServers();
    }

    public ArrayList<AdapterData> getAstraAdapters(String apiKey) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraAdapters")) return null;

        return astraManager.getAdapters();
    }

    public ArrayList<AdapterData> getAstraAdaptersByServerId(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraAdaptersByServerId")) return null;

        return astraManager.getAdaptersByServerId(id);
    }

    public ArrayList<AdapterType> getAstraAdapterTypes(String apiKey) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraAdapterTypes")) return null;

        return astraManager.getAdapterTypes();
    }

    public ArrayList<TransponderData> getAstraTransponders(String apiKey) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraTransponders")) return null;

        return astraManager.getTransponders();
    }

    public ArrayList<CamData> getAstraCams(String apiKey) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraCams")) return null;

        return astraManager.getCams();
    }

    public ArrayList<ChannelData> getAstraChannels(String apiKey) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permGetAstraChannels")) return null;

        return astraManager.getChannels();
    }

    public ArrayList<Integer> createAstraServer(String apiKey,
                                                Long serverIP,
                                                String serverSecret,
                                                Long serverLocalAddress,
                                                String serverComment,
                                                String serverName) {

        NccAstraManager astraManager = new NccAstraManager();
        ServerData serverData = new ServerData();

        if (!new NccAPI().checkPermission(apiKey, "permCreateAstraServer")) return null;

        serverData.serverIP = serverIP;
        serverData.serverSecret = serverSecret;
        serverData.serverLocalAddress = serverLocalAddress;
        serverData.serverComment = serverComment;
        serverData.serverName = serverName;

        return astraManager.createServer(serverData);
    }

    public ArrayList<Integer> createAstraAdapter(String apiKey,
                                                 Integer adapterDevice,
                                                 Integer adapterType,
                                                 Integer serverId,
                                                 String adapterComment) {
        NccAstraManager astraManager = new NccAstraManager();
        AdapterData adapterData = new AdapterData();

        if (!new NccAPI().checkPermission(apiKey, "permCreateAstraAdapter")) return null;

        adapterData.adapterDevice = adapterDevice;
        adapterData.adapterType = adapterType;
        adapterData.serverId = serverId;
        adapterData.adapterComment = adapterComment;

        return astraManager.createAdapter(adapterData);
    }

    public ArrayList<Integer> createAstraTransponder(String apiKey,
                                                     String transponderName,
                                                     Integer transponderFreq,
                                                     String transponderPolarity,
                                                     String transponderFEC,
                                                     Integer transponderSymbolrate,
                                                     String transponderType,
                                                     Integer adapterId,
                                                     String transponderLNB,
                                                     String transponderSat) {
        NccAstraManager astraManager = new NccAstraManager();
        TransponderData transponderData = new TransponderData();

        if (!new NccAPI().checkPermission(apiKey, "permCreateAstraTransponder")) return null;

        transponderData.transponderName = transponderName;
        transponderData.transponderFreq = transponderFreq;
        transponderData.transponderPolarity = transponderPolarity;
        transponderData.transponderFEC = transponderFEC;
        transponderData.transponderSymbolrate = transponderSymbolrate;
        transponderData.transponderType = transponderType;
        transponderData.adapterId = adapterId;
        transponderData.transponderLNB = transponderLNB;
        transponderData.transponderSat = transponderSat;

        return astraManager.createTransponder(transponderData);
    }

    public ArrayList<Integer> createAstraCam(String apiKey,
                                             String camServer,
                                             Integer camPort,
                                             String camUser,
                                             String camPassword,
                                             String camName,
                                             String camKey) {

        NccAstraManager astraManager = new NccAstraManager();
        CamData camData = new CamData();

        if (!new NccAPI().checkPermission(apiKey, "permCreateAstraCam")) return null;

        camData.camServer = camServer;
        camData.camPort = camPort;
        camData.camUser = camUser;
        camData.camPassword = camPassword;
        camData.camName = camName;
        camData.camKey = camKey;

        return astraManager.createCam(camData);
    }

    public ArrayList<Integer> createAstraChannel(String apiKey,
                                                 String channelName,
                                                 Integer channelTransponder,
                                                 Integer channelPnr,
                                                 Integer channelCam,
                                                 Long channelIP,
                                                 String channelComment) {

        NccAstraManager astraManager = new NccAstraManager();
        ChannelData channelData = new ChannelData();

        if (!new NccAPI().checkPermission(apiKey, "permCreateAstraChannel")) return null;

        channelData.channelName = channelName;
        channelData.transponderId = channelTransponder;
        channelData.channelPnr = channelPnr;
        channelData.camId = channelCam;
        channelData.channelIP = channelIP;

        return astraManager.createChannel(channelData);
    }

    public ArrayList<Integer> deleteAstraServer(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permDeleteAstraServer")) return null;

        return astraManager.deleteServer(id);
    }

    public ArrayList<Integer> deleteAstraAdapter(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permDeleteAstraAdapter")) return null;

        return astraManager.deleteAdapter(id);
    }

    public ArrayList<Integer> deleteAstraTransponder(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permDeleteAstraTransponder")) return null;

        return astraManager.deleteTransponder(id);
    }

    public ArrayList<Integer> deleteAstraCam(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permDeleteAstraCam")) return null;

        return astraManager.deleteCam(id);
    }

    public ArrayList<Integer> deleteAstraChannel(String apiKey, Integer id) {
        NccAstraManager astraManager = new NccAstraManager();

        if (!new NccAPI().checkPermission(apiKey, "permDeleteAstraChannel")) return null;

        return astraManager.deleteChannel(id);
    }

    public ArrayList<Integer> updateAstraServer(String apiKey,
                                                Integer id,
                                                Long serverIP,
                                                String serverSecret,
                                                Long serverLocalAddress,
                                                String serverComment,
                                                String serverName) {
        NccAstraManager astraManager = new NccAstraManager();

        ServerData serverData = new ServerData();

        if (!new NccAPI().checkPermission(apiKey, "permUpdateAstraServer")) return null;

        serverData.id = id;
        serverData.serverIP = serverIP;
        serverData.serverSecret = serverSecret;
        serverData.serverLocalAddress = serverLocalAddress;
        serverData.serverComment = serverComment;
        serverData.serverName = serverName;

        return astraManager.updateServer(serverData);
    }

    public ArrayList<Integer> updateAstraAdapter(String apiKey,
                                                 Integer id,
                                                 Integer adapterDevice,
                                                 Integer adapterType,
                                                 Integer serverId,
                                                 String adapterComment) {
        NccAstraManager astraManager = new NccAstraManager();

        AdapterData adapterData = new AdapterData();

        if (!new NccAPI().checkPermission(apiKey, "permUpdateAstraAdapter")) return null;

        adapterData.id = id;
        adapterData.adapterDevice = adapterDevice;
        adapterData.adapterType = adapterType;
        adapterData.serverId = serverId;
        adapterData.adapterComment = adapterComment;

        return astraManager.updateAdapter(adapterData);
    }

    public ArrayList<Integer> updateAstraTransponder(String apiKey,
                                                     Integer id,
                                                     String transponderName,
                                                     Integer transponderFreq,
                                                     String transponderPolarity,
                                                     String transponderFEC,
                                                     Integer transponderSymbolrate,
                                                     String transponderType,
                                                     Integer adapterId,
                                                     String transponderLNB,
                                                     String transponderSat) {
        NccAstraManager astraManager = new NccAstraManager();

        TransponderData transponderData = new TransponderData();

        if (!new NccAPI().checkPermission(apiKey, "permUpdateAstraTransponder")) return null;

        transponderData.id = id;
        transponderData.transponderName = transponderName;
        transponderData.transponderFreq = transponderFreq;
        transponderData.transponderPolarity = transponderPolarity;
        transponderData.transponderFEC = transponderFEC;
        transponderData.transponderSymbolrate = transponderSymbolrate;
        transponderData.transponderType = transponderType;
        transponderData.adapterId = adapterId;
        transponderData.transponderLNB = transponderLNB;
        transponderData.transponderSat = transponderSat;

        return astraManager.updateTransponder(transponderData);
    }

    public ArrayList<Integer> updateAstraCam(String apiKey,
                                             Integer id,
                                             String camServer,
                                             Integer camPort,
                                             String camUser,
                                             String camPassword,
                                             String camName,
                                             String camKey) {

        NccAstraManager astraManager = new NccAstraManager();
        CamData camData = new CamData();

        if (!new NccAPI().checkPermission(apiKey, "permUpdateAstraCam")) return null;

        camData.id = id;
        camData.camServer = camServer;
        camData.camPort = camPort;
        camData.camUser = camUser;
        camData.camPassword = camPassword;
        camData.camName = camName;
        camData.camKey = camKey;

        return astraManager.updateCam(camData);
    }

    public ArrayList<Integer> updateAstraChannel(String apiKey,
                                                 Integer id,
                                                 String channelName,
                                                 Integer channelPnr,
                                                 Integer transponderId,
                                                 Long channelIP,
                                                 Integer camId) {

        NccAstraManager astraManager = new NccAstraManager();
        ChannelData channelData = new ChannelData();

        if (!new NccAPI().checkPermission(apiKey, "permUpdateAstraChannel")) return null;

        channelData.channelId = id;
        channelData.channelName = channelName;
        channelData.channelPnr = channelPnr;
        channelData.transponderId = transponderId;
        channelData.channelIP = channelIP;
        channelData.camId = camId;

        return astraManager.updateChannel(channelData);
    }
}
