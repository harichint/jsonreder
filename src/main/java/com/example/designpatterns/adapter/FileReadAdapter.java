package com.example.designpatterns.adapter;

public class FileReadAdapter implements FileReader {
    private AdvanceFileReader advanceFileReader;
    //enum to hold fileformat (not related to the adapter pattern
    enum FileFormat {
        JSON("json"), XML("xml");
        String value;
        FileFormat(String format) {
            value = format;
        }
    }

    public FileReadAdapter(String fileFormat) {
        if (fileFormat.equalsIgnoreCase(FileFormat.JSON.value))
            advanceFileReader = new JsonReader();
        else if (fileFormat.equalsIgnoreCase(FileFormat.XML.value))
            advanceFileReader = new XmlReader();
    }

    @Override
    public void readFile(String fileFormat, String fileName) {
        if (fileFormat.equalsIgnoreCase(FileFormat.JSON.value))
            advanceFileReader.readJson(fileName);
        else if (fileFormat.equalsIgnoreCase(FileFormat.XML.value))
            advanceFileReader.readXml(fileName);
    }
}
