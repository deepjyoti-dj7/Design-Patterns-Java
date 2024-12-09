class XMLData {
    private String XMLData;

    public XMLData(String xmlData) {
        this.XMLData = xmlData;
    }
    public String getXMLData() {
        return XMLData;
    }
}

class DataAnalyticsTool {
    private String jsonData;

    public DataAnalyticsTool() {};

    public DataAnalyticsTool(String jsonData) {
        this.jsonData = jsonData;
    }

    public void analyzeData() {
        System.out.println("Analyzing data: " + jsonData);
    }
}

class Client {
    public void ProcessData(DataAnalyticsTool dataAnalyticsTool) {
        dataAnalyticsTool.analyzeData();
    }
}

class Adapter extends DataAnalyticsTool {
    private XMLData xmlData;

    public Adapter(XMLData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public void analyzeData() {
        System.out.println("Converting XML to JSON: " + xmlData.getXMLData() + " -> to JSON Data");
        System.out.println("Analyzing the converted JSON Data");
    }
}

public class Main {
    public static void main(String[] args) {
        XMLData xmlData = new XMLData("Sample XML Data");
        DataAnalyticsTool dataAnalyticsTool = new Adapter(xmlData);

        Client client = new Client();
        client.ProcessData(dataAnalyticsTool);
    }
}