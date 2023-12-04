package browsePage.swipePageRedirect;

public class BrowsePageRDRController {
    private final BrowsePageRDRUCI uci;
    public BrowsePageRDRController(BrowsePageRDRUCI browsePageRDRUCI){
        uci = browsePageRDRUCI;
    }
    public void execute(){
        uci.execute();
    }
}
