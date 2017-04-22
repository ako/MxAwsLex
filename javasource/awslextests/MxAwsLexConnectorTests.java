package awslextests;

import awslex.impl.LexResult;
import awslex.impl.MxAwsLexConnector;
import ca.szc.configparser.Ini;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Created by ako on 2/20/2017.
 */
public class MxAwsLexConnectorTests {
    public void doUtteranceTest(String utterance, String expectedIntent) {
        MxAwsLexConnector conn = new MxAwsLexConnector();
        LexResult result = conn.getIntentForUtterance(accessKeyId, secretAccessKey, region, "MxSlackBot", "mxslackbot", "xx123", utterance);
        String intent = result.getIntent();
        System.out.println(String.format("Intent '%s' for utterance '%s'", intent, utterance));
        assertEquals("Wrong intent", expectedIntent, intent);
    }

    @Test
    public void testUtteranceHelpMe() {
        doUtteranceTest("Can you help me?", "HelpMe");
    }

    @Test
    public void testUtteranceImageRekognize() {
        doUtteranceTest("What do you see?", "ImageRekognize");
    }

    @Test
    public void testUtteranceWhatIsNew() {
        doUtteranceTest("What is new?", "WhatIsNew");
    }

    @Test
    public void testUtteranceFindImage() {
        doUtteranceTest("Can you show me pictures of", "FindImage");
    }

    @Test
    public void testUtteranceFindImagePeople() {
        doUtteranceTest("Can you show me pictures of people", "FindImage");
    }

    @Test
    public void testUtteranceFindImagePeople2() {
        doUtteranceTest("Do you have images of people", "FindImage");
    }

    private static String accessKeyId = null;
    private static String secretAccessKey = null;
    private static String region = null;

    @BeforeClass
    public static void initConfiguration() {
        Path configurationFile = Paths.get(System.getProperty("user.home"), ".mxutils.cfg");
        System.err.println("Reading aws credentials from : " + configurationFile.toString());
        try {
            Ini ini = new Ini().read(configurationFile);
            accessKeyId = ini.getValue("AwsLex", "aws_access_key_id");
            secretAccessKey = ini.getValue("AwsLex", "aws_secret_access_key");
            region = ini.getValue("AwsLex", "region");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
